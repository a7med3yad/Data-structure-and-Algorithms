public class pointer{
    int info;
    pointer next;
    pointer prev;
    public pointer(){
        next=null;
        prev=null;
        info=0;
    }
    public pointer(int el, pointer n,pointer prev) {
        info = el;
        next = n;
        this.prev=prev;
    }
    public pointer(int el) {
        info = el;
    }
    
}
