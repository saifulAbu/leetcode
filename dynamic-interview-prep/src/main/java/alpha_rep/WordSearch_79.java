package alpha_rep;

public class WordSearch_79 {
  char[][] board;
  boolean[][] seen;
  String word;
  int R, C;

  public boolean exist(char[][] board, String word) {
    /*
    * we will use dfs
    * for each r, c, we will start
    * dfs(r, c, i)
    *   if i == word.len return true
    *   if r, c is valid and !seen[r][c] and if board[r][c] == word.at(i)
    *     seen[r][c] = true
    *     wordFound = dfs(r-1, c, i+1) || dfs(r+1, c, i+1) || ...
    *     seen[r][c] = false
    *     return wordFound
    *
    * */
    this.board = board;
    this.word = word;
    R = board.length;
    C = board[0].length;
    seen = new boolean[R][C];

    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        if(dfs(r, c, 0)){
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(int r, int c, int i) {
    if(i == word.length()) {
      return true;
    }

    if(r < 0 || r >= R || c < 0 || c >= C || seen[r][c] || board[r][c] != word.charAt(i)) {
      return false;
    }

    seen[r][c] = true;
    boolean wordFound =
                    dfs(r - 1, c, i + 1) ||
                    dfs(r + 1, c, i + 1) ||
                    dfs(r , c - 1, i + 1) ||
                    dfs(r , c + 1, i + 1) ;
    seen[r][c] = false;
    return wordFound;
  }


  public boolean exist_3_7(char[][] board, String word) {
    int R = board.length;
    int C = board[0].length;
    boolean[][] seen = new boolean[R][C];
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        if(dfs_3_7(board, word, seen, R, C, r, c, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs_3_7(char[][] board, String word, boolean[][] seen, int R, int C, int r, int c, int index) {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    if(index >= word.length()) {
      return true;
    }
    if(isValid(r, R) && isValid(c, C) && seen[r][c]) {
      return false;
    }

    if(board[r][c] != word.charAt(index)) {
      return false;
    }
    seen[r][c] = true;
    for(int [] direction : directions) {
      int nr = r + direction[0];
      int nc = c + direction[1];
      if(dfs_3_7(board, word, seen, R, C, nr, nc, index+1)) {
        return true;
      }

    }
    seen[r][c] = false;
    return false;
  }

  private boolean isValid(int r, int R) {
    return r >= 0 && r < R;
  }

  public boolean exist_drona(char[][] board, String word) {
    int R = board.length, C = board[0].length;
    boolean[][] visited = new boolean[R][C];

    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (dfs(board, word, visited, r, c, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, boolean[][] visited,
                      int r, int c, int index) {

    // 1. Base case: full word matched
    if (index == word.length()) {
      return true;
    }

    // 2. Bounds + visited + character mismatch checks
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
      return false;
    }
    if (visited[r][c] || board[r][c] != word.charAt(index)) {
      return false;
    }

    // 3. Choose
    visited[r][c] = true;

    // 4. Explore neighbors
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    for (int[] d : dirs) {
      if (dfs(board, word, visited, r + d[0], c + d[1], index + 1)) {
        return true;
      }
    }

    // 5. Unchoose (backtrack)
    visited[r][c] = false;
    return false;
  }

  int R_42, C_42;
  boolean[][] visited_42;
  char[][] board_42;
  String word_42;
  public boolean exist_4_2(char[][] board, String word) {
    R_42 = board.length;
    C_42 = board[0].length;
    visited_42 = new boolean[R_42][C_42];
    board_42 = board;
    word_42 = word;

    for(int r = 0; r < R_42; r++) {
      for(int c = 0; c < C_42; c++) {
        if(dfs_42(0, r, c)){
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs_42(int i, int r, int c) {
    if(i == word_42.length()) {
      return true;
    }
    if(r < 0 || r >= R_42 || c < 0 || c >= C_42 || visited_42[r][c] || board_42[r][c] != word_42.charAt(i)) {
      return false;
    }
    visited_42[r][c] = true;
    int[][] neigbhors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for(int [] neighbor : neigbhors) {
      int nr = r + neighbor[0], nc = c + neighbor[1];
      if(dfs_42(i + 1, nr, nc)) {
        return true;
      }
    }
    visited_42[r][c] = false;
    return false;
  }

}
