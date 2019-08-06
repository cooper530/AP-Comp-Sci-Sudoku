package com.example;

import java.util.*;

//LIST[ROW][COL]

public class Board {
    //All variables pertaining to the Board class
    private static final String pattern = "ABCDEFGHI";
    private int[][] originalBoard;
    private int[][] modBoard;
    private boolean[][] proposedBoard = new boolean[9][9];

    /*
    This initializes the board, setting it up so that there is 1-9 in the table. Currently the sudoku algorithm is
    not factored into the creation of the board, but it will at a later date.

    DEFAULT BOARD CONFIGURATION:
    2D 11x11 List
    -1 = X Spot (Unknown)
    0 = Blank Space

    */
    public Board() {
        //Creates the initial board with rows and cols as variables. Gets a random board from the BoardsList class
        BoardsList getBoard = new BoardsList();

        this.originalBoard = getBoard.getNewOriginalBoard();
        this.modBoard = getBoard.getNewModBoard();

    }

    /*
    This method prints out the board using two for loops, one for the row and the other for the column. To create the
    markers on the outside of the board, I run through a string checking for spaces (defined by X in the string).
    */
    public String toString()
    {
        //Prints out first two rows of the sudoku board
        System.out.println("  | A  B  C | D  E  F | G  H  I |");
        System.out.println("- + -  -  - + -  -  - + -  -  - +");

        //Prints out the letter/symbol for each row
        for(int i = 0; i < modBoard.length; i++) {

            //Prints out each letter per row
            if(i == 3 || i == 6)
            {
                System.out.println("- + -  -  - + -  -  - + -  -  - +");
            }

            System.out.print(pattern.charAt(i) + " |");

            //Begins each column (individual number)
            for (int j = 0; j < modBoard[0].length; j++) {
                //Checks if a mystery space is needed
                if(modBoard[i][j] == -1)
                {
                    System.out.print("   ");
                }
                //Checks if quotations are need when creating board
                else if(proposedBoard[i][j])
                {
                    System.out.print("'" + modBoard[i][j] + "'");
                }
                else
                {
                    System.out.print(" " + modBoard[i][j] + " ");
                }
                //Checks if space is required
                if(j == 2 || j == 5)
                {
                    System.out.print("|");
                }
            }
            System.out.print("|" + "\n");
        }
        return "- + -  -  - + -  -  - + -  -  - +" + "\n";
    }

    /*
    This method will get the ORIGINAL 2D list of the board, primarily used in the Verifier class.
     */
    public int[][] getOriginalBoard() { return originalBoard; }
    /*
    This method will get the MODIFIED 2D list of the board.
     */
    public int[][] getModBoard(){return modBoard;}

    /*
    This method will be used to change the specific number in the 2D Board Array (finalized value by default).
    */
    public void replacePos(char row, char col, int num, char proposed)
    {
        int intRow = Character.getNumericValue(row);
        intRow -= 10;
        int intCol = Character.getNumericValue(col);
        intCol -= 10;
        if(proposed == 'n')
        {
            proposedBoard[intRow][intCol] = true;
        }
        //Reverts back to finalized value
        else
        {
            proposedBoard[intRow][intCol] = false;
        }
        //Changes number
        modBoard[intRow][intCol] = num;
    }
}
