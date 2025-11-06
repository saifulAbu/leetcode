package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPtr_138 {
  private class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  };

  public Node copyRandomList(Node head) {
    //make new node and interleave with old
    if (head == null) {
      return null;
    }

    //traverse through the list and interleave
    Node cur = head;
    while (cur != null) {
      Node n = new Node(cur.val);
      n.next = cur.next;
      cur.next = n;
      cur = n.next;
    }
    //assign random pointer for the new list
    Node oldH = head, newH = head.next;
    while (oldH != null) {
      newH.random = null;
      if(oldH.random != null) {
        newH.random = oldH.random.next;
      }
      oldH = newH.next;
      if (newH.next != null) {
        newH = newH.next.next;
      }
    }
    Node res = head.next;
    oldH = head;
    newH = res;
    //un-interleave lists
    while (oldH != null) {
      Node nextA = newH.next;
      Node nextB = null;
      if (newH.next != null) {
        nextB = newH.next.next;
      }
      oldH.next = nextA;
      newH.next = nextB;
      oldH = nextA;
      newH = nextB;
    }
    return res;
  }

  public Node copyRandomList0(Node head) {
    Node newHead = new Node(Integer.MIN_VALUE), newTail = newHead;
    Map<Node, Node> oldToNewNodeMap = new HashMap<>();
    oldToNewNodeMap.put(null, null);

    // copy list and populate map
    Node oldNode = head;
    while(oldNode != null) {
      Node newNode = new Node(oldNode.val);
      newTail.next = newNode;
      newTail = newNode;
      oldToNewNodeMap.put(oldNode, newNode);
      oldNode = oldNode.next;
    }

    // link the random pointer
    oldNode = head;
    Node newNode = newHead.next;
    while(oldNode != null) {
      newNode.random = oldToNewNodeMap.get(oldNode.random);
      oldNode = oldNode.next;
      newNode = newNode.next;
    }

    return newHead.next;
  }
}
