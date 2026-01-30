package array_and_string;

public class GoalParser_1678 {
  public String interpret(String command) {
    StringBuilder res = new StringBuilder();
    char[] cmdArr = command.toCharArray();
    int i = 0;
    while (i < cmdArr.length) {
      if(cmdArr[i] == 'G') {
        res.append('G');
        i++;
      } else {
        if(cmdArr[i] == '(' && cmdArr[i+1] == ')') {
          res.append('o');
          i += 2;
        } else {
          res.append('a');
          res.append('l');
          i += 4;
        }
      }
    }
    return res.toString();
  }
}
