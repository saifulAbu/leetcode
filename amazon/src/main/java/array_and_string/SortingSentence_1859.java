package array_and_string;

import java.util.HashMap;
import java.util.Map;

public class SortingSentence_1859 {
  public String sortSentence(String s) {
    String [] sarr = s.split(" ");
    Map<Integer, String> m = new HashMap<>();

    for(String str : sarr) {
      int index = str.charAt(str.length()-1) - '1';
      m.put(index, str.substring(0, str.length() - 1));
    }

    String res = m.get(0);
    for(int i = 1; i < sarr.length; i++) {
      res = res + " " + m.get(i);
    }

    System.out.println(res);
    return res;
  }

  public static void main(String args[]) {
    SortingSentence_1859 s = new SortingSentence_1859();
    String str = "is2 sentence4 This1 a3";
    s.sortSentence(str);
  }
}
