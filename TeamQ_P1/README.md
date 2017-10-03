Comp 330 Project One (note organizer thingy)
David Saffo, Jorge Ramirez

**Python  v3.5 minimum used *list in places and it is fairly new
Can be run on cloud 9 by pulling the repo and running it with >python3.5 Note.py

Files and Folders:

1. FunctionTests.ipynb
    -Notebook for testing functions and methods
    
2. UnitTests.ipyb
    -Notebook for unit testing our sorting function to see if it sorted all the diffrent marks correctly 
    
3. note_functions.py
    -python file with all the sorting and printing functions for the program
    
4. Note.py
    -main python file that imports note_function.py and contains code for the CLI and calls to the sorting/printing functions
    
5. Notes
    -Folder containing our test .txt files
    
6. README.md
    -well....this read me file with documentation 
    
How to Use the Code:

opon launching the code you will be prompted for a file path to the folder containing you .txt files
If you want to use your own .txt files please do this by placing them all in a folder inside the folder were the code is running like we have with our Notes folder. To search these files simply type the name of the folder when prompted.

In the CLI you can use back to return to the previous prompt or exit to shutdown the program

After loading the files you can select how you want to sort them as follows

1. By file name
    -This will take a file name and print out all the marks that file has
    
2. By mark
    -this will take the mark ie[@,#,!,^,url] and return all the files with that mark

3. By keyword
    -this will take a keyword #something and return all files with this keyword
    
4. By mention
    -this will take a mention @something and return all files with this mention
    
5. By topic
    -this will return the topics of all files and there refrences sortted in topological order
    -I used the topics as roots and the refrences as children topics with the most refrences had the most weight and float to the top
    -Topics dont point to anything but all refrences point to their respective topic
    
Method:

We used a combination of Dictionaries and lists to sort the files

files are first sorted into seperate dictionaries with the mark being the key and a list of those marks being a value.
then files get sorted further into new dictionaries depending and the sort being preformed.
everyhthing is returned as a list of dicationaries, one dictionary per file.

for the topological sort we used tuples to further help direct the topics and refrences to the right place

Then a user can control the program with a CLI


    
    
    
    
    
    
    
    
    
    
    
    
    

