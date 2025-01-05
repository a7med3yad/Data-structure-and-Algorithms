public class SinglyLinkedList {
    private Node head;
    private Node tail;

    // Node class
    private class Node {
        int info;
        Node next;

        Node(int el) {
            this.info = el;
            this.next = null;
        }

        Node(int el, Node next) {
            this.info = el;
            this.next = next;
        }
    }

    // Insert element to the head
    public void insertToHead(int el) {
        if (head == null) {
            head = tail = new Node(el);
        } else {
            head = new Node(el, head);
        }
    }

    // Insert element to the tail
    public void insertToTail(int el) {
        if (head == null) {
            head = tail = new Node(el);
        } else {
            tail.next = new Node(el);
            tail = tail.next;
        }
    }

    // Delete element from the head
    public int deleteFromHead() {
        if (head == null) {
            System.out.println("No Node to remove");
            return 0;
        }
        int el = head.info;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return el;
    }

    // Delete element from the tail
    public int deleteFromTail() {
        if (head == null) {
            System.out.println("No Node to remove");
            return 0;
        }
        int el = tail.info;
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
        return el;
    }

    // Delete node by value
    public void deleteNode(int el) {
        if (head == null) return;

        if (head.info == el) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
        } else {
            Node pred = head;
            Node tmp = head.next;

            while (tmp != null && tmp.info != el) {
                pred = tmp;
                tmp = tmp.next;
            }

            if (tmp != null) {
                pred.next = tmp.next;
                if (tmp == tail) {
                    tail = pred;
                }
            }
        }
    }

    // Print the linked list
    public void printLinkedList() {
        if (head == null) {
            System.out.println("The LinkedList is Empty");
        } else {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.info+" | ");
                tmp = tmp.next;
            }
        }
    }

    // Check if element is in the list
    public boolean isInList(int el) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.info == el) return true;
            tmp = tmp.next;
        }
        return false;
    }
}
