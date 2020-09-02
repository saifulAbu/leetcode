package com.company;

import java.util.HashMap;

public class ContagiousArray {
  public int findMaxLength(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }
    int maxContArrayLen = Integer.MIN_VALUE;
    HashMap<Integer, Integer> scoreMap = new HashMap<>();
    scoreMap.put(0, -1);
    int curScore = 0;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == 0) {
        curScore--;
      } else {
        curScore++;
      }
      if(scoreMap.get(curScore) == null) {
        scoreMap.put(curScore, i);
      }
      int curContArrayLen = i - scoreMap.get(curScore);
      if(curContArrayLen > maxContArrayLen) {
        maxContArrayLen = curContArrayLen;
      }
    }
    return maxContArrayLen;
  }

  public static void main(String args[]) {
    ContagiousArray carr = new ContagiousArray();
    int num [] = {0, 1, 0, 1};
    int res = carr.findMaxLength(num);
    System.out.println(res);
    return;
  }
}
