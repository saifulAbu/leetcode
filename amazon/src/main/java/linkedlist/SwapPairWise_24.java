package linkedlist;

public class SwapPairWise_24 {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode node0 = head;
    ListNode node1 = head.next;
    ListNode rest = node1.next;
    node1.next = node0;
    node0.next = swapPairs(rest);
    return node1;
  }
}
