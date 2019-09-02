package com.example;
import java.util.Scanner;

public class Mode {
    private int mode;

    //Begins the game, asks the player to choose between two modes.
    public Mode() {
        boolean proceed = false;

        //Explains the modes
        System.out.println("There are 2 modes available: ");
        System.out.println("Random Mode (1): Generates a completely random board to solve (Difficulty: Medium)");
        System.out.println("Normal Mode (2): Retrieves a predefined board from the BoardsList class to solve (Difficulty: Easy)");

        while (!proceed) {
            Scanner input = new Scanner(System.in);

            System.out.println(" ");
            System.out.print("Select mode (1 or 2): ");
            try {
                mode = input.nextInt();
                //Catches if the user does not enter a 1 or 2
                if (mode > 2 || mode < 1) {
                    System.out.println("Please enter a 1 or 2");
                    continue;
                }
                proceed = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a 1 or 2");
            }
        }
        System.out.println("\n");
    }
    public int getMode(){
        return mode;
    }
}
