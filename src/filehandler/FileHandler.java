package filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileHandler {
    private static String pathToActiveDirectory = "../Files/";

    public static void setPathToActiveDirectory(String path) {
        pathToActiveDirectory = path;
    }

    public static String getPathToActiveDirectory() {
        return pathToActiveDirectory;
    }

    //Returns a string which contains the name of each file in the active directory
    public static String getListOfFiles() {
        String stringToReturn = "";
        try {
            File activeDirectory = new File(pathToActiveDirectory);
            String[] array = activeDirectory.list();
            for (int i = 0; i < array.length; i++) {
                stringToReturn += array[i] + "\n";
            }
        } catch (Exception e) {
            stringToReturn = "NULL";
        }
        return stringToReturn;
    }

    //Returns a string which contains the filename of each file of the 
    //supplied fileType in the active directory.
    public static String getListOfFilesFromType(String fileType) {
        String stringToReturn = "";
        try {
            File activeDirectory = new File(pathToActiveDirectory);
            String[] array = activeDirectory.list();
            
            for (int i = 0; i < array.length; i++) {
                if (array[i].contains(fileType)) {
                    stringToReturn += array[i] + "\n";
                }
            }
        } catch (Exception e) {
            stringToReturn = "NULL";
        }
        return stringToReturn;
    }

    //Renames a file if it exists in the active directory.
    public static boolean renameFile(String oldName, String newName) {
        String oldFilePath = pathToActiveDirectory + oldName;
        try {
            File oldFile = new File(oldFilePath);
            String newFilePath = pathToActiveDirectory + newName;
            File newFile = new File(newFilePath);
            if (oldFile.exists()) {
                oldFile.renameTo(newFile);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }   
        return true;
    }

    //Returns the size of a file in bytes if it exists in the active directory.
    public static long getSizeOfFile(String filename) {
        long size = 0;
        try {
            File activeFile = new File(pathToActiveDirectory + filename);
            if (activeFile.exists()) {
                size = activeFile.length();
            } else {
                return -1;
            }
        } catch (Exception e) {
           return -1;
        }     
        return size;
    }

    //Counts the number of lines in a file by opening it with a BufferReader and 
    //proceeds to read one line at a time.
    public static int getNumberOfLinesInAFile(String filename) {
        int lines = 0;
        try {
            String pathToFile = pathToActiveDirectory + filename;
            File activeFile = new File(pathToFile);
            BufferedReader myReader = new BufferedReader(new FileReader(activeFile));
            while (myReader.readLine() != null) {
            lines++;
            }
            myReader.close();
        } catch (IOException e) {
            return -1;
        } catch (Exception e) {
            return -1;
        }
        return lines;
    }

    //Searches for a word in a file by opening it with a BufferReader and then process one line at a time.
    //Each line is processed by first making the entire line lowercase followed by parsing one word at a time.
    //Each word is then compared against the word we are looking for, which also is made into lowercase.
    public static int searchForSpecificWordInFile(String filename, String word) {
        int numberOfTimesOccured = 0;
        String wordToSearchFor = word;
        wordToSearchFor = wordToSearchFor.toLowerCase();
        try {
            String pathToFile = pathToActiveDirectory + filename;
            File activeFile = new File(pathToFile);         
            BufferedReader myReader = new BufferedReader(new FileReader(activeFile));
            String line;
            String nextWordInLine = "";
            while ((line = myReader.readLine()) != null) {
                line = line.toLowerCase();
                for (int i = 0; i < line.length(); i++) { //Parse one line at a time.
                    if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') { //Parse the next word in the line.
                        nextWordInLine += line.charAt(i);
                    }
                    else {  //When a word has been found compare it against the word we are looking for.
                        if (nextWordInLine.compareTo(wordToSearchFor) == 0) { 
                            numberOfTimesOccured++;
                        }
                        nextWordInLine = "";
                    }
                    if (i == line.length() - 1) { //Make sure that we don't miss the last word in the line.
                        if (nextWordInLine.compareTo(wordToSearchFor) == 0) {
                            numberOfTimesOccured++;
                        }
                        nextWordInLine = "";
                    }
                }
                nextWordInLine = "";
            }
            myReader.close();
        } catch (IOException e) {
            return -1;
        } catch (Exception e) {
            return -1;
        }
        return numberOfTimesOccured;
    }
}
