
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    // Node class to represent each node in the tree
    private class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    // Add a value to the BST using iteration
    public void add(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node tmp = root;
        Node parent = null;

        while (tmp != null) {
            parent = tmp;
            if (value <= tmp.data) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }

        if (value <= parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    // Add a value to the BST using recursion (helper method included for location clarity)
    private void addHelper(Node tmp, int value) {
        if (value <= tmp.data) {
            if (tmp.left == null) {
                tmp.left = new Node(value); // Add the new node
            } else {
                addHelper(tmp.left, value); // Continue down the left subtree
            }
        } else {
            if (tmp.right == null) {
                tmp.right = new Node(value); // Add the new node
            } else {
                addHelper(tmp.right, value); // Continue down the right subtree
            }
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            addHelper(root, value);
        }
    }

    // Get the maximum value in the BST using iteration
    public int getMax() {
        Node tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.data;
    }

    // Get the maximum value in the BST using recursion
    private int getMaxHelper(Node tmp) {
        if (tmp.right == null) {
            return tmp.data;
        } else {
            return getMaxHelper(tmp.right);
        }
    }

    public int showMax() {
        return getMaxHelper(root);
    }

    // Get the minimum value in the BST using iteration
    public int getMin() {
        Node tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.data;
    }

    // Get the minimum value in the BST using recursion
    private int getMinHelper(Node tmp) {
        if (tmp.left == null) {
            return tmp.data;
        } else {
            return getMinHelper(tmp.left);
        }
    }

    public int showMin() {
        return getMinHelper(root);
    }

    // Get the height of the BST using recursion
    private int getHeightHelper(Node tmp) {
        if (tmp == null) {
            return -1;
        }
        int leftSubtreeHeight = getHeightHelper(tmp.left);
        int rightSubtreeHeight = getHeightHelper(tmp.right);
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

    public int getHeight() {
        return getHeightHelper(root);
    }

    public void Display_Level_Order() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node currNode = q.poll();  // Directly use poll(), no need to use peek() first
            System.out.print(currNode.data + " ");
            if (currNode.left != null) {
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
            }
        }
        System.out.println();
    }

    // Preorder traversal (root, left, right)
    private void preOrder(Node tmp) {
        if (tmp == null) {
            return;
        }
        System.out.print(tmp.data + " ");
        preOrder(tmp.left);
        preOrder(tmp.right);
    }

    // Inorder traversal (left, root, right)
    private void inOrder(Node tmp) {
        if (tmp == null) {
            return;
        }
        inOrder(tmp.left);
        System.out.print(tmp.data + " ");
        inOrder(tmp.right);
    }

    // Postorder traversal (left, right, root)
    private void postOrder(Node tmp) {
        if (tmp == null) {
            return;
        }
        postOrder(tmp.left);
        postOrder(tmp.right);
        System.out.print(tmp.data + " ");
    }

    // Display methods for traversal
    public void display_InOrder() {
        inOrder(root);
        System.out.println(); // To ensure a newline after traversal
    }

    public void display_preOrder() {
        preOrder(root);
        System.out.println(); // To ensure a newline after traversal
    }

    public void display_postOrder() {
        postOrder(root);
        System.out.println(); // To ensure a newline after traversal
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root; 
        }else if (root.data < data) {
            root.left = removeHelper(root.left, data); 
        }else if (root.data > data) {
            root.right = removeHelper(root.right, data); 
        }else {
            if (root.left == null) {

            } else if (root.right == null) {

            } else {
                int maxValue = this.getMaxHelper(root.left);
                root.data = maxValue;
                root.left = removeHelper(root.left, maxValue);
            }
        }

        return root;
    }

    public void remove(int data) {
        root = removeHelper(root, data);
    }

}
