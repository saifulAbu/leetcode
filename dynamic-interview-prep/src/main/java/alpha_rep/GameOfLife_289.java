package alpha_rep;

public class GameOfLife_289 {
  public void gameOfLife(int[][] board) {
    /*
    * we will have a new grid. this problem can be done in one go. using encoding.
    * 2 --> currently dead will remain dead
    * 3 --> currently dead will be alive
    * 4 --> currently alive, will be dead
    * 5 -- > currently alive, will remain alive
    *
    * for simplicity, for now we are doing a separate board
    *
    * */

    int R = board.length, C = board[0].length;
    int [][] nextBoard = new int[R][C];

    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        int neighBourCount = getNeighbor(r, c, R, C, board);
        int nextState = 0;
        int curState = board[r][c];
        if((curState == 1 && (neighBourCount == 2 || neighBourCount == 3))  || (curState == 0 && neighBourCount == 3)) {
          nextState = 1;
        }
        nextBoard[r][c] = nextState;
      }
    }

    //update board
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        board[r][c] = nextBoard[r][c];
      }
    }

  }

  private int getNeighbor(int r, int c, int R, int C, int[][] grid) {
    int[][] directions = {
            {-1,-1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0},  {1, 1}};

    int count = 0;
    for(int[] direction : directions) {
      int nR = r + direction[0];
      int nC = c + direction[1];
      if(nR >= 0 && nR < R && nC >= 0 && nC < C && grid[nR][nC] == 1) {
        count++;
      }
    }
    return count;
  }
}
