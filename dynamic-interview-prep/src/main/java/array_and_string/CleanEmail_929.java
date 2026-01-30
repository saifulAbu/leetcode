package array_and_string;

import java.util.HashSet;

public class CleanEmail_929 {
  public int numUniqueEmails(String[] emails) {
    HashSet<String> cleanEmails = new HashSet<>();
    for (String email : emails) {
      String [] tok = email.split("@");
      String userName = tok[0];
      String domainName = tok[1];
      userName = userName.split("\\+")[0].replaceAll("\\.", "");
      cleanEmails.add(userName + "@" + domainName);
    }
    return cleanEmails.size();
  }
}
