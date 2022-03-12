package array_and_string;

public class FindDifference_389 {
  public char findTheDifference(String s, String t) {
    int [] hist = new int[26];
    for (char c : t.toCharArray()) {
      hist[c - 'a']++;
    }

    for (char c : s.toCharArray()) {
      hist[c - 'a']--;
    }
    
    char ret = 0;
    for (int i = 0; i < hist.length; i++) {
      if (hist[i] == 1) {
        ret =  (char) ('a' + i);
        break;
      }
    }
    return ret;
  }
}
