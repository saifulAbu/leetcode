package alpha_rep;

import java.util.*;

public class LetterCombination_17 {
  public List<String> letterCombinations_drona(String digits) {
    String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) return result;

    backtrack_4_4(keys, digits, 0, new StringBuilder(), result);
    return result;
  }

  private void backtrack_4_4(String[] keys, String digits, int i, StringBuilder curStr, List<String> result) {
    if (i == digits.length()) {
      result.add(curStr.toString());
      return;
    }

    int len = curStr.length();
    for (char curChar : keys[digits.charAt(i) - '0'].toCharArray()) {
      curStr.append(curChar);
      backtrack_4_4(keys, digits, i + 1, curStr, result);
      curStr.deleteCharAt(len);
    }
  }

  public List<String> letterCombinations_1(String digits) {
    String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    List<String> result = new ArrayList<>();
    dfs(digits, KEYPAD, 0, new StringBuilder(digits.length()), result);
    return result;
  }

  private void dfs(String digits, String[] keypad, int i, StringBuilder curCombination, List<String> result) {
    if(i == digits.length()) {
      result.add(curCombination.toString());
    }
    int curDigit = digits.charAt(i) - '0';
    String curChars = keypad[curDigit];
    for(char ch : curChars.toCharArray()) {
      curCombination.append(ch);
      dfs(digits, keypad, i + 1, curCombination, result);
      curCombination.deleteCharAt(curCombination.length() - 1);
    }
  }


  private Map<Character, String> letters = Map.of(
      '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
      '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
  List<String> res = new LinkedList<>();

  public List<String> letterCombinations_0(String digits) {
    if (digits.length() == 0) {
      return res;
    }
    helper(0, digits, new StringBuilder());
    return res;
  }

  private void helper(int i, String digits, StringBuilder curSeq) {
    if (i == digits.length()) {
      res.add(curSeq.toString());
      return;
    }
    for (char ch : letters.get(digits.charAt(i)).toCharArray()) {
      curSeq.append(ch);
      helper(i + 1, digits, curSeq);
      curSeq.deleteCharAt(curSeq.length() - 1);
    }
  }
}
