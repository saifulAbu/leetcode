package linkedlist;

public class OddEvenLinkedList_328 {
  public ListNode oddEvenList(ListNode head) {
    ListNode result = new ListNode(0), dummyHead = new ListNode(0);
    dummyHead.next = head;
    int i = 1;
    ListNode nextOdd = result;
    ListNode evenHead = new ListNode(0);
    ListNode nextEven = evenHead;

    while (dummyHead.next != null) {
      ListNode n = dummyHead.next;
      dummyHead.next = n.next;
      n.next = null;
      if (i % 2 == 0) {
        nextEven.next = n;
        nextEven = n;
      } else {
        nextOdd.next = n;
        nextOdd = n;
      }
      i++;
    }
    nextOdd.next = evenHead.next;
    return result.next;
  }
}
