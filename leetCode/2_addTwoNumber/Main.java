
import java.util.Scanner;

public class Main {

    public static class Linknode {
        private int data;
        private Linknode next;

        Linknode() {
            this.setData(Integer.MIN_VALUE);
            this.setNext(null);
        } // default data in 0

        Linknode(int d) {
            this.setData(d);
            this.setNext(null);
        } // construct data in d

        Linknode(int d, Linknode ln) {
            this.setData(d);
            this.setNext(ln);
        } // construct data in d

        public int getData() {
            return data;
        } // get the data

        public void setData(int data) {
            this.data = data;
        } // set the data

        public Linknode getNext() {
            return next;
        } // get next node

        public void setNext(Linknode next) {
            this.next = next;
        } // set next node

        public int getLenght() {
            Linknode cur1 = this;
            int memcount = 0;
            do {
                cur1 = cur1.next;
                memcount++;
            } while (cur1 != null);
            return memcount;
        } // return the length of the linknode

        @Override
        public String toString() {
            return "Linknode{" + "data=" + data + ", next=" + next + '}';
        } // return string form of all linknode

        public Linknode addToHead(int d) {
            if (d > 9 || d < 0) {
                System.err.println("please give a digit between 0-9");
                return this;
            } else {
                if (d == 0 /* && this.getData() == 0 && this.getNext() == null */) {
                    if (this.getNext() == null) {
                        return this;
                    }
                } else {
                    if (this.getNext() == null) {
                        if (this.getData() != 0) {
                            Linknode a6 = new Linknode(d);
                            a6.setNext(this);
                            return a6;
                        } else {
                            this.setData(d);
                            return this;
                        }
                    } else {
                        Linknode a4 = new Linknode(d);
                        a4.setNext(this);
                        return a4;
                    }
                }
            }
            return this;
        } // add a number to the head of linknode

        public void printAll() {
            Linknode cur = this;
            int memcount = this.getLenght();

            System.out.print("{  ");

            do {
                System.out.print(cur.data + "  ");
                cur = cur.next;
            } while (cur != null);
            System.out.print(String.format("}, %s in total\n", memcount));
        } // print all elements in a row

        public int toNum() {

            Linknode cur2 = this;
            int base = 0;
            int memcount = this.getLenght();

            int resnum = 0;
            int pos1 = 0;
            do {
                base = cur2.getData();
                cur2 = cur2.next;
                resnum += (base * Math.pow(10, pos1));
                pos1 += 1;
            } while (cur2 != null);
            System.out.print(String.format("%s digit num is: %s\n", memcount, resnum));
            return resnum;
        } // convert the linknode into a int number
    }

    public static void addTwoNum(Linknode l1, Linknode l2) {
        int n1 = l1.toNum();
        int n2 = l2.toNum();
        System.out.print(String.format("result is: %s\n", n1 + n2));
    }

    public static void main(String[] args) {

        Linknode ln1 = new Linknode(1, new Linknode(2, new Linknode(3, null)));
        Linknode ln2 = new Linknode(4, new Linknode(5, new Linknode(6, null)));

        addTwoNum(ln1, ln2);

        System.out.println("====2addlist test done here");

    }
}
