package Tree.AvlTree;

public class TreeNode {
    TreeNode LeftNode;
    TreeNode RightNode;
    int Element;
    int height;

    public TreeNode(int element) {
        this.Element = element;
        this.LeftNode = null;
        this.RightNode = null;
        this.height = 1;
    }

    public TreeNode getRightNode() {
        return RightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        RightNode = rightNode;
    }

    public TreeNode getLeftNode() {
        return LeftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        LeftNode = leftNode;
    }

    public int getElement() {
        return Element;
    }

    public void setElement(int element) {
        Element = element;
    }
}
