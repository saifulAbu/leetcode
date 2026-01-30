package array_and_string;

public class Sqrt_69 {
  public int mySqrt(int x) {
    if(x <= 1) {
      return x;
    }
    double res = 0;
    double low = 0;
    double high = x;
    while(low <= high) {
      double mid = (low + (high - low) / 2);
      double mid_sqr = mid * mid;
      if(mid_sqr > x) {
        high = mid - 1;
      } else if (mid_sqr < x) {
        res = mid;
        low = mid + 1;
      } else {
        res = mid;
        break;
      }
    }
    return (int)res;
  }

  public int mySqrt1(int x) {
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

  public static void main(String args[]) {
    Sqrt_69 s = new Sqrt_69();
    System.out.println(s.mySqrt(5));
  }
}
