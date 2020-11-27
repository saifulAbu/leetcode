package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class PermutationSequence {
  private int[] fact = new int[10];

  public PermutationSequence() {
    fact[0] = 1;
    for(int i = 1; i <= 9; i++) {
      fact[i] = i * fact[i-1];
    }
  }

  public String getPermutation(int n, int k) {
    String res = "";
    LinkedList<Integer> digits = new LinkedList<Integer>();

    for(int i = 1; i <= n; i++) {
      digits.add(i);
    }

    int seqId = k - 1;
    int digitCount = n;

    while(digitCount > 0) {
      int grp = fact[digitCount - 1];
      int curDigitIndex = seqId / grp;
      res = res + digits.get(curDigitIndex);
      digits.remove(curDigitIndex);
      seqId = seqId - grp * curDigitIndex;
      digitCount--;
    }

    return res;
  }

  public static void main(String args[]) {
    PermutationSequence ps = new PermutationSequence();
    String res = ps.getPermutation(4, 24);
    System.out.println(res);
  }
}