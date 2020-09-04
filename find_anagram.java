package com.company;

import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return null;
    }

    public static void main(String args[]) {

        int [] hash = computeHash("hello", 5);
    }

    public static int [] computeHash(String str, int len) {
        int [] hash = new int[26];
        for(int i = 0; i < len; i++){
            hash[str.charAt(i) - 'a'] += 1;
        }
        return hash;
    }

    public static boolean hashMatches(int [] hash1, int [] hash2){
        for(int i = 0; i < 26; i++) {
            if(hash1[i] != hash2[i]){
                return false;
            }
        }
        return true;
    }
}