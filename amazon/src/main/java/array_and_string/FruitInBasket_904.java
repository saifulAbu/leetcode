package array_and_string;

public class FruitInBasket_904 {
  public int totalFruit(int[] trees) {
    int f0 = -1;
    int f1 = -1;
    int f1Count = 0;
    int max = 0;
    int curMax = 0;

    for(int fruitType : trees) {
      if(fruitType == f1) {
        f1Count++;
        curMax++;
      } else if(fruitType == f0) {
        f1Count = 1;
        f0 = f1;
        f1 = fruitType;
        curMax++;
      } else {
        curMax = f1Count + 1;
        f1Count = 1;
        f0 = f1;
        f1 = fruitType;
      }
      max = Math.max(max, curMax);
    }
    return max;
  }
}
