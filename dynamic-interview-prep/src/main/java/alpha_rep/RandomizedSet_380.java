package alpha_rep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

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

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
