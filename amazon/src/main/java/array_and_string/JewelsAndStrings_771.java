package array_and_string;

import java.util.HashSet;

public class JewelsAndStrings_771 {
  public int numJewelsInStones(String jewels, String stones) {
    int res = 0;

    HashSet<Character> jewelSet = new HashSet<>();
    for(char jewel : jewels.toCharArray()) {
      jewelSet.add(jewel);
    }

    for(char stone : stones.toCharArray()) {
      if(jewelSet.contains(stone)) {
        res++;
      }
    }

    return res;
  }
}
