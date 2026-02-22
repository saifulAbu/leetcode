package alpha_rep;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceColor_1182 {
  public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
    /*
     * get indices of each color, it will be naturally sorted
     * for each query(index, color)
     *   we can binary search in the index of the color and take the nearest one
     *
     * make sure to use ArrayList or else it will get a TLE for linkedList
     *
     * */

    ArrayList<Integer>[] colorIndex = new ArrayList[4];
    for(int i = 1; i < 4; i++) {
      colorIndex[i] = new ArrayList<>();
    }

    // store index of each color
    for(int i = 0; i < colors.length; i++) {
      int color = colors[i];
      colorIndex[color].add(i);
    }

    ArrayList<Integer> queryRes = new ArrayList<>();
    for(int[] query : queries) {
      int index = query[0];
      int targetColor = query[1];
      ArrayList<Integer> targetColorIndices = colorIndex[targetColor];
      if(targetColorIndices.isEmpty()) {
        queryRes.add(-1);
        continue;
      }
      if(targetColor == colors[index]) {
        queryRes.add(0);
        continue;
      }

      int searchResult = Collections.binarySearch(targetColorIndices, index);
      if(searchResult < 0) {
        searchResult = (searchResult + 1) * -1;
      }
      if(searchResult == 0) {
        queryRes.add(targetColorIndices.get(0) - index);
      } else if(searchResult == targetColorIndices.size()) {
        queryRes.add(index - targetColorIndices.get(searchResult - 1));
      } else {
        queryRes.add(Math.min(index - targetColorIndices.get(searchResult - 1), targetColorIndices.get(searchResult) - index));
      }
    }

    return queryRes;
  }
}
