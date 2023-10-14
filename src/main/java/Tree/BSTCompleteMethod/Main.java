package Tree.BSTCompleteMethod;

public class Main {
    public static void main(String[] args) {
        //lalala errrr
        Tree tree = new Tree();
        int[] insertNodeArray = {60, 55, 100, 107, 67, 105, 57, 45, 59, 106, 43};
        /*     int[] Array = {100, 55, 60, 57, 67, 105, 106, 59};*/
        int[] arraytest = {1, 2, 3, 4,5,6};
        for (int i : arraytest) {
            tree.insert(i);
        }
        tree.printTree("", tree.getRoot());
        System.out.println();
        System.out.println("Tinggi Tree dari Root " + tree.getRoot().getElement() + " adalah :  " + tree.RootHeightNode(tree.getRoot()));
        System.out.println("Minimum Node : " + tree.minimumNode(tree.getRoot()));
        System.out.println("Maximum Node : " + tree.maximumNode(tree.getRoot()));
        System.out.println("Size dari Tree : " + tree.getTreeSize(tree.getRoot()));
        System.out.println("Kedalaman Node : " + tree.nodeDepth(tree.getRoot()));
        System.out.println("Terkecil rekursif " + tree.recursiveMinimumNode(tree.getRoot()));
        System.out.println(tree.nodeHeight(tree.getRoot(), 100, 1));

        int size = tree.getTreeSize(tree.getRoot());
        int index = 0;
//        if (tree.isCompleteTree(tree.getRoot(), index, size)) {
//            System.out.println("Merupakan BST yang Complete");
//        } else {
//            System.out.println("Bukan BST yang complete ");
//        }


        if (tree.completeTree(tree.getRoot(), 0, size)) {
            System.out.println("Merupakan BST yang Complete");
        } else {
            System.out.println("Bukan BST yang complete ");
        }
    }
}
