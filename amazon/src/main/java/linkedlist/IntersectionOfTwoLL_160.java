package linkedlist;

public class IntersectionOfTwoLL_160 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
