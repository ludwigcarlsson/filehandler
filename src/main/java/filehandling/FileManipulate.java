package main.java.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileManipulate {
    static Scanner input = new Scanner(System.in);
    LogWriter lf = new LogWriter();
    public void readFile(String path, int choice) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            File file = new File(path);
            switch (choice) {
                case 1:
                    System.out.println(getFilename(file));
                    break;
                case 2: 
                    System.out.println(getFilesize(path, file));
                    break;
                case 3: 
                    System.out.println(getLines(path, file));
                    break;
                case 4: 
                    searchFile(path, file);
                    break;
                case 5: 
                    countWord(path, file);
                    break;
                default:
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\n"+e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an error reading the file.\n"+e.getMessage());
        }
        
    }

    public String getFilename(File file) {
        long startAction = System.currentTimeMillis();
        String filename = file.getName(); // Gets filename of the file that was chosen
        long endAction = System.currentTimeMillis();
        long exeTime = endAction - startAction;
        lf.logAction(exeTime, "Filename: "+filename);
        return filename;
    }
    public String getFilesize(String path, File file) {
        long startAction = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int data = fileInputStream.read();
            int byteCount = 0;
            String result;
                // -1 indicates no more data
            while(data != -1) {
                // process data
                byteCount++;
                // next data
                data = fileInputStream.read();
            }
            result = file.getName()+" is " + (int)Math.ceil(byteCount/1024.0) + "KB on disk."; // Calculates byte-size of file and declares it to a string
            long endAction = System.currentTimeMillis();
            long exeTime = endAction - startAction;
            lf.logAction(exeTime, "Filesize: "+ result);
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Could not get filesize.\n"+e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an error reading the file.\n"+e.getMessage());
        } catch (SecurityException e) {
            System.out.println("There was an error regarding the security of the code.\n"+e.getMessage());
        }
        return null;
    }
    public String getLines(String path, File file) {
        long startAction = System.currentTimeMillis();
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String result;
            while(br.readLine() != null) { // Loops while there is another row in file
                lines++;
            }
            result = file.getName()+" has "+lines+" lines.";
            long endAction = System.currentTimeMillis();
            long exeTime = endAction - startAction;
            lf.logAction(exeTime, result);
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Could not get lines of file.\n"+e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an error reading the file.\n"+e.getMessage());
        }
        return null;
    }
    public void searchFile(String path, File file) {
        boolean exists = false;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String word;
            String result;
            
            System.out.println("Enter word: ");
            String term = input.nextLine();

            long startAction = System.currentTimeMillis();
            while((word = br.readLine()) != null) { // While there still is words in file
                if(word.toLowerCase().contains(term.toLowerCase())) { // If word was found, case-insensitive
                    exists = true;
                }
            }
            
            if(exists) {
                result = file.getName()+" does contain the word "+term.toLowerCase()+".";
                long endAction = System.currentTimeMillis();
                long exeTime = endAction - startAction;
                lf.logAction(exeTime, result);
                System.out.println(result);
            } else if (!exists) {
                result = file.getName()+" does not contain the word "+term.toLowerCase()+".";
                long endAction = System.currentTimeMillis();
                long exeTime = endAction - startAction;
                lf.logAction(exeTime, result);
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.\n"+e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an error reading the file.\n"+e.getMessage());
        }
        FileRead.manFileMenu(path); // Calls submenu again
    }
    public void countWord(String path, File file) {
        int exists = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String word;
            String result;

            System.out.println("Enter word: ");
            String term = input.nextLine();

            long startAction = System.currentTimeMillis();
            while((word = br.readLine()) != null) { // While there still is words in file
                if(word.toLowerCase().contains(term.toLowerCase())) { // If word was found, case-insensitive
                    exists++;
                }
            }
            
            result = "The word was found "+exists+" times in "+file.getName()+".";
            long endAction = System.currentTimeMillis();
            long exeTime = endAction - startAction;
            lf.logAction(exeTime, result);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.\n"+e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an error reading the file.\n"+e.getMessage());
        }
        FileRead.manFileMenu(path); // Calls submenu again
    }
}
