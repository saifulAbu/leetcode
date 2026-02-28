package alpha_rep;

import java.util.HashMap;
import java.util.HashSet;

public class RepeatChar_1100 {

  public int numKLenSubstrNoRepeats(String s, int k) {
    /*
    * first look into first k character, advance f pointer
    *
    * then from another look, start advancing f pointer one pointer at a time
    * and compute b pointer on the fly using f. so we are not maintaining 2 pointers
    * */
    HashMap<Character, Integer> freq = new HashMap<>();
    int f = 0;
    int totalSubstr = 0;
    //traverse the first k element window
    for(; f < k; f++) {
      char in = s.charAt(f);
      freq.put(in, freq.getOrDefault(in, 0) + 1);
    }
    if(freq.size() == k) {
      totalSubstr++;
    }

    for(; f < s.length(); f++) {
      char in = s.charAt(f);
      freq.put(in, freq.getOrDefault(in, 0) + 1);

      int b = f - k;
      char out = s.charAt(b);
      freq.put(out, freq.get(out) - 1);
      if(freq.get(out) == 0) {
        freq.remove(out);
      }
      if(freq.size() == k) {
        totalSubstr++;
      }
    }
    return totalSubstr;
  }

  public int numKLenSubstrNoRepeats_01(String s, int k) {
    /*
    * the brute force solution just below gave the idea
    * we can have a start and an end pointer, we will store the characters in a hashset
    * as we enter to a new start,
    *   we remove start-1 char from hashset
    *   we add end+1 char to the list
    * we can move start one pointer forward, end one pointer forward
    *
    * */
    char[] charArr = s.toCharArray();
    int len = charArr.length;
    if(k > len) {
      return 0;
    }
    HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();

    int validSubstrCount = 0;
    int repeatedCharsInWindow = 0;
    for(int i = 0; i < k; i++) {
      char curChar = charArr[i];
      charFrequency.put(curChar, charFrequency.getOrDefault(curChar, 0) + 1);
      if(charFrequency.get(curChar) > 1) {
        repeatedCharsInWindow++;
      }
    }
    if(repeatedCharsInWindow == 0) {
      validSubstrCount++;
    }

    for(int start = 1; start <= (len - k); start++) {
      int end = start + k - 1;
      char removeChar = charArr[start-1], addChar = charArr[end];
      charFrequency.put(removeChar, charFrequency.get(removeChar) - 1);
      if(charFrequency.get(removeChar) > 0) {
        repeatedCharsInWindow--;
      } else {
        charFrequency.remove(removeChar);
      }
      charFrequency.put(addChar, charFrequency.getOrDefault(addChar, 0) + 1);
      if(charFrequency.get(addChar) > 1) {
        repeatedCharsInWindow++;
      }
      if(repeatedCharsInWindow == 0) {
        validSubstrCount++;
      }
    }
    return validSubstrCount;
  }

  public int numKLenSubstrNoRepeats_02(String s, int k) {
    /*
    * this is O(n^2) in efficient solution
    * it's okay to propose this to begin with
    * basically i will go through the array and look for k length window
    * */
    char[] charArr = s.toCharArray();
    int len = charArr.length;
    int subStrCount = 0;
    for(int start = 0; start <= (len - k); start++) {
      HashSet<Character> set = new HashSet<>();
      boolean duplicateFound = false;
      for(int j = start; j < start + k; j++) {
        char curChar = charArr[j];
        if(set.contains(curChar)) {
          duplicateFound = true;
          break;
        }
        set.add(curChar);
      }
      if(!duplicateFound) {
        subStrCount++;
      }
    }
    return subStrCount;
  }

  public int numKLenSubstrNoRepeats_0(String s, int k) {
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
