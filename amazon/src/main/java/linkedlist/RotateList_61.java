package linkedlist;

public class RotateList_61 {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    //get size of the list
    int size = 0;
    ListNode cur = head;
    while (cur != null) {
      size++;
      cur = cur.next;
    }

    k = k % size;

    if (size < 2 || k == 0) {
      return head;
    }
    cur = head;
    for (int i = 0; i < size - k - 1; i++) {
      cur = cur.next;
    }

    ListNode resHead = cur.next;
    cur.next = null;
    ListNode tail = resHead;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = head;
    return resHead;
  }
}
