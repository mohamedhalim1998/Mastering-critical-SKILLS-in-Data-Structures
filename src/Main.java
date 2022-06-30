import section13.HW1P5.HashTable;
import section13.HW1P5.PhoneEntry;

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable(10, .75);
        for (int i = 0; i < 100; i++) {
            table.put(new PhoneEntry("" + i, "" + i));
            table.printAll();
        }
    }
}



