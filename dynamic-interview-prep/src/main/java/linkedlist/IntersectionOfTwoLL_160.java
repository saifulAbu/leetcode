package linkedlist;

/*
* 0 - 1 - 2 - 3
*               \
*                -7- 8 - 9
*               /
*     4 - 5 - 6
*
* get sizes of two lists
* skip forward size difference on big list
* keep moving on two lists till reach null or node 7.
*  cases to consider:
*   1. small list might start at node 7
*   2. no intersection
*   3. both lists are same sizes
*   4. intersection, one list is bigger another smaller
* */
public class IntersectionOfTwoLL_160 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int sizeA = getSize(headA), sizeB = getSize(headB);
    if(sizeA == 0 || sizeB == 0) {
      return null;
    }

    ListNode big = headA, small = headB;
    if(sizeB >= sizeA) {
      big = headB;
      small = headA;
    }

    //skip ahead on big list
    for(int i = 0; i < Math.abs(sizeA - sizeB); i++) {
      big = big.next;
    }

    while(big != null && small != null) {
      if(big == small) {
        return big;
      }
      big = big.next;
      small = small.next;
    }

    return null;
  }

  private int getSize(ListNode head) {
    int size = 0;
    while(head != null) {
      head = head.next;
      size++;
    }
    return size;
  }

  public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
    int lenA = 0, lenB = 0;
    ListNode hA = headA, hB = headB;
    while (hA != null) {
      hA = hA.next;
      lenA++;
    }

    while (hB != null) {
      hB = hB.next;
      lenB++;
    }

    if (lenA < lenB) {
      ListNode t = headA;
      headA =headB;
      headB = t;
      int tl = lenA;
      lenA = lenB;
      lenB = tl;
    }

    hA = headA;
    hB = headB;

    for (int i = 0; i < (lenA - lenB); i++) {
      hA = hA.next;
    }

    while (hA != null && hA != hB) {
      hA = hA.next;
      hB = hB.next;
    }

    return hA;
  }
}
