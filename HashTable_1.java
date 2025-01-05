public class HashTable_1 {
    //using single probing
    private int hash_table[];
    private String statues[];
    private int size;
    
    public HashTable_1(int size) {
        this.size = size;
        hash_table = new int[this.size];
        statues = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            statues[i] = "empty";
        }
    }
    public void insert(int element){
        int indx = element%size;
        if(!statues[indx].equals("occupied")){
            hash_table[indx]=element;
            statues[indx]="occupied";
        }
        else{
            int i=indx;
            while (true) { 
                i++;
                if(i>=size)i%=size;
                if(!statues[i].equals("occupied")){
                    hash_table[i]=element;
                    statues[i]="occupied";
                    break;
                }
            }
        }
        }
        public void delete(int element){
            int indx= element%size;
            if(hash_table[indx]==element){
                statues[indx]="deleted";
            }
            else{
                int i =indx;
                while (true) { 
                    i++;
                    if(i>=size)i%=size;
                    if(statues[i].equals("occupied")){
                        if(hash_table[i]==element){
                            statues[i]="deleted";
                            break;
                        }
                    }
                    else if(statues[i].equals("empty")||i==(indx-1)){
                        System.out.println("Element Not Found");
                        break;
                    }
                }
            }
            }
            public void search(int element) {
                int index = element % size;
                if (statues[index].equals("occupied") && hash_table[index] == element) {
                    System.out.println("Element found at index " + index);
                } else {
                    int i = index;
                    while (true) { 
                        i++;
                        if (i >= size) i %= size;
                        if (statues[i].equals("empty")) {
                            System.out.println("Element Not Found");
                            break;
                        }
                        if (statues[i].equals("occupied") && hash_table[i] == element) {
                            System.out.println("Element found at index " + i);
                            break;
                        }
                        if (i == index) {
                            System.out.println("Element Not Found");
                            break;
                        }
                    }
                }
            }
            
            public void Print_Hash_Table(){
                System.out.print("| ");
                for(int i=0;i<this.size;i++){
                    if(statues[i].equals("occupied"))System.out.print(hash_table[i]+" | ");
                    else System.out.print(statues[i]+" | ");
                }

            }
        }


