package alpha_rep;

import java.util.HashSet;
import java.util.List;

//noted
public class WordBreak_139 {
  public boolean wordBreak_drona(String s, List<String> wordDict) {
    HashSet<String> dict = new HashSet<>(wordDict);
    int n = s.length();

    // dp[i] = can we segment s[i:]
    boolean[] dp = new boolean[n + 1];
    dp[n] = true; // empty string is segmentable

    for (int start = n - 1; start >= 0; start--) {
      StringBuilder sb = new StringBuilder();

      for (int end = start; end < n; end++) {
        sb.append(s.charAt(end));

        if (dict.contains(sb.toString()) && dp[end + 1]) {
          dp[start] = true;
          break;
        }
      }
    }

    return dp[0];
  }


  public boolean wordBreak_drona_backtrack(String s, List<String> wordDict) {
    /*
     * backtracking solution requires a worst case O(n ^ n) solution
     * we have a for loop that runs n times, and inside the loop i we make n recursive calls
     * f(n) = n * f(i)
     * */
    HashSet<String> dict = new HashSet<>(wordDict);
    return backtrack(s, dict, 0);
  }

  private boolean backtrack(String s, HashSet<String> dict, int start) {
    // Base case: reached the end successfully
    if (start == s.length()) {
      return true;
    }

    // Try all possible prefixes starting at 'start'
    StringBuilder sb = new StringBuilder();
    for (int end = start; end < s.length(); end++) {
      sb.append(s.charAt(end));

      // If prefix is a valid word, recurse on the remainder
      if (dict.contains(sb.toString())) {
        if (backtrack(s, dict, end + 1)) {
          return true;
        }
      }
    }

    // No valid segmentation found
    return false;
  }
}
