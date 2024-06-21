package linkedlists.singlylinked;

import java.util.HashMap;
import java.util.Map;

public class SinglyLinkedList<T> {

    public class Node<T> {
        public T data;
        public Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> headNode;

    SinglyLinkedList() {
        headNode = null;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node<T> newNode = new Node<>(data);
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
    }

    public Node<T> insertAtTail(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.nextNode = null;
        if(headNode == null)
        {
            return newNode;
        }
        else {
            Node<T> current = headNode;
            while(current.nextNode != null)
                current = current.nextNode;
            current.nextNode = newNode;
        }
        return headNode;
    }

    public void insertAfter(T data, T previous) {

        //Creating a new Node with value data
        Node newNode = new Node(data);
        //Start from head node
        Node currentNode = this.headNode;
        //traverse the list until node having data equal to previous is found
        while (currentNode != null && !currentNode.data.equals(previous)) {
            currentNode = currentNode.nextNode;
        }
        //if such a node was found
        //then point our newNode to currentNode's nextElement
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
        }
    }

    public boolean searchNodeIterative(T value) {

        //Start from first element
        Node currentNode = headNode;

        //Traverse the list till you reach end
        while (currentNode != null) {

            if (currentNode.data == value) return true; //value found
            currentNode = currentNode.nextNode;
        }
        return false; //value not found
    }

    public boolean searchNodeRecursive(Node node, T value) {

        // Base case
        if (node == null) {
            return false;  // Value not found
        }

        // Check if the node's data matches our value
        if (node.data == value) {
            return true;  // Value found
        }

        // Recursive call to next node in the list
        return searchNodeRecursive(node.nextNode, value);
    }

    public boolean deleteByValue(T value) {
        boolean deleted = false;

        Node <T> current = headNode;
        Node <T> previous = null;
        // Check if the value to delete is in the head node
        if (current.data == value) {
            headNode = headNode.nextNode;
            return true;
        }

        // Traverse the linked list to find the node with the given value
        while (current != null) {
            if (value == current.data) { // If the value is found
                previous.nextNode = current.nextNode;
                current.nextNode = null;
                deleted = true;
                break;
            }
            previous = current;
            current = current.nextNode;
        }
        return deleted;
    }

    /*Tortoise And Hare Method to find middle in single traversal*/
    public Node findMiddle() {
        Node tortoise = headNode;
        Node hare = headNode;
        while(hare != null && hare.nextNode != null && tortoise != null) {
            hare = hare.nextNode.nextNode; // move 2 step
            tortoise = tortoise.nextNode; //move 1 step
        }
        return tortoise;
    }

    /* Time and space complexity O(n) */
    public boolean detectLoopIterative() {
        // Initialize a pointer 'temp'
        // at the head of the linked list
        Node temp = headNode;

        // Create a map to keep track
        // of encountered nodes
        Map<Node, Integer> nodeMap = new HashMap<>();

        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in
            // the map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node in the map
            nodeMap.put(temp, 1);
            // Move to the next node
            temp = temp.nextNode;
        }

        // Step 3: If the list is successfully
        // traversed without a loop, return false
        return false;
    }

    /*the proof lies in this iterative process
    where the faster rate of the fast pointer
    leads to a continual decrease in the gap distance,
    ultimately resulting in their collision within the
    looped linked list. Floyd's cycle finding algorithm.
    */
    public boolean detectLoopTortoiseHare() {
        Node fast = headNode;
        Node slow = headNode;
        while(fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;

            if(fast == slow)
                return true;
        }

        return false;
    }

    /*
     *
     *
     */
    public Node detectStartingPointOfLoopTortoiseAndHare() {
        Node fast = headNode;
        Node slow = headNode;

        while(fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
            if(fast == slow) {
                slow = headNode;
                while(fast != slow)
                {
                    slow = slow.nextNode;
                    fast = fast.nextNode;
                }
                return slow;
            }
        }
        return null;
    }

    //TODO: reverse using recursion, medium and hard random problems to solve.
    // TODO: delete duplicates in linear time, using hashset
    public void reverseLLUsing3Pointer() {
        Node curr = headNode;
        Node prev = null;

        while(curr != null) {
            Node front = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = front;
        }
        headNode = prev;
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }



}
