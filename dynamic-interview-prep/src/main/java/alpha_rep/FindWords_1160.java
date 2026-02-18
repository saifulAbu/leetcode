package alpha_rep;

import java.util.HashMap;

public class FindWords_1160 {
  HashMap<Character, Integer> getWordFreq(String word) {
    HashMap<Character, Integer> freq = new HashMap<>();
    for(Character ch : word.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }
    return freq;
  }

  boolean canForm(HashMap<Character, Integer> targetMap, HashMap<Character, Integer> availableCharMap) {
    for(Character ch : targetMap.keySet()) {
      if(targetMap.get(ch) > availableCharMap.getOrDefault(ch, 0)) {
        return false;
      }
    }
    return true;
  }

  public int countCharacters(String[] words, String chars) {
    HashMap<Character, Integer> availableChars = getWordFreq(chars);

    int count = 0;
    for(String word : words) {
      if(canForm(getWordFreq(word), availableChars)) {
        count += word.length();
      }
    }
    return count;
  }
}
