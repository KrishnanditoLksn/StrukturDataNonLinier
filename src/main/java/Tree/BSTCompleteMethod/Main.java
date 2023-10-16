package Tree.BSTCompleteMethod;

public class Main {
    public static void main(String[] args) {
        //lalala errrr
        Tree tree = new Tree();
        int[] insertNodeArray = {60, 55, 100, 107, 67, 105, 57, 45, 59, 106, 43};
        /*     int[] Array = {100, 55, 60, 57, 67, 105, 106, 59};*/
        int[] arraytest = {10, 5, 15, 3, 8, 12, 30};
        for (int i : insertNodeArray) {
            tree.insert(i);
        }
        tree.printTree("", tree.getRoot());
        System.out.println();
        System.out.println("Tinggi Tree dari Root " + tree.getRoot().getElement() + " adalah :  " + tree.RootHeightNode(tree.getRoot()));
        System.out.println("Minimum Node : " + tree.minimumNode(tree.getRoot()));
        System.out.println("Maximum Node : " + tree.maximumNode(tree.getRoot()));
        System.out.println("Size dari Tree : " + tree.getTreeSize(tree.getRoot()));
        /* System.out.println("Kedalaman Node : " + tree.nodeDepth(tree.getRoot()));*/
        System.out.println("Terkecil rekursif " + tree.recursiveMinimumNode(tree.getRoot()));
        System.out.println(tree.nodeHeight(tree.getRoot(), 100, 1));
        int key = 60;
//        System.out.println("Sibling dari " + key + " adalah : " + tree.getSibNode(key));
        System.out.println("Kedalaman node " + tree.nodeDepth(tree.getRoot(), key));


        System.out.println("Pelintasan secara BFS ");
        tree.bfsLevel();
        System.out.println();

        if (tree.isQueueCompleteTree()) {
            System.out.println("Merupakan BST yang Complete");
        } else {
            System.out.println("Bukan BST yang complete ");
        }
        int node = 57;
        System.out.print("Parent dari " + node + " adalah : ");
        tree.recursiveFindParent(tree.getRoot(), node, -1);

        for (int j : insertNodeArray) {
            tree.delete(j);
            System.out.println("Menghapus " + " " + j);
            System.out.println();
            tree.printTree("", tree.getRoot());
        }
    }
}
