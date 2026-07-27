package alpha_rep;

public class LicencenseKey_482 {
    public String licenseKeyFormatting_0630(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean appendDash = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                count++;
                if (appendDash) {
                    sb.append('-');
                }
                appendDash = count % (k) == 0;
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        return sb.reverse().toString();
    }

    public String licenseKeyFormatting_drona(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);

            if (current != '-') {
                if (count > 0 && count % k == 0) {
                    sb.append('-');
                }

                sb.append(Character.toUpperCase(current));
                count++;
            }
        }

        return sb.reverse().toString();
    }
}
