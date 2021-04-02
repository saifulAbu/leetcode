package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream_1656 {
  int ptr = 1;
  String [] arr;
  public OrderedStream_1656(int n) {
    arr = new String[n+1];
  }

  public List<String> insert(int idKey, String value) {
    List<String> res = new ArrayList<>();
    arr[idKey] = value;

    while(ptr < arr.length && arr[ptr] != null) {
      res.add(arr[ptr]);
      ptr++;
    }

    return res;
  }
}
