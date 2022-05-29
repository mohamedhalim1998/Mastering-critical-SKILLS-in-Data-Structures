package section6;


public class HW3P5 {
    public static String removeBrackets(String s) {
        StackLinkedList stack = new StackLinkedList();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (stack.isEmpty() || stack.peek() == '+') {
                    stack.push(s.charAt(i - 1));
                } else {
                    if (s.charAt(i - 1) == '-') {
                        stack.push('+');
                    } else {
                        stack.push('-');
                    }
                }
            } else if (c == ')') {
                stack.pop();
            } else if (Character.isDigit(c)) {
                out.append(c);
            } else if (!stack.isEmpty() && stack.peek() == '-') {
                if (c == '-') {
                    out.append('+');
                } else {
                    out.append('-');
                }
            } else {
                out.append(c);
            }

        }
        return out.toString();
    }
}
