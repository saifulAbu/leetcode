package alpha_rep;

public class CycleCheckList_141 {

  public boolean hasCycle(ListNode head) {
    /*
    * if there is a cycle, if we have one pointer that moves one step, another pointer that moves 2 step
    * they will eventually meet
    *
    *        1
    *      /   \
    *    2        4
    *      \    /
    *        3
    *
    * if we start a fast pointer from 2, i it will go back and forth in 2 and 4
    * [slow, fast]
    * [1, 4], [4, 2], [3, 4], [4, 4]*
    *
    * at one point it will match
    * */

    ListNode slow = head, fast = head;

    while(slow != null && fast != null) {
      slow = slow.next;
      fast = fast.next;
      if(fast != null) {
        fast = fast.next;
      } else {
        break;
      }
      if(slow == fast) {
        return true;
      }
    }

    return false;
  }

  public boolean hasCycle_0(ListNode head) {
    if(head == null) {
      return false;
    }

    ListNode slowtPtr = head;
    ListNode fastPtr = slowtPtr.next;

    while(slowtPtr != null && fastPtr != null) {
      if(slowtPtr == fastPtr) {
        return true;
      }
      slowtPtr = slowtPtr.next;

      //fastPrt moves 2 leap forward
      fastPtr = fastPtr.next;
      if(fastPtr == null) {
        break;
      }
      fastPtr = fastPtr.next;
    }
    return false;
  }

  public boolean hasCycle0(ListNode head) {
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
