package alpha_rep;

import javafx.util.Pair;

import java.util.HashMap;

public class DesignUnderGroundSystem_1396 {
}

class UndergroundSystem {
  HashMap<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
  HashMap<String, Pair<Integer, Integer>> journeyTimeMap = new HashMap<>();

  public void checkIn(int id, String stationName, int t) {
    checkInMap.put(id, new Pair<>(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    Pair<String, Integer> checkInInfo = checkInMap.get(id);
    String startStationName = checkInInfo.getKey();
    int startTime = checkInInfo.getValue();
    checkInMap.remove(id);

    String directionHash = getStationHash(startStationName, stationName);
    if(!journeyTimeMap.containsKey(directionHash)) {
      journeyTimeMap.put(directionHash, new Pair<Integer, Integer>(0, 0));
    }

    Pair<Integer, Integer> journeyInfo = journeyTimeMap.get(directionHash);
    int updatedTimeCount = journeyInfo.getKey() + (t - startTime), updatedTravelCount = journeyInfo.getValue() + 1;
    journeyTimeMap.put(directionHash, new Pair<>(updatedTimeCount, updatedTravelCount));
  }

  public double getAverageTime(String startStation, String endStation) {
    Pair<Integer, Integer> journeyInfo = journeyTimeMap.get(getStationHash(startStation, endStation));
    int totalTime = journeyInfo.getKey();
    int totalTravelCount = journeyInfo.getValue();
    return ((double) totalTime) / totalTravelCount;
  }

  private String getStationHash(String startStation, String endStation) {
    return startStation + "->" + endStation;
  }
}
