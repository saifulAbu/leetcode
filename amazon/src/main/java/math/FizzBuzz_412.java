package math;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz_412 {
  public List<String> fizzBuzz_0(int n) {
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

  public List<String> fizzBuzz(int n) {
    String DIV_15 = "FizzBuzz";
    String DIV_5 = "Buzz";
    String DIV_3 = "Fizz";

    LinkedList<String> res = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0) {
        res.add(DIV_15);
      } else if (i % 5 == 0) {
        res.add(DIV_5);
      } else if (i % 3 == 0) {
        res.add(DIV_3);
      } else {
        res.add(Integer.toString(i));
      }
    }
    return res;
  }
}
