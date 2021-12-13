package linkedlist;

public class PalindromeLinkedList_234 {
  private ListNode fptr;
  public boolean isPalindrome(ListNode head) {
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
