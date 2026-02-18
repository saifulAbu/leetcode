package alpha_rep;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignALeaderBoard_1244 {

}

class Leaderboard {

  HashMap<Integer, Integer> playerScoreMap = new HashMap<>();
  TreeMap<Integer, Integer> scoreCount = new TreeMap<>(Collections.reverseOrder());

  public void addScore(int playerId, int score) {
    int prevScore = 0;
    if(playerScoreMap.containsKey(playerId)) {
      prevScore = playerScoreMap.get(playerId);
      scoreCount.put(prevScore, scoreCount.get(prevScore) - 1);
      if(scoreCount.get(prevScore) == 0) {
        scoreCount.remove(prevScore);
      }
    }
    int newScore = prevScore + score;
    playerScoreMap.put(playerId, newScore);
    scoreCount.put(newScore, scoreCount.getOrDefault(newScore, 0) + 1);
  }

  public int top(int K) {
    int sum = 0;
    int playerCount = 0;
    for(Map.Entry<Integer, Integer> entry : scoreCount.entrySet()) {
      int score = entry.getKey();
      int frequency = entry.getValue();
      for(int i = 0; i < frequency; i++) {
        sum += score;
        playerCount++;
        if(playerCount == K) {
          return sum;
        }
      }
    }
    return sum;
  }

  public void reset(int playerId) {
    int score = playerScoreMap.get(playerId);
    playerScoreMap.remove(playerId);
    scoreCount.put(score, scoreCount.get(score) - 1);
    if(scoreCount.get(score) == 0) {
      scoreCount.remove(score);
    }
  }
}
