package math;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz_412 {
  public List<String> fizzBuzz(int n) {
    LinkedList<String> res = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        res.add("FizzBuzz");
      } else if (i % 3 == 0) {
        res.add("Fizz");
      } else if (i % 5 == 0) {
        res.add("Buzz");
      } else {
        res.add(Integer.toString(i));
      }
    }
    return res;
  }
}
