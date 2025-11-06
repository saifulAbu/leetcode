package linkedlist;

/*
* cases: a linked list of cycle size = 3 and outside node = 1
* 0 - 1 - -2
*      \  /
*       3
*
* memory expensive:
*   keep a set
*   as you see a node, insert it to the set
*   if you ever see this node again in the set, that's where the cycle is
*
* without additional memory:
*   take a slow pointer, and a fast pointer. both starting from 0.
*   see where they meet.
*   now start a new pointer from begin
*   move begin one step, slow one step till they meet
*   the place they meet is the place where cycle starts.
*   check this with a few cases for outer cycle node = 2, 3, 4 etc.
*   and check with a few cases with different length of cycle.
*   continue to code
* */

public class LinkedListCycle2_142 {

  public ListNode detectCycle(ListNode head) {
    if(head == null) {
      return null;
    }

    boolean hasCycle = false;
    ListNode slow = head, fast = head;

    while(slow != null && fast != null) {
      slow = slow.next;
      fast = fast.next;
      if(fast != null) {
        fast = fast.next;
      }
      if(slow != null && slow == fast) {
        hasCycle = true;
        break;
      }
    }

    if(!hasCycle) {
      return null;
    }

    ListNode begin = head;
    while(begin != slow) {
      begin = begin.next;
      slow = slow.next;
    }

    return begin;
  }

  public ListNode detectCycle0(ListNode head) {
    if(head == null) {
      return null;
    }

    ListNode f = head, s = head;
    do {
      s = s.next;
      f = f.next;
      if (f == null) {
        break;
      }
      f = f.next;
    } while (s != null && f != null && f != s);
    if (s == null || f == null) {
      return null;
    }

    ListNode s2 = head;
    while (s != s2) {
      s = s.next;
      s2 = s2.next;
    }
    return s;
  }
}
