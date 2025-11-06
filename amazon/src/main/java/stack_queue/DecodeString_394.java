package stack_queue;

public class DecodeString_394 {
  private String encodedString;
  private int ENCODED_STRING_LEN;

  public String decodeString(String s) {
    encodedString = "1[" + s + "]";
    ENCODED_STRING_LEN = encodedString.length();

    return decode(0).processedString;
  }

  class RetVal {
    String processedString;
    int nextIndex;

    RetVal(String processedString, int nextIndex) {
      this.processedString = processedString;
      this.nextIndex = nextIndex;
    }
  }

  private String extractNumericPart(int startIndex) {
    int curIndex = startIndex;
    while(curIndex < ENCODED_STRING_LEN) {
      if(!Character.isDigit(encodedString.charAt(curIndex))) {
        break;
      }
      curIndex++;
    }
    return encodedString.substring(startIndex, curIndex);
  }

  //this function is guarranted to receive string of the following format
  // 23[a]
  private RetVal decode(int startIndex) {
    //extract the numeric part
    String numericString = extractNumericPart(startIndex);
    int repeatCount = Integer.parseInt(numericString);
    int curIndex = startIndex + numericString.length() + 1; // +1 to skip [

    StringBuilder sb = new StringBuilder();
    while(curIndex < ENCODED_STRING_LEN) {
      char curChar = encodedString.charAt(curIndex);

      if(Character.isAlphabetic(curChar)) {
        sb.append(curChar);
        curIndex++;
      } else if(Character.isDigit(curChar)) {
        RetVal retVal = decode(curIndex);
        sb.append(retVal.processedString);
        curIndex = retVal.nextIndex;
      } else if (curChar == ']'){
        break;
      }
    }
    String curStr = sb.toString();
    for(int i = 0; i < repeatCount - 1; i++) { //sb already has one, we need to add repeatCount - 1 count
      sb.append(curStr);
    }
    return new RetVal(sb.toString(), curIndex + 1);
  }
}
