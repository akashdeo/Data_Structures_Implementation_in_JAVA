package doublylinkedlist;

/**
 *
 * @author akash
 */
class Link {

    Link left;
    int data1;
    int data2;
    Link right;

    public Link(int d1, int d2) {
        data1 = d1;
        data2 = d2;
    }

    void printLink() {
        System.out.println(data1 + " " + data2);
    }
}

public class DoublyLinkedList {

    /**
     * @param args the command line arguments
     */
    private Link first;

    public DoublyLinkedList() {
        first = null;

    }

    void insertFirst(Link d) {
        Link currentLink = first;
        if (first == null) {

            first = d;
            d.right = null;
        } else {

            d.right = currentLink;
            currentLink.left = d;
            first = d;

        }
    }

    void insertLast(Link d) {
        if (first == null) {
            first = d;
            d.right = null;
            //  return;
        } else {
            Link currentLink = first;
            Link previousLink = first;
            while (currentLink != null) {
                previousLink = currentLink;
                currentLink = currentLink.right;
            }
            previousLink.right = d;
            d.left = previousLink;
            d.right = null;
        }
    }

    void insertAtPos(int pos, Link d) {
        int i = 0;
        Link currentLink = first;
        Link previousLink = first;
        if (first == null) {
            first = d;
            d.right = null;
        } else {
            while (i < pos) {
                previousLink = currentLink;
                currentLink = currentLink.right;
                i++;
            }
            previousLink.right = d;
            d.left = previousLink;
            d.right = currentLink;
            currentLink.left = d.right;
        }
    }

    Link deleteFirst() {
        Link del = first;
        if (first == null) {
            System.out.println("No data in the list");

        } else {
            Link currentLink = first;
            currentLink.left = null;
            first = currentLink.right;

        }
        return del;
    }

    Link deleteLast() {
        Link del = first;
        Link currentLink = first;
        Link previousLink = first;

        if (first == null) {
            System.out.println("No data to delete");
            return del;
        } else {
            if (currentLink.right == null) {
                currentLink.left = null;
                first = null;
            } else {
                while (currentLink.right != null) {
                    previousLink = currentLink;
                    currentLink = currentLink.right;
                }

                previousLink.right = null;
            }
        }
        return del;
    }

    Link deleteAtPos(int pos) {
        int i = 0;
        Link del = first;
        if (first == null) {
            System.out.println("No element to delete");
        } else {
            Link currentLink = first;
            Link previousLink = first;
            while (i < pos) {
                previousLink = currentLink;
                currentLink = currentLink.right;
                i++;
            }
            previousLink.right = currentLink.right;

        }
        return del;
    }

    Link updateAtPos(int pos, Link d) {
        Link del = first;
        Link currentLink = first;
        Link previousLink = first;
        int i = 0;
        while (i < pos) {

            currentLink = currentLink.right;
            i++;
        }
        currentLink.data1 = d.data1;
        currentLink.data2 = d.data2;
        return del;

    }

    void printList() {
        System.out.println("List:");
        Link currentLink = first;
        while (currentLink != null) {
            System.out.println(currentLink.data1 + " " + currentLink.data2);
            currentLink = currentLink.right;

        }
        System.out.println("---------");
    }
    
    void printReverse() {
        System.out.println("Reverse");
        Link ptr = first;
        while(ptr.right != null)
            ptr = ptr.right;
        while(ptr.left != null) {
            System.out.println("data: " + ptr.data1 + "-" + ptr.data2);
            ptr = ptr.left;
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {

        Link l1 = new Link(1, 2);
        Link l2 = new Link(3, 4);
        Link l3 = new Link(5, 6);
        Link l4 = new Link(7, 8);
        Link l5=new Link(5,6);
        DoublyLinkedList d = new DoublyLinkedList();
        d.insertFirst(l1);
            //d.printList();
        d.insertFirst(l2);
            //d.printList();
        d.insertFirst(l3);
            //d.printList();
        d.deleteFirst();
            //d.printList();
        d.insertLast(l4);
            //d.printList();
            //d.printReverse();
        d.deleteLast();
            //d.printList();
            //.printReverse();
        //d.deleteLast();
        //d.deleteLast();
        d.insertAtPos(1, l5);
        //   d.deleteAtPos(1);
        //d.updateAtPos(1, l3);
        d.printList();
    }

}
