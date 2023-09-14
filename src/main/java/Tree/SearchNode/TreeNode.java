package Tree.SearchNode;

public class TreeNode {
    private final int iData;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int iData) {
        this.iData = iData;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getiData() {
        return iData;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }
}
