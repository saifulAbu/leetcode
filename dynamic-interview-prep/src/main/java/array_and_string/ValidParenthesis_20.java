package array_and_string;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis_20 {

  HashMap<Character, Integer> parenthesisMap = new HashMap<>();
  private void initializeParentheisMap() {
    parenthesisMap.put('(', 1);
    parenthesisMap.put(')', -1);

    parenthesisMap.put('{', 2);
    parenthesisMap.put('}', -2);

    parenthesisMap.put('[',  3);
    parenthesisMap.put(']', -3);
  }

  public boolean isValid(String s) {
    initializeParentheisMap();
    Stack<Integer> stack = new Stack<>();

    for(char curParenthesis : s.toCharArray()) {
      int curParentNumVal = parenthesisMap.get(curParenthesis);
      if(curParentNumVal > 0) {
        stack.push(curParentNumVal);
      } else {
        if(stack.isEmpty() || (curParentNumVal + stack.pop() != 0)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public boolean isValid1(String s) {
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

  public boolean isValid10(String s) {
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
