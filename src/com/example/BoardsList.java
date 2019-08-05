package com.example;

import java.util.*;

public class BoardsList {
    private ArrayList<int[][]> modList = new ArrayList<>();
    private ArrayList<int[][]> originalList = new ArrayList<>();
    private int randomInt;

    /*
    DEFAULT BOARD CONFIGURATION IF WANTED TO ADD MORE BOARDS
    int[][] board = {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
        };
     */

    public BoardsList()
    {
        //Randomize for selection later on
        Random rand = new Random();
        randomInt = rand.nextInt(3);

        //List of modified boards
        int[][] modBoard1 = {
                {-1, -1, -1, 2, 6, -1, 7, -1, 1},
                {6, 8, -1, -1, 7, -1, -1, 9, -1},
                {1, 9, -1, -1, -1, 4, 5, -1, -1},
                {8, 2, -1, 1, -1, -1, -1, 4, -1},
                {-1, -1, 4, 6, -1, 2, 9, -1, -1},
                {-1, 5, -1, -1, -1, 3, -1, 2, 8},
                {-1, -1, 9, 3, -1, -1, -1, 7, 4},
                {-1, 4, -1, -1, 5, -1, -1, 3, 6},
                {7, -1, 3, -1, 1, 8, -1, -1, -1}
        };
        int[][] modBoard2 = {
                {4, 2, 3, 6, -1, -1, -1, -1, 8},
                {8, -1, -1, -1, 9, 4, -1, 2, 5},
                {5, -1, 7, -1, -1, -1, -1, -1, -1},
                {9, -1, -1, 5, 7, 6, 4, 3, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 3, 4, 1, 2, 8, -1, -1, 6},
                {-1, -1, -1, -1, -1, -1, 6, -1, 1},
                {1, 4, -1, 3, 6, -1, -1, -1, 9},
                {2, -1, -1, -1, -1, 9, 7, 8, 3}
        };
        int[][] modBoard3 = {
                {-1, 3, 5, 4, 9, -1, -1, -1, -1},
                {-1, -1, 8, 2, -1, -1, -1, -1, -1},
                {9, -1, -1, -1, 7, 6, -1, -1, -1},
                {4, -1, 1, -1, 8, -1, 6, -1, 3},
                {-1, 6, 3, -1, 1, -1, 7, 4, -1},
                {5, -1, 7, -1, 6, -1, 9, -1, 1},
                {-1, -1, -1, 8, 3, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 1, 3, -1, -1},
                {-1, -1, -1, -1, 2, 5, 8, 9, -1}
        };
        int[][] modBoard4 = {
                {-1, -1, 3, -1, 2, 5, -1, -1, 6},
                {2, -1, -1, 9, -1, -1, -1, -1, -1},
                {-1, 6, -1, -1, 7, 3, -1, -1, -1},
                {1, 5, -1, -1, 9, 4, -1, 6, 3},
                {-1, -1, 2, 3, 5, 8, 4, -1, -1},
                {9, 3, -1, 6, 1, -1, -1, 5, 7},
                {-1, -1, -1, 5, 3, -1, -1, 4, -1},
                {-1, -1, -1, -1, -1, 9, -1, -1, 1},
                {7, -1, -1, 4, 6, -1, 9, -1, -1}
        };

        //List of original boards
        int[][] originalBoard1 = {
                {-1, -1, -1, 2, 6, -1, 7, -1, 1},
                {6, 8, -1, -1, 7, -1, -1, 9, -1},
                {1, 9, -1, -1, -1, 4, 5, -1, -1},
                {8, 2, -1, 1, -1, -1, -1, 4, -1},
                {-1, -1, 4, 6, -1, 2, 9, -1, -1},
                {-1, 5, -1, -1, -1, 3, -1, 2, 8},
                {-1, -1, 9, 3, -1, -1, -1, 7, 4},
                {-1, 4, -1, -1, 5, -1, -1, 3, 6},
                {7, -1, 3, -1, 1, 8, -1, -1, -1}
        };
        int[][] originalBoard2 = {
                {4, 2, 3, 6, -1, -1, -1, -1, 8},
                {8, -1, -1, -1, 9, 4, -1, 2, 5},
                {5, -1, 7, -1, -1, -1, -1, -1, -1},
                {9, -1, -1, 5, 7, 6, 4, 3, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 3, 4, 1, 2, 8, -1, -1, 6},
                {-1, -1, -1, -1, -1, -1, 6, -1, 1},
                {1, 4, -1, 3, 6, -1, -1, -1, 9},
                {2, -1, -1, -1, -1, 9, 7, 8, 3}
        };
        int[][] originalBoard3 = {
                {-1, 3, 5, 4, 9, -1, -1, -1, -1},
                {-1, -1, 8, 2, -1, -1, -1, -1, -1},
                {9, -1, -1, -1, 7, 6, -1, -1, -1},
                {4, -1, 1, -1, 8, -1, 6, -1, 3},
                {-1, 6, 3, -1, 1, -1, 7, 4, -1},
                {5, -1, 7, -1, 6, -1, 9, -1, 1},
                {-1, -1, -1, 8, 3, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 1, 3, -1, -1},
                {-1, -1, -1, -1, 2, 5, 8, 9, -1}
        };
        int[][] originalBoard4 = {
                {-1, -1, 3, -1, 2, 5, -1, -1, 6},
                {2, -1, -1, 9, -1, -1, -1, -1, -1},
                {-1, 6, -1, -1, 7, 3, -1, -1, -1},
                {1, 5, -1, -1, 9, 4, -1, 6, 3},
                {-1, -1, 2, 3, 5, 8, 4, -1, -1},
                {9, 3, -1, 6, 1, -1, -1, 5, 7},
                {-1, -1, -1, 5, 3, -1, -1, 4, -1},
                {-1, -1, -1, -1, -1, 9, -1, -1, 1},
                {7, -1, -1, 4, 6, -1, 9, -1, -1}
        };

        //Adds the boards to the lists to be used later
        this.modList.add(modBoard1);
        this.modList.add(modBoard2);
        this.modList.add(modBoard3);
        this.modList.add(modBoard4);
        this.originalList.add(originalBoard1);
        this.originalList.add(originalBoard2);
        this.originalList.add(originalBoard3);
        this.originalList.add(originalBoard4);
        System.out.println("Currently " + 4 + " different boards are available.");
    }

    /*
    This method returns the randomized original board to the Board class.
     */
    public int[][] getNewOriginalBoard(){
        return originalList.get(randomInt);
    }

    /*
    This method returns the randomized modified board to the Board class.
     */
    public int[][] getNewModBoard(){
        return modList.get(randomInt);
    }

}
/*
        Used to create a default board. May be useful later for sudoku board algorithm
        board = new int[rows][cols];

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //This if condition checks wheter a blank space should be entered
                if ((j + 1) % 4 == 0 || (i + 1) % 4 == 0) {
                    this.board[i][j] = 0;
                    //This variable is used to keep the numbers from going over 9
                    colPosition ++;
                }
                else {
                    this.board[i][j] = j + 1 - colPosition;
                }
            }
            colPosition = 0;
        }
        */