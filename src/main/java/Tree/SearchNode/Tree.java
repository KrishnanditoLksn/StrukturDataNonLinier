package Tree.SearchNode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insertNode(int node) {
        TreeNode tempRoot = new TreeNode(node);
        /*
        cek jika root kosong  , jika ya akan diisi root
         */

        if (getRoot() == null) {
            setRoot(tempRoot);
        } else {
            /*
            membuat variabel newNode supaya root konstan
             */
            TreeNode newNode = getRoot();
            while (true) {
                if (node < newNode.getiData()) {
                    if (newNode.getLeftNode() == null) {
                        newNode.setLeftNode(tempRoot);
                        break;
                    } else {
                    /*
                    jika node sudah diisi maka , newNode akan menelusuri di left node
                     */
                        newNode = newNode.getLeftNode();
                    }
                } else if (node >= newNode.getiData()) {
                    if (newNode.getRightNode() == null) {
                        newNode.setRightNode(tempRoot);
                        break;
                    } else {
                        newNode = newNode.getRightNode();
                    }
                }
            }
        }
    }

    public int searchNode(int key) {
        TreeNode root = getRoot();
        while (true) {
            /*
            akan terus melakukan perulangan selama key belum di temukan
             */
            if (key == root.getiData()) {
                return key;
            } else {
                /*

                 */
                if (key >= root.getiData()) {
                    root = root.getRightNode();
                } else {
                    root = root.getLeftNode();
                }
            }
        }
    }

    public void inOrderTraversal(TreeNode local) {
        if (local != null) {
            inOrderTraversal(local.getLeftNode());
            System.out.print(local.getiData() + " ");
            inOrderTraversal(local.getRightNode());
        }
    }

    public void postOrderTraversal(TreeNode local) {
        if (local != null) {
            postOrderTraversal(local.getLeftNode());
            postOrderTraversal(local.getRightNode());
            System.out.print(local.getiData() + " ");
        }
    }


    public void preOrderTraversal(TreeNode local) {
        if (local != null) {
            System.out.print(local.getiData() + " ");
            preOrderTraversal(local.getLeftNode());
            preOrderTraversal(local.getRightNode());
        }
    }

    public void bfsLevel() {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode temp = treeNodeQueue.poll();
            System.out.print(temp.getiData() + " ");
            if (temp.getLeftNode() != null) {
                treeNodeQueue.add(temp.getLeftNode());
            }
            if (temp.getRightNode() != null) {
                treeNodeQueue.add(temp.getRightNode());
            }
        }
    }
}
