package linkedlist;

public class PalindromeLinkedList_234 {

  public boolean isPalindrome(ListNode head) {
    int size = getSize(head);
    if(size <= 1) {
      return true;
    }

    // case
    // origList - 1 - 2 - 3 - 3 - 2 - 1
    // halfList
    // we want this
    // halfList - 3 - 2 - 1
    // if we take size/2 nodes from origList and put it in front of halfList, we will get it
    ListNode origList = new ListNode(0, head);
    ListNode halfList = new ListNode(0);
    ListNode h = origList.next;
    for(int i = 0; i < size / 2; i++) {
      ListNode cur = h;
      h = h.next;
      //detach cur node and append to head of halfList
      cur.next = halfList.next;
      halfList.next = cur;
    }

    // for odd case, skip h pointer one step to pass over the mid node
    if(size % 2 != 0) {
      h = h.next;
    }

    // now we have two lists
    // origList 3 2 1
    // halfList 3 2 1
    // compare node by node on the value
    ListNode l0 = halfList.next, l1 = h;
    boolean isPal = true;
    while(l0 != null) {
      if(l0.val != l1.val) {
        isPal = false;
        break;
      }
      l0 = l0.next;
      l1 = l1.next;
    }

    //reconstruct the list
    // take each element from the half element and add to the front of origList
    l0 = halfList.next;
    for(int i = 0; i < size / 2; i++) {
      ListNode cur = l0;
      l0 = l0.next;
      cur.next = origList.next;
      origList.next = cur;
    }

    return isPal;
  }

  private int getSize(ListNode head) {
    int size = 0;
    while(head != null) {
      head = head.next;
      size++;
    }
    return size;
  }

  private ListNode fptr;
  public boolean isPalindrome0(ListNode head) {
    fptr = head;
    return helper(head);
  }

  private boolean helper(ListNode cur) {
    if (cur == null) {
      return true;
    }
    if (!helper(cur.next) || cur.val != fptr.val) {
      return false;
    }
    fptr = fptr.next;
    return true;
  }
}
