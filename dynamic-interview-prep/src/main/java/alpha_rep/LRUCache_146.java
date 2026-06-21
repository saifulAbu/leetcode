package alpha_rep;

import java.util.HashMap;
import java.util.Map;

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

class LRUCache_drona {
  Map<Integer, DoublyLinkedList.Node> map = new HashMap<>();
  DoublyLinkedList dll = new DoublyLinkedList();
  int capacity;

  LRUCache_drona(int capacity) {
    this.capacity = capacity;
  }

  int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    DoublyLinkedList.Node node = map.get(key);
    dll.removeNode(node);
    dll.insertToFront(node);
    return node.val;
  }

  void put(int key, int value) {
    if (map.containsKey(key)) {
      // update existing
      DoublyLinkedList.Node node = map.get(key);
      node.val = value;
      dll.removeNode(node);
      dll.insertToFront(node);
      return;
    }

    // new key
    if (map.size() == capacity) {
      // evict LRU
      DoublyLinkedList.Node lru = dll.removeFromTail();
      map.remove(lru.key);
    }

    // insert new node
    DoublyLinkedList.Node newNode = new DoublyLinkedList.Node();
    newNode.key = key;
    newNode.val = value;

    dll.insertToFront(newNode);
    map.put(key, newNode);
  }

  static class DoublyLinkedList {
    static class Node {
      int key, val;
      Node next, prev;
    }

    Node head, tail;

    DoublyLinkedList() {
      head = new Node();
      tail = new Node();
      head.next = tail;
      tail.prev = head;
    }

    void insertToFront(Node node) {
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
    }

    void removeNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.next = null;
      node.prev = null;
    }

    Node removeFromTail() {
      Node node = tail.prev;
      removeNode(node);
      return node;
    }
  }
}

class LRUCache_0613 {
  static class DoublyLinkedList {
    static class Node {
      int key;
      int val;
      Node next, prev;

      Node(int key, int val) {
        this.key = key;
        this.val = val;
      }
    }

    Node head, tail;
    DoublyLinkedList() {
      head = new Node(0, 0);
      tail = new Node(0, 0);

      head.next = tail;
      tail.prev = head;
    }

    void insertFront(Node node){
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
    }

    void removeNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    Node removeTail() {
      if(tail.prev == head) {
        return null;
      }
      Node lastNode = tail.prev;
      removeNode(lastNode);
      return lastNode;
    }
   } 

   DoublyLinkedList dll;
   Map<Integer, DoublyLinkedList.Node> map;
   int capacity, size;

   LRUCache_0613 (int capacity) {
    dll = new DoublyLinkedList();
    map = new HashMap<>();
    this.capacity = capacity;
    size = 0;
   }

   void put(int key, int value) {
    if(map.containsKey(key)) {
      DoublyLinkedList.Node n = map.get(key);
      n.val = value;
      dll.removeNode(n);
      dll.insertFront(n);
      return;
    }
    if(size == capacity) {
      map.remove(dll.removeTail().key);
      size--;
    }
    DoublyLinkedList.Node n = new DoublyLinkedList.Node(key, value);
    map.put(key, n);
    dll.insertFront(n);
    size++;
   }

   int get(int key) {
    if(!map.containsKey(key)){
      return -1;
    }
    DoublyLinkedList.Node n = map.get(key);
    dll.removeNode(n);
    dll.insertFront(n);
    return n.val;
   }
}
