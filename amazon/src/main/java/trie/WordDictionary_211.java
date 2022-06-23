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
    return searchH(root, word, 0);
  }

  private boolean searchH(TrieNode root, String word, int i) {
    if(i >= word.length()) {
      if(root.isWord) {
        return true;
      } else {
        return false;
      }
    }
    char ch = word.charAt(i);
    if(ch == '.') {
      for(char w : root.map.keySet()) {
        if(searchH(root.map.get(w), word, i+1)) {
          return true;
        }
      }
      return false;
    } else {
        if(root.map.get(ch) == null) {
          return false;
        }
        return searchH(root.map.get(ch), word, i+1);
    }
  }

  public static void main(String args[]) {
    WordDictionary_211 wd = new WordDictionary_211();
    wd.addWord("aaa");
    wd.addWord("aba");
    wd.addWord("acb");
    wd.addWord("a");
    //wd.addWord("aaa");
    //
    boolean b = wd.search("a.a");
    b = wd.search("ata");
    System.out.println("hola, mundo!");
  }
}
