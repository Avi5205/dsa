package LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    //    Adding items in a linked List
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //    Removing Last Item from Linked List
    public Node removeLast() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;

        // start at the head node
        Node temp = head;
        Node pre = head;
        // iterate through the linked list until the last node is reached
        while (temp.next != null) {
            pre = temp;  // keep track of the second-to-last node
            temp = temp.next;
        }
        // set the new tail node to be the second-to-last node
        tail = pre;
        // remove the reference to the former tail node
        tail.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set head and tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // return the removed node
        return temp;
    }

//    Adding value at starting of the list

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /*Remove First*/
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    //    Get value of the particular index
    public Node get(int index) {
        if (index < 0 || index > length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //    Set value of the particular index
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    //    Insert value in between the Linked List series
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    // Remove the node at the specified index in the list
    public Node remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) return null;
        // If the index is 0, remove the first node in the list
        if (index == 0) return removeFirst();
        // If the index is the last one in the list, remove the last node
        if (index == length - 1) return removeLast();

        // Get the previous node of the one to be removed
        Node prev = get(index - 1);
        // Get the node to be removed
        Node temp = prev.next;

        // Update the previous node's pointer to skip over the removed node
        prev.next = temp.next;
        // Detach the removed node from the list
        temp.next = null;
        // Decrease the length of the list
        length--;
        // Return the removed node
        return temp;
    }

    //    reverse the series
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    //    Find the Middle Node of the Linked List
    public Node findMiddleNode() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;
        }

        // Return the Node object representing the middle node of the linked list
        return slow;
    }

    //    Node class
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
