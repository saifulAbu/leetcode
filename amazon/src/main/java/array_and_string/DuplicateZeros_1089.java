package array_and_string;

public class DuplicateZeros_1089 {
  public void duplicateZeros(int[] arr) {
    int effectiveZeros = 0;
    int lastEffZero = -1;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == 0) {
        if(i + 1 + effectiveZeros < arr.length) {
          effectiveZeros++;
          lastEffZero = i;
        } else {
          break;
        }
      }
    }

    int shift = effectiveZeros;
    for (int j = arr.length - 1; j >= 0; j--) {
      arr[j] = arr[j-shift];
      if (arr[j-shift] == 0 & (j-shift <= lastEffZero)) {
        arr[--j] = 0;
        shift--;
      }
    }
  }
}
