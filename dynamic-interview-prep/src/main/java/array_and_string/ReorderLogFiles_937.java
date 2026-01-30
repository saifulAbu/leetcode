package array_and_string;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles_937 {
  public String[] reorderLogFiles(String[] logs) {
    Comparator comp = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        String[] spl1 = s1.split(" ", 2);
        String[] spl2 = s2.split(" ", 2);

        String id1 = spl1[0];
        String log1 = spl1[1];

        String id2 = spl2[0];
        String log2 = spl2[1];

        boolean isLetter1 = Character.isLetter(log1.charAt(0));
        boolean isLetter2 = Character.isLetter(log2.charAt(0));

        if (isLetter1 && isLetter2) {
          int compr = log1.compareTo(log2);
          if (compr == 0) {
            return id1.compareTo(id2);
          } else {
            return compr;
          }
        } else if (isLetter1 && !isLetter2) {
          return -1;
        } else if (!isLetter1 && isLetter2) {
          return 1;
        } else {
          return 0;
        }
      }
    };
    Arrays.sort(logs, comp);
    return logs;
  }
}
