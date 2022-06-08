package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_249 {
  public List<List<String>> groupStrings(String[] strs) {
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
    int [] count = new int[str.length() - 1];
    for(int i = 1; i < str.length(); i++) {
      count[i-1] = (str.charAt(i) - str.charAt(i-1) + 26) % 26;
    }
    StringBuilder hash = new StringBuilder();
    for(int i = 0; i < count.length; i++) {
      hash.append('#');
      hash.append(count[i]);
    }
    return hash.toString();
  }
}
