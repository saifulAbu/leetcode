package array_and_string;

public class ReduceToZero_1342 {
  public int numberOfSteps (int num) {
    int numSteps = 0;
    while(num > 0) {
      if(num % 2 == 0) {
        num = num / 2;
      } else {
        num = num - 1;
      }
      numSteps++;
    }
    return numSteps;
  }
}
