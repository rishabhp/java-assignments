import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        int choice, data;

        do {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Display List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at beginning: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    list.deleteFromBeginning();
                    break;
                case 4:
                    list.deleteFromEnd();
                    break;
                case 5:
                    System.out.println("List contents: ");
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
