package LinkedList;

public class Main {
    public static void main(String[] args) {
//        LinkedList myLinkedList = new LinkedList(2);
//
////        myLinkedList.getHead();
////        myLinkedList.getTail();
////        myLinkedList.getLength();
//
//        myLinkedList.append(4);
//        myLinkedList.append(6);
//        myLinkedList.append(8);
////        myLinkedList.removeFirst();
//
////        System.out.println( myLinkedList.removeLast().value);
////        System.out.println( myLinkedList.removeLast().value);
////        System.out.println( myLinkedList.removeLast());
//
////        System.out.println( myLinkedList.removeFirst().value);
////        System.out.println( myLinkedList.removeFirst().value);
////        System.out.println( myLinkedList.removeFirst());
//
//        System.out.println(myLinkedList.get(1).value );
//
//        System.out.println("\nLinked List:");
//        myLinkedList.printList();
//
//        System.out.println("===================================");
//
//
//        LinkedList myLinkedList1 = new LinkedList(0);
//        myLinkedList1.append(1);
//        myLinkedList1.append(2);
//        myLinkedList1.append(3);
//
//        System.out.println("Linked List before set():");
//        myLinkedList1.printList();
//
//        myLinkedList1.set(2, 99);
//
//        System.out.println("\nLinked List after set():");
//        myLinkedList1.printList();

//        System.out.println("======================================");
//
//        LinkedList myLinkedList3 = new LinkedList(1);
//        myLinkedList3.append(3);
//
//        System.out.println("LL before insert():");
//        myLinkedList3.printList();
//
//        myLinkedList3.insert(1, 2);
//
//        System.out.println("\nLL after insert(2) in middle:");
//        myLinkedList3.printList();
//
//        myLinkedList3.insert(0, 0);
//
//        System.out.println("\nLL after insert(0) at beginning:");
//        myLinkedList3.printList();
//
//        myLinkedList3.insert(4, 4);
//
//        System.out.println("\nLL after insert(4) at end:");
//        myLinkedList3.printList();

//
//        LinkedList myLinkedList = new LinkedList(1);
//        myLinkedList.append(2);
//        myLinkedList.append(3);
//        myLinkedList.append(4);
//        myLinkedList.append(5);
//
//        System.out.println("\nLinked List:");
//        myLinkedList.printList();
//
//        System.out.println("Middle Node:");
//        System.out.println( myLinkedList.findMiddleNode().value);
//
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            Middle Node:
//            3
//
//        */
//
//        // create a loop by connecting the tail to the second node
//       // myLinkedList.getTail().next = myLinkedList.getHead().next;
//
//
//        System.out.println("Has Loop:");
//        System.out.println( myLinkedList.hasLoop());
//
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            Has Loop:
//            true
//
//        */
//
//        int k = 2;
//        int result = myLinkedList.findKthFromEnd(k).value;
//
//        System.out.println(result); // Output: 4
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            4
//
//        */

        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);

        // Print the list before partitioning
        System.out.println("LL before partitionList:");
        ll.printList(); // Output: 3 5 8 10 2 1

        // Call the partitionList method with x = 5
        ll.partitionList(5);

        // Print the list after partitioning
        System.out.println("\nLL after partitionList:");
        ll.printList(); // Output: 3 2 1 5 8 10

        /*
            EXPECTED OUTPUT:
            ----------------
            LL before partition_list:
            3
            5
            8
            10
            2
            1

            LL after partition_list:
            3
            2
            1
            5
            8
            10

        */


    }
}
