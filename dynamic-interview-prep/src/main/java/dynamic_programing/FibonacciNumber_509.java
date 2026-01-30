package dynamic_programing;

import java.util.HashMap;

public class FibonacciNumber_509 {
  HashMap<Integer, Integer> cache = new HashMap<>();

  public int fib(int n) {
    cache.put(0, 0);
    cache.put(1, 1);
    return helper(n);
  }

  private int helper(int n) {
    if (!cache.containsKey(n)) {
      cache.put(n, helper(n - 1) + helper(n-2));
    }
    return cache.get(n);
  }
}
