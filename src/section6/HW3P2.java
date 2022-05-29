package section6;

import java.util.Stack;

public class HW3P2 {
    public static Double evaluatePostfix(String s) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("+-*/^".indexOf(c) != -1) {
                double x = stack.pop();
                double y = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(x + y);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(x * y);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                    case '^':
                        stack.push(Math.pow(y, x));
                        break;
                }
            } else {
                stack.push((double) Character.getNumericValue(c));
            }
        }
        return stack.pop();
    }
}
