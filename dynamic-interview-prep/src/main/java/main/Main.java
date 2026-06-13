package main;


import alpha_rep.*;

public class Main {

  public static void main(String [] args)
  {
    int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    GameOfLife_289 gm = new GameOfLife_289();
    gm.gameOfLife(board);
  }
}



