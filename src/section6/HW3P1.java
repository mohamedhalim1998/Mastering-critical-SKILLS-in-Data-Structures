package section6;

public class HW3P1 {
    public static String infixToPostfix(String s) {
        StackLinkedList stack = new StackLinkedList();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                out.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    out.append((char) stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(c) < precedence((char) stack.peek())) {
                    out.append((char) stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            out.append((char) stack.pop());
        }
        return out.toString();
    }

    private static int precedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;

        }
        return 0;
    }
}
