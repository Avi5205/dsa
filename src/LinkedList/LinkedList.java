package LinkedList;

import java.util.HashSet;
import java.util.Set;

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

    public boolean hasLoop() {
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

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast) {
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
    }

    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }

    public void partitionList(int x) {
        // Return if the list is empty
        if (head == null) return;

        // Create two dummy nodes for the new lists
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Initialize pointers for the new lists
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Start iterating from the head
        Node current = head;

        // Iterate through the linked list
        while (current != null) {
            // Add nodes to the new lists
            // based on their value
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }

            // Move to the next node
            current = current.next;
        }

        // Mark the end of the second list
        prev2.next = null;

        // Connect the two new lists
        prev1.next = dummy2.next;

        // Update the head of the list
        head = dummy1.next;
    }

    public void removeDuplicates() {
        // Create a set to store unique values
        Set<Integer> values = new HashSet<>();

        // Initialize the previous node as null
        Node previous = null;

        // Start at the head of the linked list
        Node current = head;

        // Iterate through the list until the end
        while (current != null) {
            // Check if the value is a duplicate
            if (values.contains(current.value)) {
                // Remove the current node from the list
                previous.next = current.next;

                // Decrement the list length by 1
                length -= 1;
            } else {
                // Add the unique value to the set
                values.add(current.value);

                // Update previous to the current node
                previous = current;
            }
            // Move to the next node in the list
            current = current.next;
        }
    }

    public void removeDuplicates1() {
        // Start at the head of the linked list
        Node current = head;

        // Iterate through the list until the end
        while (current != null) {
            // Set runner to the current node
            Node runner = current;

            // Iterate through remaining nodes
            while (runner.next != null) {
                // Check if next value is a duplicate
                if (runner.next.value == current.value) {
                    // Remove duplicate node from the list
                    runner.next = runner.next.next;

                    // Decrement the list length by 1
                    length -= 1;
                } else {
                    // Move runner to the next node
                    runner = runner.next;
                }
            }

            // Move to the next node in the list
            current = current.next;
        }
    }

    public void reverseBetween(int m, int n) {
        // Check: If there are no nodes in our linked list,
        // there's nothing to reverse, so exit the method.
        if (head == null) return;

        // Create a new 'dummy' node that precedes the head of
        // our list. This helps simplify edge cases.
        Node dummy = new Node(0);
        dummy.next = head;

        // The 'prev' pointer is used to navigate to the node
        // that sits right before our sublist begins.
        Node prev = dummy;

        // Move the 'prev' pointer so that it points to the node
        // just before our sublist. This sets up our reversal.
        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }

        // 'current' will point to the first node of the sublist
        // we wish to reverse. It essentially marks the beginning.
        Node current = prev.next;

        // This loop is responsible for actually reversing the
        // specific section (from m to n) of our linked list.
        for (int i = 0; i < n - m; i++) {

            // 'temp' takes the reference of the next node in the
            // sublist after 'current'. It is essentially the node
            // that we're going to move to the start of the sublist.
            Node temp = current.next;

            // This line detaches 'temp' from its immediate
            // position, by making 'current' point to the node after
            // 'temp'. Think of this as temporarily "removing" the
            // 'temp' node from the chain.
            current.next = temp.next;

            // Now, we want to attach 'temp' at the beginning of the
            // sublist. To do so, we first make 'temp' point to
            // whatever 'prev' was pointing at (which is the
            // current start of the sublist).
            temp.next = prev.next;

            // Finally, we adjust 'prev's pointer to point to 'temp',
            // effectively moving 'temp' to the start of our sublist.
            // Now, the start of our sublist is changed to 'temp'.
            prev.next = temp;

            // Notice, with each iteration of the loop, we're taking
            // the next node and moving it to the front of our sublist,
            // hence reversing the order.
        }

        // After reversing, if 'm' was 0, meaning the head of the
        // original list was part of the sublist we reversed,
        // 'head' will no longer be the actual starting node.
        // So, we adjust 'head' to point to the starting node
        // after the reversal operation.
        head = dummy.next;
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
