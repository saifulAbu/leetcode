package com.company;

import org.w3c.dom.html.HTMLIsIndexElement;

public class HIndex {
  public int hIndex(int[] citations) {
    if(citations == null || citations.length == 0) {
      return 0;
    }

    int s = 0;
    int totalPapers = citations.length;
    int hMax = Math.min(totalPapers, citations[0]);
    int e = citations.length - 1;
    int m;
    int curH;

    while(s <= e) {
      m = (s + e) / 2;
      int paperCount = totalPapers - m;
      curH = Math.min(paperCount, citations[m]);
      if(curH >= hMax) {
        hMax = curH;
      }
      if(paperCount > curH) {
        s = s + 1;
      } else {
        e = e - 1;
      }
    }
    return hMax;
  }

  public static void main(String args[]) {
    HIndex hindex = new HIndex();
    int [] citations = {1,1,1,1,3,3,4,4,5,6,7,7,8,9,10};
    //int [] citations = {0,1};
    int res = hindex.hIndex(citations);
    System.out.println(res);
  }
}

