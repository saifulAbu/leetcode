package leetcode;

import java.util.HashMap;
import java.util.List;

public class ReplaceWords_648 {
  public String replaceWords(List<String> dictionary, String sentence) {
    //insert words
    for(String prefix : dictionary) {
      insert(prefix);
    }

    String res = "";
    String word[] = sentence.split(" ");
    for(int i = 0; i < word.length; i++) {
      res = res + " " + getPrefix(word[i]);
    }
    return res.trim();
  }

  static class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<>();
    String word = null;
  }

  TrieNode root = new TrieNode();

  public void insert(String prefix) {
    TrieNode curRoot = root;
    for(int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if(curRoot.map.get(ch) == null) {
        curRoot.map.put(ch, new TrieNode());
      }
      curRoot = curRoot.map.get(ch);
    }
    curRoot.word = prefix;
  }

  private String getPrefix(String word) {
    TrieNode curRoot = root;
    for(int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if(curRoot.map.get(ch) == null) {
        break;
      }
      curRoot = curRoot.map.get(ch);
      if(curRoot.word != null) {
        return curRoot.word;
      }
    }
    return word;
  }
}
