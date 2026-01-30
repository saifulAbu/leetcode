package array_and_string;

public class Ransom_383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    int [] distribution = new int[26];

    for(int i = 0; i < magazine.length(); i++) {
      int curCharIndex = magazine.charAt(i) - 'a';
      distribution[curCharIndex]++;
    }

    for(int i = 0; i < ransomNote.length(); i++) {
      int curCharIndex = ransomNote.charAt(i) - 'a';
      distribution[curCharIndex]--;
      if(distribution[curCharIndex] < 0) {
        return false;
      }
    }

    return true;
  }
}
