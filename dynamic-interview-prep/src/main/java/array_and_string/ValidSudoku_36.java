package array_and_string;

import java.util.HashSet;

public class ValidSudoku_36 {
  char[][] board;
  int LEN = 9;

  private int getBoard(int r, int c) {
    char cur = board[r][c];
    if(cur == '.') {
      return 0;
    }
    return cur - '0';
  }

  private boolean validateRow(int r) {
    HashSet<Integer> set = new HashSet<>();
    for(int c = 0; c < LEN; c++) {
      int curVal = getBoard(r, c);
      if(curVal == 0) {
        continue;
      }
      if(set.contains(curVal)) {
        return false;
      }
      set.add(curVal);
    }
    return true;
  }

  private boolean validateRows() {
    for(int r = 0; r < LEN; r++) {
      if(validateRow(r) == false) {
        return false;
      }
    }
    return true;
  }

  private boolean validateColumn(int c) {
    HashSet<Integer> set = new HashSet<>();
    for(int r = 0; r < LEN; r++) {
      int curVal = getBoard(r, c);
      if(curVal == 0) {
        continue;
      }
      if(set.contains(curVal)) {
        return false;
      }
      set.add(curVal);
    }
    return true;
  }

  private boolean validateColumns() {
    for(int c = 0; c < LEN; c++) {
      if(validateColumn(c) == false) {
        return false;
      }
    }
    return true;
  }

  private boolean validateBox(int rOffSet, int cOffSet) {
    //System.out.println("rOffSet: " + rOffSet + " , cOffSet: " + cOffSet);
    HashSet<Integer> set = new HashSet<>();
    for(int rBegin = 0; rBegin < 3; rBegin++) {
      for(int cBegin = 0; cBegin < 3; cBegin++) {
        int r = rBegin + rOffSet;
        int c = cBegin + cOffSet;

        System.out.print("(" + r + "," + c + ")");

        int curVal = getBoard(r, c);
        if(curVal == 0) {
          continue;
        }
        if(set.contains(curVal)) {
          return false;
        }
        set.add(curVal);
      }
      System.out.println();
    }
    return true;
  }

  private boolean validateBoxes() {
    for(int rOffset = 0; rOffset < 9; rOffset += 3) {
      for(int cOffset = 0; cOffset < 9; cOffset += 3) {
        System.out.println("rOffSet: " + rOffset + " , cOffSet: " + cOffset);
        if(validateBox(rOffset, cOffset) == false) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    this.board = board;
    return validateRows() && validateColumns() && validateBoxes();
  }

  /******/
  public boolean isValidSudoku0(char[][] board) {
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
