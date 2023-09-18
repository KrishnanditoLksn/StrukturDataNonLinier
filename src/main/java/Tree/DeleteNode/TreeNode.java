package Tree.DeleteNode;

public class TreeNode {
    private TreeNode leftChild;
    private TreeNode rightChild;
    private final int Element;

    public TreeNode(int element) {
        this.leftChild = null;
        this.rightChild = null;
        this.Element = element;
    }

    public int getElement() {
        return Element;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
}
