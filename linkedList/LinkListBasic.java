import java.util.ArrayList;

public class LinkListBasic {

    private static class Node {
        private int value;
        private Node nextNode;

        private Node() {
            value = Integer.MIN_VALUE;
            nextNode = null;
        }

        private Node(int v) {
            value = v;
            nextNode = null;
        }

        private Node(int v, Node nn) {
            value = v;
            nextNode = nn;
        }

        // print single node and its next
        private void printNode() {
            System.out.println("value:" + value + " next:" + nextNode);
        }

        // print whole link
        private void printList() {
            System.out.print("list: ");
            String resStr = "";
            Node curNode = this;
            while (curNode != null) {
                resStr += (curNode.value + " ");
                curNode = curNode.nextNode;
            }
            System.out.print(resStr + "\n");
        }

        // add to tail
        private void add(int value) {
            if (this.value == Integer.MIN_VALUE) {
                this.value = value;
            } else {
                Node tail = new Node(value);
                Node current = this;
                while (current.nextNode != null) {
                    current = current.nextNode;
                }
                current.nextNode = tail;
            }
        }

        // todo:add to given index
        private void add(int value, int pos) {
            int len = this.getlength();
            if (pos > len - 1) {
                System.out.println("need to fill since out of range");
            } else {
                Node front = this;
                Node back = front.nextNode;
                Node inNode = new Node(value);

                for (int i = pos; i > 0; i--) {
                    front = front.nextNode;
                    back = back.nextNode;
                }
                front.nextNode = inNode;
                inNode.nextNode = back;
            }
        }

        // count the length
        private int getlength() {
            int len = 0;
            Node curNode = this;
            while (curNode != null) {
                len++;
                curNode = curNode.nextNode;
            }
            // System.out.printf("list length: %d \n", len);
            return len;
        }

        // return middle element by fast and slow node
        private int getmiddle() {
            Node slow = this;
            Node fast = this;
            Boolean slow_move = false;
            while (fast != null) {
                if (slow_move) {
                    fast = fast.nextNode;
                    slow = slow.nextNode;
                    slow_move = false;
                } else {
                    fast = fast.nextNode;
                    slow_move = true;
                }
            }
            return slow.value;
        }

        // check cycle, need the length at least three
        private Boolean checkCycle() {
            Node slow = this;
            Node fast = this;
            // Boolean slow_move = false;
            while (fast.nextNode != null && fast.nextNode.nextNode != null) {
                fast = fast.nextNode.nextNode;
                slow = slow.nextNode;
                if (fast == slow) {
                    System.out.println("contains cycle");
                    return true;
                }
            }
            System.out.println("non-cycle");
            return false;
        }

        // todo: reverse
        private void reverse() {
            Node nullHead = new Node();
        }

        // todo: remove duplicate on unsorted
        private void removeDuplicate() {
            ArrayList values = new ArrayList<>();
        }

        // find the last n node
        private void lastN(int n) {
            int len = this.getlength();
            if (n > len) {
                System.out.printf("too short to have last %d's\n", n);
            } else {
                Node slow = this;
                Node fast = this;
                for (int i = n; i > 0; i--) {
                    fast = fast.nextNode;
                }
                while (fast != null) {
                    slow = slow.nextNode;
                    fast = fast.nextNode;
                }
                System.out.printf("last %d element is: %d\n", n, slow.value);
            }
        }

    }

    // check add and add to index
    public static void addSample() {

        System.out.println("==test for add(value) to tail");
        Node ll1_5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1 = new Node(1, null);
        Node lln = new Node();

        ll1_5.add(6);
        ll1_5.printList();
        ll1_5.add(7);
        ll1_5.printList();

        ll1.add(2);
        ll1.printList();

        lln.add(10);
        lln.printList();

        System.out.println("==test for add(value) to tail");
        Node ll1_5_2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_2 = new Node(1, null);
        Node lln_2 = new Node();

        ll1_5_2.add(-10, 0);
        ll1_5_2.printList();
        ll1_5_2.add(-1, 1);
        ll1_5_2.printList();

        ll1_2.add(2, 1);
        ll1_2.printList();

        lln_2.add(10, 1);
        lln_2.printList();
    }

    // to test the cyclecheck functionality
    public static void checkCycleSample() {
        Node ll1_5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

        Node ll1_2 = new Node(1, new Node(2, null));
        Node ll3_4 = new Node(3, new Node(4, null));
        Node ll5_6 = new Node(5, new Node(6, null));
        ll1_2.nextNode.nextNode = ll3_4;
        ll3_4.nextNode.nextNode = ll5_6;
        ll5_6.nextNode.nextNode = ll1_2;

        ll1_2.checkCycle();
        ll1_5.checkCycle();
    }

    // to test the last_N functionality
    public static void lastNSample() {
        Node ll1_5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

        ll1_5.lastN(1);
        ll1_5.lastN(2);
        ll1_5.lastN(3);
        ll1_5.lastN(4);
        ll1_5.lastN(5);
        ll1_5.lastN(6);
    }

    // todo: find the two number sum on stack
    public static void twoSum(Node x, Node y) {

    }

    public static void main(String[] args) {

        Node ll1_5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_50000 = new Node(1, new Node(20, new Node(300, new Node(4000, new Node(50000, null)))));
        Node lln55_10 = new Node(7, new Node(10, new Node(-3, new Node(0, new Node(-55, null)))));

        addSample();

        System.out.println("====linked list done here");

    }
}
