public class Main {
    public static void main(String[] args) throws Exception {
           //Scanner cs =new Scanner(System.in);
        //int m=cs.nextInt();
       System.out.println("############ Doubly Linked List ###########");
       DoublyLinkedList d=new DoublyLinkedList();
       d.insertToHead(1);
       d.insertToHead(2);
       d.insertAt(1, 5);
       d.printList();
       System.out.println("The element 5 is Exist : "+d.isExist(5));
       System.out.println("The element 6 is Exist : "+d.isExist(6));
       d.insertToTail(18);
       d.insertToTail(29);
       d.printList();
       d.delete(5);
       d.printList();
       d.deleteFromHead();
       d.printList();
       ///////////////////////////////////////////////////////////////
       SinglyLinkedList s=new SinglyLinkedList();

       System.out.println("############ Singly Linked List ###########");
       s.insertToHead(1);
       s.insertToHead(2);
       s.printLinkedList();
       System.out.println("The element 5 is Exist : "+s.isInList(5));
       System.out.println("The element 6 is Exist : "+s.isInList(6));
       s.insertToTail(18);
       s.insertToTail(29);
       s.printLinkedList();
       s.deleteNode(29);
       s.printLinkedList();
       s.deleteFromHead();
       s.printLinkedList();
       
    }
}
