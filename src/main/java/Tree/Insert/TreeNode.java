package Tree.Insert;

public class TreeNode {
    TreeNode leftNode;
    TreeNode rightNode;
    private int element;

    public TreeNode(int element) {
        this.element = element;
        this.leftNode = null;
        this.rightNode = null;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftChild) {
        this.leftNode = leftChild;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getIData() {
        return element;
    }

    public void setiData(int element) {
        this.element = element;
    }
}