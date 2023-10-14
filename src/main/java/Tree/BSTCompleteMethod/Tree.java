package Tree.BSTCompleteMethod;

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

                } else if (temp.getLeftChild() != null && temp.getRightChild() != null) {
                    suksesor(temp);
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

    // many codes of this tree bst method made from algorithm  from  gfg and 2009 Introduction to Algorithms Third Ed
    //SUMBER: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java/42449385#42449385

    public void printTree(String prefix, TreeNode node) {
        if (node != null) {
            printTree(prefix + "     ", node.getRightChild());
            System.out.println(prefix + ("|-- ") + node.getElement());
            printTree(prefix + "     ", node.getLeftChild());
        }
    }

    public int minimumNode(TreeNode current) {
        //terus melakukan perulangan selama left child ada
        while (current.getLeftChild() != null) {
            //current geser terus ke anak kiri
            current = current.getLeftChild();
        }
        //jika udah kosong , current mendapatkan element yang menjadi nilai minumum dari suatu node
        return current.getElement();
    }

    //versi rekursif dengan algo dari ebook
    public int recursiveMinimumNode(TreeNode current) {
        if (current.getLeftChild() == null) {
            return current.getElement();
        }
        return recursiveMinimumNode(current.getLeftChild());
    }

    public int maximumNode(TreeNode current) {
        //terus melakukan perulangan selama anak kanan ada
        while (current.getRightChild() != null) {
            //current geser ke anak kanan
            current = current.getRightChild();
        }
        //jika sudah kosong , current akan mendapatkan element  dan menjadi node maksimum dalam tree
        return current.getElement();
    }

    public TreeNode suksesor(TreeNode temp) {
        TreeNode suksesor = temp.getRightChild();
        TreeNode parentSuksesor = null;

        while (suksesor.getLeftChild() != null) {
            parentSuksesor = suksesor;
            suksesor = suksesor.getLeftChild();
        }
        temp.setElement(suksesor.getElement());

        if (parentSuksesor != null) {
            parentSuksesor.setLeftChild(suksesor.getRightChild());
        } else {
            temp.setRightChild(suksesor.getRightChild());
        }
        return suksesor;
    }

    public TreeNode predecessor(TreeNode temp) {
        TreeNode predecessor = temp.getLeftChild();
        TreeNode parentPrede = null;

        while (predecessor.getRightChild() != null) {
            parentPrede = predecessor;
            predecessor = predecessor.getRightChild();
        }

        temp.setElement(predecessor.getElement());

        if (parentPrede != null) {
            parentPrede.setRightChild(parentPrede.getLeftChild());
        } else {
            temp.setLeftChild(predecessor.getLeftChild());
        }

        return predecessor;
    }

    public int RootHeightNode(TreeNode node) {
        //Ngebug
        if (node == null) {
            return 0;
        } else {
            int leftNodeDepth = RootHeightNode(node.getLeftChild());
            int rightNodeDepth = RootHeightNode(node.getRightChild());
            //jika right nod > left
            if (rightNodeDepth > leftNodeDepth) {
                return (rightNodeDepth + 1);
            }//huh
            else {
                return (leftNodeDepth + 1);
            }
        }
    }

    //aneh salah lagi
    public int nodeHeight(TreeNode node, int key, int height) {
        if (node == null) {
            return 0;
        }
        if (key == height) {
            return height;
        } else {
            int level = nodeHeight(node.getLeftChild(), key, height + 1);

            if (level != 0) {
                return level;
            }
        }
        return nodeHeight(node.getRightChild(), key, height + 1);
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

    //gfg
    public boolean isCompleteTree(TreeNode node, int index, int nNodes) {
        if (node == null) {
            return true;
        }
        if (index >= nNodes) {
            return true ;
        }
        //menggunakan formula 2 * index + 1 untuk node kiri dan 2 * index + 2 untuk node kanan
        return (isCompleteTree(node.getLeftChild(), 2 * index + 1, nNodes) && isCompleteTree(node.getRightChild(), 2 * index + 2, nNodes));
    }


    public int nodeDepth(TreeNode node) {
        int leftNodeHeight;
        int rightNodeHeight;
        if (node == null) {
            return 0;
        } else {
            leftNodeHeight = nodeDepth(node.getLeftChild());
            rightNodeHeight = nodeDepth(node.getRightChild());
        }
        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }

    public int getTreeSize(TreeNode node) {
        int calculateSize;
        //base case
        if (node == null) {
            return 0;
        } else {
            //menghitung ukuran tree dengan merekursi  left child dan right child
            calculateSize = getTreeSize(node.getLeftChild()) + getTreeSize(node.getRightChild()) + 1;
        }
        return calculateSize;
    }
}