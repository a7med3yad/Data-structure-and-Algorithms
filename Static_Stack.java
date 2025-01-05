public class Static_Stack{
    @SuppressWarnings("FieldMayBeFinal")
    private int[] StaticStack;
    private int top;

    public Static_Stack(int Cap) {
        StaticStack =new int[Cap];
        top =-1;
    }
    public void Top(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Top = "+StaticStack[top]);
    }
    public void insert(int num){
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        StaticStack[++top]=num;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return StaticStack[top--];
    }
    public boolean isFull(){
        return top==StaticStack.length-1;
    }  
    public boolean isEmpty(){
        return top==-1;
    }
    public int Size(){
        return top+1;
    }
    public void printStack(){
        int i=top;
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        while(i!=-1){
            System.out.print(StaticStack[i--]+" ");
        }
        System.out.println();
    }
}