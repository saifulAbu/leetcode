package hash;

import java.util.LinkedList;
import java.util.List;

public class DesignHashMap_0_706 {
  public static void main(String args[]) {
    MyHashMap obj = new MyHashMap();
    int key = 2, value = 7;
    obj.put(key,value);
    int param_2 = obj.get(key);
    obj.put(key, 5);
    obj.remove(key);
  }
}

class MyHashMap {
  class MapEntry {
    int key;
    int value;
    MapEntry(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  final int SIZE = 997;
  List<MapEntry>[] data = new List[SIZE];
  public MyHashMap() {
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

  int indexOf(List<MapEntry> bucket, int key) {
    int i = 0;
    for(MapEntry v : bucket) {
      if(v.key == key) {
        return i;
      }
      i++;
    }
    return -1;
  }

  List<MapEntry> getBucket(int x) {
    return data[getHash(x)];
  }


  public void put(int key, int value) {
    List<MapEntry> bucket = getBucket(key);
    int i = indexOf(bucket, key);
    if(i == -1) {
      MapEntry entry = new MapEntry(key, value);
      bucket.add(entry);
    } else {
      MapEntry entry = bucket.get(i);
      entry.value = value;
    }
  }

  public int get(int key) {
    List<MapEntry> bucket = getBucket(key);
    int i = indexOf(bucket, key);
    if(i == -1) {
      return -1;
    } else {
      MapEntry entry = bucket.get(i);
      return entry.value;
    }
  }

  public void remove(int key) {
    List<MapEntry> bucket = getBucket(key);
    int i = indexOf(bucket, key);
    if(i != -1) {
      bucket.remove(i);
    }
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// an opening for a new day!