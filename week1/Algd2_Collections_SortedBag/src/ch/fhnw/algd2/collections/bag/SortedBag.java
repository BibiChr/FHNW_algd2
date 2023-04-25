package ch.fhnw.algd2.collections.bag; 

import java.util.Arrays;

import ch.fhnw.algd2.collections.MyAbstractCollection2;

public class SortedBag<E extends Comparable<E>> extends MyAbstractCollection2<E> {

	public static final int DEFAULT_CAPACITY = 100;
	private int capacity;
	private Object[] data;

	public SortedBag() {
		this(DEFAULT_CAPACITY);
	}

	public SortedBag(int capacity) {
		this.capacity = capacity;
		data = new Object[capacity];
	}

	@Override
	public boolean add(E e) {
		return  true;
	}

	@Override
	public boolean remove(Object o) {
		return true;
	}

	@Override
	public boolean contains(Object o) {	return true;
	}


	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size());
	}

	@Override
	public int size() { return 0;
	}

	public static void main(String[] args) {
		SortedBag<Integer> bag = new SortedBag<Integer>();
		bag.add(2);
		bag.add(1);
		System.out.println(Arrays.toString(bag.toArray()));
	}

}
