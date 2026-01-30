package array_and_string;

public class CheckSummation_1880 {
  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    int first = getNumber(firstWord);
    int second = getNumber(secondWord);
    int target = getNumber(targetWord);

    return (first + second) == target;
  }

  private int getNumber(String str) {
    int num = 0;
    for(char ch : str.toCharArray()) {
      int intVal = getIntVal(ch);
      num = num * 10 + intVal;
    }
    return num;
  }

  private int getIntVal(char ch) {
    return (int) (ch - 'a');
  }
}
