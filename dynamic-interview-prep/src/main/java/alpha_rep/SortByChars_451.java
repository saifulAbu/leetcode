package alpha_rep;

import java.util.*;

public class SortByChars_451 {
  public String frequencySort(String s) {
    HashMap<Character, Integer> freq = new HashMap<>();
    for(Character ch : s.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }

    TreeMap<Integer, Set<Character>> sortedBucket = new TreeMap<>(Collections.reverseOrder());
    for(Character ch : freq.keySet()) {
      int count = freq.get(ch);
      if(!sortedBucket.containsKey(count)) {
        sortedBucket.put(count, new HashSet<>());
      }
      sortedBucket.get(count).add(ch);
    }

    StringBuilder sb = new StringBuilder(s.length());

    for(Integer count : sortedBucket.keySet()) {
      for(char ch : sortedBucket.get(count)) {
        for(int i = 0; i < count; i++) {
          sb.append(ch);
        }
      }
    }
    return sb.toString();
  }
}
