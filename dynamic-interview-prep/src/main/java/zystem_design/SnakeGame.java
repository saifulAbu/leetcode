package zystem_design;

import java.util.Deque;
import java.util.List;
import java.util.Random;

public class SnakeGame {

}

enum Direction {
  UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

  int r, c;
  Direction(int r, int c) {
    this.r = r;
    this.c = c;
  }
}

class Position {
  private int r, c;

  Position(int r, int c) {
    this.r = r;
    this.c = c;
  }

  int getR() {
    return r;
  }

  int getC() {
    return c;
  }

  @Override
  public boolean equals(Object other) {
    if(!(other instanceof Position)) {
      return false;
    }
    Position otherPosition = (Position) other;
    return r == otherPosition.getR() && c == otherPosition.getC();
  }

  @Override
  public int hashCode() {
    return 31 * r + c;
  }

  public Position advance(Direction direction) {
    return new Position(r + direction.r, c + direction.c);
  }
}

class Snake {
  Deque<Position> occupiedCoordinates;
  Direction direction;

  Snake(Deque<Position> occupiedCoordinates) {
    this.occupiedCoordinates = occupiedCoordinates;
  }

  Position getHeadPosition() {
    return occupiedCoordinates.getFirst();
  }

  Direction getDirection() {
    return direction;
  }

  boolean collidesWith(Position position) {
    return occupiedCoordinates.contains(position);
  }

  public void advanceToNextPosition(Position nextHeadPosition, boolean landedOnFood) {
    occupiedCoordinates.addFirst(nextHeadPosition);
    if(!landedOnFood) {
      occupiedCoordinates.removeLast();
    }
  }

  public void setDirection(Direction newDirection) {
    // don't let change direction to the opposite side immediately
    if((direction == Direction.UP && newDirection == Direction.DOWN) ||
            (direction == Direction.DOWN && newDirection == Direction.UP) ||
            (direction == Direction.LEFT && newDirection == Direction.RIGHT) ||
            (direction == Direction.RIGHT && newDirection == Direction.LEFT))  {
      return;
    }
    direction = newDirection;
  }

  public boolean contains(Position foodPosition) {
    return occupiedCoordinates.contains(foodPosition);
  }
}

class Board {
  Position foodPosition;
  Random rand;
  int R, C;

  Board(int r, int c) {
    R = r;
    c = C;
  }

  boolean isInBoard(Position position) {
    int r = position.getR(), c = position.getC();
    return (r >= 0 && r < R && c >= 0 && c < C);
  }

  Position getCurrentFoodPosition() {
    return foodPosition;
  }

  void spawnFood(Snake snake) {
    while(true) {
      int r = rand.nextInt(R);
      int c = rand.nextInt(C);
      foodPosition = new Position(r, c);
      if(!snake.contains(foodPosition)) {
        break;
      }
    }
  }
}

class GameEngine {
  Snake snake;
  Board board;
  boolean gameOver = false;

  GameEngine(Snake snake, Board board) {
    this.snake = snake;
    this.board = board;
  }

  // will be called from mainLoop which is a infinite a forloop
  void tick() {
    if(gameOver) {
      return;
    }

    // determine next head position
    Position nextHeadPosition = snake.getHeadPosition().advance(snake.getDirection());

    // check if it is a collision with the board or with the snake it self
    if(!board.isInBoard(nextHeadPosition) || snake.collidesWith(nextHeadPosition)) {
      gameOver = true;
      return;
    }

    // check if head landed on food position
    boolean landedOnFood = false;
    if(board.getCurrentFoodPosition().equals(nextHeadPosition)) {
      landedOnFood = true;
    }

    // if landed on food, increase score, grow snake
    snake.advanceToNextPosition(nextHeadPosition, landedOnFood);

    // ask board to put new food
    if(landedOnFood) {
      board.spawnFood(snake);
    }

    // sleep
    //Thread.sleep(1000);
  }

  void handleInput(Direction newDirection) {
    snake.setDirection(newDirection);
  }
}


/*
enum Direction {
  UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

  final int r, c;
  Direction(int r, int c) {
    this.r = r;
    this.c = c;
  }
}

class Position {

  int r, c;
  public Position(int foodR, int foodC) {
    this.r = foodR;
    this.c = foodC;
  }

  public Position advanceAStepTo(Direction direction) {
    return new Position(r + direction.r, c + direction.c);
  }

  public int getR() {
    return r;
  }

  public int getC() {
    return c;
  }
}

class Snake {

  Direction direction;
  Deque<Position> positions;

  Snake(Deque<Position> positions, Direction direction) {
    this.positions = positions;
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public Position getHead() {
    return positions.getFirst();
  }

  public boolean contains(Position position) {
    return positions.contains(position);
  }

  public void addFront(Position nextHeadPosition, boolean grow) {
    positions.addFirst(nextHeadPosition);
    if(!grow) {
      positions.removeLast();
    }
  }

  public void setDirection(Direction newDirection) {
    this.direction = direction;
  }
}

class Board {
  int R, C;
  Position foodPosition;
  Random rand = new Random();
  
  Board(int r, int c) {
    this.R = r;
    this.C = c;
  }

  public boolean isInBoard(Position position) {
    int r = position.getR(), c = position.getC();
    if(r >= 0 && r < R && c >= 0 && c < C) {
      return true;
    }
    return false;
  }

  public boolean hasFoodIn(Position position) {
    return foodPosition.equals(position);
  }

  public void spawnFood(Snake snake) {
    Position snakeHead = snake.getHead();
    int r = snakeHead.getR(), c = snakeHead.getC();

    while (true) {
      int foodR = rand.nextInt(R), foodC = rand.nextInt(C);

      foodPosition = new Position(foodR, foodC);
      if(!snake.contains(foodPosition)) {
        break;
      }
    }
  }
}

class GameEngine {
  boolean gameOver = false;
  Snake snake;
  Board board;
  int score;

  GameEngine(Board board, Snake snake) {
    this.snake = snake;
    this.board = board;
  }

  void tick() throws InterruptedException {
    if(gameOver) {
      return;
    }

    Position currentSnakeHeadPosition = snake.getHead();
    Direction currentSnakeDirection = snake.getDirection();
    Position nextHeadPosition = currentSnakeHeadPosition.advanceAStepTo(currentSnakeDirection);
    
    // check if the next head position is
    // 0. out of the board
    // 1. hits the snake itself
    if(!board.isInBoard(nextHeadPosition) || snake.contains(nextHeadPosition)) {
      gameOver = true;
      return;
    }
    
    boolean grow = false;
    // 2. into a the food
    if(board.hasFoodIn(nextHeadPosition)) {
      grow = true;
      score++;
      board.spawnFood(snake);
    }
    
    //grow snake
    snake.addFront(nextHeadPosition, grow);
    
    //sleep for some time
    Thread.sleep(1000);
  }

  public void handleInput(Direction newDirection) {
    //make sure we cannot immediately go to the opposite direction
    Direction currentDirection = snake.getDirection();
    if(         (currentDirection == Direction.UP && newDirection == Direction.DOWN)
            ||  (currentDirection == Direction.DOWN && newDirection == Direction.UP )
            ||  (currentDirection == Direction.LEFT && newDirection == Direction.RIGHT )
            ||  (currentDirection == Direction.RIGHT && newDirection == Direction.LEFT )
    ) {
      return;
    }
    snake.setDirection(newDirection);
  }

}
 */