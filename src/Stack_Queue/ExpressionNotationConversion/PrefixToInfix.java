package Stack_Queue.ExpressionNotationConversion;

import java.util.Stack;

public class PrefixToInfix {

    public static void main(String[] args) {
        String prefix = "*+abc";
        System.out.println("Infix: " + prefixToInfix(prefix));
    }

    public static String prefixToInfix(String s) {
        Stack<String> stack = new Stack<>();


        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String t1 = stack.pop();
                String t2 = stack.pop();
                String con = "(" + t1 + ch + t2 + ")";
                stack.push(con);
            }
        }

        return stack.pop();
    }
}
