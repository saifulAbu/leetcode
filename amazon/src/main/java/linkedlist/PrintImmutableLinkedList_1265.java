package linkedlist;

interface ImmutableListNode {
    public void printValue(); // print the value of this node.
    public ImmutableListNode getNext(); // return the next node.
};

public class PrintImmutableLinkedList_1265 {
  public void printLinkedListInReverse(ImmutableListNode head) {
    if(head == null) {
      return;
    }
    printLinkedListInReverse(head.getNext());
    head.printValue();
  }
}
