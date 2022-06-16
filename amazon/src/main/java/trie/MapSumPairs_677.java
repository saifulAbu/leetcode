package trie;

import java.util.HashMap;

public class MapSumPairs_677 {
  static class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<>();
    int val = 0;
  }
  TrieNode root = new TrieNode();

  public void insert(String key, int val) {
    TrieNode curRoot = root;
    for(int i = 0; i < key.length(); i++) {
      char ch = key.charAt(i);
      if(curRoot.map.get(ch) == null) {
        curRoot.map.put(ch, new TrieNode());
      }
      curRoot = curRoot.map.get(ch);
    }
    curRoot.val = val;
  }

  public int sum(String key) {
    TrieNode curRoot = root;
    for(int i = 0; i < key.length(); i++) {
      char ch = key.charAt(i);
      if(curRoot.map.get(ch) == null) {
        return 0;
      }
      curRoot = curRoot.map.get(ch);
    }
    return sumHelper(curRoot);
  }

  private int sumHelper(TrieNode curRoot) {
    int sum = curRoot.val;
    for(char ch : curRoot.map.keySet()) {
      sum = sum + sumHelper(curRoot.map.get(ch));
    }
    return sum;
  }

  public static void main(String args[]) {
    MapSumPairs_677 mp = new MapSumPairs_677();
    mp.insert("a", 7);
    mp.insert("ab", 3);
    mp.insert("ba", 5);
    System.out.println(mp.sum(""));
    System.out.println("hello, world!");
  }
}
