package ch.fhnw.algd2.collections.bag; 

import java.util.Arrays;

import ch.fhnw.algd2.collections.MyAbstractCollection;

public class UnsortedBag<E extends Comparable<E>> extends
		MyAbstractCollection<E> {

	public static final int DEFAULT_CAPACITY = 100;
	private int capacity;
	private Object[] data;

	public UnsortedBag() {
		this(DEFAULT_CAPACITY);
	}

	public UnsortedBag(int capacity) {
		this.capacity = capacity;
		data = new Object[capacity];
	}

	@Override
	public boolean add(E e) {
	}

	@Override
	public boolean remove(Object o) {
	}

	@Override
	public boolean contains(Object o) {
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size());
	}

	@Override
	public int size() {
		
	}

	public static void main(String[] args) {
		UnsortedBag<Integer> bag = new UnsortedBag<Integer>();
		bag.add(2);
		bag.add(1);
		System.out.println(Arrays.toString(bag.toArray()));
	}

}
