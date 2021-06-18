package array_and_string;

import java.util.Stack;

public class ValidParenthesis_20 {
  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    for(char c : s.toCharArray()) {
      if(st.empty()) {
        st.push(c);
        continue;
      }
      if((c == '}' && st.peek() == '{') ||
              (c == ')' && st.peek() == '(') ||
              (c == ']' && st.peek() == '[')
      ) {
        st.pop();
      } else {
        st.push(c);
      }
    }
    return st.size() == 0;
  }

  public boolean isValid1(String s) {
    int count = 0;
    for(char c : s.toCharArray()) {
      if(c == '(') {
        count += 2;
      } else if(c == ')') {
        count -= 2;
      } else if(c == '{') {
        count += 3;
      } else if(c == '}') {
        count -= 3;
      } else if(c == '[') {
        count += 5;
      } else if(c == ']') {
        count -= 5;
      }
    }
    return count == 0;
  }
}
