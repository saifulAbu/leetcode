package trees_and_graphs;

import java.util.*;

public class WordLadder_127 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //form set
    Set<String> wordSet = new HashSet<>();
    wordList.remove(beginWord);
    wordList.add(beginWord);
    for(String word : wordList) {
      wordSet.add(word);
    }

    //form graph
    Map<String, List<String>> graph = formGraph(wordList);

    return helperBFS(beginWord, endWord, wordList, wordSet, graph);
  }

  private int helperBFS(String beginWord, String endWord, List<String> wordList, Set<String> wordSet, Map<String, List<String>>graph) {
    if(!wordSet.contains(endWord)) {
      return 0;
    }
    Queue<String> q = new ArrayDeque<>();
    HashSet<String> visited = new HashSet<>();
    int level = 1;
    q.add(beginWord);
    visited.add(beginWord);

    while(!q.isEmpty()) {
      Queue<String> nextQueue = new ArrayDeque<>();
      while(!q.isEmpty()) {
        String curWord = q.poll();
        List<String> neighbor = graph.get(curWord);
        if(neighbor == null || neighbor.size() == 0) {
          return 0;
        }
        for(String word : neighbor) {
          if(word.equals(endWord)) {
            return level + 1;
          }
          if(!visited.contains(word)) {
            nextQueue.offer(word);
          }
          visited.add(word);
        }
      }
      q = nextQueue;
      level++;
    }
    return 0;
  }

  private Map<String, List<String>> formGraph( List<String> wordList) {
    Map<String, List<String>> graph = new HashMap<>();

    for(int i = 0; i < wordList.size() - 1; i++) {
      String w1 = wordList.get(i);
      for(int j = i + 1; j < wordList.size(); j++) {
        String w2 = wordList.get(j);
        if(isNeighbor(w1, w2)) {
          graph.putIfAbsent(w1, new ArrayList<String>());
          graph.putIfAbsent(w2, new ArrayList<String>());

          graph.get(w1).add(w2);
          graph.get(w2).add(w1);
        }
      }
    }
    return graph;
  }

  private boolean isNeighbor(String w1, String w2) {
    int numMisMatch = 0;
    for(int i = 0; i < w1.length(); i++) {
      if(w1.charAt(i) != w2.charAt(i)) {
        numMisMatch++;
      }
      if(numMisMatch > 1) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {
    String beginWord = "zzz";
    String endWord = "hot";

    String [] wordArr = {"hot","dot","dog","lot","log","cog"};

    List<String> wordList = new ArrayList<>();
    for(String word : wordArr) {
      wordList.add(word);
    }

    WordLadder_127 wl = new WordLadder_127();
    System.out.println(wl.ladderLength(beginWord, endWord, wordList));
  }
}
// wheel
// of dharma