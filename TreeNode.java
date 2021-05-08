public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T data;

    public TreeNode(T dataNode) {
        left = null;
        right = null;
        data = dataNode;
    }

    public TreeNode(TreeNode<T> node) {
        left = node.left;
        right = node.right;
        data = node.getData();
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
