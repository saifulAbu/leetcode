package array_and_string;

public class CompareVersion_165 {
  public int compareVersion(String version1, String version2) {
    String [] splt1 = version1.split("\\.");
    String [] splt2 = version2.split("\\.");

    int n1 = splt1.length, n2 = splt2.length;

    for (int i = 0; i < Integer.max(n1, n2); i++) {
      int v1 = i < n1 ? Integer.parseInt(splt1[i]) : 0;
      int v2 = i < n2 ? Integer.parseInt(splt2[i]) : 0;
      if (v1 > v2) {
        return 1;
      } else if (v1 < v2) {
        return  -1;
      }
    }

    return 0;
  }
}
