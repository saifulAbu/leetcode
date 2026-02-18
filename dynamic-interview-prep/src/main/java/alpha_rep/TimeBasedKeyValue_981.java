package alpha_rep;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKeyValue_981 {


}

class TimeMap {
  HashMap<String, TreeMap<Integer, String>> storage = new HashMap<>();

  public void set(String key, String value, int timestamp) {
    if(!storage.containsKey(key)) {
      storage.put(key, new TreeMap<>());
    }

    storage.get(key).put(timestamp, value);

  }

  public String get(String key, int timestamp) {
    if(!storage.containsKey(key)) {
      return "";
    }

    TreeMap<Integer, String> timeStampedValueMap = storage.get(key);
    Integer floorKey = timeStampedValueMap.floorKey(timestamp);
    if(floorKey != null) {
      return timeStampedValueMap.get(floorKey);
    }
    return "";
  }
}
