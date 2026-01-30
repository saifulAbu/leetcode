package array_and_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for(String str : strs) {
      String hash = getHash(str);
      map.putIfAbsent(hash, new ArrayList<String>());
      List list = map.get(hash);
      list.add(str);
    }

    return new ArrayList<>(map.values());
  }

  private String getHash(String str){
    int [] count = new int[26];
    for(int i = 0; i < str.length(); i++) {
      count[str.charAt(i) - 'a']++;
    }
    StringBuilder hash = new StringBuilder();
    for(int i = 0; i < count.length; i++) {
      hash.append('#');
      hash.append(count[i]);
    }
    return hash.toString();
  }

  public static void main(String args[]) {
    String [] strs = {"eat","tea","tan","ate","nat","bat"};
    GroupAnagrams_49 sol = new GroupAnagrams_49();
    System.out.println(sol.groupAnagrams(strs));
  }
}
