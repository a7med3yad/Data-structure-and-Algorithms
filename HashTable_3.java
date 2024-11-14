public class HashTable_3 {
    private int hash_table[];
    private String statues[];
    private int size;
    
    public HashTable_3(int size) {
        this.size = size;
        hash_table = new int[this.size];
        statues = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            statues[i] = "empty";
        }
    }
    
    public void insert(int element) {
        int indx = element % size;
        int p = 5 - (element % 5);  // double hashing step size
        int i = indx;

        while (statues[i].equals("occupied")) {
            i = (i + p) % size;
        }

        hash_table[i] = element;
        statues[i] = "occupied";
    }
    
    public void delete(int element) {
        int indx = element % size;
        int p = 5 - (element % 5);  // double hashing step size
        int i = indx;

        while (true) { 
            if (statues[i].equals("occupied") && hash_table[i] == element) {
                statues[i] = "deleted";
                break;
            }
            if (statues[i].equals("empty")) {
                System.out.println("Element Not Found");
                break;
            }
            i = (i + p) % size;
            if (i == indx) { 
                System.out.println("Element Not Found");
                break;
            }
        }
    }
    
    public void search(int element) {
        int indx = element % size;
        int p = 5 - (element % 5);  // double hashing step size
        int i = indx;

        while (true) {
            if (statues[i].equals("occupied") && hash_table[i] == element) {
                System.out.println("Element found at index " + i);
                break;
            }
            if (statues[i].equals("empty")) {
                System.out.println("Element Not Found");
                break;
            }
            i = (i + p) % size;
            if (i == indx) {  
                System.out.println("Element Not Found");
                break;
            }
        }
    }
    
    public void Print_Hash_Table() {
        System.out.print("| ");
        for (int i = 0; i < this.size; i++) {
            if (statues[i].equals("occupied")) {
                System.out.print(hash_table[i] + " | ");
            } else {
                System.out.print(statues[i] + " | ");
            }
        }
    }
}
