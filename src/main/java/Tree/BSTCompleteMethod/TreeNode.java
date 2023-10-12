package Tree.BSTCompleteMethod;

public class TreeNode {
    private int Element;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int element) {
        this.leftChild = null;
        this.rightChild = null;
        this.Element = element;
    }

    public int getElement() {
        return Element;
    }

    public void setElement(int element) {
        this.Element = element;
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
