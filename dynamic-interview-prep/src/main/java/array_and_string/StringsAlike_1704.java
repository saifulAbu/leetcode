package array_and_string;

public class StringsAlike_1704 {
  public boolean halvesAreAlike(String s) {
    char [] str = s.toCharArray();
    int v0 = 0;
    for (int i = 0; i < str.length / 2; i++) {
      if (isVowel(str[i])) {
        v0++;
      }
    }
    int v1 = 0;
    for (int i = str.length / 2; i < str.length ; i++) {
      if (isVowel(str[i])) {
        v1++;
      }
    }

    if (v1 == v0) {
      return  true;
    }
    return false;
  }

  boolean isVowel(char ch) {
    ch = Character.toLowerCase(ch); {
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||ch == 'u') {
        return true;
      }
      return false;
    }
  }
}
