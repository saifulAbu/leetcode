package trees_and_graphs;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AlienDictionary_269 {
  public String alienOrder(String[] words) {
    return "";
  }

  private static int findMisMatchedIndex(String str0, String str1) {
    for(int i = 0; i < Math.min(str0.length(), str1.length()); i++) {
      if(str0.charAt(i) != str1.charAt(i)) {
        return i;
      }
    }
    return -1;
  }

  private static HashMap<Character, Set<Character>> getGraph(String [] words) {
    HashMap<Character, Set<Character>> graph = new HashMap<>();
    for(char ch : getAlphabet(words)) {
      graph.put(ch, new HashSet<>());
    }
    for(int i = 1; i < words.length; i++) {
      String w0 = words[i-1];
      String w1 = words[i];
      int k = findMisMatchedIndex(w0, w1);
      if(k == -1) {
        continue;
      }
      char pred = w0.charAt(k);
      char dec = w1.charAt(k);
      graph.get(pred).add(dec);
    }
    return graph;
  }

  private static char[] getAlphabet(String [] words) {
    Set<Character> set = new HashSet<>();
    for(String word : words) {
      for(char ch : word.toCharArray()) {
        set.add(ch);
      }
    }
    char [] res = new char[set.size()];
    int i = 0;
    Iterator<Character> setItr = set.iterator();
    while(setItr.hasNext()) {
      res[i++] = setItr.next();
    }
    return res;
  }

  private static HashMap<Character, Integer> getIndegree(HashMap<Character, Set<Character>> map) {
    HashMap<Character, Integer> indegree = new HashMap<>();
    for(char ch : map.keySet()) {
      indegree.put(ch, 0);
    }
    for(Set<Character> edges : map.values()) {
      for(char ch : edges) {
        indegree.put(ch, indegree.get(ch) + 1);
      }
    }
    return indegree;
  }

  public static void main(String [] args) {
    assertEquals(findMisMatchedIndex("abcxyz", "abcdef"), 3);
    assertEquals(findMisMatchedIndex("abc", "def"), 0);
    assertEquals(findMisMatchedIndex("abc", "abf"), 2);
    assertEquals(findMisMatchedIndex("abc", "abcdef"), -1);

    String [] words = {"wrt","wrf","er","ett","rftt"};

    char [] res = getAlphabet(words);
    HashMap<Character, Set<Character>> graph = getGraph(words);
    HashMap<Character, Integer> indegree = getIndegree(graph);
    System.out.println("hola");
  }

}
