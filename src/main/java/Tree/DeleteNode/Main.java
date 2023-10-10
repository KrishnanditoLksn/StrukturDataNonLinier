package Tree.DeleteNode;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] insert2 = {60, 55, 100, 107, 67, 105, 57, 45, 59, 106, 43};
        int[] Array = {100, 55, 60, 57, 67, 105, 106, 59};
        for (int i : insert2) {
            tree.insert(i);
        }
        tree.printTree("", tree.getRoot());
        System.out.println();
        System.out.println("Kedalaman Tree : " + tree.nodeDepth(tree.getRoot()));
        System.out.println("Minimum Node : " + tree.minimumNode(tree.getRoot()));
        System.out.println("Maksimum Node : " + tree.maximumNode(tree.getRoot()));
        System.out.println("Size dari Tree : " + tree.getTreeSize(tree.getRoot()));


        for (int j : Array) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.print("Hapus : " + j);
            System.out.println();
            System.out.println();
            tree.delete(j);
            tree.printTree("", tree.getRoot());
            System.out.println(" ");
            System.out.print("Tampilan IN Order Traversal : " + " ");
            tree.inOrderTraversal();
        }
    }
}
