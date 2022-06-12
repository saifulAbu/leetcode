package hash;

public class UniqueWordAbbr_288 {
  public UniqueWordAbbr_288(String[] dictionary) {

  }

  public boolean isUnique(String word) {
    return false;
  }

  public String getAbbr(String word) {
    if(word.length() < 3) {
      return word;
    }

    return "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
  }

  public static void main(String[] args) {
    String [] dic = {};
    UniqueWordAbbr_288 uabr = new UniqueWordAbbr_288(dic);
    System.out.println(uabr.getAbbr("internationalization"));
    System.out.println(uabr.getAbbr("dog"));
    System.out.println(uabr.getAbbr("d"));
    System.out.println(uabr.getAbbr(""));

  }
}
