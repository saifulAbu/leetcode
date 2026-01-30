package hash;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbr_288 {
  public UniqueWordAbbr_288(String[] dictionary) {
    initialize(dictionary);
  }

  HashMap<String, Integer> map = new HashMap<>();
  HashSet<String> set = new HashSet<>();

  private void initialize(String[] dictionary) {
    for(String word : dictionary) {
      if(set.contains(word)) {
        continue;
      }
      set.add(word);
      String abr = getAbbr(word);
      map.put(abr, map.getOrDefault(abr, 0) + 1);
    }
  }

  public boolean isUnique(String word) {
    String abr = getAbbr(word);
    if(!map.containsKey(abr) || (set.contains(word) && map.get(abr) == 1)) {
      return true;
    }
    return false;
  }

  public String getAbbr(String word) {
    if(word.length() < 3) {
      return word;
    }

    return "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
  }

  public static void main(String[] args) {
    String [] dic = {};
    UniqueWordAbbr_288 uabr = new UniqueWordAbbr_288(dic);
    System.out.println(uabr.getAbbr("internationalization"));
    System.out.println(uabr.getAbbr("dog"));
    System.out.println(uabr.getAbbr("d"));
    System.out.println(uabr.getAbbr(""));

  }
}
