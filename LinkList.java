/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author akash
 */
class Link {

    int data1;
    int data2;
    Link next;

    public Link(int d1, int d2) {
        data1 = d1;
        data2 = d2;

    }

    public void printLink() {
        System.out.println(data1 + " " + data2);
    }

}

public class LinkList {

    private Link first;

    LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(Link d) {

        d.next = first;
        first = d;
    }

    public void insertAtLast(Link d) {
        Link previousLink = first;
        Link currentLink = first;
        if (first == null) {
            d.next = first;
            first = d;
        } else {
            while (currentLink != null) {
                previousLink = currentLink;
                currentLink = currentLink.next;

            }
            currentLink = d;
            previousLink.next = currentLink;
            currentLink.next = null;
        }
    }

    void insertAtPosition(Link d, int pos) {
        Link currentLink = first;
        int i = 0;
        while (i < pos - 1) {
            currentLink = currentLink.next;
            i++;
        }
        d.next = currentLink.next;
        currentLink.next = d;

    }

    Link deleteFirst() {
        Link del = first;
        if (first == null) {
            return null;
            //throw new NoSuchElementException();
        }

        first = first.next;
        return del;
    }

    Link deleteLast() {
        Link del = first;
        if (first == null) {
            del = null;
        }
        Link f = first.next;
        if (f.next == null) {
            del = f.next;
        }
        Link currentLink = first;
        Link prevToPrevLink = first;
        Link prev = first;
        Link previousLink = first;
        while (currentLink != null) {
            previousLink = currentLink;
            currentLink = currentLink.next;
        }
        while (prevToPrevLink != previousLink) {
            prev = prevToPrevLink;
            prevToPrevLink = prevToPrevLink.next;
        }
        prev.next = null;

        return del;

    }

    Link deleteAtPosition(int pos) {
        Link del = first;
        int i = 0;
        Link currentLink = first;
        while (i < pos - 1) {
            currentLink = currentLink.next;
            i++;
        }
        Link l = currentLink.next;
        Link p = l.next;
        currentLink.next = p;
        l.next = null;
        return del;
    }

    public void printList() {
        Link currentLink = first;
        while (currentLink != null) {
            currentLink.printLink();
            currentLink = currentLink.next;
        }
    }

    public static void main(String[] args) {
        Link l1 = new Link(1, 2);
        Link l2 = new Link(3, 3);
        Link l3 = new Link(4, 5);
        Link l4 = new Link(5, 6);
        Link l5 = new Link(1, 1);
        LinkList a = new LinkList();
        a.insertFirst(l1);

        a.deleteFirst();

        a.insertAtLast(l4);
        //a.deleteAtPosition(1);

        a.insertAtPosition(l5, 1);
        a.printList();
    }
}
