package main.java.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LogWriter {
    File file = new File("../out/log.txt");
    public void logAction(long exeTime, String action){
        LocalDateTime dt = LocalDateTime.now(); // Gets current time
        try {
            PrintWriter pWrite = new PrintWriter(new FileWriter(file, true));
            pWrite.write("[" + dt.format(DateTimeFormatter.ofPattern("uuuu-MMM-dd HH:mm:ss")) +"] " + 
                action + " (Execution took "+ exeTime + " ms)\n"); // Write current date and arguments to file log.txt
            pWrite.close(); // No more writing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
