package com.example;

public class Verifier {

    /*
    This method determines if the board specified is completely filled (finished). It runs through the board, determining if there are any -1 values
    left in the 2D list.
     */
    public static boolean completeFilled(Board board){
        int[][] verifyBoard = board.getModBoard();
        for(int i=0;i<verifyBoard.length;i++)
        {
            for(int j=0;i<verifyBoard[0].length;i++)
            {
                if(verifyBoard[i][j] == -1)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    This method determines if the board space specified is an original clue. It runs through the board, determining if there are any -1 values
    in the 2D list.
     */
    public static boolean spaceFilled(Board board, char col, char row){
        int[][] verifyBoard = board.getOriginalBoard();
        int intRow = Character.getNumericValue(row);
        int intCol = Character.getNumericValue(col);
        //System.out.println("Before: " + intRow + " and col " + intCol);
        intRow -= 10;
        intCol -= 10;
        //System.out.println("After: " + intRow + " and col " + intCol);
        //System.out.println(verifyBoard[intRow][intCol]);
        //Special cases to determine position with 0 row
        if(intRow >= 3){
            if(intRow >= 6){
                intRow += 2;
            }
            else{
                intRow+= 1;
            }
        }

        if(verifyBoard[intRow][intCol] != -1)
        {
            return true;
        }
        return false;
    }

    /*
    This method determines that the user input is a valid position. To do this, a large if statement determines if the
    String values are equal to a position on the board (A-I) (returns true or false).
     */
    public static boolean confirmPos(char col, char row){
        col = Character.toLowerCase(col);
        row = Character.toLowerCase(row);

        if((col == 'a'|| col == 'b'|| col == 'c'|| col == 'd'|| col == 'e'|| col == 'f'|| col == 'g'|| col == 'h'|| col == 'i') &&
                (row == 'a'|| row == 'b'|| row == 'c'|| row == 'd'|| row == 'e'|| row == 'f'|| row == 'g'|| row == 'h'|| row == 'i')){
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
    This method determines that the number is valid (1-9).
     */
    public static boolean confirmNum(int num){

        if(num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9){
            return true;
        }
        else
        {
            return false;
        }
    }
    /*
    This method determines whether there is a simalar number in the postitions same row, column, or region.
    DO NOT EDIT THIS CODE
     */
    public static boolean confirmReplacement(Board board, int num, char row, char col){
        //Check the row of the board
        int intRow = Character.getNumericValue(row);
        intRow -= 10;
        //The board that will be used to verify the values
        int[][] checkBoard = board.getModBoard();
        for(int i = 0; i < checkBoard[intRow].length;i++)
        {
            //System.out.println("Row: " + checkBoard[intRow][i]);
            if(num == checkBoard[intRow][i])
            {
                return false;
            }
        }

        //Check the column of the board
        int intCol = Character.getNumericValue(col);
        intCol -= 10;
        //The +2 accounts for the columns are longer than the rows
        for(int i = 0; i < checkBoard[intRow].length;i++)
        {
            //System.out.println("Column: " + checkBoard[i][intCol]);
            if(num == checkBoard[i][intCol])
            {
                return false;
            }
        }

        //Check the region of the board
        int value;
        if(intRow <= 2)
        {
            if(intCol <= 2)
            {
                value = 0;


            }

            else if(intCol <= 5)
            {
                value = 3;
            }
            else
            {
                value = 6;
            }
        }
        else if(intRow <= 5)
        {
            if(intCol <= 2)
            {
                value = 0;


            }

            else if(intCol <= 5)
            {
                value = 3;
            }
            else
            {
                value = 6;
            }
        }
        else
        {
            if(intCol <= 2)
            {
                value = 0;


            }

            else if(intCol <= 5)
            {
                value = 3;
            }
            else
            {
                value = 6;
            }
        }
        return confirmRegion(value, num, checkBoard);

    }
    /*
    This method verifies the region is valid or not
     */
    private static boolean confirmRegion(int value, int num, int[][] checkBoard){
        for(int i=0;i<value + 3;i++)
        {
            for(int j=0;j<value + 3;j++)
            {
                if(checkBoard[i][j] == num)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
