package loggingservice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

public class LoggingService {
    
    private static String pathToOutputFile = "../Logs/Log.txt";

    public static void logMessage(String message) {
        try {
            Calendar myCalendar = Calendar.getInstance();
            Date currentDate = myCalendar.getTime();
            String output = currentDate.toString();
            File outputFile = new File(pathToOutputFile);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            } 
            FileWriter myWriter = new FileWriter(pathToOutputFile, true);
            myWriter.write(output + " " + message + "\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}