package backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombination_17 {
  private Map<Character, String> letters = Map.of(
      '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
      '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
  List<String> res = new LinkedList<>();

  public List<String> letterCombinations(String digits) {
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
