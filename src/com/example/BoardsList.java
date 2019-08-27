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
        int[][] modBoard2 = {
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
        int[][] modBoard3 = {
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
        int[][] modBoard4 = {
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
        System.out.println("To win the game, all values must be correct and finalized.");
        System.out.println("Enter a number to replace at the col/row, or type -1 to clear the slot.");
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