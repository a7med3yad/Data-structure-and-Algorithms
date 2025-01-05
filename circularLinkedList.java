public class circularLinkedList {
    Node next;
    int info;
    private Node head;
    private Node tail;
    
    public void printlist(){
        Node tmp=head;
        while(tmp.next!=head){
            System.out.println(tmp.info);
            tmp=tmp.next;
        }
    }
}
