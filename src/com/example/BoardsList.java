package com.example;

import de.sfuhrm.sudoku.*;

import java.util.*;

public class BoardsList {
    private ArrayList<int[][]> boardsList = new ArrayList<>();

    private GameMatrix matrix = Creator.createFull();
    private Riddle riddle = Creator.createRiddle(matrix);
    private byte[][] byteArray = riddle.getArray();
    private int[][] originalArray = new int[byteArray.length][byteArray[0].length];
    private int[][] modArray = new int[byteArray.length][byteArray[0].length];
    private int randomInt;

    public BoardsList()
    {
        //Puts the old array (byte format) to the new array (int)
        for(int i = 0; i < byteArray.length; i++) {
            for(int j = 0; j < byteArray[0].length; j++) {
                originalArray[i][j] = byteArray[i][j];
                modArray[i][j] = byteArray[i][j];
            }
        }
        //Converts all 0 values to -1
        for(int i = 0; i < originalArray.length; i++) {
            for(int j = 0; j < originalArray[0].length; j++) {
                if(originalArray[i][j] == 0) {
                    originalArray[i][j] = -1;
                }
                if (modArray[i][j] == 0) {
                    modArray[i][j] = -1;
                }
            }
        }

        //List of original boards
        int[][] originalBoard1 = {
                {-1, -1, 7, -1, -1, -1, -1, -1, -1},
                {-1, 8, 4, -1, -1, 1, -1, -1, -1},
                {9, 6, 5, -1, -1, 7, 3, -1, -1},
                {6, 5, -1, -1, -1, -1, -1, -1, 4},
                {-1, -1, 8, -1, -1, -1, -1, -1, -1},
                {3, 4, 2, -1, -1, -1, 8, 6, 5},
                {4, 9, 6, -1, 2, 8, 1, 3, -1},
                {8, 2, 3, -1, 7, -1, -1, -1, 9},
                {5, -1, 1, -1, 6, -1, 2, -1, -1}
        };
        int[][] originalBoard2 = {
                {1, -1, -1, -1, -1, -1, -1, -1, -1},
                {9, 2, 5, -1, 1, 4, -1, -1, -1},
                {-1, 6, 8, 2, -1, -1, -1, -1, -1},
                {3, 4, -1, 7, -1, -1, -1, -1, -1},
                {5, 8, 7, 9, -1, -1, -1, 2, -1},
                {2, -1, -1, -1, -1, -1, -1, 6, -1},
                {6, 3, 9, 1, 2, -1, -1, 8, -1},
                {8, 5, 4, -1, 7, -1, -1, -1, 2},
                {7, 1, -1, 4, -1, 3, -1, -1, 5}
        };
        int[][] originalBoard3 = {
                {9, 1, -1, 3, 4, -1, 8, 6, 7},
                {8, 3, 4, 1, -1, -1, 2, 5, -1},
                {5, 6, 7, 8, -1, -1, 3, 4, 1},
                {6, -1, -1, -1, 3, -1, 9, -1, -1},
                {7, 4, 5, 6, -1, 8, -1, -1, 3},
                {-1, -1, -1, -1, 7, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, 4},
                {3, 8, 1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 7, -1, -1}
        };
        int[][] originalBoard4 = {
                {-1, 3, -1, 9, 7, 5, 6, -1, -1},
                {-1, -1, -1, 1, 8, -1, 9, -1, -1},
                {8, -1, 1, 4, 6, 3, -1, -1, -1},
                {-1, -1, -1, 2, 3, 7, -1, 6, -1},
                {-1, -1, 9, 5, 1, 6, -1, 4, -1},
                {-1, 7, -1, -1, 9, 4, 2, 1, -1},
                {-1, 8, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 6, 2, 1, -1, -1, -1},
                {1, -1, 6, 7, 5, -1, -1, -1, -1}
        };
        int[][] originalBoard5 = {
                {-1, -1, -1, -1, -1, 4, 7, 2, 5},
                {-1, -1, -1, -1, -1, -1, 6, 3, 4},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 4, -1, 3, -1, -1, 9, -1, -1},
                {-1, 2, -1, -1, -1, -1, -1, -1, -1},
                {-1, 7, 8, -1, 9, -1, 1, -1, 2},
                {1, 6, -1, -1, 2, -1, 3, 7, 8},
                {2, 8,-1, -1, -1, 1, -1, 5, 6},
                {5, 3, 4, -1, 8, 7, 2, 1, 9}
        };
        int[][] originalBoard6 = {
                {5, -1, -1, -1, -1, -1, 2, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, 9, -1, -1, -1, -1, 8, 1},
                {3, -1, -1, 4, -1, -1, -1, -1, -1},
                {-1, 2, -1, -1, 1, -1, -1, 7, -1},
                {-1, 8, 5, 6, -1, -1, -1, -1, 9},
                {9, 4, -1, 1, 2, -1, -1, 6, 5},
                {8, 5, 7, 3, 6, -1, -1, 4, 2},
                {2, 1, 6, 5, -1, 4, 7, 9, 3}
        };
        int[][] originalBoard7 = {
                {9, -1, -1, 2, 3, 4, 5, 6, -1},
                {7, -1, 3, -1, 5, 6, 9, 4, 1},
                {4, -1, 6, 7, 9, 1, 8, 2, 3},
                {-1, -1, 8, -1, -1, 2, -1, 3, 6},
                {6, -1, -1, -1, -1, -1, 7, -1, -1},
                {1, -1, -1, -1, -1, 8, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 1, -1, -1, -1, 7, 5},
                {-1, -1, -1, -1, -1, 9, 1, -1, 4}
        };
        int[][] originalBoard8 = {
                {-1, 2, -1, -1, -1, -1, -1, -1, -1},
                {8, -1, -1, -1, -1, -1, 7, -1, -1},
                {-1, -1, -1, -1, -1, -1, 3, 4, 5},
                {2, -1, -1, 7, -1, -1, -1, -1, -1},
                {3, -1, -1, 4, -1, -1, 9, -1, 6},
                {9, -1, -1, 3, -1, -1, 5, 7, 4},
                {1, 9, 3, 6, 2, -1, 4, 5, 8},
                {-1, 7, -1, 9, 1, -1, 2, 6, 3},
                {5, -1, -1, -1, 4, -1, -1, 9, 7}
        };
        int[][] originalBoard9 = {
                {1, 3, -1, 4, 8, 5, 9, 2, 6},
                {2, 4, -1, -1, 7, -1, 3, -1, 5},
                {5, 8, -1, 6, -1, -1, 1, 4, 7},
                {4, -1, -1, -1, -1, 2, 5, 6, 3},
                {-1, 7, -1, -1, -1, -1, -1, -1, 4},
                {-1, 5, -1, -1, 9, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 6, 5, 9},
                {-1, -1, -1, -1, 5, 9, 8, -1, 2},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        int[][] originalBoard10 = {
                {4, -1, 5, 6, 1, 7, -1, 2, -1},
                {1, -1, 7, 3, 8, 2, 4, -1, -1},
                {8, -1, -1, 9, -1, 5, 6, -1, -1},
                {-1, -1, -1, 4, -1, -1, 3, -1, 7},
                {-1, -1, -1, 4, -1, -1, 3, -1, 7},
                {5, -1, 6, 8, 2, -1, 9, -1, -1},
                {-1, 4, -1, 1, 3, 6, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {6, -1, 2, 7, 5, 4, -1, -1, -1}
        };

        boardsList.add(originalBoard1);
        boardsList.add(originalBoard2);
        boardsList.add(originalBoard3);
        boardsList.add(originalBoard4);
        boardsList.add(originalBoard5);
        boardsList.add(originalBoard6);
        boardsList.add(originalBoard7);
        boardsList.add(originalBoard8);
        boardsList.add(originalBoard9);
        boardsList.add(originalBoard10);

        Random rand = new Random();
        randomInt = rand.nextInt(9);
    }

    /*
    This method returns the randomized original board to the Board class.
     */
    public int[][] getRandomOriginalBoard(){
        return originalArray;
    }

    /*
    This method returns the randomized modified board to the Board class.
     */
    public int[][] getRandomModBoard(){
        return modArray;
    }

    /*
    This method returns the predefined original board to the Board class.
     */
    public int[][] getOriginalBoard()
    {
        return boardsList.get(randomInt);
    }

    /*
    This method returns the predefined modified board to the Board class.
     */
    public int[][] getModBoard()
    {
        int[][] modBoard = new int[9][9];
        int[][] originalBoard = boardsList.get(randomInt);
        for(int i=0;i<originalBoard.length;i++){
            for(int j=0;j<originalBoard[0].length;j++){
                modBoard[i][j] = originalBoard[i][j];
            }
        }

        return modBoard;
    }

}