import java.util.Arrays;

public class StackArray {
    int[] arr;
    int index;
    int size;

    public StackArray(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        arr[index++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is full");
        }
        return arr[--index];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is full");
        }
        return arr[index - 1];
    }

    public static String reverseWords(String s) {
        StringBuilder out = new StringBuilder();
        StackArray stack = new StackArray(s.length());
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    out.append((char) stack.pop());
                }
                out.append(' ');
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            out.append((char) stack.pop());
        }
        return out.toString();
    }

    public static int reverseNumber(int num) {
//        return Integer.parseInt(reverseWords("" +num));
        int len = ("" + num).length();
        StackArray stack = new StackArray(len);
        int mul = (int) Math.pow(10, len - 1);
        while (mul > 0) {
            int div = num / mul;
            stack.push(div);
            num -= div * mul;
            mul /= 10;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res = res * 10 + stack.pop();
        }
        return res;
    }

    public static boolean validParentheses(String s) {
        StackArray stack = new StackArray(s.length());
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static String removeAdjacentDuplicates(String s) {
        StackArray stack = new StackArray(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && !stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
                i--;
            }
            if (i >= 0){
                stack.push(s.charAt(i));
            }
        }
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            out.append((char) stack.pop());
        }
        return out.toString();
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
