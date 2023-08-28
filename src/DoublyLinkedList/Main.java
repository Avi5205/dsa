package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(7);
        dll.append(2);

        dll.prepend(1);

        dll.printList();
    }
}
