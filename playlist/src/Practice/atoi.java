package Practice;

public class atoi {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        boolean flag = true;
        long num = 0;
        while (i < n && (s.charAt(i) == ' ')) i++;

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            flag = s.charAt(i) == '+';
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (flag && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (!flag && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return flag ? (int) num : (int) -num;
    }

    // Main method for testing
    public static void main(String[] args) {
        atoi converter = new atoi();

        // Test cases
        String[] tests = {
                "42",
                "   -42",
                "4193 with words",
                "words and 987",
                "-91283472332",
                "+123",
                "00000123"
        };

        for (String s : tests) {
            System.out.println("Input: \"" + s + "\" -> Output: " + converter.myAtoi(s));
        }
    }
}
