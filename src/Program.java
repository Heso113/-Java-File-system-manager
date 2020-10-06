import filehandler.*;
import iohandler.*;
import loggingservice.*;

public class Program {
    private static String mainMenuMessage = "";
    private static String listFilesMenuMessage = "";
    private static String modifyFilesMenuMessage = "";
    private static long startTime = 0;
    private static long endTime = 0;

    public static void main(String[] args) {
        createMenuMessages();

        boolean applicationIsRunning = true;
        int userInput = 0;
        long elapsedMilliseconds = 0;
        while (applicationIsRunning) {
            IOHandler.printToConsole(mainMenuMessage);
            userInput = IOHandler.getIntFromUser();
            switch (userInput) {
                case 1:
                {   
                    boolean listFileMenuActive = true;
                    while (listFileMenuActive) {
                        IOHandler.printToConsole(listFilesMenuMessage);
                        userInput = IOHandler.getIntFromUser();
                        switch (userInput) {
                            case 1:
                            {
                                String output = "";
                                startTime = System.currentTimeMillis();
                                output = FileHandler.getListOfFiles();
                                endTime = System.currentTimeMillis();
                                elapsedMilliseconds = endTime - startTime;
                                if (output != "NULL") {
                                    IOHandler.printToConsole(output);
                                    LoggingService.logMessage("Listed each file in Files folder. Executiontime: " + elapsedMilliseconds + " ms." );
                                } else {
                                    IOHandler.printToConsole("Failed to list files. Bad filepath.");
                                    LoggingService.logMessage("List files command failed. Bad filepath.");
                                }
                                break;
                            }
                            case 2:
                            {
                                String output = "";
                                String filetype = "";
                                IOHandler.printToConsole("Enter a filetype (.jpg, .txt, etc): ");
                                filetype = IOHandler.getStringFromUser();
                                startTime = System.currentTimeMillis();
                                output = FileHandler.getListOfFilesFromType(output);
                                endTime = System.currentTimeMillis();
                                elapsedMilliseconds = endTime - startTime;
                                if (output != "NULL") {
                                    IOHandler.printToConsole(output);
                                    LoggingService.logMessage("Listed each file of type " + filetype + " Executiontime: " + elapsedMilliseconds + " ms.");
                                } else {
                                    IOHandler.printToConsole("Failed to list files. Bad filepath.");
                                    LoggingService.logMessage("Failed to list files of specific type. Bad filepath.");
                                }
                                break;
                            }
                            case 3:
                            {
                                listFileMenuActive = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2:
                {
                    boolean modifyFilesMenuActive = true;
                    while (modifyFilesMenuActive) {
                        IOHandler.printToConsole(modifyFilesMenuMessage);
                        userInput = IOHandler.getIntFromUser();
                        switch (userInput) {
                            case 1:
                            {
                                //Rename
                                IOHandler.printToConsole("Enter filename you want to change: ");
                                String oldFilename = IOHandler.getStringFromUser();
                                IOHandler.printToConsole("Enter new filename: ");
                                String newFilename = IOHandler.getStringFromUser();
                                startTime = System.currentTimeMillis();
                                boolean success = FileHandler.renameFile(oldFilename, newFilename);
                                endTime = System.currentTimeMillis();
                                elapsedMilliseconds = endTime - startTime;
                                if (success) {
                                    IOHandler.printToConsole("Change name succeeded." );
                                    LoggingService.logMessage("Renamed file from " + oldFilename + " to " + newFilename + ". Exectiontime: " + elapsedMilliseconds + " ms.");
                                } else {
                                    IOHandler.printToConsole("Change name failed. File doesn't exist.");
                                    LoggingService.logMessage("Change name of file command failed. Bad filepath.");
                                }
                                break;
                            }
                            case 2:
                            {
                                //Size
                                IOHandler.printToConsole("Enter filename: ");
                                String filename = IOHandler.getStringFromUser();
                                startTime = System.currentTimeMillis();
                                long size = FileHandler.getSizeOfFile(filename);
                                endTime = System.currentTimeMillis();
                                elapsedMilliseconds = endTime - startTime;
                                if (size != -1) {
                                    IOHandler.printToConsole("The size of " + filename + " is " + size + " bytes.\n");
                                    LoggingService.logMessage("Fetched size of file " + filename + ", it was " + size + " bytes in size. Executiontime: " + elapsedMilliseconds + " ms.");
                                } else {
                                    IOHandler.printToConsole("Failed to get size of file. File does not exist.");
                                    LoggingService.logMessage("Get size of file command failed. Bad filepath.");
                                }

                                break;
                            }
                            case 3:
                            {
                                //Nr of lines
                                IOHandler.printToConsole("Enter filename: ");
                                String filename = IOHandler.getStringFromUser();
                                startTime = System.currentTimeMillis();
                                int numberOfLines = FileHandler.getNumberOfLinesInAFile(filename);
                                endTime = System.currentTimeMillis();
                                elapsedMilliseconds = endTime - startTime;
                                if (numberOfLines != -1) {
                                    IOHandler.printToConsole(filename + " has " + numberOfLines + " lines.\n");
                                    LoggingService.logMessage("Counted the number of lines in " + filename + ", it contained " + numberOfLines + " lines. Executiontime: " + elapsedMilliseconds + " ms.");
                                }
                                else {
                                    IOHandler.printToConsole("Failed to get number of lines. File does not exist.");
                                    LoggingService.logMessage("Get number of lines command failed. Bad filepath.");
                                }
                                break;
                            }
                            case 4:
                             {
                                //Search for word
                                IOHandler.printToConsole("Enter filename: ");
                                String filename = IOHandler.getStringFromUser();
                                IOHandler.printToConsole("Enter a word to search for: ");
                                String word = IOHandler.getOneWordFromUser();
                                startTime = System.currentTimeMillis();
                                int numberOfTimesOccured = FileHandler.searchForSpecificWordInFile(filename, word);
                                endTime = System.currentTimeMillis();
                                elapsedMilliseconds = endTime - startTime;
                               if (numberOfTimesOccured != -1) {
                                IOHandler.printToConsole("The word: " + word + " occured " + numberOfTimesOccured + " in " + filename + ".\n");
                                LoggingService.logMessage("Searched for the word " + word + " in " + filename + ", it occured " + numberOfTimesOccured + " times. Executiontime: " + elapsedMilliseconds + " ms.");
                               } else {
                                    IOHandler.printToConsole("Failed to search for word. File does not exist.");
                                    LoggingService.logMessage("Search for word command failed. Bad filepath.");
                               }
                                break;
                             }
                            case 5:
                                modifyFilesMenuActive = false;
                                break;
                        }       
                    }
                    break;
                }
                case 3:
                {
                    applicationIsRunning = false;
                    break;
                }
                default:
                {
                    IOHandler.printToConsole("Invalid choice. Please try again.");
                    break;
                }
            }
        }


    }

    private static void createMenuMessages() {
        mainMenuMessage +=  "\n--------------------------------------\n" +
                            "|    Welcome to FileSystemManager    |\n" +
                            "--------------------------------------\n"  +
                            "1. List files\n" +
                            "2. Manipulate files\n" +
                            "3. Exit\n\n" +
                            "Please select what you want to do: ";
    
        listFilesMenuMessage += "\n--------------------------------------\n" +
                                "|            File listing            |\n" +
                                "--------------------------------------\n"  +
                                "1. List all available files\n" +
                                "2. List files of specific type\n" +        
                                "3. Return to main menu\n\n" +
                                "Please select what you want to do: ";
    
        modifyFilesMenuMessage += "\n--------------------------------------\n" +
                                  "|         File manipulation          |\n" +
                                  "--------------------------------------\n"  +
                                  "1. Rename file\n" +
                                  "2. Check size of file\n" +
                                  "3. Count number of lines in file\n" +
                                  "4. Search for word in file\n" +
                                  "5. Return to main menu\n\n" +
                                  "Please select what you want to do: ";                                     
    }
}