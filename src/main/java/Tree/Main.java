package Tree;

import Tree.Insert.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(42);
        tree.insert(21);
        tree.insert(38);
        tree.insert(27);
        tree.insert(71);
        tree.insert(82);
        tree.insert(55);
        tree.insert(63);
        tree.insert(6);
        tree.insert(2);
        tree.insert(40);
        tree.insert(12);
        /*System.out.println(tree.findNode(21));*/
        /*System.out.println(tree.findTheNode(12));*/
        /* tree.breadthFirstSearch();*/
        /*  tree.postOrder(tree.getRoot());*/
        System.out.println(tree.findTheNode(16));
        System.out.println("Level order traversal : ");
        tree.breadthFirstSearch();
        /* System.out.println(tree.searchTree(12));*/
        /*   tree.findTreeNode(21);*/
       /* int found = tree.findNode(71);  // cari node key=25
        if(found != -1) {
            System.out.println("Ketemu node key= 25");
        }
        else {
            System.out.println("Node key=25 Tidak Ketemu");
        }*/

    }
}