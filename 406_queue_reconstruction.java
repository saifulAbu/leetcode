package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstruction {
  class QueueItemComparator implements Comparator<int[]> {

    //sort descending order
    @Override
    public int compare(int[] o1, int[] o2) {
      if(o1[0] == o2[0]) {
        return o1[1] - o2[1];
      } else {
        return o2[0] - o1[0];
      }
    }
  }

  public int[][] reconstructQueue(int[][] people) {
    ArrayList<int[]> result = new ArrayList<>();
    Arrays.sort(people, new QueueItemComparator());
    for(int[] item : people) {
      result.add(item[1], item);
    }
    return result.toArray(new int[people.length][]);
  }

  public static void main(String args[]) {
    int [][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    QueueReconstruction q = new QueueReconstruction();
    int [][] result = q.reconstructQueue(people);
    return;
  }

}
