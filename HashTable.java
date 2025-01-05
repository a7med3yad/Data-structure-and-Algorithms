public class HashTable {
    private int size;
    private SinglyLinkedList[] hash_table;

    public HashTable(int size) {
        this.size=size;
        hash_table = new SinglyLinkedList[this.size];

        for (int i = 0; i < this.size; i++) {
            hash_table[i] = new SinglyLinkedList();
        }
    }

    public void insert(int element) {
        int indx = element % size;
        hash_table[indx].insertToTail(element); 
    }

    public void delete(int element) {
        int indx = element % size;
        hash_table[indx].deleteNode(element); 
    }

    public void search(int element) {
        int indx = element % size;
        if (hash_table[indx].isInList(element)) {
            System.out.println("Element Found");
        } else {
            System.out.println("Element Not Found");
        }
    }

    public void Print_Hash_Table() {
        for (int i = 0; i < size; i++) {
            System.out.print("index " + i + " : | ");
            hash_table[i].printLinkedList();
            System.out.println();
        }
    }
}
