package alpha_rep;

import java.awt.*;
import java.util.*;

public class ValidParenthesis_20 {

  public boolean isValid_drona(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (!map.containsKey(c)) {
        stack.push(c);  // opening bracket
      } else {
        if (stack.isEmpty() || stack.peek() != map.get(c)) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  public boolean isValid(String s) {
    HashMap<Character, Integer> parenthesisIdMap = new HashMap<>();
    parenthesisIdMap.put('(', 1);
    parenthesisIdMap.put(')', -1);

    parenthesisIdMap.put('{', 2);
    parenthesisIdMap.put('}', -2);

    parenthesisIdMap.put('[', 3);
    parenthesisIdMap.put(']', -3);

    Stack<Integer> stack = new Stack<>();
    for(Character ch : s.toCharArray()) {
      int curId = parenthesisIdMap.get(ch);
      if(curId > 0) {
        stack.push(curId);
      } else {
        if(stack.isEmpty() || (stack.peek() + curId != 0)) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  public boolean isValid_0(String s) {
    HashMap<Character, Integer> parenthesisMap = new HashMap<>();

    parenthesisMap.put('(', 1);
    parenthesisMap.put(')', -1);

    parenthesisMap.put('{', 2);
    parenthesisMap.put('}', -2);

    parenthesisMap.put('[', 3);
    parenthesisMap.put(']', -3);

    Stack<Integer> stack = new Stack<>();

    for(Character ch : s.toCharArray()) {
      int parenthesisId = parenthesisMap.get(ch);
      if(parenthesisId > 0) {
        stack.push(parenthesisId);
      }  else {
        if(stack.isEmpty() || stack.peek() + parenthesisId != 0) {
          return false;
        }
        stack.pop();
      }
    }

    return stack.isEmpty();
  }

  public boolean isValid_3(String s) {
    HashMap<Character, Integer> parenthesisMap = new HashMap<>();
    parenthesisMap.put('(', 1);
    parenthesisMap.put(')', -1);

    parenthesisMap.put('{', 2);
    parenthesisMap.put('}', -2);

    parenthesisMap.put('[', 3);
    parenthesisMap.put(']', -3);

    Stack<Integer> stack = new Stack<>();

    for(Character ch : s.toCharArray()) {
      int curVal = parenthesisMap.get(ch);
      if(curVal > 0) {
        stack.push(curVal);
      } else {
        if(!stack.isEmpty() && stack.peek() + curVal == 0) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  /*
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
  /
   */
}
