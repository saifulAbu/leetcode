package backtracking;

public class SudokuSolver_37 {
  int n = 9;
  int [][]row = new int[n][n+1];
  int [][]col = new int[n][n+1];
  int [][] group = new int[n][n+1];
  int [][] grid = new int[n][n];

  private void fillup(char[][] board) {
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        char curVal = board[r][c];
        if (curVal != '.') {
          int d = curVal - '0';
          int grp = getGrp(r, c);
          placeNumber(r, c, grp, d);
        }
      }
    }
  }

  private void updateBoard(char[][] board) {
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        int curVal = grid[r][c];
        if (curVal == 0) {
          board[r][c] = '.';
        } else {
          board[r][c] = (char) (curVal + '0');
        }
      }
    }
  }

  private int getGrp(int r, int c) {
    return 3 * (r / 3) + c / 3;
  }

  private boolean canPlaceNumber(int r, int c, int grp, int d) {
    return grid[r][c] == 0 && row[r][d] == 0 && col[c][d] == 0 && group[grp][d] == 0;
  }

  private void placeNumber(int r, int c, int grp, int d) {
    grid[r][c] = d;
    row[r][d]++;
    col[c][d]++;
    group[grp][d]++;
  }

  private void removeNumber(int r, int c, int grp, int d) {
    grid[r][c] = 0;
    row[r][d]--;
    col[c][d]--;
    group[grp][d]--;
  }

  private boolean helper(int r, int c) {
    if (r == n) {
      return true;
    }
    int grp = getGrp(r, c);
    int nextR = r;
    int nextC = c + 1;
    if (nextC == n) {
      nextC = 0;
      nextR = r + 1;
    }

    if (grid[r][c] == 0) {
      for (int d = 1; d <= 9; d++) {
        if (canPlaceNumber(r, c, grp, d)) {
          placeNumber(r, c, grp, d);
          if (helper(nextR, nextC)) {
            return true;
          }
          removeNumber(r, c, grp, d);
        }
      }
      return false;
    } else {
      return helper(nextR, nextC);
    }
  }

  public void solveSudoku(char[][] board) {
    fillup(board);
    helper(0, 0);
    updateBoard(board);
  }
  
  public static void main(String args[]) {
    SudokuSolver_37 sk = new SudokuSolver_37();
    char [][] brd = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };
    sk.solveSudoku(brd);
    System.out.println();
  }
}
