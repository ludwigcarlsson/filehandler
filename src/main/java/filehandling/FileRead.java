package main.java.filehandling;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.Program;

public class FileRead {
    static Scanner sc = new Scanner(System.in);
    static FileManipulate fm = new FileManipulate();
    
    public void getFileExtensions() {
        String path = "../src/main/resources/";
        System.out.println("Enter a file-extension: ");
        String input = sc.nextLine();

        List<String> results = new ArrayList<String>(); 
        File[] files = new File(path).listFiles(); // Create array of files from path

        for (File file : files) { 
            if (file.isFile() && file.getName().endsWith("."+input)) {
                results.add(file.getName()); // Adds name of file to an Arraylist if its a file and its extension is equal to the input
            }
        }
        if(results.isEmpty()) {
            System.out.println("No files with " +input+ "-extension found.");
        } else {
            System.out.println(results);
        }
        System.out.println("---------------------");
        Program.mainMenu();
    }
    
    public void getFiles() {
        String path = "../src/main/resources/";

        List<String> results = new ArrayList<String>();
        File[] files = new File(path).listFiles();

        for (File file : files) { 
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        System.out.println(results);
        System.out.println("---------------------");
        Program.mainMenu();
    }

    public void manFile() {
        String path = "../src/main/resources/";

        List<String> results = new ArrayList<String>();
        File[] files = new File(path).listFiles();

        for (File file : files) { 
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        System.out.println(results);
        
        System.out.println("Enter the file you want to manipulate:");

        String file = path;
        String input = sc.nextLine();
        file += input;
        manFileMenu(file); // Calls the filemanipulation-menu with file chosen as an argument
    }
    public static void manFileMenu(String file) {
        boolean x = true;
        do {
            System.out.println("---------------------");
            System.out.println("1. Filename\n2. Filesize\n3. Lines in file\n4. Search for word\n5. Count specific word\n6. Back to menu");
           
            int choice = 0;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            }

            switch (choice) {
                case 1:
                    fm.readFile(file, choice);
                    break;
                case 2:
                    fm.readFile(file, choice);
                    break;
                case 3:
                    fm.readFile(file, choice);
                    break;
                case 4:
                    fm.readFile(file, choice);
                    break;
                case 5:
                    fm.readFile(file, choice);
                    break;
                case 6:
                    x=false; // Breaks do-while loop
                    System.out.println("---------------------");
                    Program.mainMenu();
                    break;
                default:
                    break;
            }
        } while (x);
    }
}
