package array_and_string;

import java.util.HashMap;

public class FirstUniqueChar_387 {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> charCount = new HashMap<>();
    char[] charArr = s.toCharArray();

    // build the histogram
    for(Character ch : charArr) {
      charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
    }

    // return the first character with 1 occurrence count
    for(int i = 0; i < charArr.length; i++) {
      if(charCount.get(charArr[i]) == 1) {
        return i;
      }
    }

    return -1;
  }

  public int firstUniqChar0(String s) {
    char[] map = new char[26];
    char[] data = s.toCharArray();
    for(char c : data) {
      map[c - 'a']++;
    }

    for (int i = 0; i < data.length; i++) {
      if (map[data[i] - 'a'] == 1) {
        return i;
      }
    }
    return - 1;
  }
}
