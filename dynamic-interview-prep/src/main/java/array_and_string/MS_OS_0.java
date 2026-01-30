package array_and_string;

import java.util.HashMap;
import java.util.HashSet;

public class MS_OS_0 {

  public int solution(String S) {
    //stores character of current substring in consideration
    HashSet<Character> seen = new HashSet<>();
    //in case of all different characters, we will have 1 subtring of all unique chars
    int count = 1;
    for (Character ch : S.toCharArray()) {
      //already saw this character in current substring
      // so time to create a new substring
      if (seen.contains(ch)) {
        //
        seen.clear();
        count++;
      }
      seen.add(ch);
    }
    return count;
  }
  
  public static void main(String args []) {

      MS_OS_0 sol = new MS_OS_0();
      System.out.println(sol.solution("a"));
    System.out.println(sol.solution("abcdef"));

      //System.out.println(Integer.MAX_VALUE);

  }
}
