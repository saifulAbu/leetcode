package array_and_string;

public class Sqrt_69 {
  public int mySqrt(int x) {
    int res = 0;
    int low = 0;
    int high = x;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(mid * mid > x) {
        high = mid - 1;
      } else {
        if((mid + 1) * (mid + 1) > x) {
          res = mid;
          break;
        } else {
          low = mid + 1;
        }
      }
    }
    return res;
  }
}
