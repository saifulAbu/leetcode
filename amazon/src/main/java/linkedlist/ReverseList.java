package linkedlist;

public class ReverseList {
  public ListNode reverseList(ListNode head) {
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
    ListNode curhead = head;

    while(curhead != null) {
      ListNode temp = curhead;
      curhead = curhead.next;
      temp.next = dummyHead.next;
      dummyHead.next = temp;
    }

    return dummyHead.next;
  }

  public static void main(String args[]) {

  }
}
