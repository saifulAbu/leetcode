package linkedlist;

public class ReverseList {

  public ListNode reverseList(ListNode head) {
    ListNode dummyHead = new ListNode(0), curNode = head;

    while(curNode != null) {
      ListNode nextNode = curNode.next;
      curNode.next = dummyHead.next;
      dummyHead.next = curNode;
      curNode = nextNode;
    }

    return dummyHead.next;
  }

  public ListNode reverseList0(ListNode head) {
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
