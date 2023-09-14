package Tree.SearchNode;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertNode(56);
        tree.insertNode(30);
        tree.insertNode(40);
        tree.insertNode(22);
        tree.insertNode(70);
        tree.insertNode(95);
        tree.insertNode(60);
        tree.insertNode(65);
        tree.insertNode(11);
        tree.insertNode(16);
        tree.insertNode(63);
        tree.insertNode(67);
        tree.insertNode(3);
        tree.insertNode(37);
        tree.insertNode(88);

        System.out.println("Cari Node dengan Nilai 16: " + tree.searchNode(16));
        System.out.println("Cari Node dengan Nilai 63: " + tree.searchNode(63));

        System.out.println("Pelintasan secara In Order:");
        tree.inOrderTraversal(tree.getRoot());
        System.out.println();

        System.out.println("Pelintasan secara Post Order:");
        tree.postOrderTraversal(tree.getRoot());
        System.out.println();

        System.out.println("Pelintasan secara Pre Order:");
        tree.preOrderTraversal(tree.getRoot());
        System.out.println();

        System.out.println("Pelintasan secara BFS:");
        tree.bfsLevel();
    }

}
