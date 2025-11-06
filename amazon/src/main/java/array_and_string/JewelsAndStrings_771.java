package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStrings_771 {

  private Set<Character> makeJewelSet(String jewels) {
    Set<Character> jewelSet = new HashSet<>();
    for(Character jewel : jewels.toCharArray()) {
      jewelSet.add(jewel);
    }
    return jewelSet;
  }

  private int countJewelsInStones(Set<Character> jewelSet, String stones) {
    int count = 0;
    for(Character stone : stones.toCharArray()) {
      if(jewelSet.contains(stone)) {
        count++;
      }
    }
    return count;
  }

  public int numJewelsInStones(String jewels, String stones) {
    return countJewelsInStones(makeJewelSet(jewels), stones);
  }

  public int numJewelsInStones0(String jewels, String stones) {
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
