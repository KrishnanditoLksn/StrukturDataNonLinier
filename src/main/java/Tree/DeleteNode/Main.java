package Tree.DeleteNode;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] array = {100, 63, 65, 60, 95, 88, 67, 70, 56, 22, 16, 11, 3, 30, 40, 37};
        tree.insert(56);
        tree.insert(30);
        tree.insert(40);
        tree.insert(22);
        tree.insert(70);
        tree.insert(95);
        tree.insert(60);
        tree.insert(65);
        tree.insert(11);
        tree.insert(16);
        tree.insert(63);
        tree.insert(67);
        tree.insert(3);
        tree.insert(37);
        tree.insert(88);


        for (int j : array) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.print("Hapus : " + j);
            System.out.println();
            tree.delete(j);
            tree.inOrderTraversal(tree.getRoot());
        }

    }

}
