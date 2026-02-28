package alpha_rep;

public class RemoveDuplicates_83 {

  public ListNode deleteDuplicates(ListNode head) {
    /*
    * 1 1 1 2 2 2 3 3 4 4
    *
    * curNode = head;
    * while(curNode != null && curNode.next != null)
    *   if(curNode.next.val == curNode.val )
    *     curNode.next = curNode.next.next
    *   else
    *     curNode = curNode.next
    *
    * */
    ListNode curNode = head;
    while(curNode != null && curNode.next != null) {
      ListNode nextNode = curNode.next;
      if(nextNode.val == curNode.val) {
        curNode.next = nextNode.next;
        nextNode.next = null;
      } else {
        curNode = nextNode;
      }
    }
    return head;
  }


  public ListNode deleteDuplicates_0(ListNode head) {
    ListNode front = head;
    while(front != null) {
      ListNode back = front.next;
      while(back != null && back.val == front.val) {
        back = back.next;
      }
      front.next = back;
      front = front.next;
    }
    return head;
  }

  public ListNode deleteDuplicates_1(ListNode head) {
    if(head == null) {
      return null;
    }

    ListNode curNode = head;
    while(curNode != null && curNode.next != null) {
      if(curNode.val == curNode.next.val) {
        curNode.next = curNode.next. next;
      } else {
        curNode = curNode.next;
      }
    }
    return head;
  }
}
