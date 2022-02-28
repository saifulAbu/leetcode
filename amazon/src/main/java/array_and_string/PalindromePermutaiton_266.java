package array_and_string;

import java.util.HashMap;

public class PalindromePermutaiton_266 {
  public boolean canPermutePalindrome(String s) {
    HashMap<Character, Integer> count = new HashMap<>();
    for (char c : s.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    int oddCount = 0;
    for (char ch : count.keySet()) {
      if (count.get(ch) % 2 != 0) {
        oddCount++;
        if (oddCount > 1) {
          return false;
        }
      }
    }
    return true;
  }
}
