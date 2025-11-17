class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }
}

public class MergeSortedLinkedList {
    public static LinkedList mergeLinkedList(LinkedList l1, LinkedList l2) {
        Node head1 = l1.getHead();
        Node head2 = l2.getHead();
        
        LinkedList mergedList = new LinkedList();
        
        if (head1 == null) return l2;
        if (head2 == null) return l1;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                mergedList.insert(head1.data);
                head1 = head1.next;
            } else {
                mergedList.insert(head2.data);
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            mergedList.insert(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            mergedList.insert(head2.data);
            head2 = head2.next;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);

        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        System.out.println("List 1:");
        list1.display();
        System.out.println("List 2:");
        list2.display();

        LinkedList mergedList = mergeLinkedList(list1, list2);
        System.out.println("Merged List:");
        mergedList.display();
    }
}
