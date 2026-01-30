package alpha_rep;

public class RepeatChar_1100 {
  public int numKLenSubstrNoRepeats(String s, int k) {
    if(k > s.length()) {
      return 0;
    }

    int repeatCharCount = 0, validSubArrCount = 0;
    char[] charArr = s.toCharArray();
    int[] frequency = new int[26];
    //int[] frequency = new int[2];

    //count initial window
    for(int i = 0; i < k; i++) {
      int addChar = getCharToIntIndex(charArr[i]);
      if(isCurFrequencyOne(frequency, addChar)) {
        repeatCharCount++;
      }
      frequency[addChar]++;
    }
    if(repeatCharCount == 0) {
      validSubArrCount++;
    }

    // process rest of the array elements
    for(int addIndex = k, subtractIndex = 0; addIndex < s.length(); addIndex++, subtractIndex++) {
      int subtractChar = getCharToIntIndex(charArr[subtractIndex]);

      frequency[subtractChar]--;
      if(isCurFrequencyOne(frequency, subtractChar)) {
        repeatCharCount--;
      }

      int addChar = getCharToIntIndex(charArr[addIndex]);
      if(isCurFrequencyOne(frequency, addChar)) {
        repeatCharCount++;
      }
      frequency[addChar]++;

      if(repeatCharCount == 0) {
        validSubArrCount++;
      }
    }

    return validSubArrCount;
  }

  private boolean isCurFrequencyOne(int[] frequency, int index) {
    return frequency[index] == 1;
  }

  private int getCharToIntIndex(char ch) {
    return ch - 'a';
  }
}
