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
}
