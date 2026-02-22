package alpha_rep;

import java.util.HashMap;

//public class LRUCache_146 {
class LRUCache_146 {
  HashMap<Integer, Node> nodeMap = new HashMap<>();
  Node head = new Node(-1, -1), tail = new Node(-1, -1);
  int size = 0;
  int capacity = 0;
  class Node {
    Node prev, next;
    int val, key;
    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  //public LRUCache(int capacity) {
  public LRUCache_146(int capacity) {
    head.next = tail;
    tail.prev = head;
    this.capacity = capacity;
  }

  public void put(int key, int value) {
    if(nodeMap.containsKey(key)) {
      Node node = nodeMap.get(key);
      node.val = value;
      removeFromList(node);
      addToHead(node);
      return;
    }

    if(size < capacity){
      Node node = new Node(key, value);
      nodeMap.put(key, node);
      addToHead(node);
      size++;
    } else {
      Node tailNode = getTailNode();
      removeFromList(tailNode);
      nodeMap.remove(tailNode.key);

      // reuse the node
      tailNode.key = key;
      tailNode.val = value;
      nodeMap.put(key, tailNode);
      addToHead(tailNode);
    }
  }

  private Node getTailNode() {
    return tail.prev;
  }

  private void removeFromList(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  private void addToHead(Node node) {
    Node curFront = head.next;
    curFront.prev = node;
    node.next = curFront;
    head.next = node;
    node.prev = head;
  }


  public int get(int key) {
    Node node = nodeMap.get(key);
    if(node == null) {
      return -1;
    }
    removeFromList(node);
    addToHead(node);
    return node.val;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */