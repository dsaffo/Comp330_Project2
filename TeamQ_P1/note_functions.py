# -*- coding: utf-8 -*-
"""
Created on Thu Sep 21 19:50:51 2017

@author: dsaffo
"""

#Function Lib for sorting and printing 

import os
import re
import glob

#test file loader not used
def new_load_files(dir):
    return glob.glob(dir + "/*.txt")

#file loader reads all files in a folder
def load_files(dir):                                                                                                  
    print("Loading Files")
    r = []                                                                                                            
    subdirs = [x[0] for x in os.walk(dir)]                                                                            
    for subdir in subdirs:                                                                                            
        files = os.walk(subdir).__next__()[2]                                                                             
        if (len(files) > 0):                                                                                          
            for file in files:                                                                                        
                r.append(subdir + "/" + file)                                                                         
    return r

#sorts the notes into a dictionary for every file were the key is the marker and the value is a list of those markers
def sort_notes(files,path):
    used_id = []
    
    print("Sorting Notes")
    all_files=[]
    for f in range(len(files)):
        fil_url = []
        #name = "file" + str(f)
        file = open(files[f], encoding='cp1252')
        file_str = file.read()
        file.close()
        #print(files[f])
        marks = re.findall(r'\B[@#!^]\w+', file_str) #regex for marker
        urls = re.findall(r'(?:[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*\.)+[-a-zA-Z@:%_\+~#?&//=]{2,256}',file_str) #regex for urls
        doms = ['.com','.org','.net','.edu','.gov'] #url filter for only common domains
        for u in urls:
            for d in doms:
                if d in u:
                    fil_url.append(u)
        
        file_marks = {'name':files[f][len(path)+1:],'@':[],'#':[],'!':[],'^':[],'url':[]}
        for m in marks:
            x = m in used_id
            if (len(m) != 0 and x == False):
                file_marks[m[0]].append(m)
            if m[0] == "!":
                    used_id.append(m)
        for u in fil_url:
            file_marks['url'].append(u)
        all_files.append(file_marks)
    return all_files

#sorts files by a specific mark
def sort_by_mark(dicts, mark):
    files = []
    for d in dicts:
        #print(d[mark])
        if (len(d[mark]) !=0):
            sort = {'name':d['name'], 'marks':d[mark]}
            files.append(sort)
    return files

#sorts a specific file
def sort_by_note(dicts,name):
    for d in dicts:
        if name in d['name']:
            return d
    else:
        return "file not found"

#sorts a specific # or @ 
def sort_by_word(dicts,mark,word):
    words = []
    for d in dicts:
        if word in d[mark]:
            words.append(d)
    return words

#sorts all topics and refrences in topological order
def sort_by_topic(dicts):
    all_topics = []
    roots = []
    children = []
    for d in dicts: #read into tuples for easier handling of refrences pointing to topic
        if (len(d['!']) !=0):
            tup = (d['name'],d['!'])
            roots.append(tup)
        if (len(d['^']) !=0):
            tup = (d['name'],d['^'])
            children.append(tup)
   
    for r in roots:
        graph = {'root': (), 'children':[], 'weight': 0} #read tuples to a dictionary with a weight of refrences
        for c in children:
            word1 = c[1][0][1:]
            word2 = r[1][0][1:]
            if (word1[1:] == word2[1:]):
                graph['root'] = r
                graph['children'].append(c[0])
                graph['weight'] += 1
            else:
                graph['root'] = r
        all_topics.append(graph)
        
    topo_sorted = sorted(all_topics, key=lambda k: k['weight'], reverse=True) #sort by weight greatest to least
    return topo_sorted

#helper function to trim file names
def file_names(files,path):
    names = []
    for f in files:
        f = f[len(path)+1:]
        names.append(f)
    return names


#prints for the various types of sorts uses *list to print out contents of a list python 3.5 and up only
def prnt_results_by_note(results):
    print ('File Name:', results['name'])
    for k in results.keys():
        if k != 'name':
            print(k + ':' , *results[k] , '/ Total:', len(results[k]), '\n')

def prnt_results_by_mark(results):
    for r in results:
        print ('File Name:', r['name'], '/ Marks:', *r['marks'], '/ Total:', len(r['marks']), '\n')

def prnt_results_by_word(results, word):
    if len(results) == 0:
        print ("no matches found", '\n')
    else:
        print('Files with your search:',word)
        for r in results:
            print('File Name:', r['name'], '/ Total:', r[word[0]].count(word), '\n')

def prnt_results_by_topic(results):
    for r in results:
        print("Topic:", *r['root'][1], "/ File:",r['root'][0])
        if (len(r['children']) !=0):
            print('References:', *r['children'], "/ Total:", r['weight'], '\n')
        else:
            print('no refrences', '\n')


















