package alpha_rep;

import java.util.Stack;

public class BackspaceStringCompare_844 {

  private String buildString(String s) {
    Stack<Character> stack = new Stack<>();
    for(char ch : s.toCharArray()) {
      if(ch == '#') {
        if(!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(ch);
      }
    }

    String str = "";
    while(!stack.isEmpty()) {
      str += stack.pop();
    }

    return str;
  }

  public boolean backspaceCompare(String s, String t) {
    return buildString(s).equals(buildString(t));
  }
}
