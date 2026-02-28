package alpha_rep;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
  public boolean isAnagram_drona(String s, String t) {
    if (s.length() != t.length()) return false;

    Map<Character, Integer> freqs = new HashMap<>();
    for (char c : s.toCharArray()) {
      freqs.put(c, freqs.getOrDefault(c, 0) + 1);
    }

    for (char c : t.toCharArray()) {
      if (!freqs.containsKey(c)) return false;
      freqs.put(c, freqs.get(c) - 1);
      if (freqs.get(c) == 0) freqs.remove(c);
    }

    return freqs.isEmpty();
  }

  public boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> freq = new HashMap<>();
    for(Character ch : s.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }

    //decrement for the second string
    for(Character ch : t.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, 0) - 1);
      if(freq.get(ch) < 0) {
        return false;
      }
      if(freq.get(ch) == 0) {
        freq.remove(ch);
      }
    }

    return freq.isEmpty();
  }

  public boolean isAnagram_0(String s, String t) {
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
