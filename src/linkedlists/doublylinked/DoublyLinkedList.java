package linkedlists.doublylinked;

public class DoublyLinkedList<T> {

    public class Node {
        public T data;
        public Node next;
        public Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    public Node head;

    DoublyLinkedList() {
        head = null;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data);
        newNode.prev = null;
        newNode.next = head;
        if(head != null) {
            head.prev = newNode;
            head = newNode;
        }
    }

    //deletes the first element
    public void deleteAtHead(){
        //if list is empty do nothing
        if(isEmpty())
            return;

        //if List is not empty then link head to the
        //nextElement of firstElement.
        head = head.next;
        head.prev = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public boolean deleteByValue(T input) {
        boolean deleted = false;
        if(isEmpty())
            return false;
        Node curr = head;
        if(curr.data == input) {
            deleteAtHead();
            return true;
        }
        while(curr != null) {
            if(curr.data == input) {
                curr.prev.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = curr.prev;
                deleted = true;
                break;
            }
            curr = curr.next;
        }
        return deleted;
    }
}
