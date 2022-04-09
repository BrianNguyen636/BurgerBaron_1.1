/*
 * @Author Brian Nguyen
 *
 */

class MyStack {
    class Node {
        Node next;
        String theItem;

        public Node(String item) {
            theItem = item;
            next = null;
        }
        public String toString() {return theItem;}
    }
    Node start;

    MyStack() {start = null;}

    boolean isEmpty() {return start == null;}
    void push(String item) {
        Node node = new Node(item);
        node.next = start;
        start = node;
    }
    String pop() {
        Node result = start;
        start = start.next;
        return result.toString();
    }

    String peek() {return start.toString();}

    int size() {
        Node move = start;
        int size = 0;
        while (move != null) {
            size++;
            move=move.next;
        }
        return size;
    }
    public String toString() {
        Node move = start;
        String result = "[";
        while (move != null) {
            result += move.theItem;
            if (move.next != null) {
                result += ", ";
            } else {
                result += "]";
            }
            move=move.next;
        }
        return result;
    }
}
