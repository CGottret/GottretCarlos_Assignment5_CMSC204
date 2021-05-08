import java.util.ArrayList;
import java.util.HashMap;

public class MorseCodeTree implements LinkedConverterTreeInterface {
    private TreeNode<String> root;
    private final HashMap<String, String> map = new HashMap<>();
    private ArrayList<String> inorder = new ArrayList<>();

    public MorseCodeTree() {
        root = new TreeNode<>("");
        buildTree();
    }

    /**
     * Returns a reference to the root
     *
     * @return reference to root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * sets the root of the Tree
     *
     * @param newNode a TreeNode<T> that will be the new root
     */
    @Override
    public void setRoot(TreeNode newNode) {
        root = new TreeNode(newNode);
    }

    /**
     * Adds result to the correct position in the tree based on the code
     * This method will call the recursive method addNode
     *
     * @param code   the code for the new node to be added
     * @param result
     * @return the linkedConverterTree with the new node added
     */
    @Override
    public LinkedConverterTreeInterface insert(Object code, Object result) {
        addNode(root, code, result);
        return null;
    }

    /**
     * This is a recursive method that adds element to the correct position
     * in the tree based on the code.
     *
     * @param root   the root of the tree for this particular recursive instance of addNode
     * @param code   the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode root, Object code, Object letter) {
        if (root == null) {
            return;
        }
        char firstChar = code.toString().charAt(0);
        if (code.toString().length() == 1) {
            TreeNode newNode = new TreeNode(letter);
            if (firstChar == '.') {
                if (root.getLeft() != null) {
                    root.getLeft().setData(letter);
                } else {
                    root.setLeft(newNode);
                }
            } else if (firstChar == '-') {
                if (root.getRight() != null) {
                    root.getRight().setData(letter);
                } else {
                    root.setRight(newNode);
                }
            }
            return;
        }

        if (firstChar == '.') {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode(""));
            }
            root = root.getLeft();
        } else if (firstChar == '-') {
            if (root.getRight() == null) {
                root.setRight(new TreeNode(""));
            }
            root = root.getRight();
        }
        String remain = code.toString().substring(1);
        addNode(root, remain, letter);
    }

    /**
     * Fetch the data in the tree based on the code
     * This method will call the recursive method fetchNode
     *
     * @param code the code that describes the traversals within the tree
     * @return the result that corresponds to the code
     */
    @Override
    public Object fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode
     * that corresponds with the code
     *
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return the data corresponding to the code
     */
    @Override
    public Object fetchNode(TreeNode root, Object code) {
        if (root == null) {
            return null;
        }
        String codeStr = code.toString();
        char firstChar = codeStr.charAt(0);
        if (codeStr.length() == 1) {
            if (firstChar == '.') {
                return root.getLeft().getData();
            } else if (firstChar == '-') {
                return root.getRight().getData();
            }
            return null;
        }

        if (firstChar == '.') {
            root = root.getLeft();
        } else if (firstChar == '-') {
            root = root.getRight();
        }
        String remain = codeStr.substring(1);
        return fetchNode(root, remain);
    }

    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException {
        return null;
    }

    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
        return null;
    }

    /**
     * This method builds the LinkedConverterTree by inserting TreeNodes<T>
     * into their proper locations
     */
    @Override
    public void buildTree() {
        map.put(".-", "a");
        map.put("-...", "b");
        map.put("-.-.", "c");
        map.put("-..", "d");
        map.put(".", "e");
        map.put("..-.", "f");
        map.put("--.", "g");
        map.put("....", "h");
        map.put("..", "i");
        map.put(".---", "j");
        map.put("-.-", "k");
        map.put(".-..", "l");
        map.put("--", "m");
        map.put("-.", "n");
        map.put("---", "o");
        map.put(".--.", "p");
        map.put("--.-", "q");
        map.put(".-.", "r");
        map.put("...", "s");
        map.put("-", "t");
        map.put("..-", "u");
        map.put("...-", "v");
        map.put(".--", "w");
        map.put("-..-", "x");
        map.put("-.--", "y");
        map.put("--..", "z");

        for (String code : map.keySet()) {
            TreeNode ref = root;
            addNode(ref, code, map.get(code));
        }
    }

    /**
     * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
     * Used for testing to make sure tree is built correctly
     *
     * @return an ArrayList of the items in the linked Tree
     */
    @Override
    public ArrayList toArrayList() {
        LNRoutputTraversal(root, inorder);
        return inorder;
    }

    /**
     * The recursive method to put the contents of the linked converter tree in an ArrayList<T>
     * LNR (Inorder)
     *
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode root, ArrayList list) {
        if (root == null) {
            return;
        }
        LNRoutputTraversal(root.getLeft(), inorder);
        inorder.add(root.getData().toString());
        LNRoutputTraversal(root.getRight(), inorder);
    }
}
