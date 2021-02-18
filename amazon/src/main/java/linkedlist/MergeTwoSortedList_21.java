package linkedlist;

public class MergeTwoSortedList_21 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(Integer.MIN_VALUE);
    ListNode tail = head;

    while(l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        ListNode temp = l1;
        l1 = l2;
        l2 = temp;
      }
      ListNode temp = l1;
      l1 = l1.next;

      temp.next = null;
      tail.next = temp;
      tail = tail.next;
    }

    if(l1 == null) {
      l1 = l2;
    }
    tail.next = l1;

    return head.next;
  }

  public static void main(String args[]) {
    ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
    ListNode l2 = new ListNode(0);
    MergeTwoSortedList_21 mtl = new MergeTwoSortedList_21();
    ListNode r = mtl.mergeTwoLists(null, null);
    return;
  }

}
