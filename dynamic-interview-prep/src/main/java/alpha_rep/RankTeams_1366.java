package alpha_rep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class RankTeams_1366 {
  public String rankTeams(String[] votes) {
    /*
    * case :
    * ABC
    * BCA
    * BCA
    * we can build a 2d array
    * 1 0 2 -> A's different position vote count
    * 2 1 0
    * 0 2 1
    *
    * we can take the characters in a list [A, B, C]
    *
    * we can sort the list based on the array we have created. we will have to create a custom sort comparator.
    * teams will be any character so we will have to use hashmap
    * */

    HashMap<Character, int[]> voteData = new HashMap<>();
    int teamCount = votes[0].length();
    //initialize the array list for all the teams
    for(char ch : votes[0].toCharArray()) {
      voteData.put(ch, new int[teamCount]);
    }

    //building a 2d array of votes on different position
    for(String vote : votes) {
      for(int i = 0; i < teamCount; i++) {
        char currentTeam = vote.charAt(i);
        voteData.get(currentTeam)[i]++;
      }
    }

    //make list of the team's
    ArrayList<Character> teams = new ArrayList(voteData.keySet());

    // sort the teams based on vote data
    // at any position, if voteCountT1 > voteCountT0, T1 should be place first
    // if we checked all the position, we return the decistion by who ever comes alphabatically
    teams.sort(new Comparator<Character>() {
      @Override
      public int compare(Character t0, Character t1) {
        int[] voteData0 = voteData.get(t0), voteData1 = voteData.get(t1);

        for(int i = 0; i < teamCount; i++) {
          if(voteData0[i] != voteData1[i]) {
            return voteData1[i] - voteData0[i];
          }
        }
        return t0 - t1;
      }
    });

    StringBuilder sb = new StringBuilder(teamCount);
    for(char team : teams) {
      sb.append(team);
    }

    return sb.toString();
  }
}
