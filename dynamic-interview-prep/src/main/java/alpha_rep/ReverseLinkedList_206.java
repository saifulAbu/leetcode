package alpha_rep;

public class ReverseLinkedList_206 {
  public ListNode reverseList(ListNode head) {
    /*
    * create a dummy head
    * keep inserting an element to the front
    * */
    ListNode resultHead = new ListNode(), curNode = head;

    while(curNode != null) {
      ListNode nodeToAdd = curNode;
      curNode = curNode.next;

      nodeToAdd.next = resultHead.next;
      resultHead.next = nodeToAdd;
    }
    return resultHead.next;
  }


  public ListNode reverseList_0(ListNode head) {
    ListNode result, dummy;
    result = new ListNode(0);
    dummy = new ListNode(0);
    dummy.next = head;

    while (dummy.next != null) {
      ListNode cur = dummy.next;
      dummy.next = cur.next;
      cur.next = result.next;
      result.next = cur;
    }

    return result.next;
  }

  public ListNode reverseList_1(ListNode head) {
    ListNode dummyOrig = new ListNode(-1, head);
    ListNode dummyReversed = new ListNode();

    while(dummyOrig.next != null) {
      ListNode cur = dummyOrig.next;
      dummyOrig.next = cur.next;

      cur.next = dummyReversed.next;
      dummyReversed.next = cur;
    }

    return dummyReversed.next;
  }

  public ListNode reverseList_0621(ListNode head) {
    ListNode dummyHead = new ListNode(-1);
    while (head != null) {
      ListNode cur = head;
      head = head.next;
      cur.next = dummyHead.next;
      dummyHead.next = cur;
    }
        
    return dummyHead.next;
  }

    public ListNode reverseList_0621_2(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode cur = head;
      head = head.next;
      cur.next = newHead;
      newHead = cur;
    }
        
    return newHead;
  }
}
