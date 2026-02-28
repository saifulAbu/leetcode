package alpha_rep;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStr_340 {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    /*
    * k = 2
    * 0 1 2 3 4 5
    * a a a b b c
    * b     f
    * we want to maintain a forward and backward pointer. they will have this invariant that starting from backward,
    * ending at f, we will have only 2 distinct characters. we will also maintain a hashmap that will contain frequency
    * of each character between b and f. [a => 3, b => 1]
    * we will move the f pointer using a forloop. we will include the character at f in the hashmap first. then will try
    * to move b pointer forward and decrease frequency of characters until we restablish our invariant.
    *
    * */

    int maxLen = 0;
    int backPtr = 0;
    HashMap<Character, Integer> freqMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char frontChar = s.charAt(i);
      // include the front character first
      freqMap.put(frontChar, freqMap.getOrDefault(frontChar, 0) + 1);

      // adjust the back pointer to establish invariant
      while(freqMap.size() > k) {
        char backChar = s.charAt(backPtr++);
        int backCharNewFreq = freqMap.get(backChar) - 1;
        if(backCharNewFreq == 0) {
          freqMap.remove(backChar);
        } else {
          freqMap.put(backChar, backCharNewFreq);
        }
      }

      maxLen = Math.max(maxLen, i - backPtr + 1);
    }

    return maxLen;
  }

  public int lengthOfLongestSubstringKDistinct_1(String s, int k) {
    char[] charArr = s.toCharArray();
    int len = charArr.length;
    HashMap<Character, Integer> freqMap = new HashMap<>();
    int maxSubstrLen = 0;

    int f = 0, b = 0;
    for(f = 0; f < len; f++) {
      char in = charArr[f];
      freqMap.put(in, freqMap.getOrDefault(in, 0) + 1);

      //restore invariant that we are keeping k distinct between f and b pointers
      while (freqMap.size() > k && b <= f) {
        char out = charArr[b];
        int count = freqMap.get(out);
        if(count == 1) {
          freqMap.remove(out);
        } else {
          freqMap.put(out, count-1);
        }
        b++;
      }

      int curSize = f - b + 1;
      maxSubstrLen = Math.max(curSize, maxSubstrLen);
    }
    return maxSubstrLen;
  }

  public int lengthOfLongestSubstringKDistinct_02(String s, int k) {
    HashMap<Character, Integer> freq = new HashMap<>();
    int maxLen = 0;
    int b = 0;
    for(int f = 0; f < s.length(); f++) {
      char in = s.charAt(f);
      int curFreq = freq.getOrDefault(in, 0);
      freq.put(in, curFreq + 1);

      //maintain invariant
      while(freq.size() > k) {
        char out = s.charAt(b);
        curFreq = freq.get(out);
        if(curFreq == 1) {
          freq.remove(out);
        } else {
          freq.put(out, curFreq - 1);
        }
        b++;
      }

      maxLen = Math.max(maxLen, (f - b + 1));
    }

    return maxLen;
  }
}
