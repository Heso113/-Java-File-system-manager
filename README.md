# Java File system manager
A simple file system manager developed in Java which allows the user to manipulate files in the "Files" folder to some extent. 

The application allows the user to:
 - List the name of each file
 - List the name of each file of a specific type (png, jpg, txt, etc.)
 - Rename a file
 - Get size of a file
 - Get the number of lines in a file
 - Search for a word in a file

## Commands
This section will give a short explanation of each command and what it does.

#### List the name of each file
As the name says it lists the name of each file in the "Files" folder.

#### List the name of each file of a specific type
Will prompt the user to input a filetype, for example ".jpg", and proceeds to print the name of each file of the given filetype in the "Files" folder.

#### Rename a file
Prompts the user to input the name of the file he/she wants to rename along with the new name for the file. 
If the file exists in the "Files" folder the application will rename it to the given name. 

#### Get the size of a file
Prompts the user for a filename and if the file exists in the "Files" folder the application will fetch and print the size of the file in bytes.

#### Get the number of lines in a file
Prompts the user for a filename and if the file exists in the "Files" folder the application will fetch and print the number of lines in the given file.

#### Search for a word in a file
Prompts the user for a filename and a word to search for. If the file exists in the "Files" folder the application will open and search the file for the given word.
The application will then print the number of times the word occured in the file.

## Log service 
Each command is also logged in "Log.txt" in the "Logs" folder. Each log contains information of when the command was issued, if it succeded and the execution time of the command.

Here is a snippet of the logfile:
<img width="746" alt="logs" src="https://user-images.githubusercontent.com/21289637/95209728-f5a67280-07ea-11eb-8c12-94a618ffbc7e.PNG">


## Gitbash commands

These are the commands used to compile and run the application in the Gitbash console:
<img width="591" alt="filesystemcommands" src="https://user-images.githubusercontent.com/21289637/95202132-30a3a880-07e1-11eb-96cc-f682663ed345.PNG">
