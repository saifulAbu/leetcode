package alpha_rep;

import java.util.*;

public class GroupAnagram_49 {

  public List<List<String>> groupAnagrams_drona(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String key = buildKey(str);
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
  }

  private String buildKey(String str) {
    int[] freq = new int[26];
    for (char c : str.toCharArray()) {
      freq[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      sb.append((char)(i + 'a'));  // fix: cast to char
      sb.append(freq[i]);
      sb.append('#');              // delimiter prevents collision
    }
    return sb.toString();
  }

  private String buildKey_2_18(String str) {
    int[] freq = new int[26];
    for(char ch : str.toCharArray()) {
      freq[ch - 'a']++;
    }

    StringBuilder sb = new StringBuilder(100);
    for(int i = 0; i < 26; i++) {
      char ch = (char) (i + 'a');
      int count = freq[i];
      sb.append(ch);
      sb.append(count);
      sb.append('#');
    }
    return sb.toString();
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> group = new HashMap<>();
    for(String str : strs) {
      String key = buildKey_2_18(str);
      if(!group.containsKey(key)) {
        group.put(key, new LinkedList<>());
      }
      group.get(key).add(str);
    }
    return new LinkedList<>(group.values());
  }

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
  private String buildKey_2_19(String str) {
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
    String key = buildKey_2_19(str);
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


  public List<List<String>> groupAnagrams_old_01(String[] strs) {
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

  private String buildKey_2_26(String str) {
    int [] freq = new int[26];
    for(int i = 0; i < str.length(); i++) {
      freq[str.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder(str.length());
    for(int i = 0; i< 26; i++) {
      sb.append(i + 'a');
      sb.append(freq[i]);
      sb.append('#');
    }
    return sb.toString();
  }

  public List<List<String>> groupAnagrams_2_26(String[] strs) {
    HashMap<String, List<String>> groupAnagramMap = new HashMap<>();
    for(String str : strs) {
      String key = buildKey_2_26(str);
      if(!groupAnagramMap.containsKey(key)) {
        groupAnagramMap.put(key, new LinkedList<>());
      }
      groupAnagramMap.get(key).add(str);
    }
    return new LinkedList<>(groupAnagramMap.values());
  }
}
