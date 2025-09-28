package Stack_Queue.ExpressionNotationConversion;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String postfix = "ab+c*";
        System.out.println("Infix: " + postfixToInfix(postfix));
    }

    public static String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {

                String t1 = stack.pop();
                String t2 = stack.pop();
                String con = "(" + t2 + ch + t1 + ")";
                stack.push(con);
            }
        }

        return stack.pop();
    }
}
