package array_and_string;

public class FinalValueVariable_2011 {
  public int finalValueAfterOperations(String[] operations) {
    int curVal = 0;
    for (String op : operations) {
      if (op.contains("+")) {
        curVal++;
      } else {
        curVal--;
      }
    }
    return curVal;
  }
}
