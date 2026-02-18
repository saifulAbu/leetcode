package alpha_rep;

import java.util.HashMap;

public class RemoveDups_1836 {
  public ListNode deleteDuplicatesUnsorted(ListNode head) {
    /*
    * will go in two passes,
    * 0. build a hashmap value -> count
    * 1. remove nodes with count > 1
    * */
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    // build frequency
    ListNode curNode = head;
    while(curNode != null) {
      int curVal = curNode.val;
      frequencyMap.put(curVal, frequencyMap.getOrDefault(curVal, 0) + 1);
      curNode = curNode.next;
    }

    // iterate through and remove any node that has frequency > 1
    ListNode prevHead = new ListNode(-1, head);
    curNode = prevHead;

    while(curNode != null && curNode.next != null) {
      ListNode nextNode = curNode.next;
      int nextVal = nextNode.val;
      if(frequencyMap.get(nextVal) > 1) {
        frequencyMap.put(nextVal, frequencyMap.get(nextVal) - 1);
        curNode.next = nextNode.next;
        nextNode.next = null;
      } else {
        curNode = curNode.next;
      }
    }
    return prevHead.next;
  }
}
