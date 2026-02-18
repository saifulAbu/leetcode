package alpha_rep;

public class ReverseLinkedList_206 {
  public ListNode reverseList(ListNode head) {
    /*
    * create a dummy head
    * keep inserting an element to the front
    * */
    ListNode resultHead = new ListNode(), curNode = head;

    while(curNode != null) {
      ListNode nodeToAdd = curNode;
      curNode = curNode.next;

      nodeToAdd.next = resultHead.next;
      resultHead.next = nodeToAdd;
    }
    return resultHead.next;
  }


  public ListNode reverseList_0(ListNode head) {
    ListNode result, dummy;
    result = new ListNode(0);
    dummy = new ListNode(0);
    dummy.next = head;

    while (dummy.next != null) {
      ListNode cur = dummy.next;
      dummy.next = cur.next;
      cur.next = result.next;
      result.next = cur;
    }

    return result.next;
  }
}
