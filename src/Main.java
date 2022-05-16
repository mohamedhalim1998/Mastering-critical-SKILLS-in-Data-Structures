public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.insert(2, 8);
        System.out.println(vector.find(1));
        System.out.println(vector.find(10));
        System.out.println(vector.get(5));
        System.out.println(vector.getFront());
        System.out.println(vector.getBack());
        System.out.println(vector);
        vector.rotateRight();
        System.out.println(vector);
        vector.rotateLeft();
        System.out.println(vector);
        System.out.println(vector.remove(2));
        System.out.println(vector);
        vector.rotateRight(5);
        System.out.println(vector);
    }
}
