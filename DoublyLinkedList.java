public class DoublyLinkedList {
    private pointer head;
    private pointer tail;
    private int cnt;

    // Check if list is empty
    public boolean isEmpty() {
        return cnt == 0;
    }

    // Insert element to the tail
    public void insertToTail(int el) {
        pointer newPointer = new pointer(el);
        if (isEmpty()) {
            head = tail = newPointer;
        } else {
            newPointer.prev = tail;
            tail.next = newPointer;
            tail = newPointer;
        }
        cnt++;
    }

    // Insert element to the head
    public void insertToHead(int el) {
        pointer newPointer = new pointer(el);
        if (isEmpty()) {
            head = tail = newPointer;
        } else {
            newPointer.next = head;
            head.prev = newPointer;
            head = newPointer;
        }
        cnt++;
    }

    // Insert element at a specific position
    public void insertAt(int pos, int el) {
        if (pos < 0 || pos > cnt) {
            System.out.println("Out of Bounds");
            return;
        }
        if (pos == 0) {
            insertToHead(el);
        } else if (pos == cnt) {
            insertToTail(el);
        } else {
            pointer newPointer = new pointer(el);
            pointer curr = head;
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }
            newPointer.next = curr.next;
            newPointer.prev = curr;
            curr.next.prev = newPointer;
            curr.next = newPointer;
            cnt++;
        }
    }

    // Delete element from the head
    public int deleteFromHead() {
        if (isEmpty()) {
            System.out.println("No Node to remove");
            return 0;
        }
        int el = head.info;
        if (cnt == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        cnt--;
        return el;
    }

    // Delete element from the tail
    public int deleteFromTail() {
        if (isEmpty()) {
            System.out.println("No Node to remove");
            return 0;
        }
        int el = tail.info;
        if (cnt == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        cnt--;
        return el;
    }

    // Delete element from a specific position
    public void deleteFrom(int pos) {
        if (pos < 0 || pos >= cnt) {
            System.out.println("Out of Bounds");
            return;
        }
        if (isEmpty()) {
            System.out.println("No Node to remove");
            return;
        }
        if (pos == 0) {
            deleteFromHead();
        } else if (pos == cnt - 1) {
            deleteFromTail();
        } else {
            pointer current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            cnt--;
        }
    }

    // Delete element by value
    public void delete(int el) {
        if (isEmpty()) {
            System.out.println("No Node to remove");
            return;
        }
        if (head.info == el) {
            deleteFromHead();
        } else if (tail.info == el) {
            deleteFromTail();
        } else {
            pointer current = head;
            while (current != null && current.info != el) {
                current = current.next;
            }
            if (current != null) {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                cnt--;
            } else {
                System.out.println("Element not found");
            }
        }
    }

    // Print list
    public void printList() {
        pointer tmp = head;
        while (tmp != null) {
            System.out.println(tmp.info);
            tmp = tmp.next;
        }
    }
    public boolean isExist(int el){
        pointer tmp=head;
        while(tmp!=null&&tmp.info!=el){
            tmp=tmp.next;
        }
        return tmp!=null;
    }
}
