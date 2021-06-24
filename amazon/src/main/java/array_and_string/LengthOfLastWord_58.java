package array_and_string;

public class LengthOfLastWord_58 {
  public int lengthOfLastWord(String s) {
    String[] splt = s.split(" ");
    if(splt.length > 0) {
      return splt[splt.length - 1].length();
    }
    return 0;
  }
}
//dummy commit
//dummy commit
//dummy commit
//dummy commit