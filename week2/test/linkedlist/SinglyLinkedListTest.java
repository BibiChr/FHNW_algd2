package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SinglyLinkedListTest {

    @Test
    public void testInsertFirst() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirst(1);
        assertEquals(1, (int) list.get(0));
        assertEquals(1, list.size());

        list.insertFirst(2);
        list.insertFirst(3);
        assertEquals(3, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void testGetFirst() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(0);

        assertEquals(0, (int) list.getFirst());
    }

    @Test
    public void testEmptyList() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void testInsertAfter() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirst(1);
        list.insertAfter(2, 0);
        list.insertAfter(3, 1);
        list.insertAfter(4, 2);
        list.insertAfter(5, 0);

        assertEquals(5, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(2));
        assertEquals(3, (int) list.get(3));
        assertEquals(4, (int) list.get(4));
        assertEquals(5, (int) list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAfterInvalidIndex() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insertAfter("invalid", 1);
    }

    @Test
    public void testCopy() {
        SinglyLinkedList<String> original = new SinglyLinkedList<>();
        original.insertFirst("first");
        original.insertAfter("second", 0);
        original.insertAfter("third", 1);

        SinglyLinkedList<String> copy = new SinglyLinkedList<>(original);

        assertNotEquals(original, copy);
        assertEquals(3, original.size());
        assertEquals(original.size(), copy.size());
        assertEquals(original.get(0), copy.get(0));
        assertEquals(original.get(1), copy.get(1));
        assertEquals(original.get(2), copy.get(2));
    }

    @Test
    public void testRemoveAll() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirst(1);
        list.insertAfter(2, 0);
        list.insertAfter(3, 1);

        list.removeAll();

        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveById() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirst(1);
        list.insertAfter(2, 0);
        list.insertAfter(3, 1);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
    }

    @Test
    public void testRemoveFirst() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirst(1);
        list.insertAfter(2, 0);
        list.insertAfter(3, 1);

        list.removeFirst();

        assertEquals(2, list.size());
        assertEquals(2, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
    }

    @Test
    public void testToString() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirst(1);
        list.insertAfter(2, 0);
        list.insertAfter(3, 1);

        assertEquals("The list contains 3 elements.", list.toString());
    }


}