package main.java;

import java.util.Scanner;

import main.java.filehandling.FileRead;


public class Program {
    static FileRead fr = new FileRead();
    static Scanner sc = new Scanner(System.in);
    private static boolean status = true;
    public static void main(String[] args) {
        System.out.println("This is the filemanager-program. What would you like to do? :)");
        mainMenu();   
    }
    public static void mainMenu() {
        System.out.println("1. List all files.\n2. List files based on type.\n3. Manipulate a file of your choosing.\n4. Exit");
        do {
            int choice = 0;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    fr.getFiles();
                    break;
                case 2:
                    fr.getFileExtensions();
                    break;
                case 3: 
                    fr.manFile();
                    break;
                case 4: 
                    exit();
                    break;
                default:
                    break;
            }
        } while (status);
    }
    public static void exit() {
        System.out.println("Are you sure? Y/N");
        char ans;
        if(sc.hasNextLine()) {
            ans = sc.next().charAt(0);
            if (Character.toLowerCase(ans) == 'y') {
                System.out.println("Goodbye :D");
                status = false;
            } else if (Character.toLowerCase(ans) == 'n'){
                System.out.println("Okay");
            }
        }
    }
}
