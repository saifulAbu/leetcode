package array_and_string;

public class RemoveOuterMostParenthesis_1021 {
  public String removeOuterParentheses(String S) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for(char ch : S.toCharArray()) {
      if (ch == '(') {
        count++;
        if (count != 1) {
          sb.append(ch);
        }
      } else {
        count--;
        if (count != 0) {
          sb.append(ch);
        }
      }
    }
    return sb.toString();
  }
}
