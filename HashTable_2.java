import java.util.Arrays;
public class HashTable_2 {
    private int[] hash_table;
    private String[] status;
    private int size;

    public HashTable_2(int size) {
        this.size = size;
        hash_table = new int[this.size];
        status = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            status[i] = "empty";
        }
    }

    public void insert(int element) {
        int index = element % size;
        if (!status[index].equals("occupied")) {
            hash_table[index] = element;
            status[index] = "occupied";
        } else {
            int i = index;
            int p = 1;
            while (true) {
                i = (index + p * p) % size; // Quadratic probing
                p++;
                if(i<0){
                    while(i<0){
                        i+=this.size;
                    }
                }
                if (!status[i].equals("occupied")) {
                    hash_table[i] = element;
                    status[i] = "occupied";
                    break;
                }
            }
        }
    }

    public void delete(int element) {
        int index = element % size;
        if (status[index].equals("occupied") && hash_table[index] == element) {
            status[index] = "deleted";
        } else {
            int i = index;
            int p = 1;
            while (true) {
                i = (index + p * p) % size; // Quadratic probing
                p++;
                if(i<0){
                    while(i<0){
                        i+=this.size;
                    }
                }
                if (status[i].equals("occupied") && hash_table[i] == element) {
                    status[i] = "deleted";
                    break;
                } else if (status[i].equals("empty")) {
                    System.out.println("Element Not Found");
                    break;
                }
            }
        }
    }

    public void search(int element) {
        int index = element % size;
        if (status[index].equals("occupied") && hash_table[index] == element) {
            System.out.println("Element found at index " + index);
        } else {
            int i = index;
            int p = 1;
            while (true) {
                i = (index + p * p) % size;
                p++;
                if(i<0){
                    while(i<0){
                        i+=this.size;
                    }
                }
                if (status[i].equals("occupied") && hash_table[i] == element) {
                    System.out.println("Element found at index " + i);
                    break;
                } else if (status[i].equals("empty")) {
                    System.out.println("Element Not Found");
                    break;
                }
                if(i==index){
                    System.out.println("Element Not Found");
                    break;
                }
            }
        }
    }

    public void Print_Hash_Table() {
        System.out.print("| ");
        for (int i = 0; i < this.size; i++) {
            if (status[i].equals("occupied")) System.out.print(hash_table[i] + " | ");
            else System.out.print(status[i] + " | ");
        }
        System.out.println();
    }
}
