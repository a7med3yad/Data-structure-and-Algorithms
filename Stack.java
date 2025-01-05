public class Stack {
    private pointer head;
    int cnt=0;
    public boolean isEmpty(){
        return head==null;
    }
    public void insert(int n){
        pointer newpointer= new pointer(n);
        if(isEmpty()){
            head=newpointer;
            cnt++;
            return;
        }
        newpointer.prev=head;
        head=newpointer;
        cnt++;
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        if(head.prev ==null && head.next==null){
            head=null;
            
        }
        else{
            head=head.prev;
            head.next=null;
        }
        cnt--;
    }
    public void print_Stack(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return ;
        }
        pointer tmp = head;
        while(tmp!=null){
            System.out.print(tmp.info+" ");
            tmp=tmp.prev;
        }
        System.out.println();
    }
    public void top(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println("Top = "+head.info);
        }
    }
    public int Size(){
        return cnt;
    }
}
