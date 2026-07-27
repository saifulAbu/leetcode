package alpha_rep;

import java.util.*;

public class RandomizedSet_380 {
/*
* we are going to use combination of arrayList and hashMap to achieve O(1) target
* arrayList can delete in O(1) the last element.
* we can replace the target element with last element and delete the last element
*
* arrayList []
* map []
* insert 1
* [1]
* [1 => 0]
* insert 3
* [1,3], [1=>0, 3=>1]
* insert 4
* [1,3,4], [1=>0, 3=>1, 4=>2]
*
* delete 3
* get index of 3 from map, =>1
* take last element 4 from list [1,3,4], put 4 at place 1, which leads to [1,4,4], update 4's index on map [1=>0, 4=>1, 3=>1]
* delete last element, [1,4]. delete 3 from the map [1=>0, 4=>1]
*
* */
    ArrayList<Integer> nums = new ArrayList<>();
    HashMap<Integer, Integer> numIdxMap = new HashMap<>();
    Random rand = new Random();

    public boolean insert(int val) {
      if(numIdxMap.containsKey(val)) {
        return false;
      }

      nums.add(nums.size(), val);
      numIdxMap.put(val, nums.size()-1);
      return true;
    }

    public boolean remove(int val) {
      if(!numIdxMap.containsKey(val)) {
        return false;
      }

      int valIndex = numIdxMap.get(val);
      int lastListItem = nums.get(nums.size()-1);
      nums.set(valIndex, lastListItem);
      numIdxMap.put(lastListItem, valIndex);

      nums.remove(nums.size()-1);
      numIdxMap.remove(val);
      return true;
    }

    public int getRandom() {
      return nums.get(rand.nextInt(nums.size()));
    }
}


class RandomizedSet_0524 {
  Map<Integer, Integer> map;
  List<Integer> list;
  Random rand;

  public RandomizedSet_0524() {
    map = new HashMap<>();
    list = new ArrayList<>();
    rand = new Random();
  }

  public boolean insert(int val) {
    if(map.containsKey(val)) {
      return false;
    }
    list.add(val);
    map.put(val, list.size()-1);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }

    int idx = map.get(val);
    int lastIdx = list.size() - 1;
    int lastElem = list.get(lastIdx);

    // Move last element into idx
    list.set(idx, lastElem);
    map.put(lastElem, idx);

    // Remove last element
    list.remove(lastIdx);

    // Remove val from map
    map.remove(val);

    return true;
  }

  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}

class RandomizedSet_0727 {
  List<Integer> vals = new ArrayList<>();
  Map<Integer, Integer> map = new HashMap<>();
  Random random = new Random();

  boolean insert(int val) {
    if(map.containsKey(val)) {
      return false;
    }

    map.put(val, vals.size());
    vals.addLast(val);
    return true;
  }

  boolean remove(int val) {
    if(!map.containsKey(val)) {
      return false;
    }
    
    int idx = map.get(val);
    int lastElem = vals.get(vals.size() - 1);
    vals.set(idx, lastElem);
    vals.removeLast();

    map.put(lastElem, idx);
    map.remove(val);

    return true;
  }
  
  int getRandom() {
    return vals.get(random.nextInt(vals.size()));
  }
}