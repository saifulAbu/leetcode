package array_and_string;

import java.util.*;

public class GroupAnagram_49 {
  private int[] count = new int[26];
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groups = new HashMap<>();
    for (String str : strs) {
      String hash = getHash(str);
      if (!groups.containsKey(hash)) {
        groups.put(hash, new LinkedList<String>());
      }
      groups.get(hash).add(str);
    }
    return new ArrayList(groups.values());
  }

  private String getHash(String str) {
    for (char c : str.toCharArray()) {
      count[c - 'a']++;
    }
    StringBuilder hash = new StringBuilder();
    for (int i = 0; i < count.length; i++) {
      hash.append(i);
      hash.append('x');
      hash.append(count[i]);
      hash.append('x');
      count[i] = 0;
    }
    return hash.toString();
  }
}
