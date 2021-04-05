package array_and_string;

public class SumOfOddLenSubArr_1588 {
  public int sumOddLengthSubarrays(int[] arr) {
    int res = 0;
    int n = arr.length;
    int [][] sum = new int[n][n];

    for(int i = 0; i < n; i++) {
      sum[i][i] = arr[i];
    }

    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++){
        sum[i][j] = sum[i][j-1] + arr[j];
      }
    }

    for(int i = 0; i < n; i++) {
      for(int j = i; j < n; j += 2) {
        res += sum[i][j];
      }
    }

    return res;
  }

  public static void main(String args[]) {
    int [] arr = {1,4,2,5,3};
    SumOfOddLenSubArr_1588 obj = new SumOfOddLenSubArr_1588();
    System.out.println(obj.sumOddLengthSubarrays(arr));
  }
}
