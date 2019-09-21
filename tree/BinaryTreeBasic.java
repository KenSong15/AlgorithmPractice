import java.util.Scanner; // Import the Scanner class

public class BinaryTreeBasic {

    private static class Node {
        private int value;
        private Node leftNode;
        private Node rightNode;

        private Node() {
        }

        private Node(int v) {
            value = v;
            leftNode = null;
            rightNode = null;
        }

        private Node(int v, Node ln, Node rn) {
            value = v;
            leftNode = ln;
            rightNode = rn;
        }

        // print single node and its left and right
        private void printNode() {
            System.out.println("value:" + value + " left:" + leftNode + " right:" + rightNode);
        }

        // print whole tree in inorder way
        private void printTreeInOnder() {
            if (this.leftNode != null) {
                this.leftNode.printTreeInOnder();
            }
            System.out.print(this.value + " ");
            if (this.rightNode != null) {
                this.rightNode.printTreeInOnder();
            }
        }

        // print whole tree in preorder way
        private void printTreePreOnder() {
            System.out.print(this.value + " ");
            if (this.leftNode != null) {
                this.leftNode.printTreePreOnder();
            }
            if (this.rightNode != null) {
                this.rightNode.printTreePreOnder();
            }
        }

        // print whole tree in postorder way
        private void printTreePostOnder() {
            if (this.leftNode != null) {
                this.leftNode.printTreePostOnder();
            }
            if (this.rightNode != null) {
                this.rightNode.printTreePostOnder();
            }
            System.out.print(this.value + " ");
        }

    }

    public static void printInThreeOrderSample() {
        System.out.println("printing tree 1-5 1-7 in three order:");
        /*
         * contains: 1 2 3 4 5 6 7 inorder: 1 2 3 4 5 6 7 preorder: 4 2 1 3 6 5 7
         * postorder: 1 3 2 5 7 6 4
         */
        Node tree1_7 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(6, new Node(5, null, null), new Node(7, null, null)));
        System.out.printf("%s %s is:", "tree1_7", "in order");
        tree1_7.printTreeInOnder();
        System.out.print("\n");

        System.out.printf("%s %s is:", "tree1_7", "pre order");
        tree1_7.printTreePreOnder();
        System.out.print("\n");

        System.out.printf("%s %s is:", "tree1_7", "post order");
        tree1_7.printTreePostOnder();
        System.out.print("\n");
        System.out.println("------------------");

        /*
         * contains: 1 2 3 4 5 inorder: 1 2 3 4 5 preorder: 4 2 1 3 5 postorder: 1 3 2 5
         * 4
         */
        Node tree1_5 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(5, null, null));
        System.out.printf("%s %s is:", "tree1_5", "in order");
        tree1_5.printTreeInOnder();
        System.out.print("\n");

        System.out.printf("%s %s is:", "tree1_5", "pre order");
        tree1_5.printTreePreOnder();
        System.out.print("\n");

        System.out.printf("%s %s is:", "tree1_5", "post order");
        tree1_5.printTreePostOnder();
        System.out.print("\n");
        System.out.println("------------------");
    }

    // add value to tree as a leaf,will modify the original
    public static Node add(Node t, int v) {
        System.out.printf("adding %d to tree with root %d \n", v, t.value);
        Node node = new Node(v);
        if (t == null) {
            return node;
        } else {
            Node parent = null;
            Node current = t;
            while (current != null) {
                parent = current;
                if (current.value <= v) {
                    current = current.rightNode;
                } else {
                    current = current.leftNode;
                }
            }
            if (parent.value <= v) {
                parent.rightNode = node;
            } else {
                parent.leftNode = node;
            }
            return t;
        }
    }

    // search if the value is exist on given tree
    public static void search(Node t, int target) {
        String directionStr = "";
        if (t == null) {
            System.out.println("tree is null");
        } else {
            Node current = t;
            while (current != null) {
                if (current.value == target) {
                    if (directionStr == "") {
                        directionStr = "on root";
                    }
                    System.out.printf("found! %s \n", directionStr);
                    return;
                } else if (target < current.value) {
                    current = current.leftNode;
                    directionStr += "left ";
                } else if (target > current.value) {
                    current = current.rightNode;
                    directionStr += "right ";
                }
            }
            System.out.println("no found...");
        }
    }

    // test if add and search working
    public static void addAndSearchSample() {
        Node tree1 = new Node(1, null, null);

        Node tree1_7 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(6, new Node(5, null, null), new Node(7, null, null)));

        Node tree1_5 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(5, null, null));

        search(tree1, 1);
        search(tree1, 7);
        search(tree1_7, 5);
        search(tree1_7, 3);
        search(tree1_5, 1);
        search(tree1_5, 6);

        Node tree1_6 = add(tree1_5, 6);
        search(tree1_6, 6);
    }

    public static void main(String[] args) {

        Node tree1 = new Node(1, null, null);

        Node tree1_7 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(6, new Node(5, null, null), new Node(7, null, null)));

        Node tree1_5 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(5, null, null));

        addAndSearchSample();

        System.out.println("b_tree done here");

    }
}