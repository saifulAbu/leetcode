import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        List<Integer> result = findAnagrams(s2, s1);
        if(result.isEmpty()){
            return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        List<Integer> result = new ArrayList<Integer>();

        if(lenS < lenP) {
            return result;
        }

        int[] hashP = computeHash(p, lenP);

        //compute has for first few characters
        int[] hashMoving = computeHash(s, lenP);
        if(hashMatches(hashP, hashMoving)){
            result.add(0);
        }

        for(int start = 1; start + lenP <= lenS; start++){
            char prevChar = s.charAt(start-1);
            char newChar = s.charAt(start + lenP - 1);
            hashMoving[prevChar - 'a']--;
            hashMoving[newChar - 'a']++;

            if(hashMatches(hashP, hashMoving)){
                result.add(start);
            }
        }


        return result;
    }

    public int [] computeHash(String str, int len) {
        int [] hash = new int[26];
        for(int i = 0; i < len; i++){
            hash[str.charAt(i) - 'a'] += 1;
        }
        return hash;
    }

    public boolean hashMatches(int [] hash1, int [] hash2){
        for(int i = 0; i < 26; i++) {
            if(hash1[i] != hash2[i]){
                return false;
            }
        }
        return true;
    }
}