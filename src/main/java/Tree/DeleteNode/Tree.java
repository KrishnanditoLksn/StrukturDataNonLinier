package Tree.DeleteNode;

import java.util.LinkedList;
import java.util.Queue;

//NAMA : EMMANUEL KRISHNANDITO LAKSANA


public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int data) {
        TreeNode tempRoot = new TreeNode(data);
        if (root == null) {
            root = tempRoot;
        } else {
            TreeNode newNode = getRoot();
            while (true) {
                if (data < newNode.getElement()) {
                    if (newNode.getLeftChild() == null) {
                        newNode.setLeftChild(tempRoot);
                        break;
                    } else {
                        newNode = newNode.getLeftChild();
                    }
                } else if (data >= newNode.getElement()) {
                    if (newNode.getRightChild() == null) {
                        newNode.setRightChild(tempRoot);
                        break;
                    } else {
                        newNode = newNode.getRightChild();
                    }
                }
            }
        }
    }

    public boolean findTheNode(int key) {
        TreeNode searcher = getRoot();

        while (searcher != null) {
            if (searcher.getElement() < key) {
                searcher = searcher.getRightChild();

            } else if (searcher.getElement() > key) {
                searcher = searcher.getLeftChild();
            } else {
                return true;
            }
        }
        return false;
    }

    public void preOrderTraversal(TreeNode localRoot) {
        if (localRoot == null) {
            return;
        }
        System.out.println(localRoot.getElement() + " ");
        preOrderTraversal(localRoot.getRightChild());
        preOrderTraversal(localRoot.getLeftChild());
    }

    public void postOrderTraversal(TreeNode localRoot) {
        if (localRoot == null) {
            return;
        }
        postOrderTraversal(localRoot.getLeftChild());
        postOrderTraversal(localRoot.getRightChild());
        System.out.println(localRoot.getElement() + " ");
    }

    public void inOrderTraversal() {
        inOrderTraversal(getRoot());
    }

    public void inOrderTraversal(TreeNode localRoot) {
        if (localRoot == null) {
            return;
        }
        inOrderTraversal(localRoot.getLeftChild());
        System.out.print(localRoot.getElement() + " ");
        inOrderTraversal(localRoot.getRightChild());
    }

    //thanks to achmad herlambang
    public void delete(int key) {
        TreeNode parent = root;
        TreeNode temp = root;
        //Searching dulu , setelah temp sama dengan key , maka baru lakukan penghapusan node dengan berbagai kondisi
        while (temp != null) {
            if (key < temp.getElement()) {
                parent = temp;
                temp = temp.getLeftChild();
            } else if (key > temp.getElement()) {
                parent = temp;
                temp = temp.getRightChild();
            } else {
                //pengkondisian berbagai kondisi child
                if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                    if (key < parent.getElement()) {
                        parent.setLeftChild(null);
                    } else if (key > parent.getElement()) {
                        parent.setRightChild(null);
                    } else {
                        root = null;
                    }
                } else if (temp.getLeftChild() == null && temp.getRightChild() != null) {
                    //kondisi 1 atau 2
                    if (key < parent.getElement()) {
                        parent.setLeftChild(temp.getRightChild());
                    } else if (key > parent.getElement()) {
                        parent.setRightChild(temp.getRightChild());
                    } else {
                        root = temp.getRightChild();
                    }
                }//kondisi 3 , kiri tidak kosong  dan kanan kosong
                else if (temp.getLeftChild() != null && temp.getRightChild() == null) {
                    if (key < parent.getElement()) {
                        //kondisi 4 punya anak kiri dari anak kiri
                        parent.setLeftChild(temp.getLeftChild());
                    }
                    //kondisi 4 punya anak kanan dari anak kiri

                    else if (key > parent.getElement()) {
                        parent.setRightChild(temp.getLeftChild());
                    } else {
                        root = temp.getLeftChild();
                    }
                }
                return;
            }
        }
    }

    public TreeNode getSibNode(int key) {
        TreeNode parent = getRoot();
        TreeNode temp = getRoot();

        while (temp != null) {
            if (key < temp.getElement()) {
                parent = temp;
                temp = temp.getLeftChild();
            } else if (key > temp.getElement()) {
                parent = temp;
                temp = temp.getRightChild();
            } else {
                if (temp == parent.getLeftChild()) {
                    return parent.getRightChild();
                } else if (temp == parent.getRightChild()) {
                    return parent.getLeftChild();
                }
            }
        }
        return null;
    }

    public void bfsLevel() {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode temp = treeNodeQueue.poll();
            System.out.print(temp.getElement() + " ");
            if (temp.getLeftChild() != null) {
                treeNodeQueue.add(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                treeNodeQueue.add(temp.getRightChild());
            }
        }
    }

    //SUMBER: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java/42449385#42449385
    public void printTree(String prefix, TreeNode node) {
        if (node != null) {
            printTree(prefix + "     ", node.getRightChild());
            System.out.println(prefix + ("|-- ") + node.getElement());
            printTree(prefix + "     ", node.getLeftChild());
        }
    }

    public int minimumNode(TreeNode current) {
        if (current.getLeftChild() == null) {
            return current.getElement();
        }
        return minimumNode(current.getLeftChild());
    }

    public int maximumNode(TreeNode current) {
        //mengecek jika anak kanan kosong
        if (current.getRightChild() == null) {
            //return data di pointer
            return current.getElement();
        }
        //panggil fungsi rekursi
        return maximumNode(current.getRightChild());
    }
}