package array_and_string;

import java.util.LinkedList;
import java.util.List;

public class TextJustification_68 {
  private static class Partition {
    private static class JustifiedPartition {
      char[] chars;
      int i;
      JustifiedPartition(int maxSize) {
        chars = new char[maxSize];
        i = 0;
      }

      void putWord(String word) {
        for (char ch : word.toCharArray()) {
          chars[i++] = ch;
        }
      }

      void putSpace(int spaces) {
        while (spaces > 0) {
          chars[i++] = ' ';
          spaces--;
        }
      }

      public String toString() {
        while (i < chars.length) {
          chars[i++] = ' ';
        }
        return new String(chars);
      }

    }

    LinkedList<String> words = new LinkedList<>();
    int MAX_CAPACITY;
    int usedCapacity = 0;
    int charCount = 0;
    Partition(int capacity) {
      this.MAX_CAPACITY = capacity;
    }
    boolean offer(String word) {
      if (usedCapacity == 0) {
        usedCapacity += word.length();
        words.add(word);
        charCount += word.length();
        return true;
      }

      if (usedCapacity + 1 + word.length() > MAX_CAPACITY) {
        return false;
      }

      usedCapacity += 1;
      usedCapacity += word.length();
      charCount += word.length();
      words.add(word);
      return true;
    }

    String process() {
      JustifiedPartition justifiedPartition = new JustifiedPartition(MAX_CAPACITY);
      int wordCount = words.size();
      int blankCount = Math.max(wordCount - 1, 1);
      int allowableSpaceCount = MAX_CAPACITY - charCount;
      int spacePerBlank = allowableSpaceCount / blankCount;
      int extraSpace = allowableSpaceCount % blankCount;
      for (int i = 0; i < words.size() - 1; i++) {
        justifiedPartition.putWord(words.get(i));
        justifiedPartition.putSpace(spacePerBlank);
        if (extraSpace > 0) {
          justifiedPartition.putSpace(1);
          extraSpace--;
        }
      }
      justifiedPartition.putWord(words.getLast());
      return justifiedPartition.toString();
    }

    String processLast() {
      StringBuilder sb = new StringBuilder(MAX_CAPACITY);
      for (String word : words) {
        sb.append(word);
        sb.append(' ');
      }
      sb.deleteCharAt(sb.length() - 1);
      while (sb.length() < MAX_CAPACITY) {
        sb.append(' ');
      }
      return sb.toString();
    }

    public String toString() {
      String res = "";
      for (String w : words) {
        res = res + w + " ";
      }
      return res.trim();
    }
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    Partition p = new Partition(maxWidth);
    List<String> res = new LinkedList<>();
    for (String word : words) {
      if (!p.offer(word)) {
        res.add(p.process());
        p = new Partition(maxWidth);
        p.offer(word);
      }
    }
    res.add(p.processLast());

    return res;
  }
}
