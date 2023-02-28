package ch.fhnw.algd2.collections.bag;

import java.util.Arrays;

import ch.fhnw.algd2.collections.MyAbstractCollection;

public class UnsortedBag<E extends Comparable<E>> extends
        MyAbstractCollection<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private int capacity;
    private Object[] data;
    private int lastIndex;

    public UnsortedBag() {
        this(DEFAULT_CAPACITY);
    }

    public UnsortedBag(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        this.lastIndex = 0;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (lastIndex + 1 > capacity) {
            //resizeArray(true);
            throw new IllegalStateException();
        }
        data[lastIndex++] = e;
        return true;
    }

    private void resizeArray(boolean enlarge) {
        data = Arrays.copyOf(data,
                enlarge
                        ? data.length * 2
                        : data.length - data.length / 4
        );
        capacity = data.length;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        int i = 0;
        while (i < lastIndex && !data[i].equals(o)) i++;
        if (i == lastIndex) {
            return false;
        }
        data[i] = null;
        lastIndex--;
        while (i < lastIndex && data[i + 1] != null) {
            data[i] = data[++i];
        }
        if (lastIndex <= capacity / 2) {
            resizeArray(false);
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        int i = 0;
        while (i < lastIndex && !data[i].equals(o)) i++;
        return i < lastIndex;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size());
    }

    @Override
    public int size() {
        return lastIndex;
    }

    public static void main(String[] args) {
        UnsortedBag<Integer> bag = new UnsortedBag<Integer>();
        bag.add(2);
        bag.add(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }
}