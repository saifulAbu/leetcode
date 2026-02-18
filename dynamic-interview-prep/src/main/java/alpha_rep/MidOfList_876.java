package alpha_rep;

public class MidOfList_876 {
  public ListNode middleNode(ListNode head) {
    /*
    * we can think of two cases
    * 1. list having even number of elements
    * 2. list having odd number of elements
    *
    * we can use two pointers, slow and fast
    *
    * s
    * 1 2 3 4 5
    * f
    *
    * s
    * 1 2 3 4
    * f
    *
    * if f pointer reaches to the last node, or reaches to null, slow pointer will be the one we are looking for
    *
    * */

    ListNode slow = head, fast = head;

    while(head != null && head.next != null) {
      slow = slow.next;
      head = head.next;
      if(head != null) {
        head = head.next;
      }
    }
    return slow;
  }
}
