package array_and_string;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord_819 {
  static public String mostCommonWord(String paragraph, String[] banned) {
    HashSet<String> bannedSet = new HashSet<>();
    for (String str : banned) {
      bannedSet.add(str);
    }
    paragraph = paragraph.replaceAll("[\\!\\?\\'\\,\\;\\.]", " ");
    paragraph = paragraph.toLowerCase();
    String [] paraArr = paragraph.split("\\s+");
    HashMap<String, Integer> paraMap = new HashMap<>();
    for (String str : paraArr) {
      if(!bannedSet.contains(str)) {
        paraMap.put(str, paraMap.getOrDefault(str, 0) + 1);
      }
    }
    int max = 0;
    String maxStr = "";
    for (String str : paraMap.keySet()) {
      if (paraMap.get(str).intValue() > max) {
        max = paraMap.get(str).intValue();
        maxStr = str;
      }
    }
    return maxStr;
  }

  public static void main(String args[]) {
    mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit", new String[] {"hit"});
  }


}
