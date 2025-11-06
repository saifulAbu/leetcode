package array_and_string;

public class DuplicateZeros_1089 {

  public void duplicateZeros(int[] arr) {
    // find the last element of newly zero duplicated array
    // for the example array of
    // 0 2 0
    // newLastElem = 1 after the following loop ends
    int newLastElem = 0;
    int curSize = 0;
    boolean lastZeroExpands = true;
    while(curSize < arr.length){
      if(arr[newLastElem] == 0) {
        curSize += 2;
      } else {
        curSize += 1;
      }
      //increase the newLastElem pointer only if new array have capacity for more element
      // for the input array
      // 0 1
      // we don't want to increase newLastElem index
      if(curSize < arr.length) {
        newLastElem++;
      }

      // for the case of input
      // 1 0 0 1
      // the last zero will only take one spot, handle this situation with the bool variable
      if(curSize > arr.length) {
        lastZeroExpands = false;
      }
    }

    if(newLastElem == arr.length - 1) {
      return;
    }

    // we know what would be the last element of new array
    // shift that last element from the end
    // duplicate any zeros on the way
    // if the last zero does not expand, make it take one spot
    int i = arr.length - 1;
    if((arr[newLastElem]) == 0 && !lastZeroExpands) {
      arr[i--] = arr[newLastElem--];
    }
    // rest of the zeros can expand as doubles
    while(i >= 0) {
      arr[i] = arr[newLastElem--];
      // we have just encountered a zero
      // so duplicate the zero
      if(arr[i] == 0) {
        arr[--i] = 0;
      }
      i--;
    }
  }

  public void duplicateZeros0(int[] arr) {
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
