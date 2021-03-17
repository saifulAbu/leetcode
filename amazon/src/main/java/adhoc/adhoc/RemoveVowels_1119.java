package adhoc.adhoc;

public class RemoveVowels_1119 {
  public String removeVowels(String s) {
    StringBuilder sb = new StringBuilder();
    for(char c : s.toCharArray()) {
      if(!(isVowel(c))){
        sb.append(c);
      }
    }
    return sb.toString();
  }

  private boolean isVowel(char c) {
    if(c =='a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
      return true;
    }
    return false;
  }

  public static void main(String args[]) {

  }
}
