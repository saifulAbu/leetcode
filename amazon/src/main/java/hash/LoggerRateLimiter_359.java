package hash;

import org.codehaus.plexus.component.configurator.converters.composite.MapConverter;

import java.util.HashMap;

public class LoggerRateLimiter_359 {
  HashMap<String, Integer> map = new HashMap<>();

  public boolean shouldPrintMessage(int timestamp, String message) {
    if(!map.containsKey(message) || (timestamp - map.get(message) >= 10)) {
      map.put(message, timestamp);
      return true;
    }
    return false;
  }
}
