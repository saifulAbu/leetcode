package linkedlist;

public class MergeTwoSortedLists_23 {
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length == 0) {
      return null;
    }
    return mergeDivQ(0, lists.length - 1, lists);
  }

  private ListNode mergeDivQ(int b, int e, ListNode[] lists) {
    if (b == e) {
      return lists[b];
    }
    int m =  b + (e - b) / 2;
    ListNode l0 = mergeDivQ(b, m, lists), l1 = mergeDivQ(m + 1, e, lists);;
    return merge(l0, l1);
  }

  private ListNode merge(ListNode l0, ListNode l1) {
    ListNode res = new ListNode(0);
    ListNode tail = res;
    while (l0 != null && l1 != null) {
      ListNode cur = null;
      if (l0.val < l1.val) {
        cur = l0;
        l0 = l0.next;
      } else {
        cur = l1;
        l1 = l1.next;
      }
      tail.next = cur;
      tail = cur;
    }
    if (l0 != null) {
      tail.next = l0;
    } else {
      tail.next = l1;
    }
    return res.next;
  }
}
