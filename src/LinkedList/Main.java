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

        System.out.println("======================================");

        LinkedList myLinkedList3 = new LinkedList(1);
        myLinkedList3.append(3);

        System.out.println("LL before insert():");
        myLinkedList3.printList();

        myLinkedList3.insert(1, 2);

        System.out.println("\nLL after insert(2) in middle:");
        myLinkedList3.printList();

        myLinkedList3.insert(0, 0);

        System.out.println("\nLL after insert(0) at beginning:");
        myLinkedList3.printList();

        myLinkedList3.insert(4, 4);

        System.out.println("\nLL after insert(4) at end:");
        myLinkedList3.printList();




    }
}