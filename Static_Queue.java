public class Static_Queue{
    @SuppressWarnings("FieldMayBeFinal")
    private int[]StaticQueue;
    private int rear ,front;
    @SuppressWarnings("FieldMayBeFinal")
    private int Capacity;
    public Static_Queue(int Capacity) {
        this.Capacity=Capacity;
        StaticQueue=new int[Capacity];
        front=0;rear=-1;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        rear=(rear+1)%Capacity;
        StaticQueue[rear]=data;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int data = StaticQueue[front];
        front = (front+1)%Capacity;
        return data;
    }
    public void print_Queue(){
        int i =front;
        while((i + Capacity) % Capacity != rear){
            System.out.print(StaticQueue[i]+" ");
            i=(i+1)%Capacity;
        }
        System.out.println(StaticQueue[i]);
    }
    public boolean isEmpty(){
        return (rear-front+1+Capacity)%Capacity==0;
    }

    public boolean isFull(){
        return rear==Capacity-1;
    }
    public int count() {
        return (rear - front + 1 + Capacity) % Capacity;
    }
    
}