package trie;

import java.util.*;

public class AutocompleteSystem_642 {
  static class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<>();
    boolean isWord = false;
    String sentence = "";
    int count = 0;
  }

  private static class ListElem implements Comparable {
    String sentence;
    int freq;
    ListElem(String sentence, int freq) {
      this.sentence = sentence;
      this.freq = freq;
    }

    @Override
    public int compareTo(Object o) {
      ListElem el = (ListElem) o;
      if(el.freq - freq == 0) {
        return sentence.compareTo(el.sentence);
      }
      return el.freq - freq;
    }
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

  private void getSentenceCount(TrieNode root, List<ListElem> list) {
    if(root.isWord) {
      list.add(new ListElem(root.sentence, root.count));
    }
    for(char ch : root.map.keySet()) {
      TrieNode child = root.map.get(ch);
      getSentenceCount(child, list);
    }
  }

  public List<String> input(char c) {
    return null;
  }

  public static void main(String args[]) {
    String[] sentences = {"aaa", "aa", "a", "aba"};
    int[] count = {7, 3, 2, 7};
    AutocompleteSystem_642 autoComplete = new AutocompleteSystem_642(sentences, count);
    List<ListElem> items = new LinkedList<ListElem>();
    autoComplete.getSentenceCount(autoComplete.root, items);
    Collections.sort(items);
    System.out.println();
  }
}
