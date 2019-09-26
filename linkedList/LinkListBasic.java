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

        // get value on given position
        private int get(int pos) {
            if (pos != 0) {
                return this.nextNode.get(pos - 1);
            } else {
                return this.value;
            }
        }

        // set value on given position
        private Node set(int pos, int value) {
            if (pos != 0) {
                return new Node(this.value, this.nextNode.set(pos - 1, value));
            } else {
                this.value = value;
                return this;
            }
        }

        // add to tail
        private Node add(int value) {
            if (this.value == Integer.MIN_VALUE) {
                this.value = value;
                return this;
            } else {
                Node tail = new Node(value);
                Node current = this;
                while (current.nextNode != null) {
                    current = current.nextNode;
                }
                current.nextNode = tail;
                return this;
            }
        }

        // add to given index
        private Node add(int value, int pos) {
            int len = this.getlength();
            Node result = new Node(value);

            if (pos > len - 1) {
                System.out.println("out of range: added to tail");
                result = this.add(value);
                return result;
            } else if (pos == 0) { // add to a new node's head
                if (this.value == Integer.MIN_VALUE) {
                    return result;
                } else {
                    result.nextNode = this;
                    return result;
                }
            } else {
                Node current = this;
                Node inNode = new Node(value);
                for (int i = pos; i > 1; i--) {
                    current = current.nextNode;
                }
                Node temp = current.nextNode;
                current.nextNode = inNode;
                inNode.nextNode = temp;
                return this;
            }
        }

        // remove node on given index start from 0
        private Node remove(int i) {
            Node result = null;
            int len = this.getlength();
            if (i >= len) {
                System.out.println("out of range exception");
                return this;
            } else {
                if (i == 0) {
                    result = this.nextNode;
                    return result;
                } else {
                    result = this;
                    Node cur = this;
                    for (int j = 0; j < i - 1; j++) {
                        cur = cur.nextNode;
                    }
                    cur.nextNode = cur.nextNode.nextNode;
                }
                return result;
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

        // reverse
        private Node reverse() {
            Node pointer = this;
            if (pointer.getlength() == 1) {
                return pointer;
            } else {
                Node result = null;

                while (pointer.nextNode != null) {
                    result = new Node(pointer.value, result);
                    pointer = pointer.nextNode;
                }
                result = new Node(pointer.value, result);
                return result;
            }
        }

        // remove duplicate on unsorted
        private Node removeDuplicate() {
            ArrayList<Integer> values = new ArrayList<Integer>();
            int len = this.getlength();
            Node result = this;

            if (len == 1) {
                System.out.println("only one element can't duplicate");
                return result;
            } else {
                Node current = result;

                for (int i = 0; i < len; i++) {
                    if (values.contains(current.value)) {
                        result = result.remove(i);
                        len = result.getlength();
                        i--; // reset the loop back
                        current = current.nextNode;
                    } else {
                        values.add(current.value);
                        current = current.nextNode;
                    }
                }
                return result;
            }
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

        ll1_5 = ll1_5.add(6);
        ll1_5.printList();
        ll1_5 = ll1_5.add(7);
        ll1_5.printList();

        ll1 = ll1.add(2);
        ll1.printList();

        lln = lln.add(10);
        lln.printList();

        System.out.println("==test for add(value,pos) to delicated position");
        Node ll1_5a = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_5b = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_5c = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_5d = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_5e = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_5f = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

        Node ll1_2 = new Node(1, null);
        Node lln_2 = new Node();

        Node ll0p = ll1_5a.add(-1, 0);
        ll0p.printList();
        Node ll1p = ll1_5b.add(-2, 1);
        ll1p.printList();
        Node ll2p = ll1_5c.add(-3, 2);
        ll2p.printList();
        Node ll3p = ll1_5d.add(-4, 3);
        ll3p.printList();
        Node ll4p = ll1_5e.add(-5, 4);
        ll4p.printList();
        Node ll5p = ll1_5f.add(-6, 5);
        ll5p.printList();

        ll1_2 = ll1_2.add(2, 1);
        ll1_2.printList();

        lln_2 = lln_2.add(10, 1);
        lln_2.printList();
    }

    // test the cyclecheck functionality
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

    // test the last_N functionality
    public static void lastNSample() {
        Node ll1_5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

        ll1_5.lastN(1);
        ll1_5.lastN(2);
        ll1_5.lastN(3);
        ll1_5.lastN(4);
        ll1_5.lastN(5);
        ll1_5.lastN(6);
    }

    // test reverse functionality
    public static void reverseSample() {
        Node ll1_5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_2 = new Node(1, new Node(2, null));
        Node ll1 = new Node(1, null);

        ll1_5.printList();
        ll1_5 = ll1_5.reverse();
        ll1_5.printList();

        ll1_2.printList();
        ll1_2 = ll1_2.reverse();
        ll1_2.printList();

        ll1.printList();
        ll1 = ll1.reverse();
        ll1.printList();

    }

    // test the remore functionality
    public static void removeSample() {
        Node ll1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll3 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll4 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll6 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

        System.out.println("remove 1==");
        Node r1 = ll1.remove(0);
        r1.printList();
        System.out.println("remove 2==");
        Node r2 = ll2.remove(1);
        r2.printList();
        System.out.println("remove 3==");
        Node r3 = ll3.remove(2);
        r3.printList();
        System.out.println("remove 4==");
        Node r4 = ll4.remove(3);
        r4.printList();
        System.out.println("remove 5==");
        Node r5 = ll5.remove(4);
        r5.printList();
        System.out.println("remove 6==");
        Node r6 = ll6.remove(5);
        r6.printList();

    }

    // test remove duplicate on unsort linked list
    public static void removeDuplicateSample() {
        Node ll1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(4, null)))));
        Node ll3 = new Node(1, new Node(1, new Node(3, new Node(4, new Node(5, null)))));
        Node ll4 = new Node(1, new Node(1, new Node(1, new Node(4, new Node(5, null)))));

        System.out.println("1===");
        ll1.printList();
        ll1 = ll1.removeDuplicate();
        ll1.printList();

        System.out.println("2===");
        ll2.printList();
        ll2 = ll2.removeDuplicate();
        ll2.printList();

        System.out.println("3===");
        ll3.printList();
        ll3 = ll3.removeDuplicate();
        ll3.printList();

        System.out.println("4===");
        ll4.printList();
        ll4 = ll4.removeDuplicate();
        ll4.printList();

    }

    // find the two number sum on stack, make linked list and print it
    public static void twoSum(Node x, Node y) {
        int lenX = x.getlength();
        int lenY = y.getlength();
        int lenLong = Math.max(lenX, lenY);
        Node result = new Node();
        int carryOn = 0;

        for (int i = 0; i < lenLong; i++) {
            int curposX = lenX - i - 1;
            int curposY = lenY - i - 1;
            int digitX = 0;
            int digitY = 0;
            if (curposX < 0) {
                digitX = 0;
            } else {
                digitX = x.get(curposX);
            }
            if (curposY < 0) {
                digitY = 0;
            } else {
                digitY = y.get(curposY);
            }
            // System.out.printf("x: %d y: %d \n", digitX, digitY);
            result = result.add(digitX + digitY, 0);

        }
        // result.printList();
        result = twoSumRegulate(result);
        System.out.println("the two sum result is:");
        result.printList();
    }

    // eliminate any >10 value to make sure linked list represent a number
    public static Node twoSumRegulate(Node n) {
        int len = n.getlength();
        for (int i = 0; i < len; i++) {
            int curpos = len - i - 1;
            int curvalue = n.get(curpos);

            if (curvalue > 9) {
                if (curpos == 0) {
                    n.set(curpos, curvalue - 10);
                    n = n.add(1, 0);
                } else {
                    n.set(curpos, curvalue - 10);
                    n.set(curpos - 1, n.get(curpos - 1) + 1);
                }
            }
        }
        return n;
    }

    // test two sum
    public static void twoSumSample() {
        Node ll01_5 = new Node(9, new Node(9, new Node(9, new Node(9, new Node(15, null)))));
        Node ll0 = new Node(0, null);
        Node ll2 = new Node(2, null);
        Node ll99 = new Node(9, new Node(9, null));
        Node ll999 = new Node(9, new Node(9, new Node(9, null)));
        Node ll18 = new Node(1, new Node(8, null));

        twoSum(ll0, ll0);
        twoSum(ll0, ll2);
        twoSum(ll2, ll2);
        twoSum(ll99, ll2);
        twoSum(ll2, ll18);
        twoSum(ll99, ll18);
        twoSum(ll999, ll18);
    }

    public static void main(String[] args) {

        Node ll1_5 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node ll1_50000 = new Node(1, new Node(20, new Node(300, new Node(4000, new Node(50000, null)))));
        Node lln55_10 = new Node(7, new Node(10, new Node(-3, new Node(0, new Node(-55, null)))));

        Node ll01_5 = new Node(9, new Node(9, new Node(9, new Node(9, new Node(15, null)))));
        Node ll0 = new Node(0, null);
        Node ll2 = new Node(2, null);
        Node ll99 = new Node(9, new Node(9, null));
        Node ll999 = new Node(9, new Node(9, new Node(9, null)));
        Node ll18 = new Node(1, new Node(8, null));

        twoSumSample();

        System.out.println("====linked list basic done here");

    }
}
