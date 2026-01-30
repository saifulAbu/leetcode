package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class PanGram_1832 {
  public boolean checkIfPangram(String sentence) {
    Set<Character> set = new HashSet<>();

    for(Character ch : sentence.toCharArray()) {
      set.add(ch);
    }
    if (set.size() == 26) {
      return true;
    }
    return false;
  }
}
