package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializes certain aspects of the program. Ex: Input, win booleans, the board, and clock
        boolean win = false;
	    int moves = 0;
        long start = System.currentTimeMillis();
        long finish = 0;
        //Initializes Board, game starts in Board class
        Board sudoku = new Board();

        System.out.println("To win the game, all values must be correct and finalized.");
        System.out.println("Enter a number to replace at the col/row, or type -1 to clear the slot.");

        while (!win){
            Scanner input = new Scanner(System.in);

            moves += 1;
            //Catches the interrupted exception in order to wait a specified period of time
            System.out.println("\n");
            System.out.println("Printing..." + "\n");

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
            int num;
            try {
                System.out.print("Enter number: ");
                num = input.nextInt();

                //Confirms if the user input is a valid number
                if (!Verifier.confirmNum(num)) {
                    System.out.println("Value entered is neither a valid number (1-9)!");
                    continue;
                }
            }
            catch(java.util.InputMismatchException e)
            {
                System.out.println("Value entered is neither a valid number (1-9)!");
                continue;
            }

            //Checks if the value is final
            System.out.print("Is this value final? (Y/N): ");
            char finalValue = input.next().charAt(0);
            finalValue = Character.toLowerCase(finalValue);
            if(finalValue == 'y' || finalValue == 'n')
            {
                //The confirmation if the number is valid in the location
                if(finalValue == 'n')
                {
                    sudoku.replacePos(row, col, num, finalValue);
                }
                else if(Verifier.confirmReplacement(sudoku, num, row, col))
                {
                    if(num == -1)
                    {
                        sudoku.replacePos(row, col, num);
                        continue;
                    }
                    sudoku.replacePos(row, col, num, finalValue);
                }
                else
                {
                    System.out.println("That number will not fit!");
                    continue;
                }
            }
            else{
                System.out.println("Please enter a 'y' or 'n'.");
                continue;
            }


            //Determines if the game is complete
            if(Verifier.completeFilled(sudoku))
            {
                System.out.println("Board completely filled!");
                win = true;
                finish = System.currentTimeMillis();
            }

        }
        long timeElapsed = finish - start;
        System.out.println("Game over! Your time was " + timeElapsed/1000 + " seconds in " + moves + " moves.");
    }
}
