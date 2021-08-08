package array_and_string;

public class MergeSortedArray_88 {
  public void merge(int[] a0, int m, int[] a1, int n) {
    int i0 = m - 1;
    int i1 = n - 1;
    int i = a0.length - 1;

    while (i0 >= 0 && i1 >= 0) {
      a0[i--] = (a0[i0] > a1[i1] ? a0[i0--] : a1[i1--]);
    }

    while (i1 >= 0) {
      a0[i--] = a1[i1--];
    }
  }
}
// false
//dummy commit for today
// more dummy commit
// more dummy commit
// more dummy commit
// more dummy commit
// more dummy commit
// dummy initial
// just a thing on wheel
// keep the wheel moving
// hello
