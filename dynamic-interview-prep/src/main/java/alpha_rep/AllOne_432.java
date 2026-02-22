package alpha_rep;

import java.util.HashMap;
import java.util.HashSet;

public class AllOne_432 {
    class Node {
      int count;
      Node next, prev;
      HashSet<String> set = new HashSet<>();
      Node(int count) { this.count = count; }
    }

    Node head = new Node(Integer.MAX_VALUE);
    Node tail = new Node(Integer.MIN_VALUE);

    HashMap<String, Node> nodeMap = new HashMap<>();

    public AllOne_432() {
      head.next = tail;
      tail.prev = head;
    }

    // -------------------------
    // INC — CLEAN VERSION
    // -------------------------
    public void inc(String key) {
      Node curNode = nodeMap.get(key);

      // CASE 1: new key → goes to bucket 1
      if (curNode == null) {
        Node bucket1 = tail.prev;
        if (bucket1.count != 1) {
          bucket1 = new Node(1);
          addBefore(bucket1, tail);
        }
        bucket1.set.add(key);
        nodeMap.put(key, bucket1);
        return;
      }

      // CASE 2: existing key → move to count+1 bucket
      int nextCount = curNode.count + 1;
      Node prevNode = curNode.prev;

      if (prevNode.count != nextCount) {
        prevNode = new Node(nextCount);
        addBefore(prevNode, curNode);
      }

      // Move key
      curNode.set.remove(key);
      prevNode.set.add(key);
      nodeMap.put(key, prevNode);

      // Delete empty bucket
      if (curNode.set.isEmpty()) {
        remove(curNode);
      }
    }

    // -------------------------
    // DEC — YOUR VERSION WAS GOOD
    // -------------------------
    public void dec(String key) {
      Node curNode = nodeMap.get(key);
      int nextCount = curNode.count - 1;

      // CASE 1: key disappears
      if (nextCount == 0) {
        nodeMap.remove(key);
        curNode.set.remove(key);
        if (curNode.set.isEmpty()) remove(curNode);
        return;
      }

      // CASE 2: move to next-lower bucket
      Node nextNode = curNode.next;
      if (nextNode.count != nextCount) {
        nextNode = new Node(nextCount);
        addAfter(curNode, nextNode);
      }

      curNode.set.remove(key);
      nextNode.set.add(key);
      nodeMap.put(key, nextNode);

      if (curNode.set.isEmpty()) remove(curNode);
    }

    // -------------------------
    // HELPERS
    // -------------------------
    private void remove(Node curNode) {
      Node prev = curNode.prev, next = curNode.next;
      prev.next = next;
      next.prev = prev;
    }

    private void addBefore(Node newNode, Node nextNode) {
      Node prev = nextNode.prev;
      newNode.next = nextNode;
      nextNode.prev = newNode;
      newNode.prev = prev;
      prev.next = newNode;
    }

    private void addAfter(Node curNode, Node newNode) {
      Node nextNode = curNode.next;
      curNode.next = newNode;
      newNode.prev = curNode;
      newNode.next = nextNode;
      nextNode.prev = newNode;
    }

    public String getMaxKey() {
      if (head.next == tail) return "";
      return head.next.set.iterator().next();
    }

    public String getMinKey() {
      if (tail.prev == head) return "";
      return tail.prev.set.iterator().next();
    }
  }
