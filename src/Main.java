public class Main {
    public static void main(String[] args) {
        SparseMatrix mat = new SparseMatrix(10, 10);
        mat.set(5, 3, 5);
        mat.set(7, 3, 7);
        mat.set(2, 3, 2);
        mat.set(0, 3, 2);
        mat.set(6, 5, 6);
        mat.set(4, 5, 4);
        mat.set(3, 7, 3);
        mat.set(1, 7, 1);
        //mat.set(1, 70, 1);
        mat.print();
        mat.printNonZero();

        SparseMatrix mat2 = new SparseMatrix(10, 10);
        mat2.set(5, 1, 9);
        mat2.set(6, 3, 8);
        mat2.set(9, 9, 9);
        mat2.print();
        System.out.println("----------------------------------------------------");
        mat.add(mat2);
        mat.print();
        mat.printNonZero();

    }
}
