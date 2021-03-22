package array_and_string;

import java.util.HashMap;

public class SingleRowKeyboard_1165 {
  public int calculateTime(String keyboard, String word) {
    int totalTime = 0;
    int curIndex = 0;

    HashMap<Character, Integer> map = new HashMap<>();

    char[] keyboardChar = keyboard.toCharArray();
    for(int i = 0; i < keyboard.length(); i++) {
      map.put(keyboardChar[i], i);
    }

    for(Character ch : word.toCharArray()) {
      int nextIndex = map.get(ch);
      totalTime += Math.abs(curIndex - nextIndex);
      curIndex = nextIndex;
    }

    return totalTime;
  }
}
