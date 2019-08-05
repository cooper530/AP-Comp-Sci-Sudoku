package com.example;

import java.util.Scanner;

/*
NOTES FOR FUTURE IMPROVEMENTS:

- COMPLETE (Issue was column was longer than row) Create a verifier method to determine whether the integer selected for that place is valid (check row, column, region)
- COMPLETE Edit the method in Board class to replace the X value with the desired value
- COMPLETE Create a timer for the player to see how long their game was
- COMPLETE Determine the best possible print layout for the sudoku board for the player
- COMPLETE Create a possible value signature, "" or ()
- COMPLETE Random class system to handle multiple boards (BoardsList class)
- COMPLETE Simplify board and verifier classes
- Possible restart command to reset entire program?

TROUBLESHOOT:
-In some instances, the space requested is falsely returned as being filled. Possibly because working with a new board?
*/

public class Main {

    public static void main(String[] args) {
        //Initializes certain aspects of the program. Ex: Input, win booleans, the board, and clock
        Scanner input = new Scanner(System.in);
        boolean win = false;
	    Board sudoku = new Board();
        long start = System.currentTimeMillis();
        long finish = 0;

        while (!win){
            //Catches the interrupted exception in order to wait a specified period of time
            System.out.println("\n");
            System.out.println("Printing..." + "\n");

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt(); // restore interrupted status
            }

            System.out.println(sudoku);

            System.out.print("Enter col (A-I): ");
            char col= input.next().charAt(0);

            System.out.print("Enter row (A-I): ");
            char row= input.next().charAt(0);

            //Determines whether the user input is valid for row and col
            if(!Verifier.confirmPos(col, row))
            {
                System.out.println("Value entered is neither a valid column or row!");
                continue;
            }

            //Checks if the space is -1. If it is not, then print the location is filled, continue if else.
            else if(Verifier.spaceFilled(sudoku, col, row))
            {
                System.out.println("That location is filled originally!");
                continue;
            }

            System.out.print("Enter number: ");
            int num = input.nextInt();

            //Confirms if the user input is a valid number
            if(!Verifier.confirmNum(num))
            {
                System.out.println("Value entered is neither a valid number (1-9)!");
                continue;
            }

            //System.out.println(Verifier.confirmReplacement(sudoku, num, row, col));
            //The confirmation if the number is valid in the location
            if(Verifier.confirmReplacement(sudoku, num, row, col))
            {
                //Ask if value is final
                System.out.print("Is this value final? (Y/N): ");
                char finalValue = input.next().charAt(0);
                finalValue = Character.toLowerCase(finalValue);
                if(finalValue == 'y' || finalValue == 'n')
                {
                    //The physical replacement of the number in that slot
                    sudoku.replacePos(row, col, num, finalValue);
                }
                else{
                    System.out.println("Please enter a 'y' or 'n'.");
                    continue;
                }
            }
            else
            {
                System.out.println("That number will not fit!");
                continue;
            }

            //Determines if the game is complete
            if(Verifier.completeFilled(sudoku))
            {
                win = true;
                finish = System.currentTimeMillis();
            }

        }
        long timeElapsed = finish - start;
        System.out.println("Game over! Your time was " + timeElapsed + " milliseconds.");
    }
}
