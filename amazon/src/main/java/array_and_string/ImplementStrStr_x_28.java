package array_and_string;

public class ImplementStrStr_x_28 {
    public int strStr(String haystack, String needle) {
      if(needle.equals("")) {
        return 0;
      }
      if(haystack.equals("")) {
        return -1;
      }
      if(haystack.length() < needle.length()) {
        return -1;
      }
      int res = -1;
      int M = Integer.MAX_VALUE;
      int needleHash = 0;
      int rollingHash = 0;
      int alphabetLen = 26;

      for(int i = 0; i < needle.length(); i++) {
        needleHash = (alphabetLen * needleHash + intVal(needle.charAt(i))) % M;
        rollingHash = (alphabetLen * rollingHash + intVal(haystack.charAt(i))) % M;
      }

      int aL = 1;
      for(int i = 0; i < needle.length() - 1; i++) {
        aL = (aL * alphabetLen) % M;
      }

      if(rollingHash == needleHash) {
        if(haystack.substring(0, needle.length()).equals(needle)) {
          return 0;
        }
      }

      for(int i = 1; i <= haystack.length() - needle.length(); i++) {
        rollingHash = (((rollingHash - aL * intVal(haystack.charAt(i-1))) * alphabetLen) % M + intVal(haystack.charAt(i + needle.length() -1))) % M;
        if(rollingHash == needleHash) {
          if(haystack.substring(i, i + needle.length()).equals(needle)) {
            return i;
          }
        }
      }

      return -1;
    }

    private int intVal(char c) {
      return c - 'a' + 1;
    }

  public static void main(String args[]) {
    ImplementStrStr_x_28 sol = new ImplementStrStr_x_28();
    System.out.println(sol.strStr("hello", "ha"));
  }


}
