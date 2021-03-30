package array_and_string;

public class MaximumNestingDepth_1614 {
  public int maxDepth(String s) {
    int maxDepth = 0;
    int curDepth = 0;
    for(char c : s.toCharArray()) {
      if(c == '(') {
        curDepth++;
        if(curDepth > maxDepth) {
          maxDepth = curDepth;
        }
      } else if( c == ')') {
        curDepth--;
      }
    }

    return maxDepth;
  }
}
