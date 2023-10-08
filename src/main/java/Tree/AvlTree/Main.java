package Tree.AvlTree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
    /*    tree.insertNode(29);
        tree.insertNode(20);
    */
        tree.root = tree.insertNodeRecur(tree.getRoot(), 29);
        tree.root = tree.insertNodeRecur(tree.getRoot(), 20);
        tree.root = tree.insertNodeRecur(tree.getRoot(), 50);
        tree.root = tree.insertNodeRecur(tree.getRoot(), 60);
        tree.printTree("", tree.getRoot());

        System.out.println(tree.getLeftNodeHeight(tree.getRoot()));
    }
}
