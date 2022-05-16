public class Vector {
    int[] arr;
    int size;
    int capacity;

    public Vector(int size) {
        arr = new int[size];
        capacity = size;

    }

    public Vector() {
        arr = new int[2];
        capacity = 2;
    }

    public int getSize() {
        return size;
    }

    public int getFront() {
        if (size == 0) {
            throw new RuntimeException("no such element");
        }
        return arr[0];
    }

    public int getBack() {
        if (size == 0) {
            throw new RuntimeException("no such element");
        }
        return arr[size - 1];
    }

    public int get(int index) {
        if (size <= index) {
            throw new RuntimeException("no such element");
        }
        return arr[index];
    }

    public void set(int index, int element) {
        if (size <= index) {
            throw new RuntimeException("no such element");
        }
        arr[index] = element;

    }


    public void add(int element) {
        if (capacity == size) {
            increaseCapacity(2 * capacity);
        }
        arr[size++] = element;
    }


    public void insert(int index, int element) {
        if (size <= index) {
            throw new RuntimeException("no such element");
        }
        if (size + 1 > capacity) {
            increaseCapacity(2 * capacity);
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
        size++;
    }

    private void increaseCapacity(int newCapacity) {
        capacity = newCapacity;
        int[] copy = new int[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[i];
        }
        arr = copy;
    }

    int find(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void rotateRight() {

        int last = arr[size - 1];
        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    public void rotateRight(int m) {

        int mod = m % size;
        int[] lastSection = new int[mod];
        for (int i = size - 1, j = 0; j < mod; i--, j++) {
            lastSection[j] = arr[i];
        }
        for (int i = size - 1; i >= mod; i--) {
            arr[i] = arr[i - mod];
        }
        for (int i = 0, j = mod - 1; i < mod; i++, j--) {
            arr[i] = lastSection[j];
        }
    }

    public void rotateLeft() {

        int first = arr[0];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = first;
    }

    public int remove(int index) {
        if (size <= index) {
            throw new RuntimeException("no such element");
        }
        int val = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return val;
    }

    public int findTransposition(int element) {
        int index = find(element);
        if (index == 0) {
           return 0;
        } else {
            int temp = arr[index - 1];
            arr[index - 1] = arr[index];
            arr[index] = temp;
        }
        return index;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Vector{");
        for (int i = 0; i < size - 1; i++) {
            builder.append(arr[i]).append(", ");
        }
        builder.append(arr[size - 1]).append("}");
        return builder.toString();
    }
}
