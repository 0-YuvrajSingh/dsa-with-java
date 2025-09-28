package Stack_Queue.ExpressionNotationConversion;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {

    }

    public static String prefixToPostfix(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = s.length(); i>= 0 ; i--) {
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else{
                String t1 = stack.pop();
                String t2 = stack.pop();
                stack.push(t1 + t2 + ch);
            }
        }
        return stack.peek();
    }
}
