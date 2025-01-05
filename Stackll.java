public class Stackll {
    private Node top;

    public void push(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            newNode.next=null;
        }
        else{
            newNode.next=top;
        }
        top=newNode;
    }
    public void pop(){
        if(isEmpty())return;
        top = top.next;
    }
    public boolean isEmpty(){
        return top==null;
    }
    public int Top(){
        if(isEmpty())return -1;
        return top.info;
    }
    public void print_Stack(){
        if(isEmpty())return;
        Node tmp = top;
        while(tmp!=null){
            System.out.println(tmp.info);
            tmp=tmp.next;
        }
    }

}
