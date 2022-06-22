package trie;

import java.util.HashMap;

public class WordDictionary_211 {
  static class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<>();
    boolean isWord = false;
    String word = "";
  }

  TrieNode root = new TrieNode();

  public void addWord(String word) {
    TrieNode curRoot = root;
    for(char ch : word.toCharArray()) {
      curRoot.map.putIfAbsent(ch, new TrieNode());
      curRoot = curRoot.map.get(ch);
    }
    curRoot.isWord = true;
    curRoot.word = word;
  }

  public boolean search(String word) {
    return true;
  }

  public static void main(String args[]) {
    WordDictionary_211 wd = new WordDictionary_211();
    wd.addWord("aaa");
    wd.addWord("aba");
    wd.addWord("acb");
    wd.addWord("a");
    //wd.addWord("aaa");
    //
    System.out.println("hola, mundo!");
  }
}
