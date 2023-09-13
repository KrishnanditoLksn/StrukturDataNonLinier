package Tree.Insert;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insert(int data) {
        TreeNode helper = new TreeNode(data);
        if (getRoot() == null) {
            setRoot(helper);
        } else {
            TreeNode baru = getRoot();
            while (true) {
                if (data < baru.getIData()) {
                    if (baru.getLeftNode() == null) {
                        baru.setLeftNode(helper);
                        break;
                    } else {
                        baru = baru.getLeftNode();
                    }
                } else if (data >= baru.getIData()) {
                    if (baru.getRightNode() == null) {
                        baru.setRightNode(helper);
                        break;
                    } else {
                        baru = baru.getRightNode();
                    }
                }
            }
        }
    }
                                                                    // PERTEMUAN 3
    public int findNode(int key) {
        TreeNode nodeTraveller = this.root;

        while (true) {
            if (key == nodeTraveller.getIData()) {
                System.out.print("Ketemu cuy :");
                return key;
            } else {
                if (key >= nodeTraveller.getIData()) {
                    nodeTraveller = nodeTraveller.getRightNode();
                } else {
                    nodeTraveller = nodeTraveller.getLeftNode();
                }
            }
        }
    }

    /*
    experimental method
     */


    public boolean findTheNode(int key) {
        TreeNode search = getRoot();

        while (search != null) {
          /*  if (key == search.getIData()) {
                return true;
            } else {*/
            if (search.getIData() < key) {
                search = search.getRightNode();

            } else if (search.getIData() > key) {
                search = search.getLeftNode();
            } else {
                return true;
            }
        }
        return false;
    }


    public void breadthFirstSearch() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempo = queue.poll();
            System.out.println(tempo.getIData() + " ");
            if (tempo.getLeftNode() != null) {
                queue.add(tempo.getLeftNode());
            }
            if (tempo.getRightNode() != null) {
                queue.add(tempo.getRightNode());
            }
        }
    }

    public void inOrderTraversal(TreeNode localRoot) {
        if (localRoot != null) {
            inOrderTraversal(localRoot.getLeftNode());
            System.out.print(localRoot.getIData() + " ");
            inOrderTraversal(localRoot.getRightNode());
        }
    }

    public void postOrderTraversal(TreeNode rootLocal) {
        if (rootLocal != null) {
            postOrderTraversal(rootLocal.getLeftNode());
            postOrderTraversal(rootLocal.getRightNode());
            System.out.print(rootLocal.getIData() + " ");
        }
    }

    public void preOrderTraversal(TreeNode rootLocal) {
        if (rootLocal != null) {
            System.out.print(rootLocal.getIData() + " ");
            preOrderTraversal(rootLocal.getLeftNode());
            preOrderTraversal(rootLocal.getRightNode());
        }
    }//AKHIR PERTEMUAN 3
}


/*

    public int searchTree(int key) {
        TreeNode search = getRoot();

        if (key == search.getIData()) {
            return key;
        } else {
            if (key < search.getIData()) {
                search = search.getLeftNode();
                return search.getIData();
            }
        }
        return search.getIData();
    }
}
*/
