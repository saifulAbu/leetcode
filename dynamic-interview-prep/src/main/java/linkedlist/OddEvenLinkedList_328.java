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

  public ListNode oddEvenList0(ListNode head) {
    ListNode oddHead = new ListNode(0), oddTail = oddHead, evenHead = new ListNode(0), evenTail = evenHead;

    ListNode curOdd = head, curEven = null;
    while(curOdd != null) {
      curEven = curOdd.next;
      oddTail.next = curOdd;
      oddTail = curOdd;
      oddTail.next = null;

      if(curEven == null) {
        break;
      }
      curOdd = curEven.next;
      evenTail.next = curEven;
      evenTail = curEven;
      evenTail.next = null;
    }

    oddTail.next = evenHead.next;

    return oddHead.next;
  }
}
