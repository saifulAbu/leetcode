package array_and_string;

public class FirstUniqueChar_387 {
  public int firstUniqChar(String s) {
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
