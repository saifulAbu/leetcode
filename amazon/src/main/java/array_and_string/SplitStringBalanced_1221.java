package array_and_string;

public class SplitStringBalanced_1221 {
  public int balancedStringSplit(String s) {
    char [] charArr = s.toCharArray();
    int count = 0;
    int balance = 0;
    for(int i = 0; i < charArr.length; i++) {
      char ch = charArr[i];
      if(ch == 'L'){
        balance++;
      } else {
        balance--;
      }
      if(balance == 0) {
        count++;
      }

    }
    return count;
  }
}
