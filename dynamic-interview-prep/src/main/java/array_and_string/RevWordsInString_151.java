package array_and_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RevWordsInString_151 {

  public String reverseWords(String s) {
    String[] words = s.split("\\s+");
    StringBuilder sb = new StringBuilder(s.length());
    for(int i = words.length - 1; i >= 0; i--) {
      sb.append(words[i]);
      if(i != 0) {
        sb.append(' ');
      }
    }
    return sb.toString().trim();
  }

  static public String reverseWords0(String s) {
    List<String> list = Arrays.asList(s.split("\\s+"));
    Collections.reverse(list);
    return String.join(" ", list).trim();
  }

}
