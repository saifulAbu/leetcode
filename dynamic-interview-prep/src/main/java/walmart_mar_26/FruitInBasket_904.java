package walmart_mar_26;

import java.util.HashMap;
import java.util.HashSet;

public class FruitInBasket_904 {
  public int totalFruit_bruteForce(int[] fruits) {
    int len = fruits.length;
    int maxFruit = 0;
    //calculate all possible (start, end)
    for(int s = 0; s < len; s++) {
      HashSet<Integer> set = new HashSet<>();
      int e = s;
      for(; e < len; e++) {
        set.add(fruits[e]);
        if(set.size() > 2) {
          break;
        }
        maxFruit = Math.max(maxFruit, e - s + 1);
      }
    }
    return maxFruit;
  }

  public int totalFruit(int[] fruits) {
    int len = fruits.length;
    int maxFruit = 0;
    HashMap<Integer, Integer> freqs = new HashMap<>();
    int s = 0;
    for(int e = 0; e < len; e++) {
      int in = fruits[e];
      freqs.put(in, freqs.getOrDefault(in, 0) + 1);

      while(freqs.size() > 2) {
        int out = fruits[s];
        freqs.put(out, freqs.get(out) - 1);
        if(freqs.get(out) == 0) {
          freqs.remove(out);
        }
        s++;
      }

      maxFruit = Math.max(maxFruit, e - s + 1);
    }

    return maxFruit;
  }

}
