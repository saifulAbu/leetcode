package array_and_string;

public class ReverseInteger_7 {
    public int reverse(int x) {
        int output = 0;

        while(x != 0) {
            int curDigit = x % 10;
            x = x / 10;

            if(output > Integer.MAX_VALUE / 10 || (output == Integer.MAX_VALUE / 10 && curDigit > Integer.MAX_VALUE % 10)) {
                return 0;
            } else if(output < Integer.MIN_VALUE / 10 || (output == Integer.MIN_VALUE / 10 && curDigit > Integer.MAX_VALUE % 10)) {
                return 0;
            } else {
                output = output * 10 + curDigit;
            }
        }

        return output;
    }
}
