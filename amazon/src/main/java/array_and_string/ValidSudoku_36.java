package array_and_string;

import java.util.HashSet;

public class ValidSudoku_36 {
  char[][] board;
  int LEN = 9;
  public boolean isValidSudoku(char[][] board) {
    this.board = board;
    //check rows
    for (int r = 0; r < LEN; r++) {
      if (!isValidRow(r)) {
        return false;
      }
    }
    //check column
    for (int c = 0; c < LEN; c++) {
      if (!isValidCol(c)) {
        return false;
      }
    }
    //check boxes
    for (int r = 0; r < LEN; r += 3) {
      for (int c = 0; c < LEN; c += 3) {
        if (!isValidBox(r, c)) {
          return false;
        }
      }
    }

    // all checks passed return true
    return true;
  }

  private boolean isValidRow(int r) {
    HashSet<Character> set = new HashSet<>();
    for (int c = 0; c < LEN; c++) {
      char ch = board[r][c];
      if (ch == '.') {
        continue;
      }
      if (set.contains(ch)) {
        return false;
      }
      set.add(ch);
    }
    return true;
  }

  private boolean isValidCol(int c) {
    HashSet<Character> set = new HashSet<>();
    for (int r = 0; r < LEN; r++) {
      char ch = board[r][c];
      if (ch == '.') {
        continue;
      }
      if (set.contains(ch)) {
        return false;
      }
      set.add(ch);
    }
    return true;
  }

  private boolean isValidBox(int startR, int startC) {
    HashSet<Character> set = new HashSet<>();
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        char ch = board[r + startR][c + startC];
        if (ch == '.') {
          continue;
        }
        if (set.contains(ch)) {
          return false;
        }
        set.add(ch);
      }
    }
    return true;
  }
}
