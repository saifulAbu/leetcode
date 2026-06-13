package zystem_design;

public class HashMap <K, V> {
  class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value, Entry<K,V> next){
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  int capacity = 16;
  int size = 0;
  float loadFactor = 0.75f;
  Entry<K, V> [] buckets;

  public HashMap() {
    buckets = new Entry[capacity];
  }

  private int getBucketIndex(K key) {
    int hash = key.hashCode();
    hash = hash & 0x7fff_ffff; //hash code might be negative to make it positive
    return hash % capacity;
  }

  public void put(K key, V value) {
    int bucketIndex = getBucketIndex(key);
    Entry<K, V> head = buckets[bucketIndex];
    while(head != null) {
      if(head.key.equals(key)) {
        head.value = value;
        return;
      }
      head = head.next;
    }
    buckets[bucketIndex] = new Entry<>(key, value, buckets[bucketIndex]);
    size++;
    if(size >=  loadFactor * capacity) {
      rehash();
    }
  }

  public V get(K key) {
    int bucketIndex = getBucketIndex(key);
    Entry<K, V> head = buckets[bucketIndex];
    while(head != null) {
      if(head.key.equals(key)) {
        return head.value;
      }
      head = head.next;
    }
    return null;
  }

  public V remove(K key) {
    int bucketIndex = getBucketIndex(key);
    Entry<K, V> head = buckets[bucketIndex], prev = null;

    while(head != null) {
      if(head.key.equals(key)) {
        V removedValue = head.value;
        if(prev == null) { //remove the head element
          buckets[bucketIndex] = head.next;
        } else {
          prev.next = head.next;
        }
        size--;
        return removedValue;
      } else {
        prev = head;
        head = head.next;
      }
    }
    return null;
  }

  private void rehash() {
    Entry<K,V>[] oldbucket = buckets;
    size = 0;
    capacity = capacity * 2;
    buckets = new Entry[capacity];
    for(Entry<K, V> head : oldbucket) {
      while(head != null) {
        put(head.key, head.value);
        head = head.next;
      }
    }
  }

  public boolean containsKey(K key) {
    return get(key) != null;
  }

  public int size() {
    return size;
  }
}
