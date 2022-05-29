package section6;

import java.util.Arrays;

public class StackRedesign {
    int[] arr;
    int addedElements;
    int size;

    public StackRedesign(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public boolean push(int value) {
        if (isFull()) {
            return false;
        }
        for (int i = addedElements - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = value;
        addedElements++;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is full");
        }
        int value = arr[0];
        for (int i = 0; i < addedElements - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[addedElements - 1] = 0;
        addedElements--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is full");
        }
        return arr[0];
    }


    public boolean isEmpty() {
        return addedElements == 0;
    }

    public boolean isFull() {
        return addedElements == size;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public void display() {
        System.out.println(this);
    }
}
