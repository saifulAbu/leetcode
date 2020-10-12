package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
  HashMap<Integer, Integer> indexMap;
  ArrayList<Integer> set;
  Random rand;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    indexMap = new HashMap<>();
    set = new ArrayList<>();
    rand = new Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(indexMap.containsKey(val)) {
      return false;
    }
    set.add(val);
    indexMap.put(val, set.size()-1);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(!indexMap.containsKey(val)) {
      return false;
    }
    if(indexMap.size() == 0) {
      return false;
    }
    if(indexMap.containsKey(val) && indexMap.size() == 1) {
      indexMap.clear();
      set.clear();
      return true;
    }
    int elemIndex = indexMap.get(val);
    indexMap.remove(val);
    int lastElem = set.get(set.size() - 1);
    set.set(elemIndex, lastElem);
    indexMap.put(lastElem, elemIndex);
    set.remove(set.size() - 1);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {

    int randIndex = rand.nextInt(set.size());
    return set.get(randIndex);
  }

  public static void main(String args[]) {
    RandomizedSet obj = new RandomizedSet();
    boolean ret_val = false;
    int randObj = 0;
    ret_val = obj.remove(0);
    ret_val = obj.remove(0);
    ret_val = obj.insert(0);
    randObj = obj.getRandom();
    ret_val = obj.remove(0);
    ret_val = obj.insert(0);
    randObj = obj.getRandom();
    randObj = obj.getRandom();
    randObj = obj.getRandom();
    return;
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
