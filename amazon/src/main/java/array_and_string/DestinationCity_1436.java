package array_and_string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity_1436 {
  public String destCity(List<List<String>> paths) {
    Set<String> hashSet = new HashSet<>();

    for (List<String> path : paths) {
      hashSet.add(path.get(0));
      hashSet.add(path.get(1));
    }

    for (List<String> path : paths) {
      hashSet.remove((path.get(0)));
    }
    return hashSet.iterator().next();
  }
}
