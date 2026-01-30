package design;

import java.util.HashMap;

public class LRUCache_146 {
  private static class Node {
    Node prev;
    Node next;
    int val;
    int key;
    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  int size = 0;
  int MAX = 0;
  HashMap<Integer, Node> map = new HashMap<>();
  Node tail = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE), head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);

  private void addToHead(Node node) {
    Node prev = head;
    Node next = head.next;

    node.prev = prev;
    node.next = next;

    prev.next = node;
    next.prev = node;
  }

  private void removeNode(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
    node.prev = null;
    node.next = null;
  }

  private void removeAndAddFront(Node node) {
    removeNode(node);
    addToHead(node);
  }

  public LRUCache_146 (int capacity) {
    this.MAX = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) return  -1;
    removeAndAddFront(node);
    return node.val;
  }

  public void put(int key, int value) {
    Node node = map.get(key);
    if (node == null) {
      if (size == MAX) {
        Node last = tail.prev;
        removeNode(last);
        map.remove(last.key);
        size--;
      }
      node = new Node(key, value);
      map.put(key, node);
      addToHead(node);
      size++;
    } else {
      node.val = value;
      removeAndAddFront(node);
    }
  }

  public static void main(String args[]) {
    LRUCache_146 lRUCache = new LRUCache_146(2);
    lRUCache.put(1, 0); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
  }
}

/*
*
["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
*
* */