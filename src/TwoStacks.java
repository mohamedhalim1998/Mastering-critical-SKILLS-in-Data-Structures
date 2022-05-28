import java.util.Arrays;

public class TwoStacks {
    int[] arr;
    int top1;
    int top2;
    int size;

    public TwoStacks(int size) {
        this.size = size;
        top2 = size - 1;
        this.arr = new int[size];
    }

    public void push(int index, int value) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        if (index == 1) {
            arr[top1++] = value;
        } else {
            arr[top2--] = value;
        }
    }

    public int pop(int index) {

        if (index == 1 && !isEmpty(1)) {
            return arr[--top1];
        } else if (index == 2 && !isEmpty(2)) {
            return arr[++top2];
        }
        throw new RuntimeException("stack is full");
    }

    public int peek(int index) {
        if (index == 1 && !isEmpty(1)) {
            return arr[top1 - 1];
        } else if (index == 2 && !isEmpty(2)) {
            return arr[top2 + 1];
        }
        throw new RuntimeException("stack is full");
    }

    public boolean isEmpty(int index) {
        if (index == 1) {
            return top1 == 0;
        } else {
            return top2 == size - 1;
        }
    }

    public boolean isFull() {
        return top1 == top2;
    }
    public void display() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
