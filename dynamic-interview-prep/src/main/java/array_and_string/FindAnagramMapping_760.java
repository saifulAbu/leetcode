package array_and_string;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMapping_760 {
  public int[] anagramMappings(int[] A, int[] B) {
    int[] res = new int[A.length];
    Map<Integer, Integer> mapB = new HashMap<>();
    for(int i = 0; i < A.length; i++) {
     mapB.put(B[i], i);
    }

    for(int i = 0; i < A.length; i++) {
      res[i] = mapB.get(A[i]);
    }
    return res;
  }
}
