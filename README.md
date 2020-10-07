# Filehandler
### Hello and welcome to the simplest of filehandlers!
In this program you can do some basic file-exploring such as listing all files, listing files with a specific extension or get some information about a specific file.

Main menu:

![Mainmenu](https://github.com/ludwigcarlsson/filehandler/blob/main/img/filehandlerMainmenu.PNG?raw=true)

Sub menu: 

![Submenu](https://github.com/ludwigcarlsson/filehandler/blob/main/img/filehandlerSubmenu.PNG?raw=true)

1. Compiling the project: execute following command from root:
    >_javac -d out src/main/java/*.java src/main/java/filehandling/*.java_

2. Running the program during development: execute the following command from /out
    >_java main/java/Program_

Remember that every change requires the project to be compiled for the changes to take effect!

3. Creating a jar-file of the project: execute the following command from /out
    >_jar cfe Filehandler.jar main/java/Program main/java/*.class main/java/filehandling/*.class_

4. Running the jar-file: 
   > _java -jar Program.jar_
