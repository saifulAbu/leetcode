package array_and_string;

import java.util.*;

public class KeyBoardRow_500 {

  public String[] findWords(String[] words) {
    Set<Character> s0 = new HashSet<>();
    for (char ch : "qwertyuiop".toCharArray()) {
      s0.add(ch);
    }

    Set<Character> s1 = new HashSet<>();
    for (char ch : "asdfghjkl".toCharArray()) {
      s1.add(ch);
    }

    Set<Character> s2 = new HashSet<>();
    for (char ch : "zxcvbnm".toCharArray()) {
      s2.add(ch);
    }

    List<String> res = new LinkedList<>();

    for (String word : words) {
      if (allContainsInSameSet(word, s0, s1, s2)) {
        res.add(word);
      }
    }
    return res.toArray(new String[0]);
  }

  private boolean allContainsInSameSet(String str, Set s0, Set s1, Set s2) {
    char ch = Character.toLowerCase(str.charAt(0));
    Set setToConsider;
    if (s0.contains(ch)) {
      setToConsider = s0;
    } else if(s1.contains(ch)) {
      setToConsider = s1;
    } else {
      setToConsider = s2;
    }
    for (char c : str.toCharArray()) {
      if (!setToConsider.contains(Character.toLowerCase(c))){
        return false;
      }
    }
    return true;
  }
}

