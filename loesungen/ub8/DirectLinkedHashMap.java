package ub8;

import java.util.*;

public class DirectLinkedHashMap<T> implements HashMap<T>{
  
  

  public DirectLinkedHashMap(int size){
    m_m = size;
    m_HashTable = (LinkedList<Element>[])new LinkedList[size];
    for (int i=0; i<size; ++i){
      m_HashTable[i] = new LinkedList<Element>();
    }
  }
  
  private int h(int key){
    return key % m_m;
  }
  
  public String toString(){
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < m_m; i++){
      output.append("[Index " + i + ", Elemente:");
      for (Element element : (LinkedList<Element>)m_HashTable[i]){
        output.append("  " + element.m_key);
      }
      output.append(".\n");
    }
    output.delete(output.length() - 2, output.length());
    return output.toString();
  }
  
//***** interface HashMap ******************************************************
  
  public int getSize(){
    return m_size;
  }
  
  public boolean contains(int key){
    for (Element e : m_HashTable[h(key)]){
      if (e.m_key == key)
        return true;
    }
    return false;
  }
  
  public T get(int key){
    for (Element e : m_HashTable[h(key)]){
      if (e.m_key == key)
        return e.m_data;
    }
    return null;
  }
  
  public void put(int key, T data){
    for (Element e : m_HashTable[h(key)]){
      if (e.m_key == key){
        e.m_data = data;
        return;
      }
    }
    ++m_size;
    m_HashTable[h(key)].add(new Element(key, data));
  }
  
  public void remove(int key){
    for (Element e : m_HashTable[h(key)]){
      if (e.m_key == key){
        m_HashTable[h(key)].remove(new Element(key, null));
        --m_size;
        return;
      }
    }
  }
  
  
//***** attributes & nested classes ********************************************
  private class Element {
    private T m_data;
    private Integer m_key;
    public Element(int key, T data) {
      m_data = data;
      m_key = key;
    }
    
    public boolean equals(Object o) {
      return m_key.equals(((Element)o).m_key);
    }
  }
  
  private LinkedList<Element>[] m_HashTable;
  private int m_m;
  private int m_size = 0;
  
}
