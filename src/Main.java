<<<<<<< HEAD
import section10.*;
=======
import section6.HW3P3;
import section6.HW3P5;
>>>>>>> 148c7a3ba470a3660974bcbcef35a9eac4ac9f0a


public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD


        HW2P2.PriorityQueue tasks = new HW2P2.PriorityQueue();

        tasks.enqueue(1131, 1);
        tasks.enqueue(3111, 3);
        tasks.enqueue(2211, 2);
        tasks.enqueue(3161, 3);
        tasks.enqueue(7761, 7);

        System.out.println(tasks.dequeue());
        System.out.println(tasks.dequeue());

        tasks.enqueue(1535, 1);
        tasks.enqueue(2815, 2);
        tasks.enqueue(3845, 3);
        tasks.enqueue(3145, 3);

        while (!tasks.isEmpty())
            System.out.println(tasks.dequeue());
    }

}

=======
        System.out.println(HW3P5.removeBrackets("1-(2-3-(4+5-(6-7)))"));

    }


}
>>>>>>> 148c7a3ba470a3660974bcbcef35a9eac4ac9f0a
