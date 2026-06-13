package alpha_rep;

public class MergeTwoSortedList_21 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(), tail = head;
    while(l1 != null && l2 != null) {
      ListNode nodeToAdd = null;
      if(l1.val < l2.val) {
        nodeToAdd = l1;
        l1 = l1.next;
      } else {
        nodeToAdd = l2;
        l2 = l2.next;
      }
      tail.next = nodeToAdd;
      tail = nodeToAdd;
    }

    ListNode remaining = l1;
    if(l1 == null) {
      remaining = l2;
    }
    tail.next = remaining;

    return head.next;
  }





























  public ListNode mergeTwoLists_01(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(Integer.MIN_VALUE), tail = head;

    while(l1 != null && l2 != null) {
      ListNode cur;
      if(l1.val <= l2.val) {
        cur = l1;
        l1 = l1.next;
      } else {
        cur = l2;
        l2 = l2.next;
      }
      tail.next = cur;
      tail = cur;
      tail.next = null;
    }

    ListNode remaining = l1;
    if(remaining == null) {
      remaining = l2;
    }
    tail.next = remaining;

    return head.next;
  }

  public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
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

  public ListNode mergeTwoLists_02(ListNode list1, ListNode list2) {
    ListNode dummy3 = new ListNode(), tail = dummy3;

    while(list1 != null && list2.next != null) {
      ListNode cur;
      if(list1.next.val > list2.next.val) {
        cur = list2.next;
        list2 = list2.next;
      } else {
        cur = list1.next;
        list1 = list1.next;
      }
      tail.next = cur;
      tail = cur;
    }

    if(list1 == null) {
      tail.next = list2;
    } else {
      tail.next = list1;
    }

    return dummy3.next;
  }

}
