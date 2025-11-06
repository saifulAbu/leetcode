package linkedlist;

public class MidOfList_876 {
  public ListNode middleNode(ListNode head) {
    int size = getSize(head);
    ListNode middle = head;
    for(int i = 0; i < size / 2; i++) {
      middle = middle.next;
    }
    return middle;
  }

  private int getSize(ListNode head) {
    int size = 0;
    while(head != null) {
      size++;
      head = head.next;
    }
    return size;
  }
}
