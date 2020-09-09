package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class SortCharByFreq {
    private class Entry implements Comparable<Entry> {
        char ch;
        int freq;

        Entry(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(Entry o) {
            return o.freq - freq;
        }
    }

    public String frequencySort(String s) {
        if(s.length() <= 1) {
            return s;
        }

        StringBuilder result = new StringBuilder(s.length());

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            int freq = freqMap.getOrDefault(ch, 0);
            freqMap.put(ch, freq+1);
        }

        Entry[] entryArr = new Entry[freqMap.size()];

        int curIndex = 0;
        for(char ch : freqMap.keySet()) {
            entryArr[curIndex] = new Entry(ch, freqMap.get(ch));
            curIndex += 1;
        }

        Arrays.sort(entryArr);

        for(Entry entry : entryArr) {
            char ch = entry.ch;
            int freq = entry.freq;
            for(int i = 0; i < freq; i++){
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String args[]) {
        SortCharByFreq solution = new SortCharByFreq();
        String s = "Aabb";
        System.out.println(solution.frequencySort(s));
    }
}
