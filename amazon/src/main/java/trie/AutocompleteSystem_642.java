package trie;

import java.util.*;

public class AutocompleteSystem_642 {
  TrieNode root = new TrieNode();
  TrieNode curRoot = root;
  StringBuilder wordSoFar = new StringBuilder();

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
    List<String> strList = new LinkedList<>();
    if(c == '#') {
      curRoot.sentence = wordSoFar.toString();
      curRoot.count += 1;
      curRoot.isWord = true;

      //reset
      curRoot = root;
      wordSoFar.setLength(0);
      return strList;
    }

    wordSoFar.append(c);
    curRoot.map.putIfAbsent(c, new TrieNode());
    curRoot = curRoot.map.get(c);

    List<ListElem> sentenceCounts = new LinkedList<ListElem>();
    getSentenceCount(curRoot, sentenceCounts);
    Collections.sort(sentenceCounts);

    for(int i = 0; i < 3 && !sentenceCounts.isEmpty(); i++) {
      strList.add(sentenceCounts.get(0).sentence);
      sentenceCounts.remove(0);
    }

    return strList;
  }

  public static void main(String args[]) {
    String[] sentences = {"aaa", "aa", "a", "aba"};
    int[] count = {5, 3, 2, 7};
    AutocompleteSystem_642 obj = new AutocompleteSystem_642(sentences, count);
    //List<ListElem> items = new LinkedList<ListElem>();
    //autoComplete.getSentenceCount(autoComplete.root, items);
    //Collections.sort(items);

    List<String> list;
    list = obj.input('a'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
    list = obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
    list = obj.input('a'); // return []. There are no sentences that have prefix "i a".
    list = obj.input('#');

    list = obj.input('a'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
    list = obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
    list = obj.input('a'); // return []. There are no sentences that have prefix "i a".


    System.out.println();
  }
}
