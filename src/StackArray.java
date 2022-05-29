import java.util.Arrays;
import java.util.Stack;

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

    public void insertBottom(int value) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        insertBottomHelper(index - 1, index);
        arr[0] = value;
        index++;
    }

    private void insertBottomHelper(int curr, int next) {
        if (next == 0)
            return;
        arr[next] = arr[curr];
        insertBottomHelper(curr - 1, curr);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return arr[--index];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is full");
        }
        return arr[index - 1];
    }

    public void reverse() {
        if (!isEmpty()) {
            int x = pop();
            reverse();
            insertBottom(x);
        }
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

    public static int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    if (i == s.length() - 1) {
                        return 2 * scoreOfParentheses(s.substring(1, i));
                    } else {
                        return scoreOfParentheses(s.substring(0, i + 1)) + scoreOfParentheses(s.substring(i + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static int scoreOfParentheses2(String s) {
        if (s.length() == 2) {
            return 1;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int c = stack.pop();
                int p = stack.pop();
                stack.push(p + Math.max(c * 2, 1));
            }
        }
        return stack.pop();
    }

    public static int[] nextGreater(int[] arr) {
        StackArray stack = new StackArray(arr.length);
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int x = stack.peek();
                if (x > arr[i]) {
                    res[i] = x;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static String removeAdjacentDuplicates(String s) {
        StackArray stack = new StackArray(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && !stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
                i--;
            }
            if (i >= 0) {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            out.append((char) stack.pop());
        }
        return out.toString();
    }

    public static int[] asteroidCollision(int[] asteroids) {
        StackArray stack = new StackArray(asteroids.length);
        for (int i = asteroids.length - 1; i >= 0; i--) {
            int x = asteroids[i];
            boolean push = true;
            while (!stack.isEmpty() && x > 0 && stack.peek() < 0) {
                if (x > Math.abs(stack.peek())) {
                    stack.pop();
                } else if (Math.abs(x) == Math.abs(stack.peek())) {
                    stack.pop();
                    push = false;
                    break;
                } else {
                    push = false;
                    break;
                }
            }

            if (push)
                stack.push(x);

        }
        int size = stack.index;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
