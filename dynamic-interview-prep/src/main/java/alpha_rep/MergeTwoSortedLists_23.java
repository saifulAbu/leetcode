package alpha_rep;

import java.util.PriorityQueue;

//noted
public class MergeTwoSortedLists_23 {

  public ListNode mergeKLists_drona(ListNode[] lists) {
    ListNode dummy = new ListNode();
    ListNode tail = dummy;

    PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
    );

    // Add all non-null heads
    for (ListNode node : lists) {
      if (node != null) {
        pq.offer(node);
      }
    }

    while (!pq.isEmpty()) {
      ListNode minNode = pq.poll();
      tail.next = minNode;
      tail = minNode;

      if (minNode.next != null) {
        pq.offer(minNode.next);
      }
    }

    return dummy.next;
  }


  public ListNode mergeKLists_bruteForce_drona(ListNode[] lists) {
    ListNode dummy = new ListNode();
    ListNode tail = dummy;

    while (true) {
      int minIndex = -1;
      int minVal = Integer.MAX_VALUE;

      // Find the list with the smallest head
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null && lists[i].val < minVal) {
          minVal = lists[i].val;
          minIndex = i;
        }
      }

      // All lists exhausted
      if (minIndex == -1) {
        break;
      }

      // Append the smallest node
      ListNode node = lists[minIndex];
      lists[minIndex] = node.next;

      tail.next = node;
      tail = node;
    }

    return dummy.next;
  }


  public ListNode mergeKLists_0(ListNode[] lists) {
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
