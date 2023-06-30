package ub8.vorbereitung.offen

public class LinearHashMap<T> extends OpenHashMap<T>{
  
  public LinearHashMap(int size){
    super(size);
  }
  
  public int h(int key){
    return key % getTableSize();
  }
  
  public int s(int j, int key){
    return j;
  }

}
