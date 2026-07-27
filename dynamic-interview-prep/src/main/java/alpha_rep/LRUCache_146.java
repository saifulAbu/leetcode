package alpha_rep;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

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


class LRUCache_0714 {

    int capacity = 0;
    Map<Integer, DoublyLinkedList.Node> nodeMap;
    DoublyLinkedList dll;

    public LRUCache_0714(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        dll = new DoublyLinkedList();
    
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
          return -1;
        }
        DoublyLinkedList.Node node = nodeMap.get(key);
        dll.removeNode(node);
        dll.insertToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
      // check if key exists, update, node and re insert to the dll
      // if does not exist, check cur capacity, if size == n, remove the last node, create node, insert to front

      if(nodeMap.containsKey(key)) {
        DoublyLinkedList.Node node = nodeMap.get(key);
        node.val = value;
        dll.removeNode(node);
        dll.insertToFront(node);
      } else {
        if (nodeMap.size() == capacity) {
          DoublyLinkedList.Node last = dll.removeFromEnd();
          nodeMap.remove(last.key);
        }
        DoublyLinkedList.Node node = new DoublyLinkedList.Node();
        node.key = key;
        node.val =value;
        nodeMap.put(key, node);
        dll.insertToFront(node);
      }
    }

    static class DoublyLinkedList {
      static class Node {
        Node next, prev;
        int val;
        int key;
      }
      Node head, tail;
      DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
      }

      void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
      }

      void insertToFront(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
      } 

      Node removeFromEnd() {
        Node last = tail.prev;
        removeNode(last);
        return last;
      }
    }
}

class LRUCache_0727 {
  int capacity;
  Map<Integer, LRUCache_0727.DoublyLinkedList.Node> nodeMap = new HashMap<>();
  LRUCache_0727.DoublyLinkedList dll = new LRUCache_0727.DoublyLinkedList();

  LRUCache_0727(int capacity) {
    this.capacity = capacity; 
  }
  int get(int k) {
    if(!nodeMap.containsKey(k)) {
      return -1;
    }

    LRUCache_0727.DoublyLinkedList.Node n = nodeMap.get(k);
    dll.removeNode(n);
    dll.insertToFront(n);
    return n.val;
  }

  void put(int k, int v) {
    LRUCache_0727.DoublyLinkedList.Node n;
    if(nodeMap.containsKey(k)) {
      n = nodeMap.get(k);
      n.key = k;
      n.val = v;
      dll.removeNode(n);
    } else {
      n = new LRUCache_0727.DoublyLinkedList.Node(k, v);
      nodeMap.put(k, n);
      if(nodeMap.size() > capacity) {
        LRUCache_0727.DoublyLinkedList.Node tail = dll.removeFromTail();
        nodeMap.remove(tail.key);
      }
    }
    dll.insertToFront(n);

  }

  static class DoublyLinkedList {
    static class Node {
      Node next, prev;
      int key, val;
      Node(int k, int v) {
        key = k;
        val = v;
      }
    }

    Node head, tail;
    DoublyLinkedList() {
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }
    
    void removeNode(Node n) {
      n.next.prev = n.prev;
      n.prev.next = n.next;
    }

    void insertToFront(Node n) {
      n.prev = head;
      n.next = head.next;
      
      head.next.prev = n;
      head.next = n;
    }

    Node removeFromTail() {
      Node n = tail.prev;
      removeNode(n);

      return n;
    }
  }
}