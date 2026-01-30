package array_and_string;

import java.util.List;

public class CountItemMatchingRules_1773 {
  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int count = 0;
    int ruleIndx = getIndex(ruleKey);
    for(List<String> item : items) {
      String curRuleVal = item.get(ruleIndx);
      if(curRuleVal.equals(ruleValue)) {
        count++;
      }
    }
    return count;
  }

  private int getIndex(String ruleKey){
    if(ruleKey.equals("type")) {
      return 0;
    } else if(ruleKey.equals("color")) {
      return 1;
    } else {
      return 2;
    }
  }
}
