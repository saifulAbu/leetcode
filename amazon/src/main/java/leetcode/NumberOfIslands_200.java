package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class NumberOfIslands_200 {
  private int[] DIRECTIONS = {0, 0, -1, +1}; // THIS NEEDS TO BE UPDATED LATER PART OF THE CODE
  Stack<Integer> blockStack = new Stack<>();
  int NUM_BLOCKS;
  int[] visitedBlocks;
  int[] terrain;

  void flattenGrid(char[][] grid) {
    int R = grid.length, C = grid[0].length;
    NUM_BLOCKS = R * C;

    DIRECTIONS[0] = +C;
    DIRECTIONS[1] = -C;

    visitedBlocks = new int[NUM_BLOCKS];
    terrain = new int[NUM_BLOCKS];

    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        int curBlock = r * C + c;
        terrain[curBlock] = grid[r][c] == '1' ? 1 : 0;
      }
    }
  }

  private void exploreStartingFromBlock(int block) {
    blockStack.push(block);
    visitedBlocks[block] = 1;

    while(!blockStack.isEmpty()) {
      int curBlock = blockStack.pop();
      for(int direction : DIRECTIONS) {
        int neighbor = curBlock + direction;
        if(isValid(neighbor) && terrain[neighbor] == 1 && visitedBlocks[neighbor] == 0) {
          exploreStartingFromBlock(neighbor);
        }
      }
    }
  }

  private boolean isValid(int block) {
    return block >= 0 && block < NUM_BLOCKS;
  }

  public int numIslands(char[][] grid) {
    flattenGrid(grid);
    int numIsland = 0;

    for(int curBlock = 0; curBlock < NUM_BLOCKS; curBlock++) {
      //if this is a land and not visited before
      if(terrain[curBlock] == 1 && visitedBlocks[curBlock] == 0) {
        numIsland++;
        exploreStartingFromBlock(curBlock);
      }
    }

    return numIsland;
  }
}

class NumberOfIslands_1_200 {
  int R, C; // row and column count
  int[][] DIR_OFFSET = {{-1, 0}, {1, 0}, {0, -1}, {0, 1} };
  boolean [][] visited;
  int [][] board;

  public int numIslands(char[][] grid) {
    R = grid.length;
    C = grid[0].length;

    visited = new boolean[R][C];
    board = new int[R][C];

    initialize(grid);

    int numIslands = 0;
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        if(board[r][c] == 1 && visited[r][c] == false) {
          numIslands++;
          bfs(r, c);
        }
      }
    }
    return numIslands;
  }

  private void initialize(char[][] grid) {
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        board[r][c] = grid[r][c] - '0';
      }
    }

    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        visited[r][c] = false;
      }
    }
  }

  class Coordinates {
    int r, c;
    Coordinates (int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  private void bfs(int r, int c) {
    Queue<Coordinates> q = new LinkedList<>();
    q.offer(new Coordinates(r, c));
    visited[r][c] = true;
    while (!q.isEmpty()) {
      Coordinates coordinate = q.poll();
      int curR = coordinate.r, curC = coordinate.c;
      for(int dirRow = 0; dirRow < 4; dirRow++) {
        int neighborR = curR + DIR_OFFSET[dirRow][0], neighborC = curC  + DIR_OFFSET[dirRow][1];
        if(isValid(neighborR, neighborC) && board[neighborR][neighborC] == 1 && !visited[neighborR][neighborC]) {
          q.offer(new Coordinates(neighborR, neighborC));
          visited[neighborR][neighborC] = true;
        }
      }
    }
  }

  private boolean isValid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }
}

class NumberOfIslands_0_200 {
  boolean [][] visited;
  int m, n;
  int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  char [][] grid;
  public int numIslands(char[][] grid) {
    this.grid = grid;
    m = grid.length;
    n = grid[0].length;
    visited = new boolean[m][n];
    int numIsland = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == '1' && !visited[r][c]) {
          bfs(r, c);
          numIsland++;
        }
      }
    }
    return numIsland;
  }
  private void bfs(int r, int c) {
    Queue<int []> q = new LinkedList<>();
    visited[r][c] = true;
    q.offer(new int[] {r, c});
    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int[] curBlock = q.poll();
        int curR = curBlock[0];
        int curC = curBlock[1];
        for (int []direction : directions) {
          int nextR = curR + direction[0];
          int nextC = curC + direction[1];
          if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && visited[nextR][nextC] == false && grid[nextR][nextC] == '1') {
            visited[nextR][nextC] = true;
            q.offer(new int[] {nextR, nextC});
          }
        }
      }
    }
  }
}
