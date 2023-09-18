package Tree.DeleteNode;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(50);
        tree.insert(40);
        tree.insert(30);
        tree.insert(45);
        tree.insert(35);
        tree.insert(33);
        tree.insert(70);
        tree.insert(80);
        tree.insert(75);
        tree.insert(85);
        tree.bfsLevel();
        System.out.println();
        tree.delete(85);
        tree.bfsLevel();

    }
}
