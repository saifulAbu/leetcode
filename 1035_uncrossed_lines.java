class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int dp[][] = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                int maxCross = Math.max(dp[i][j-1], dp[i-1][j]);
                if(A[i-1] == B[j-1]) {
                    maxCross = Math.max(dp[i-1][j-1] + 1, maxCross);
                }
                dp[i][j] = maxCross;
            }
        }
        return dp[A.length][B.length];
    }
}