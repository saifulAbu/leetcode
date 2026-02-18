package alpha_rep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordDistance_244 {
  HashMap<String, List<Integer>> wordIndexMap = new HashMap<>();
  //public WordDistance(String[] wordsDict) {
  public WordDistance_244(String[] wordsDict) {
    /*
    * create a map of word -> [i0, i1, i3] the indices the word appears
    * then
    *   word0 -> [i0, i1, i3]
    *   word1 -> [j0, j1, j3]
    * find the min distance between these two lists. both lists are naturally sorted. so move the index that is smaller
    * */



    for(int i = 0; i < wordsDict.length; i++) {
      String word = wordsDict[i];
      if(!wordIndexMap.containsKey(word)) {
        wordIndexMap.put(word, new LinkedList<>());
      }
      wordIndexMap.get(word).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    if(word1.equals(word2)) {
      return 0;
    }

    List<Integer> indexList1 = wordIndexMap.get(word1);
    List<Integer> indexList2 = wordIndexMap.get(word2);

    int i = 0, j = 0;
    int minDistance = Integer.MAX_VALUE;
    while(i < indexList1.size() && j < indexList2.size()) {
      int index0 = indexList1.get(i), index1 = indexList2.get(j);
      minDistance = Math.min(Math.abs(index0 - index1), minDistance);
      if(index0 < index1) {
        i++;
      } else {
        j++;
      }
    }
    return minDistance;
  }
}
