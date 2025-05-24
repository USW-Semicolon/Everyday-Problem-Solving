import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
    private static BinaryTree tree = new BinaryTree("A");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.insert(name, left, right);
        }

        String preorder = tree.preorder();
        String inorder = tree.inorder();
        String postorder = tree.postorder();

        System.out.println(preorder + "\n" + inorder + "\n" + postorder + "\n");
    }

    static class Node {
        String name;
        Node leftChild;
        Node rightChild;

        private Node(String name) {
            this.name = name;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree(String rootName) {
            this.root = new Node(rootName);
        }

        void insert(String nodeName, String leftChild, String rightChild) {
            Node node = search(root, nodeName, leftChild, rightChild);

            node.leftChild = ".".equals(leftChild) ? null : new Node(leftChild);
            node.rightChild = ".".equals(rightChild) ? null : new Node(rightChild);
        }

        Node search(Node head, String nodeName, String left, String right) {
            if (head == null) {
                return null;
            }

            if (head.name.equals(nodeName)) {
                return head;
            }

            if (head.leftChild != null) {
                Node leftResult = search(head.leftChild, nodeName, left, right);

                if (leftResult != null) {
                    return leftResult;
                }
            }

            return search(head.rightChild, nodeName, left, right);
        }

        String preorder() {
            StringBuilder sb = new StringBuilder();

            preorder(root, sb);
            return sb.toString();
        }

        private void preorder(Node node, StringBuilder sb) {
            if (node == null) {
                return;
            }

            sb.append(node.name);
            preorder(node.leftChild, sb);
            preorder(node.rightChild, sb);
        }

        String inorder() {
            StringBuilder sb = new StringBuilder();

            inorder(root, sb);
            return sb.toString();
        }

        private void inorder(Node node, StringBuilder sb) {
            if (node == null) {
                return;
            }

            inorder(node.leftChild, sb);
            sb.append(node.name);
            inorder(node.rightChild, sb);
        }

        String postorder() {
            StringBuilder sb = new StringBuilder();

            postorder(root, sb);
            return sb.toString();
        }

        private void postorder(Node node, StringBuilder sb) {
            if (node == null) {
                return;
            }

            postorder(node.leftChild, sb);
            postorder(node.rightChild, sb);
            sb.append(node.name);
        }
    }
}
