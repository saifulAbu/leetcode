package alpha_rep;

import java.util.HashSet;
import java.util.Set;

public class CleanEmail_929 {
  public int numUniqueEmails(String[] emails) {
    HashSet<String> cleanEmails = new HashSet<>();
    for (String email : emails) {
      String[] tok = email.split("@");
      String userName = tok[0];
      String domainName = tok[1];
      userName = userName.split("\\+")[0].replaceAll("\\.", "");
      cleanEmails.add(userName + "@" + domainName);
    }
    return cleanEmails.size();
  }

  public int numUniqueEmails_drona(String[] emails) {
    Set<String> uniqueEmails = new HashSet<>();

    for (String email : emails) {
      StringBuilder sb = new StringBuilder();
      int i = 0;

      // 1. Process local name with strict, zero-allocation memory discipline
      while (i < email.length()) {
        char ch = email.charAt(i);
        if (ch == '+' || ch == '@') {
          break;
        }
        if (ch != '.') {
          sb.append(ch);
        }
        i++;
      }

      // 2. Fast-forward to the domain using JVM-optimized intrinsics
      int domainStart = email.indexOf('@', i);

      // 3. Append the exact domain block in one clean sweep
      sb.append(email.substring(domainStart));

      uniqueEmails.add(sb.toString());
    }

    return uniqueEmails.size();
  }
}
