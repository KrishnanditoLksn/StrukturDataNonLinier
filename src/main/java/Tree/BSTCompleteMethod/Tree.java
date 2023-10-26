package Tree.BSTCompleteMethod;

import java.util.LinkedList;
import java.util.Queue;

//NAMA : EMMANUEL KRISHNANDITO LAKSANA


public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        TreeNode<T> tempRoot = new TreeNode<T>(data);
        if (root == null) {
            root = tempRoot;
        } else {
            TreeNode<T> newNode = getRoot();
            while (true) {
                if (data.compareTo(newNode.getElement()) < 0) {
                    if (newNode.getLeftChild() == null) {
                        newNode.setLeftChild(tempRoot);
                        break;
                    } else {
                        newNode = newNode.getLeftChild();
                    }
                } else if (data.compareTo(newNode.getElement()) >= 0) {
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

    public boolean findTheNode(T key) {
        TreeNode<T> searcher = getRoot();

        while (searcher != null) {
            if (key.compareTo(searcher.getElement()) < 0) {
                searcher = searcher.getRightChild();

            } else if (key.compareTo(searcher.getElement()) > 0) {
                searcher = searcher.getLeftChild();
            } else {
                return true;
            }
        }
        return false;
    }

    public T findTheNode2(T key) {
        TreeNode<T> searcher = getRoot();

        while (searcher != null) {
            if (key.compareTo(searcher.getElement()) < 0) {
                searcher = searcher.getRightChild();
                if (key.compareTo(searcher.getRightChild().getElement()) > 0) {
                    return searcher.getLeftChild().getElement();
                } else {
                    searcher = searcher.getLeftChild();
                }

            } else if (key.compareTo(searcher.getElement()) > 0) {
                searcher = searcher.getLeftChild();
                if (key.compareTo(searcher.getLeftChild().getElement()) < 0) {
                    return searcher.getElement();
                } else {
                    searcher = searcher.getRightChild();
                }
            }
        }
        return null;
    }

    public void preOrderTraversal(TreeNode<T> localRoot) {
        if (localRoot == null) {
            return;
        }
        System.out.println(localRoot.getElement() + " ");
        preOrderTraversal(localRoot.getRightChild());
        preOrderTraversal(localRoot.getLeftChild());
    }

    public void postOrderTraversal() {
        postOrderTraversal(getRoot());
    }

    public void postOrderTraversal(TreeNode<T> localRoot) {
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

    private void inOrderTraversal(TreeNode<T> localRoot) {
        if (localRoot == null) {
            return;
        }
        inOrderTraversal(localRoot.getLeftChild());
        System.out.print(localRoot.getElement() + " ");
        inOrderTraversal(localRoot.getRightChild());
    }

    //thanks to achmad herlambang
    public void delete(T key) {
        TreeNode<T> parent = root;
        TreeNode<T> temp = root;
        //Searching dulu , setelah temp sama dengan key , maka baru lakukan penghapusan node dengan berbagai kondisi
        while (temp != null) {
            if (key.compareTo(temp.getElement()) < 0) {
                parent = temp;
                temp = temp.getLeftChild();
            } else if (key.compareTo(temp.getElement()) > 0) {
                parent = temp;
                temp = temp.getRightChild();
            } else {
                //pengkondisian berbagai kondisi child
                if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                    if (key.compareTo(parent.getElement()) < 0) {
                        parent.setLeftChild(null);
                    } else if (key.compareTo(parent.getElement()) > 0) {
                        parent.setRightChild(null);
                    } else {
                        root = null;
                    }
                } else if (temp.getLeftChild() == null && temp.getRightChild() != null) {
                    //kondisi 1 atau 2
                    if (key.compareTo(parent.getElement()) < 0) {
                        parent.setLeftChild(temp.getRightChild());
                    } else if (key.compareTo(parent.getElement()) > 0) {
                        parent.setRightChild(temp.getRightChild());
                    } else {
                        root = temp.getRightChild();
                    }
                }//kondisi 3 , kiri tidak kosong  dan kanan kosong
                else if (temp.getLeftChild() != null && temp.getRightChild() == null) {
                    if (key.compareTo(parent.getElement()) < 0) {
                        //kondisi 4 punya anak kiri dari anak kiri
                        parent.setLeftChild(temp.getLeftChild());
                    }
                    //kondisi 4 punya anak kanan dari anak kiri

                    else if (key.compareTo(parent.getElement()) > 0) {
                        parent.setRightChild(temp.getLeftChild());
                    } else {
                        root = temp.getLeftChild();
                    }

                } else if (temp.getLeftChild() != null && temp.getRightChild() != null) {
                    predecessor(temp);
                }
                return;
            }
        }
    }

    public T getSibNode(T key) {
        TreeNode<T> parent = getRoot();
        TreeNode<T> temp = getRoot();

        while (temp != null) {
            if (key.compareTo(temp.getElement()) < 0) {
                parent = temp;
                temp = temp.getLeftChild();
            } else if (key.compareTo(temp.getElement()) > 0) {
                parent = temp;
                temp = temp.getRightChild();
            } else {
                if (temp == parent.getLeftChild()) {
                    return parent.getRightChild().getElement();
                } else if (temp == parent.getRightChild()) {
                    return parent.getLeftChild().getElement();
                }
            }
        }
        return null;
    }

    // many codes of this tree bst method made from algorithm  from  gfg and 2009 Introduction to Algorithms Third Ed
    //SUMBER: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java/42449385#42449385

    public void printTree(String prefix, TreeNode<T> node) {
        if (node != null) {
            printTree(prefix + "     ", node.getRightChild());
            System.out.println(prefix + ("|-- ") + node.getElement());
            printTree(prefix + "     ", node.getLeftChild());
        }
    }

    public int nodeDepth(TreeNode<T> current, T node) {
        //base case
        if (current == null) {
            return 0;
        }
        int nodeCounter = -1;
        if (current.getElement() == node || (nodeCounter = nodeDepth(current.getLeftChild(), node)) >= 0 || (nodeCounter = nodeDepth(current.getRightChild(), node)) >= 0) {
            nodeCounter += 1;
        }
        return nodeCounter;
    }

    public T minimumNode(TreeNode<T> current) {
        //terus melakukan perulangan selama left child ada
        while (current.getLeftChild() != null) {
            //current geser terus ke anak kiri
            current = current.getLeftChild();
        }
        //jika udah kosong , current mendapatkan element yang menjadi nilai minumum dari suatu node
        return current.getElement();
    }

    //versi rekursif dengan algo dari ebook
    public T recursiveMinimumNode(TreeNode<T> current) {
        if (current.getLeftChild() == null) {
            return current.getElement();
        }
        return recursiveMinimumNode(current.getLeftChild());
    }

    public T recursiveMaximumNode(TreeNode<T> current) {
        if (current.getRightChild() == null) {
            return current.getElement();
        }
        return recursiveMaximumNode(current.getRightChild());
    }

    public T maximumNode(TreeNode<T> current) {
        //terus melakukan perulangan selama anak kanan ada
        while (current.getRightChild() != null) {
            //current geser ke anak kanan
            current = current.getRightChild();
        }
        //jika sudah kosong , current akan mendapatkan element  dan menjadi node maksimum dalam tree
        return current.getElement();
    }

    public TreeNode<T> suksesor(TreeNode<T> temp) {
        TreeNode<T> suksesor = temp.getRightChild();
        TreeNode<T> parentSuksesor = null;

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

    public void predecessor(TreeNode<T> temp) {
        TreeNode<T> predecessor = temp.getLeftChild();
        TreeNode<T> parentPrede = null;

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
    }

    public int RootHeightNode(TreeNode<T> node) {
        //Ngebug
        if (node == null) {
            return 0;
        } else {
            int leftNodeDepth = RootHeightNode(node.getLeftChild());
            int rightNodeDepth = RootHeightNode(node.getRightChild());
            //jika right nod > left
            if (rightNodeDepth > leftNodeDepth) {
                return rightNodeDepth + 1;
            }//huh
            else {
                return leftNodeDepth + 1;
            }
        }
    }

    //aneh salah lagi
    public int nodeHeight(TreeNode<T> node, int key, int height) {
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
        Queue<TreeNode<T>> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode<T> temp = treeNodeQueue.poll();
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
    public boolean isCompleteTree(TreeNode<T> node, int index, int nNodes) {
        if (node == null) {
            return false;
        }
        if (index >= nNodes) {
            return false;
        }
        //menggunakan formula 2 * index + 1 untuk node kiri dan 2 * index + 2 untuk node kanan
        return (isCompleteTree(node.getLeftChild(), 2 * index + 1, nNodes) && isCompleteTree(node.getRightChild(), 2 * index + 2, nNodes));
    }


    //algo by GEEKS FOR GEEKS
    //recursive version to find the parent of node
    public void recursiveFindParent(TreeNode<T> current, T node, T parentTofind) {
        //jika kosong

        if (current == null) {
            return;
        }
        if (node.compareTo(current.getElement()) == 0) {
            //jika ketemu tapi tidak ada parent , cetak -1
            System.out.println(parentTofind);
        } else {
            recursiveFindParent(current.getLeftChild(), node, current.getElement());
            recursiveFindParent(current.getRightChild(), node, current.getElement());
        }
    }

    public boolean isQueueCompleteTree() {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        boolean checker = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> temp = queue.peek();
            queue.remove();

            if (temp == null) {
                checker = true;
            } else {
                if (checker) {
                    return false;
                }
                queue.add(temp.getLeftChild());
                queue.add(temp.getRightChild());
            }
        }
        return true;
    }

    public int getTreeSize(TreeNode<T> node) {
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


    //SOAL UTS 1 SDNL NAMA : EMMANUEL KRISHNANDITO LAKSANA
    //NIM : 225314024

    //UNFINISHED NODE
    public T keyGreaterNode(T key) {
        TreeNode<T> node = getRoot();
        if (node == null) {
            return null;
        } else {
            while (true) {
                node = node.getRightChild();
                node = node.getLeftChild();
                if (key.compareTo(node.getLeftChild().getElement()) > 0) {
                    return node.getRightChild().getElement();
                }
            }
        }
    }
}