package linkedlist;

public class CycleCheckList_141 {
  public boolean hasCycle(ListNode head) {
    ListNode slowPointer = head;
    ListNode fastPointer = head;

    while(slowPointer != null && fastPointer != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next;
      if(fastPointer != null) {
        fastPointer = fastPointer.next;
      }
      if(slowPointer != null && slowPointer == fastPointer) {
        return true;
      }
    }
    return false;
  }

  public static void main(String args[]) {
    ListNode l0 = new ListNode(0);
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);

    l0.next = l1;
    l1.next = l2;
    l2.next = l3;
    l3.next = l1;

    CycleCheckList_141 c = new CycleCheckList_141();
    System.out.println(c.hasCycle(l0));

  }
}
