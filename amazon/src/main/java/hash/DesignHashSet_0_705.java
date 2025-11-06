package hash;

import java.util.LinkedList;
import java.util.List;

class DesignHashSet_705 {
  public static void main(String args[]) {
    int key = 7;
    MyHashSet obj = new MyHashSet();
    obj.add(key);
    obj.add(5);
    obj.add(1007);
    obj.add(7);
    obj.add(2008);
    obj.remove(8);
    boolean param_3 = obj.contains(key);
    param_3 = obj.contains(7);
    System.out.println("hola");
  }
}

class MyHashSet {
  final int SIZE = 1000;
  List<Integer>[] data = new List[SIZE];
  public MyHashSet() {
    initialize();
  }

  int getHash(int x) {
    return x % SIZE;
  }

  private void initialize() {
    for(int i = 0; i < SIZE; i++) {
      data[i] = new LinkedList<>();
    }
  }

  public void add(int key) {
    List<Integer> bucket = getBucket(key);
    int i = indexOf(bucket, key);
    if(i == -1) {
      bucket.add(key);
    }
  }

  int indexOf(List<Integer> bucket, int x) {
    int i = 0;
    for(int v : bucket) {
      if(v == x) {
        return i;
      }
      i++;
    }
    return -1;
  }

  List<Integer> getBucket(int x) {
    return data[getHash(x)];
  }

  public void remove(int key) {
    List<Integer> bucket = getBucket(key);
    int k = indexOf(bucket, key);
    if(k != -1) {
      bucket.remove(k);
    }
  }

  public boolean contains(int key) {
    return indexOf(getBucket(key), key) != -1;
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */