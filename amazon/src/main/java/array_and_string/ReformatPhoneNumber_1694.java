package array_and_string;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReformatPhoneNumber_1694 {
  public String reformatNumber(String number) {
    Queue<Character> q = new ArrayDeque<>();
    for(char ch : number.toCharArray()) {
      if(Character.isLetterOrDigit(ch)){
        q.add(ch);
      }
    }
    StringBuilder builder = new StringBuilder();
    while (!q.isEmpty()) {
      if (q.size() > 4) {
        builder.append(q.poll());
        builder.append(q.poll());
        builder.append(q.poll());
        builder.append('-');
      } else if (q.size() == 4) {
        builder.append(q.poll());
        builder.append(q.poll());
        builder.append('-');
        builder.append(q.poll());
        builder.append(q.poll());
      } else if (q.size() == 3) {
        builder.append(q.poll());
        builder.append(q.poll());
        builder.append(q.poll());
      } else {
        builder.append(q.poll());
        builder.append(q.poll());
      }
    }
    return builder.toString();
  }
}

//


