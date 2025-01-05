public class SortedLinkedList {
    private Node head;
    private Node tail;

    public SortedLinkedList() {
        head = null;
        tail = null;
    }
    public void insert(int el) {
        Node newNode = new Node(el);

        
        if (head == null) {
            head = tail = newNode;
            return;
        }

        if (el <= head.info) {
            newNode.next = head;
            head = newNode;
            return;
        }

        if (el >= tail.info) {
            tail.next = newNode;
            tail = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.info < el) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }
    public void printLinkedList() {
        if (head == null) {
            System.out.println("The LinkedList is Empty");
        } else {
            Node tmp = head;
            while (tmp != null) {
                System.out.println(tmp.info);
                tmp = tmp.next;
            }
        }
    }
}
