package stack;

import linkedlist.SinglyLinkedList;

import java.util.NoSuchElementException;

public class Stack<T> {

    private final SinglyLinkedList<T> list;

    Stack() {
        this.list = new SinglyLinkedList<>();
    }

    public T top() {
        // liest die Daten des obersten Elementes
        try {
            return list.getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }


    public void push(T data) {
        // legt neue Daten auf den Stapel
        list.insertFirst(data);
    }

    public T pop() {
        //löscht das oberste Element des Stapels und gibt den Inhalt zurück
        try {
            var elem = list.getFirst();
            list.removeFirst();
            return elem;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean isEmpty() {
        //gibt true zurück, wenn der Stapel leer ist
        return list.size() == 0;
    }

}
