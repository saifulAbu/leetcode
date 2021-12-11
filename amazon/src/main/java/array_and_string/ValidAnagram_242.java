package array_and_string;

public class ValidAnagram_242 {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int [] histoGram = new int[26];
    for (int i = 0; i < s.length(); i++) {
      histoGram[s.charAt(i) - 'a']++;
      histoGram[t.charAt(i) - 'a']--;
    }
    for (int count : histoGram) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
}
