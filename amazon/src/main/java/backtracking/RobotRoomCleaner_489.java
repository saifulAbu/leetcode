//package backtracking;
//
//import javafx.util.Pair;
//
//import java.util.HashSet;
//
//public class RobotRoomCleaner_489 {
//  int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//  HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
//  int dir = 1;
//  Robot robot;
//  private  void left() {
//    dir = (dir + 1) % 4;
//    robot.turnLeft();
//  }
//  private  void right() {
//    dir = (dir + 4 - 1) % 4;
//    robot.turnRight();
//  }
//  private void goBack() {
//    right();
//    right();
//    robot.move();
//    right();
//    right();
//  }
//  public void cleanRoom(Robot robot) {
//    this.robot = robot;
//    cleanHelper(new Pair<Integer, Integer>(0, 0));
//  }
//
//  private void cleanHelper(Pair<Integer, Integer> pair) {
//    visited.add(pair);
//    robot.clean();
//    int x = pair.getKey();
//    int y = pair.getValue();
//    for (int i = 0; i < 4; i++) {
//      int[] direction = directions[dir];
//      int nextX = x + direction[0], nextY = y + direction[1];
//      Pair<Integer, Integer> nextPair = new Pair<>(nextX, nextY);
//      if (!visited.contains(nextPair)) {
//        if (!robot.move()) {
//          visited.add(nextPair);
//        } else {
//          cleanHelper(nextPair);
//          goBack();
//        }
//      }
//      right();
//    }
//  }
//
//  interface Robot {
//    // Returns true if the cell in front is open and robot moves into the cell.
//    // Returns false if the cell in front is blocked and robot stays in the current cell.
//    public boolean move();
//
//    // Robot will stay in the same cell after calling turnLeft/turnRight.
//    // Each turn will be 90 degrees.
//    public void turnLeft();
//
//    public void turnRight();
//
//    // Clean the current cell.
//    public void clean();
//  }
//}
