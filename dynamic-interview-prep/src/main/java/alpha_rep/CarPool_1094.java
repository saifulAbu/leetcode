package alpha_rep;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CarPool_1094 {
  public boolean carPooling(int[][] trips, int capacity) {
    /*
     * people = trip[0], start = trip[1], end = trip[2]
     *
     * we will use a treeMap, sorted ascending way based on timeStamp
     * at time stamp of start, we are having +people
     * at time stamp for end, we are having -people
     *
     * we will continue through the treemap and add up the people counts
     * at any point if it exceeds capacity, return false;
     *
     */

    TreeMap<Integer, Integer> timeStampMap = new TreeMap<>();
    for (int[] trip : trips) {
      int people = trip[0], start = trip[1], end = trip[2];
      timeStampMap.put(start, timeStampMap.getOrDefault(start, 0) + people);
      timeStampMap.put(end, timeStampMap.getOrDefault(end, 0) - people);
    }

    int curPeople = 0;
    for (int peopleChange : timeStampMap.values()) {
      curPeople += peopleChange;
      if (curPeople > capacity) {
        return false;
      }
    }
    return true;
  }

  public boolean carPooling_0613(int[][] trips, int capacity) {
    TreeMap<Integer, Integer> passMap = new TreeMap<>();
    for (int[] trip : trips) {
      int numPassengers = trip[0];
      int startLocation = trip[1];
      int endLocation = trip[2];

      // Add passengers at the start location
      passMap.put(startLocation, passMap.getOrDefault(startLocation, 0) + numPassengers);

      // Subtract passengers at the end location
      passMap.put(endLocation, passMap.getOrDefault(endLocation, 0) - numPassengers);
    }

    int curCapacity = 0;
    for (int location : passMap.keySet()) {
      curCapacity += passMap.get(location);
      if (curCapacity > capacity) {
        return false;
      }
    }
    return true;
  }

  public boolean carPooling_drona_1(int[][] trips, int capacity) {
    // Min-Heap sorted by location (timestamp).
    // Tie-breaker: sort by passenger change ascending (drop-offs before pick-ups).
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt((int[] a) -> a[0])
            .thenComparingInt(a -> a[1]));

    for (int[] trip : trips) {
      int numPassengers = trip[0];
      int startLocation = trip[1];
      int endLocation = trip[2];

      // Add start event: [location, passenger_increase]
      pq.offer(new int[] { startLocation, numPassengers });

      // Add end event: [location, passenger_decrease]
      pq.offer(new int[] { endLocation, -numPassengers });
    }

    int currentCapacity = 0;
    while (!pq.isEmpty()) {
      currentCapacity += pq.poll()[1];

      if (currentCapacity > capacity) {
        return false;
      }
    }

    return true;
  }


  //[numPassengers_i, from_i, to_i]
  public boolean carPooling_0714(int[][] trips, int capacity) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int [] b) {
        if(a[0] == b[0]) {
          return Integer.compare(a[1], b[1]);
        }
        return Integer.compare(a[0], b[0]);
      }
    });

    for(int[] trip : trips) {
      pq.add(new int[] {trip[1], trip[0]});
      pq.add(new int[] {trip[2], -trip[0]});
    }

    int curCapacity  = 0;
    while (!pq.isEmpty()) {
      curCapacity += pq.poll()[1];
      if (curCapacity > capacity) {
        return false;
      }
    }
    return true;
  }

  public boolean carPooling_drona_bucket(int[][] trips, int capacity) {
    // Since the max coordinate is 1000, we can use an array of size 1001
    int[] timeline = new int[1001];
    
    for (int[] trip : trips) {
        int passengers = trip[0];
        int start = trip[1];
        int end = trip[2];
        
        timeline[start] += passengers; // Pick-up
        timeline[end] -= passengers;   // Drop-off
    }
    
    int curCapacity = 0;
    for (int passengerChange : timeline) {
        curCapacity += passengerChange;
        if (curCapacity > capacity) {
            return false;
        }
    }
    
    return true;
}
}
