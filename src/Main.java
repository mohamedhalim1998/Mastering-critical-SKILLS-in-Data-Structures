import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TwoStacks stk = new TwoStacks(10);
        stk.push(2, 5);
        stk.push(2, 6);
        stk.pop(2);
        stk.pop(2);
        stk.push(2, 7);
        stk.push(2, 9);

        stk.push(1, 4);
        stk.push(1, 6);
        stk.push(1, 8);
        stk.display();
    }
}
