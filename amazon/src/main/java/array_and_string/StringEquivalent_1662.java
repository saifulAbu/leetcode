package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class StringEquivalent_1662 {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    List<Character> l1 = new ArrayList<>();
    List<Character> l2 = new ArrayList<>();

    fillList(word1, l1);
    fillList(word2, l2);

    if(l1.size() != l2.size()) {
      return false;
    }

    for(int i = 0; i < l1.size(); i++) {
      if(l1.get(i) != l2.get(i)) {
        return false;
      }
    }

    return true;
  }

  private void fillList(String[] words, List<Character> l1) {
    for(String word : words) {
      for(char c : word.toCharArray()) {
        l1.add(c);
      }
    }
  }
}
