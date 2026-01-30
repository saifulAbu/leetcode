package stack_queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class EvaluatePolishNotation_150 {

  /*
  * 1 4 2 / +
  * keep pushing to stack as long as we see numbers
  * [1 4 2* ] * -> indicates stack top
  * we see /
  * secondOperand = 2, firstOperand = 4, res = 4 / 2 = 2.
  * [1* ] current stack
  * push res to stack
  * [1 2*]
  * */
  HashSet<String> operatorSet = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
  private boolean isOperator(String token) {
    return operatorSet.contains(token);
  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> operands = new Stack<>();
    for(String token : tokens) {
      if(isOperator(token)) {
        int secondOperand = operands.pop(), firstOperand = operands.pop(), res = 0;
        switch(token) {
          case "+":
            res = firstOperand + secondOperand;
            break;
          case "-":
            res = firstOperand - secondOperand;
            break;
          case "*":
            res = firstOperand * secondOperand;
            break;
          case "/":
            res = firstOperand / secondOperand;
            break;
        }
        operands.push(res);
      } else {
        operands.push(Integer.parseInt(token));
      }
    }
    return operands.pop();
  }

  public int evalRPN0(String[] tokens) {
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
