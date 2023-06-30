package ub8;

public abstract class OpenHashMap<T> implements HashMap<T>{
  
  abstract int h(int key);
  abstract int s(int j, int key);
  
  public OpenHashMap(int size){
    m_n = 0;
    m_HashTable = new Element[size];
    for (int i = 0; i < size; i++){
      m_HashTable[i] = new Element(-1, null);
    }
  }
  
  private Element find(int key){
    int j = 0;
    int i;
    int hashValue = h(key);
    do{
      i = (hashValue - s(j, key)% getTableSize() + getTableSize()) % getTableSize();
      System.out.println("< " + s(j,key) );
      j++;
    } while (m_HashTable[i].m_zustand != Zustand.FREI && m_HashTable[i].m_key != key);
    if (m_HashTable[i].m_zustand == Zustand.BELEGT){
      assert m_HashTable[i].m_key == key;
      return m_HashTable[i];
    } else{
      return null;
    }
  }
  
  protected int getTableSize() {
    return m_HashTable.length;
  }
  
  public String toString(){
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < getTableSize(); i++){
      if (m_HashTable[i].m_key == -1)
        output.append(" leer ");
      else{
        if (m_HashTable[i].m_zustand == Zustand.ENTFERNT){
          output.append(" (" + m_HashTable[i].m_key + ") ");
        }else{
          output.append("  " + m_HashTable[i].m_key + "  ");
        }
      }
    }
    return output.toString();
  }
  
//***** interface HashMap ******************************************************
  
  public int getSize(){
    return m_n;
  }
  
  public boolean contains(int key){
    return find(key) != null;
  }
  
  public T get(int key){
    Element e  = find(key);
    if (e!=null) return e.m_data;
    return null;
  }
  
  public void put(int key, T data){
    // Vorbedingung: mindestens ein Platz ist noch frei
    Element e = find(key);
    if (e!=null){
      e.m_data = data;
      return;
    }else{
      int j = 0;
      int index;
      int hash = h(key);
      while(true){
        index = (hash - s(j++, key) + getTableSize()) % getTableSize();
        if (m_HashTable[index].m_zustand != Zustand.BELEGT){
          m_HashTable[index].m_key = key;
          m_HashTable[index].m_data = data;
          m_HashTable[index].m_zustand = Zustand.BELEGT;
          ++m_n;
          return;
        } 
      }
    }
  }
  
  public void remove(int key){
    Element e = find(key);
    if (e!=null){
      e.m_zustand = Zustand.ENTFERNT;
      --m_n;
    }
  }
  
  
//***** attributes, enums & nested classes *************************************
  
  private Element[] m_HashTable;
  private int m_n;                 // Anzahl der gespeicherten Elemente
  
  private static enum Zustand {
    FREI, BELEGT, ENTFERNT
  };
  
  private class Element {
    private T m_data;
    private int m_key;
    private Zustand m_zustand;
    
    public Element(int key, T data) {
      m_data = data;
      m_key = key;
      m_zustand = Zustand.FREI;
    }
  }

}
