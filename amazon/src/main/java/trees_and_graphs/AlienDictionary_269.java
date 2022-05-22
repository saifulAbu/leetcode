package trees_and_graphs;

import static org.junit.Assert.*;
import org.junit.Test;

public class AlienDictionary_269 {
  public String alienOrder(String[] words) {
    return "";
  }

  static int findMisMatchedIndex(String str0, String str1) {
    for(int i = 0; i < Math.min(str0.length(), str1.length()); i++) {
      if(str0.charAt(i) != str1.charAt(i)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String [] args) {
    assertEquals(findMisMatchedIndex("abcxyz", "abcdef"), 3);
    assertEquals(findMisMatchedIndex("abc", "def"), 0);
    assertEquals(findMisMatchedIndex("abc", "abf"), 2);
    assertEquals(findMisMatchedIndex("abc", "abcdef"), -1);
  }


}
