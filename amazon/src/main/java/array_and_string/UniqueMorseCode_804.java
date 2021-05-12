package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCode_804 {
  private String [] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
  public int uniqueMorseRepresentations(String[] words) {
    // form word and put in a set
    Set<String> morseSet = new HashSet<>();
    for(String word : words) {
      morseSet.add(formWord(word));
    }
    return morseSet.size();
  }

  private String formWord(String word) {
    String morse = "";
    for (char c : word.toCharArray()) {
      int i = c - 'a';
      morse = morse + alphabet[i];
    }
    return morse;
  }
}

//no idea yet
