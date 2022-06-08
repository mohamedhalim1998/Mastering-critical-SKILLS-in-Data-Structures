
import section7.HW1P4;

import java.util.Queue;


public class Main {
    public static void main(String[] args) {
        HW1P4.QueueTwoStacks qu = new HW1P4.QueueTwoStacks(6);

        for (int i = 1; i <= 6; ++i)
            qu.enqueue(i);

        System.out.println(qu.dequeue() + " ");

            qu.enqueue(7);

        while(!qu.isEmpty())
            System.out.println(qu.dequeue() + " ");

    }


}
