package array_and_string;

import java.util.Arrays;

public class MinDeletion_1647 {
  public int minDeletions(String s) {
    int [] freq = new int[26];
    for (char ch : s.toCharArray()) {
      freq[ch - 'a']++;
    }

    Arrays.sort(freq);

    int totalDeletion = 0;
    for (int i = freq.length - 2; i >= 0; i--) {
      int minCountToValidateCurrent = freq[i];
      if (freq[i+1] == 0) {
        minCountToValidateCurrent = 0;
      } else if (freq[i+1] <= freq[i]) {
        minCountToValidateCurrent = freq[i+1] - 1;
      }
      totalDeletion += (freq[i] - minCountToValidateCurrent);
      freq[i] = minCountToValidateCurrent;
    }

    return totalDeletion;
  }
}
