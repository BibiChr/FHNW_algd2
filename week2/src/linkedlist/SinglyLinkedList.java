package linkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private int size;
    private Element<E> head;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public SinglyLinkedList(SinglyLinkedList<E> orig) {
        this.size = orig.size;
        this.head = new Element<>(orig.head);
    }


    public void insertFirst(E e) {
        Element<E> newElement = new Element<>(e, null);
        newElement.next = head;
        head = newElement;
        size++;
    }

    public void insertAfter(E e, int index) {
        checkIndexIsValid(index);

        Element<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next = new Element<>(e, current.next);
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
    }

    public void remove(int index) {
        checkIndexIsValid(index);

        if (index == 0) {
            head = head.next;
        } else {
            Element<E> current = head;
            int i = 0;
            while (i < index - 1) {
                current = current.next;
                i++;
            }

            current.next = current.next.next;
        }
        size--;
    }

    public void removeAll() {
        head = null;
        size = 0;
    }

    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.object;
    }

    public E get(int index) {
        checkIndexIsValid(index);
        Element<E> current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current.object;
    }

    public int size() {
        return size;
    }

    public String toString() {
        return "The list contains " + size + " elements.";
    }

    private void checkIndexIsValid(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Element<E> {
        E object;
        Element<E> next;

        Element(E object, Element<E> next) {
            this.object = object;
            this.next = next;
        }

        Element(Element<E> origin) {
            this.object = origin.object;
            this.next = origin.next != null ? new Element<>(origin.next) : null;
        }
    }

}
