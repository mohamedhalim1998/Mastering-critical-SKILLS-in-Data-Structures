package section7;

public class HW2P3 {
    public static class SumStream {
        int k;
        int sum = 0;
        CircularQueue queue;
        public SumStream(int k) {
            this.k = k;
            queue = new CircularQueue(k);
        }

        public int next(int x) {
            if(queue.isFull()) {
                sum -= queue.dequeue();
            }
            sum += x;
            queue.enqueue(x);
            return sum;
        }

    }
}
