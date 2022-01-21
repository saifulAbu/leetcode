package array_and_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RevWordsInString_151 {
  static public String reverseWords(String s) {
    List<String> list = Arrays.asList(s.split("\\s+"));
    Collections.reverse(list);
    return String.join(" ", list).trim();
  }

  public static void main(String [] args) {
    reverseWords("hello  ");
  }
}
