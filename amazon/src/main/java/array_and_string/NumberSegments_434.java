package array_and_string;

public class NumberSegments_434 {
  public int countSegments(String s) {
    s = s.trim();
    if(s.isEmpty() || s.isBlank()) {
      return 0;
    }
    return s.split("\\s+").length;
  }
}
