package trie;

import java.util.HashMap;
import java.util.List;

public class AutocompleteSystem_642 {
  static class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<>();
    boolean isWord = false;
    String sentence = "";
    int count = 0;
  }
  TrieNode root = new TrieNode();
  public AutocompleteSystem_642(String[] sentences, int[] times) {
    for(int i = 0; i < sentences.length; i++) {
      insert(sentences[i], times[i]);
    }
  }

  private void insert(String sentence, int time) {
    TrieNode curRoot = root;
    for(int i = 0; i < sentence.length(); i++) {
      char ch = sentence.charAt(i);
      curRoot.map.putIfAbsent(ch, new TrieNode());
      curRoot = curRoot.map.get(ch);
    }
    curRoot.sentence = sentence;
    curRoot.isWord = true;
    curRoot.count = time;
  }

  public List<String> input(char c) {
    return null;
  }

  public static void main(String args[]) {
    String[] sentences = {"aaa", "aa", "a", "aba"};
    int[] count = {5, 3, 2, 7};
    AutocompleteSystem_642 obj = new AutocompleteSystem_642(sentences, count);
    System.out.println();
  }
}
