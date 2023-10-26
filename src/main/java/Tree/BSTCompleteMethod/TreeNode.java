package Tree.BSTCompleteMethod;

public class TreeNode <T extends Comparable<T>> {
        //<T extends Comparable<T>>// {
    private T Element;
    private TreeNode <T>  leftChild;
    private TreeNode <T> rightChild;
    private TreeNode  <T>  parent;

    public TreeNode(T  element) {
        this.leftChild = null;
        this.rightChild = null;
        this.Element = element;
        this.parent = null;
    }

//    public TreeNode  <T> getParent() {
//        return parent;
//    }
//
//    public void setParent(TreeNode parent) {
//        this.parent = parent;
//    }

    public T getElement() {
        return Element;
    }

    public void setElement(T element) {
        this.Element = element;
    }

    public TreeNode <T>  getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode <T> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode  <T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode <T> leftChild) {
        this.leftChild = leftChild;
    }
}
