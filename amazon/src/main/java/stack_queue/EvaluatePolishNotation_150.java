package stack_queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class EvaluatePolishNotation_150 {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    HashSet<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    for (String token : tokens) {
      if (operator.contains(token)) {
        int res = 0;
        int op0 = stack.pop();
        int op1 = stack.pop();
        switch (token) {
          case "+":
            res = op1 + op0;
            break;
          case "-":
            res = op1 - op0;
            break;
          case "*":
            res = op1 * op0;
            break;
          case "/":
            res = op1 / op0;
            break;
        }
        stack.push(res);
      } else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.pop();
  }
}
