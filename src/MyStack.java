class MyStack {
    Node start;

    public MyStack() {start = null;}

    boolean isEmpty() {return start == null;}

    void push(String theItem) {
        Node item = new Node(theItem);
        item.next = start;
        start = item;
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
            result += move.item;
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
class Node {
    Node next;
    String item;

    public Node(String theItem) {
        item = theItem;
        next = null;
    }
    public String toString() {return item;}
}
