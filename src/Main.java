
import section7.HW1P4;
import section7.HW2P1;
import section7.HW2P2;
import section7.HW2P3;

import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        HW2P3.SumStream stream = new HW2P3.SumStream(4);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(stream.next(scanner.nextInt()));
        }
    }

}
