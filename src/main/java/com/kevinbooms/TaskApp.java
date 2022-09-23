package com.kevinbooms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskApp {

    private final CommandLine console = new CommandLine();
    private List<String> tasks;
    private String listDescription;

    private String listFileName;

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }

    public String getListFileName() {
        return listFileName;
    }

    public void setListFileName(String listFileName) {
        this.listFileName = listFileName;
    }

    public TaskApp(List<String> tasks, String listDescription, String listFileName) {
        this.tasks = tasks;
        this.listDescription = listDescription;
        this.listFileName = listFileName;
    }

    public static void main(String[] args) {
        CommandLine console = new CommandLine();
        List<String> tasks = new ArrayList<>();
        TaskApp app = new TaskApp(tasks, "", "newlist");


        console.printGreeting();
        int userChoice = -1;
        while (userChoice != 0) {
            console.printMainMenu();
            userChoice = console.promptForMenuSelection("\nPlease choose an option: ");
            try {
                switch (userChoice) {
                    case 1:
                        app.handleCreateList();
                        userChoice = -1;
                        break;
                    case 2:
                        app.openList();
                        userChoice = -1;
                        break;
                    case 3:
                        System.out.println("you chose 3");
                        userChoice = -1;
                        break;
                    case 0:
                        System.out.println("\n Goodbye!");
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println(userChoice + "is invalid. Please select a valid number...\n");
            }
        }

    }

    public void handleCreateList() {
        System.out.println("\n** Creating new List! **");
        setListDescription(console.promptForString("Enter a description of the list: "));
        System.out.println("Creating new list of: " + getListDescription());
        handleListOptions();
    }

    public void openList() {
        System.out.println("\n** Opening existing List **");

        String filePath = (console.promptForString("Open file.. ") + ".txt");
        File listFile = new File(filePath);

        try (Scanner loadFile = new Scanner(listFile)) {
            if (!tasks.isEmpty()) {
                for (String task : tasks) {
                    tasks.remove(task);
                }
            }
            while (loadFile.hasNextLine()) {
                String currentLine = loadFile.nextLine();
                if (currentLine.startsWith("**")) {
                    setListDescription(currentLine.substring(3));
                } else {
                    tasks.add(currentLine);
                }
            }
            System.out.println("Opened file: " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
        handleListOptions();
    }

    public void handleListOptions() {
        int userChoice = -1;
        while (userChoice != 0) {
            viewList();
            console.printListMenu();
            userChoice = console.promptForMenuSelection("\nPlease choose an option: ");
            switch (userChoice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    editListDesc();
                    break;
                case 4:
                    saveList();
                    break;
                case 0:
                    System.out.println("\nBack to main menu...");
            }
        }
    }

    public void viewList() {
        int taskCount = tasks.size();
        System.out.println("\n=================================");
        System.out.println(taskCount + " " + getListDescription());
        System.out.println("=================================");
        for (String task: tasks) {
            System.out.println((tasks.indexOf(task) + 1) + ") " + task);
        }
        System.out.println("=================================\n");
    }
    public void addTask() {
        System.out.println("\n** Add a task **");
        tasks.add(console.promptForString("___ Enter Task ___"));
    }
    public void removeTask() {
        System.out.println("\n** Remove a task **");
        tasks.remove(console.promptForInt("___ Enter Task # ___"));
    }
    public void editListDesc() {
        System.out.println("\n** Edit List Description **");
        setListDescription(console.promptForString("Please enter a new description: "));
    }
    public void saveList() {
        System.out.println("\n** Save List **");

        String filePath = (console.promptForString("Save As.. (no extension necessary)") + ".txt");

        try (PrintWriter todoFile = new PrintWriter(filePath)) {
            // save the current list to the file path
            // need to write an algorithm that prints the description as "** listDescription()" to the new file and then iterates through list and writes each line to new file after description
            todoFile.println("** " + getListDescription());
            for (String task : tasks) {
                todoFile.println(task);
            }
            // inform user that the file was saved succesfully
            System.out.println("List saved as: " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");

        }
    }
}
