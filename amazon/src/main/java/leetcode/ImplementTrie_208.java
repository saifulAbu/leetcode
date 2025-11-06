package leetcode;

import java.util.HashMap;

public class ImplementTrie_208 {
  class TrieNode {
   HashMap<Character, TrieNode> nextLevel = new HashMap<>();
   boolean isWord = false;

   boolean containsChar(char ch) {
     return nextLevel.containsKey(ch);
   }

   void put(char ch, TrieNode node) {
     nextLevel.put(ch, node);
   }

   TrieNode get(char ch) {
     return nextLevel.get(ch);
   }

   void setWord() {
     isWord = true;
   }

    public boolean isWord() {
     return isWord;
    }
  }

  TrieNode root = new TrieNode();

  public void insert(String word) {
    TrieNode curNode = root;

    for(Character ch : word.toCharArray()) {
       if(!curNode.containsChar(ch)) {
         curNode.put(ch, new TrieNode());
       }
       curNode = curNode.get(ch);
    }
    curNode.setWord();
  }

  private TrieNode traverseWord(String word) {
    TrieNode curNode = root;
    for(Character ch : word.toCharArray()) {
      if(!curNode.containsChar(ch)) {
        return null;
      }
      curNode = curNode.get(ch);
    }
    return curNode;
  }

  public boolean search(String word) {
    TrieNode endNode = traverseWord(word);
    return endNode != null && endNode.isWord();
  }

  public boolean startsWith(String prefix) {
    TrieNode endNode = traverseWord(prefix);
    return endNode != null;
  }
}

























class ImplementTrie_0_208 {
  static int R = 26;
  private static class TrieNode {
    private TrieNode[] next = new TrieNode[R];
    private boolean isWord = false;

    boolean contains(char c) {
      return next[c - 'a'] != null;
    }

    void put(char c, TrieNode node) {
      next[c - 'a'] = node;
    }

    TrieNode get(char c) {
      return next[c - 'a'];
    }

    boolean isWord() {
      return isWord;
    }

    void setWord() {
      isWord = true;
    }
  }


  TrieNode root;
  public ImplementTrie_0_208() {
    root = new TrieNode();
  }

  public void insert(String word) {
    insertHelper(root, word, 0);
  }

  private void insertHelper(TrieNode root, String word, int i) {
    if(i == word.length()) {
      root.setWord();
      return;
    }

    char ch = word.charAt(i);
    if(!root.contains(ch)) {
      root.put(ch, new TrieNode());
    }

    insertHelper(root.get(ch), word, i + 1);
  }

  public boolean search(String word) {
    TrieNode node = startsWithHelper(root, word, 0);
    return node != null && node.isWord();
  }

  public boolean startsWith(String prefix) {
    return startsWithHelper(root, prefix, 0) != null;
  }

  private TrieNode startsWithHelper(TrieNode root, String prefix, int i) {
    if (i == prefix.length()) {
      return root;
    }
    char ch = prefix.charAt(i);
    if (!root.contains(ch)) {
      return null;
    }
    return startsWithHelper(root.get(ch), prefix, i+1);
  }

  public static void main(String args[]) {
    ImplementTrie_208 tr = new ImplementTrie_208();
    tr.insert("leet");
    tr.insert("led");
    print(tr.search("led") + "");
    System.out.println("hola");
  }

  static public void print(String str) {
    System.out.println(str);
  }
}
