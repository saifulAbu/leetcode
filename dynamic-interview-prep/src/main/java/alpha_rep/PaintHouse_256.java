package alpha_rep;

public class PaintHouse_256 {
  public int minCost(int[][] costs) {
    /*
    *
    * if we know optimum cost for house 0, for colors [r0, g0, b0], we can compute optimal cost for house 0 and 1
    * for different colors. for house 0 and 1 would be [r1 + min(g0, b0), g1 + min(r0, b0), b1 + min(r0, g0)]
    *
    * dynamic programming problem.
    * */

    int N = costs.length;
    int[][] optimalCost = new int[N][3];

    optimalCost[0][0] = costs[0][0];
    optimalCost[0][1] = costs[0][1];
    optimalCost[0][2] = costs[0][2];

    for(int i = 1; i < N; i++) {
      optimalCost[i][0] = costs[i][0] + Math.min(optimalCost[i-1][1], optimalCost[i-1][2]);
      optimalCost[i][1] = costs[i][1] + Math.min(optimalCost[i-1][0], optimalCost[i-1][2]);
      optimalCost[i][2] = costs[i][2] + Math.min(optimalCost[i-1][1], optimalCost[i-1][0]);
    }

    return Math.min(Math.min(optimalCost[N-1][0], optimalCost[N-1][1]), optimalCost[N-1][2]);
  }
}
