package linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeKSortedList {
  public ListNode mergeKLists(ListNode[] lists) {
    return helper(Arrays.asList(lists));
  }

  private ListNode helper(List<ListNode> lists){
    if(lists.size() == 0) {
      return null;
    }
    if(lists.size() == 1) {
      return lists.get(0);
    }
    List<ListNode> l0 = new LinkedList<>();
    List<ListNode> l1 = new LinkedList<>();

    boolean addToFirst = true;
    int i = 0;
    while(i < lists.size()) {
      if(addToFirst) {
        l0.add(lists.get(i));
        addToFirst = false;
      } else {
        l1.add(lists.get(i));
        addToFirst = true;
      }
      i++;
    }
    ListNode combined0 = helper(l0);
    ListNode combined1 = helper(l1);

    return mergeTwoLists(combined0, combined1);
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    ListNode l0 = new ListNode(9, new ListNode(9, new ListNode(9)));
    ListNode l1 = new ListNode(0);
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(7)));
    ListNode l4 = null;

    ListNode[] lst = {l0, l1, l2, l4};
    MergeKSortedList m = new MergeKSortedList();
    ListNode l = m.mergeKLists(lst);
    return;
  }
}
