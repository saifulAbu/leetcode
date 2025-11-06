package array_and_string;

import java.util.*;

public class GroupAnagram_49 {
  int[] histogram = new int[26];
  private void buildHistogram(String str) {
    //reset array
    for(int i = 0; i < histogram.length; i++) {
      histogram[i] = 0;
    }

    for(char ch : str.toCharArray()) {
      histogram[ch - 'a']++;
    }
  }

  StringBuilder sb = new StringBuilder();
  private String buildKey(String str) {
    sb.setLength(0);
    buildHistogram(str);

    for(int i = 0; i < histogram.length; i++) {
      sb.append(i + 'a');
      sb.append(histogram[i]);
    }
    return sb.toString();
  }

  HashMap<String, List<String>> groupedMap = new HashMap<>();
  private void addToMap(String str) {
    String key = buildKey(str);
    List<String> list = groupedMap.get(key);
    if(list == null) {
      list = new LinkedList<>();
    }
    list.add(str);
    groupedMap.put(key, list);
  }

  private void buildMap(String[] strs) {
    for(String str : strs) {
      addToMap(str);
    }
  }

  private List<List<String>> extractValues() {
    return new ArrayList(groupedMap.values());
  }


  public List<List<String>> groupAnagrams(String[] strs) {
    buildMap(strs);
    return extractValues();
  }

  /***/
  private int[] count = new int[26];
  public List<List<String>> groupAnagrams0(String[] strs) {
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
