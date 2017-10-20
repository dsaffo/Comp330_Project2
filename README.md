# Comp330_Project2

What the project does.

Our project is a note taking mobile application for the Android OS. It is loosely modeled after similar apps such as Evernote.
The user has the ability from the homescreen to create a note with a specific title and body of content. The user can then save
this note for future viewing. Each note is saved with a time stamp associated with it. That way the user can tell when 
the note was created. Inidivudal notes are previewed to the user on the homescreen, and the user has the ability to search 
through the notes for an identifier of their choice. All the notes are editable and can be deleted. The app is also 
fully integrated with Google Calander, and the user can add notes to events on their own calander. Additionally, notes can
be viewed through Android Wear.

Why this project is useful.

This project is useful because of its ease of use. We integrated all of Android's native icons, so the users will be innately 
familiar with how to navigate through the app. We give the user the ability to totally customize notes and set events in their
google accounts. Additionally, as wearables become more common, we inteegrated the app to these devices as well. This way,
the user can easily integrate our app into a variety of their everyday devices and services. 

How users can get started with the project.

Users will start off after downloading by signing into their google accounts. This will allow for integration with their 
calanders. By having Android's native icons, the users should be familiar with basic functionality of our app. The "plus"
icon will add a new note. This will take you to a new screen that has spaces for "title" and "content". The two icons on the 
menu bar are "save" and "delete", which should be familiar. If the user does not enter information and tries to save,
we prompt them to enter information and do not allow them to save an empty note. Once saved or deleted, the user goes back
to the inital homescreen. There, they will see individual notes previewed in a list form. The user can click on any note of
their choosing if they want to edit or delete it. The search icon on the homescreen is very user friendly. Whenever the user 
enters a letter/number/identifier, the list of notes automatically updates with the newly sorted list. If the user wants to 
add something to their google calader or Android Wear device, they simply add "@gcal" or "@gwatch" respecively to their 
individual notes. 

Who maintains and contributes to the project.

Katelyn Schoenberger is the project manager for this group. She organized the overall structure of the project. Jorge
Ramirez Rojas was the creator of the Unit testing for the project. David Saffo and Brendan Shea were the main developers of
the mobile application. 

Program Stucture and Classes
	-MainActivity: Our main class and home display for the app responsible for most navigation, list view, and search view
	-Note: Our note object class defines the parts that make up a note mainly the title,date,content, and various marks
	-NoteActivity: Our activity for creating/editing/and deleting notes google calander permisions are created here as well
	-NoteAdaptor: Takes the list of notes and displays them as a list view for MainActivity
	-Utilities: Class for static functions used throughout the app for everything from getting notes to sorting marks
	-UnitTest: Class for unit testing of the various sort functions
	
Support Files:
	-330NoteUML.png: Abstracted UML of our design objectives
	-UserGUIDE.pdf: User guide and instructional document detailing mission, method, and install/running procedures 

