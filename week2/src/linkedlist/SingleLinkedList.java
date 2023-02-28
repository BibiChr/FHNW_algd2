package linkedlist;

public class SingleLinkedList {

    private Element head;

    public Element get(int index) {
        //for(int i = 0; i < )
        return new Element(0, null);
    }

    public boolean delete(int key) {
        Element before = null;
        Element current = head;

        while (current != null && current.data != key) {
            before = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (before != null) {
            before.next = current.next;
        } else {
            head = current.next;
        }
        return true;
    }

    public boolean del1(int key) {
        Element current = head;
        Element before = null;
        while (current != null) {
            if (current.data == key) {
                if (before != null) {
                    before.next = current.next;
                } else {
                    head = null;
                }
                return true;
            }
            before = current;
            current = current.next;
        }
        return false;
    }

    public boolean del2(int key) {
        Element current = head;
        if (current != null) {
            if (current.data == key) {
                head = null;
                return true;
            }
            while (current.next != null) {
                if (current.next.data == key) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public boolean exists(int key) {
        Element current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void prepend(int data) {
        Element r = new Element(data, null);
        r.next = head;
        head = r;
    }

    void append(int key) {
        Element last = head;
        if (last != null) {
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Element(key, null);
        } else {
            head = new Element(key, null);
        }
    }

    private static class Element {
        int data;
        Element next;

        Element(int data, Element next) {
            this.data = data;
            this.next = next;
        }
    }

}
