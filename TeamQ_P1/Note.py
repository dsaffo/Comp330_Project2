# -*- coding: utf-8 -*-
"""
Created on Mon Sep 18 15:10:15 2017

@author: dsaffo, jramirez09
""" 

import note_functions as nf #our functions library for sorting an printing 
from pathlib import Path #if you have python 3 you should have this lib

def main():
    #level 0 welcome menu prompt for folder with notes path
    level = 0
    while (level == 0):
        print("Hello welcome to noterizerthingy!")
        print("Type exit to quit at any time", '\n')
        path = input("Please enter your folder path: ")
        path_check = Path(path)
        if path == "exit":
            break
        elif (path != None and path_check.is_dir()):
            files = nf.new_load_files(path)
            dicts = nf.sort_notes(files,path)
            level = 1
        else:
            print("That is not a valid folder path please try again.", '\n')
            level = 0
        #level 1 path found prompt user to select what sort they want to do on the notes
        while (level == 1):
            print("How would you like to sort your notes?")
            print("possible commands are; file, mark, keyword, mention, topic, and back to return to previous menu")
            search = input("Search by: ")
            if (search == 'back'):
                level = 0
            elif (search == 'exit'):
                break
            
            #level 2 is search by file out puts all marks in a given file
            elif(search == 'file'):
                all_names = nf.file_names(files,path)
                level = 2
                while(level == 2):
                    file_name = input("Please enter a file name, or type list to see files to search, or back to return to previous menu: ")
                    if(file_name == 'back'):
                        level = 1
                    elif(file_name == 'exit'):
                        break
                    elif(file_name == 'list'):
                        print(*all_names, sep =', ')
                    elif(file_name != None and file_name in all_names):
                        res = nf.sort_by_note(dicts,file_name)
                        print('\n')
                        nf.prnt_results_by_note(res)
                        level = 1
                    else:
                        print("not a valid filename or could not find file, please try again")
                        print('\n')
                        level = 2
            
            
            #level 3 is search by mark search all files that contain the desired mark
            elif(search == 'mark'):
                level = 3
                while(level == 3):
                    mark = input("Please enter mark (possible marks are;@, #, !, ^,url) or back to return to previous menu: ")
                    commands = ["@","#","!","^","url"]
                    if(mark == 'back'):
                        level = 1
                    elif(mark == 'exit'):
                        break
                    elif(mark != None and mark in commands):
                        res = nf.sort_by_mark(dicts,mark)
                        print('\n')
                        nf.prnt_results_by_mark(res)
                        level = 1
                    else:
                        print("not a valid mark")
                        print('\n')
                        level = 3
                
            #level 4 is search by keyword user can find all files with a specific #    
            elif(search == 'keyword'): 
                level = 4
                while(level == 4):
                    keyword = input("Please enter keyword or back to return to previous menu: ")
                    if(keyword == 'back'):
                        level = 1
                    elif(keyword == 'exit'):
                        break
                    elif(keyword != None and '#' in keyword and len(keyword) > 1):
                        res = nf.sort_by_word(dicts, '#', keyword)
                        print('\n')
                        nf.prnt_results_by_word(res, keyword)
                        level = 1
                    else:
                        print ("not a valid keyword")
                        print('\n')
                        level = 4
                
            #level 5 is search by mention user can find all files with a specific mention
            elif(search == 'mention'):
                level = 5
                while(level == 5):
                    mention = input("Please enter a mention or back to return to previous menu: ")
                    if(mention == 'back'):
                        level = 1
                    elif(mention == 'exit'):
                        break
                    elif(mention != None and '@' in mention and len(mention) > 1):
                        res = nf.sort_by_word(dicts, '@' , mention)
                        print('\n')
                        nf.prnt_results_by_word(res, mention)
                        level = 1
                    else:
                        print ("not a valid mention")
                        print('\n')
                        level = 5
                
                
            #level 6 is topics, return a list of all Topics! and ther Refrences^ in topological order
            elif(search == 'topic'):
                level = 6
                while(level == 6):
                    print('\n')
                    print('Notes sorted by topological order:')
                    res = nf.sort_by_topic(dicts)
                    nf.prnt_results_by_topic(res)
                    print('\n')
                    level = 1
                    
                    
                
            else: 
               print("That search option does not exist. Try again." )
               print('\n')
               level = 1
        
        
        
        
        
    
main()

#File - Ask for file name 
#Mark - ask for what mark (@,#,!,^,url)
#Keyword - ask for the keyword (#somthing)
#Mention - ask for who is mentioned (@someone)
#Topic - ask for what topic to look for (!somethin #
                                        #
                                        

