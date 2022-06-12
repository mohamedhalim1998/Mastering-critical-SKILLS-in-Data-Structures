import section8.*;


public class Main {
    public static void main(String[] args) {
        HW5P3.BinaryTree tree= new HW5P3.BinaryTree(1);
	/*
	tree.add(new int[]{2, 4, 8 },new char[]{'L', 'L', 'L' });
	tree.add(new int[]{2, 4, 9 },new char[]{'L', 'L', 'R' });
	tree.add(new int[]{2, 5, 10 },new char[]{'L', 'R', 'L' });
	tree.add(new int[]{2, 5, 11 },new char[]{'L', 'R', 'R' });

	tree.add(new int[]{3, 6, 12 },new char[]{'R', 'L', 'L' });
	tree.add(new int[]{3, 6, 13 },new char[]{'R', 'L', 'R' });
	tree.add(new int[]{3, 7, 14 },new char[]{'R', 'R', 'L' });
	tree.add(new int[]{3, 7, 15 },new char[]{'R', 'R', 'R' });
	tree.add(new int[]{3, 7, 15, 16 },new char[]{'R', 'R', 'R', 'R' });
	*/

        tree.add(new int[]{2, 3 },new char[]{'L', 'L'});
        tree.add(new int[]{4, 5, 6, 8, 9 },new char[]{'R', 'R', 'R', 'R', 'R' });
        tree.add(new int[]{4, 2, 3 },new char[]{'R', 'L', 'L'});
        tree.add(new int[]{4, 5, 6, 7 },new char[]{'R', 'R', 'L', 'L'});
        tree.add(new int[]{4, 5, 6, 8, 9 },new char[]{'R', 'R', 'L', 'R', 'R'});
        tree.add(new int[]{4, 5, 6, 7 },new char[]{'R', 'R', 'R', 'L'});

        // (2(3()())())
        // (6(7()())(8()(9()())))
        // (8()(9()()))

        tree.printDuplicatedSubtrees();

    }
}

