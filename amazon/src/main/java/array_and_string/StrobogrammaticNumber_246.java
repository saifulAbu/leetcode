package array_and_string;

import java.util.HashMap;

public class StrobogrammaticNumber_246 {
  public boolean isStrobogrammatic(String num) {
    HashMap<Character, Character> conversionMap = new HashMap<>();
    conversionMap.put('0', '0');
    conversionMap.put('1', '1');
    conversionMap.put('6', '9');
    conversionMap.put('8', '8');
    conversionMap.put('9', '6');

    StringBuilder sb = new StringBuilder(num.length());
    for (int i = num.length() - 1; i >= 0; i--) {
      char cur = num.charAt(i);
      if (conversionMap.get(cur) == null) {
        return false;
      }
      sb.append(conversionMap.get(cur));
    }
    return sb.toString().equals(num);
  }
}
