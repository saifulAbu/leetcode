package linkedlist;

public class RotateList_61 {

  /*
  * case
  * 1 2 3 4 5, k = 2
  * 4 5 1 2 3
  *
  * we find the proper new head's parent 3
  * find the proper new head 4
  * detach 3 from 4 [1 2 3] [4 5]
  * find its tail, 5
  * add first list to the tail [4 5 1 2 3]
  * */
  public ListNode rotateRight(ListNode head, int k) {
    int size = getSize(head);
    if(k != 0 && size != 0) {
      k = k % size;
    }

    if(size < 2 || k == 0) {
      return head;
    }

    ListNode dummyParent = new ListNode(Integer.MIN_VALUE, head);

    ListNode parentOfNewHead = dummyParent;

    // we need to move parent pointer size - k times to arrive targeted parent position
    for(int i = 0; i < size - k; i++) {
      parentOfNewHead = parentOfNewHead.next;
    }

    //get new head
    ListNode headOfNewNode = parentOfNewHead.next;
    //detach new head from previous list
    parentOfNewHead.next = null;
    ListNode tailOfNewNode = getTail(headOfNewNode);
    // add the remaining list to the new list's tail
    tailOfNewNode.next = head;

    //deallocate memory
    dummyParent.next = null;

    return headOfNewNode;
  }

  private ListNode getTail(ListNode head) {
    ListNode tail = head;
    while(tail.next != null) {
      tail = tail.next;
    }
    return tail;
  }

  private int getSize(ListNode head) {
    int size = 0;
    while(head != null) {
      head = head.next;
      size++;
    }
    return size;
  }

  public ListNode rotateRight0(ListNode head, int k) {
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
