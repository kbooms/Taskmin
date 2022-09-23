package com.kevinbooms;

import java.util.Scanner;

public class CommandLine {

    private final Scanner scanner = new Scanner(System.in);

    public void printGreeting() {
        System.out.println("=================================");
        System.out.println("Welcome to Taskmin");
        System.out.println("=================================\n");
    }

    public void printMainMenu() {
        System.out.println("1. Create New List");
        System.out.println("2. Open Existing List");
        System.out.println("3. Help");
        System.out.println("0. Exit App");
    }

    public void printListMenu() {
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Edit Description");
        System.out.println("4. Save List");
        System.out.println("0. Exit");
    }

    public int promptForMenuSelection(String prompt) {

        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public String promptForString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {

        int userChoice;
        System.out.println(prompt);
        try {
            userChoice = (Integer.parseInt(scanner.nextLine()) - 1);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Task not found...");
            userChoice = -1;
        }
        return userChoice;
    }
}