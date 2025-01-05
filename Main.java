
public class Main {

    public static void main(String[] args) {
       // initializeSieve();
       BST b =new BST();
       b.add(3);
       b.add(1);
       b.add(2);
       b.add(4);
       b.add(5);
       b.display_InOrder();

        
        
       
    }
    
   /*  public static void initializeSieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= isPrime.length - 1; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= isPrime.length - 1; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int nextPrime(int n) {
        int candidate = n + 1;
        while (!isPrime[candidate]) {
            candidate++;
        }
        return candidate;
    }*/
}
