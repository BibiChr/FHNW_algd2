package ub7;
/**
 * PriorityQueue with updatePriority and item concept.
 * Makes use of a min heap.
 * 
 * @author Christoph Stamm
 */

import java.util.*;

public class PQueue<E extends Comparable<E>> {
    public static class PQItem<E extends Comparable<E>> implements Comparable<PQItem<E>> {
        private E m_data;
        private int m_index;
        
        public PQItem(E data, int index) {
            m_data = data;
            m_index = index;
        }
        
        public int compareTo(PQItem<E> item) {
            return m_data.compareTo(item.m_data);
        }
        
        public E getData() {
            return m_data;
        }
        
        public void setIndex(int index) {
            m_index = index;
        }
        
        public int getIndex() {
            return m_index;
        }
    }
    
    private ArrayList<PQItem<E>> m_array;
    
    public PQueue() {
        m_array = new ArrayList<PQItem<E>>();
    }
    
    /**
     * O(n)
     */
    public PQueue(Collection<? extends E> c) {
        m_array = new ArrayList<PQItem<E>>(c.size());
        
        // copy elements
        int j = 0;
        for(E e: c) {
            m_array.add(new PQItem(e, j++));
        }
      
    	// create heap
    	final int s = m_array.size();
    	int l2 = s/2 - 1;
    	for (int i = l2; i >= 0; i--) {
    	    siftDown(i);
    	}
    }
    
    public int size() {
        return m_array.size();
    }
    
    public boolean isEmpty() {
        return m_array.isEmpty();
    }
    
    /**
     * O(log n)
     */
    public PQItem<E> add(E data) {
        int s = size();
        PQItem<E> item = new PQItem(data, s);
        m_array.add(item);
        siftUp(s);
        return item;
    }
    
    /**
     * O(log n)
     */
    public E removeFirst() {
        int size = size();
        if (size == 0) return null;
        if (size == 1) return m_array.remove(0).getData();
            
		int last = size - 1;
		// swap a[first] with a[last]
		PQItem<E> t = m_array.get(0); 
        E data = t.getData();
		set(0, m_array.get(last)); 
		set(last, t);
		// remove last
		m_array.remove(last);
		// heapify
		siftDown(0);
        return data;
    }
    
    public void clear() {
        m_array.clear();
    }
    
    public PQItem<E> getItem(int i) {
        return (i >= 0 && i < size()) ? m_array.get(i) : null;
    }
    
    public PQItem<E> getFirstItem() {
        return getItem(0);
    }
    
    public PQItem<E> getNextItem(PQItem<E> item) {
        if (item == null) return null;
        int index = item.getIndex() + 1;
        return (index < size()) ? m_array.get(index) : null;
    }
    
    /**
     * O(log n)
     */
    public void updatePriority(PQItem<E> item) {
        int pos = item.getIndex();
        if (pos > 0) {
            // check heap condition at parent
            int par = (pos - 1)/2;
    		if (m_array.get(par).compareTo(m_array.get(pos)) > 0) {
                siftUp(pos);
                return;
            }
        }
        int son = pos*2 + 1;
        if (son < size()) {
            // check heap condition at son
    		if (m_array.get(pos).compareTo(m_array.get(son)) > 0) {
                siftDown(pos);
            }        
        }
    }
    
    private int set(int pos, PQItem<E> item) {
        int oldIndex = item.getIndex();
        item.setIndex(pos);
        m_array.set(pos, item);
        return oldIndex;
    }
    
    /**
     * sift down at position pos.
     * O(log n)
     */
    private void siftDown(int pos) {
        final int end = size() - 1;
    	int son = pos*2 + 1;
    	
    	while (son <= end) {
    		// son ist der linke Sohn
    		if (son < end) {
    			// pos hat auch einen rechten Sohn
    			if (m_array.get(son).compareTo(m_array.get(son + 1)) > 0) son++;
    		}
    		// son ist der grössere Sohn
    		if (m_array.get(pos).compareTo(m_array.get(son)) > 0) {
	    		// swap a[pos] with a[son]
				PQItem<E> t = m_array.get(pos); 
				set(pos, m_array.get(son)); 
				set(son, t);
				pos = son;
				son = 2*pos + 1;
    		} else {
    			return;
    		}
    	}
    }
    
    /**
     * sift up at position pos
     * O(log n)
     */
    private void siftUp(int pos) {
        int par = (pos - 1)/2; // parent
        
        while(par >= 0) {
    		if (m_array.get(par).compareTo(m_array.get(pos)) > 0) {
	    		// swap a[par] with a[pos]
				PQItem<E> t = m_array.get(par); 
				set(par, m_array.get(pos)); 
				set(pos, t);
				pos = par;
				par = (pos - 1)/2;
    		} else {
    			return;
    		}            
        }
    }
}
