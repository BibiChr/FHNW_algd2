package mergesort;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ComparableList<T> {
    private Element<T> head;
    private Element<T> tail;
    private int count = 0;

    public ComparableList() {
        head = new Element<>();
        tail = new Element<>();
        head.next = tail;
    }

    public int size() {
        return count;
    }

    public void addHead(T object) {
        Element<T> newElement = new Element<>();
        newElement.object = object;
        newElement.before = head;
        newElement.next = head.next;
        head.next = newElement;
        ++count;
    }

    public void addTail(T object) {
        Element<T> newElement = new Element<>();
        newElement.object = object;
        newElement.before = tail.before;
        newElement.next = tail;
        tail.before.next = newElement;
        ++count;
    }

    public T removeHead(T object) {
        if (head.next != tail) {
            head.next = head.next.next;
            head.next.before = head;
        }
        return head.next.object;
    }

    public T removeTail(T object) {
        if (head.next != tail) {
            tail.before = tail.before.before;
            tail.before.next = tail;
        }
        return tail.before.object;
    }

    @Override
    public String toString() {
        String result = "";
        Element<T> current = head.next;
        while (current != tail) {
            result += current.object.toString() + " ";
            current = current.next;
        }
        return result;
    }

    private void remove(Element<T> returned) {
    //todo
    }

    private static class Element<T> {
        T object;
        Element<T> next;
        Element<T> before;

        Element() {
            this.object = null;
            this.next = null;
            this.before = null;
        }

        Element(T object, Element<T> next, Element<T> before) {
            this.object = object;
            this.next = next;
            this.before = before;
        }

        @Override
        public String toString() {
            return "before: " + before.object + "\n"
                    + "object: " + object + "\n"
                    + "next: " + next + "\n";
        }

    }

    private class CListIterator implements ListIterator<T> {

        //Die Exception IllegalStateException wird dann geworfen, wenn der Iterator nicht in einem gültigen
        //Zustand ist, um zum Beispiel die Methode remove() auszuführen (studieren Sie dazu die Details in der
        //Java-Dokumentation zu ListIterator).

        private Element<T> next;
        private Element<T> returned;
        private int index;
        private int version;

        public CListIterator() {
            next = head.next;
            returned = null;
            index = 0;
            version = 0;
        }

        @Override
        public boolean hasNext() {
            return next != null && next != tail;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            returned = next;
            next = next.next;
            index++;
            return returned.object;
        }

        @Override
        public boolean hasPrevious() {
            return returned.before != head;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            returned = returned.before;
            next = returned.next;
            index--;
            return returned.object;
        }

        @Override
        public int nextIndex() {
            return index+1;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {
            if (returned == null) {
                throw new IllegalStateException();
            } else {
                if (returned == next) {
                    next = returned.next;
                } else index--;
                ComparableList.this.remove(returned);
                returned = null;
            }
        }

        @Override
        public void set(T object) {
            if (returned == null)
                throw new IllegalStateException();
            else {
                if (!(object instanceof Comparable<?>)) {
                    throw new IllegalArgumentException();
                }
                returned.object = object;
            }
        }

        @Override
        public void add(T t) {

        }
    }

}
