package array_and_string;

public class FindNumbersEvenDigit_1295 {
  public int findNumbers(int[] nums) {
    int res = 0;

    for(int num : nums) {
      if((Math.floor(Math.log10(num)) + 1) % 2 ==  0) {
        System.out.println("has even digits");
        res++;
      }
    }

    return res;
  }

  public static  void main(String args[]) {
    FindNumbersEvenDigit_1295 f = new FindNumbersEvenDigit_1295();
    f.findNumbers(new int[]{1296});
  }
}
