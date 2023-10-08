package Tree.AvlTree;

public class Tree {
    TreeNode root;

    public Tree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insertNode(int data) {
        TreeNode rootTemp = new TreeNode(data);
        //jika root kosong
        if (root == null) {
            root = rootTemp;
        } else {
            //yang jalan temp
            TreeNode temp = root;
            while (true) {
                if (root.getElement() < data) {
                    if (temp.getLeftNode() == null) {
                        temp.setLeftNode(rootTemp);
                        break;
                    } else {
                        temp = temp.getLeftNode();
                    }
                } else if (temp.getElement() >= data) {
                    if (temp.getRightNode() == null) {
                        temp.setRightNode(rootTemp);
                        break;
                    } else {
                        temp = temp.getRightNode();
                    }
                }
            }
        }
    }


    TreeNode insertNodeRecur(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }
        if (data < node.Element) {
            node.LeftNode = insertNodeRecur(node.getLeftNode(), data);
        } else {
            node.RightNode = insertNodeRecur(node.getRightNode(), data);
        }
        return node;
    }

    public void printTree(String prefix, TreeNode node) {
        if (node != null) {
            printTree(prefix + "     ", node.getRightNode());
            System.out.println(prefix + ("|-- ") + node.getElement());
            printTree(prefix + "     ", node.getLeftNode());
        }
    }

    public int balanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return heightTree(node.getLeftNode()) - heightTree(node.getRightNode());
    }

    public int maxNode(int nodeA, int nodeB) {
        return Math.max(nodeA, nodeB);
    }

    public int getLeftNodeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftNode = getLeftNodeHeight(node.getLeftNode());
            int rightNode = getLeftNodeHeight(node.getRightNode());
            if (leftNode > rightNode) {
                return leftNode + 1;
            } else {
                return rightNode + 1;
            }
        }
    }

    public int heightTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
}
