//public class DoubleHashMap<T> extends OpenHashMap<T>{
//
//  public DoubleHashMap(int size){
//    super(size);
//  }
//
//  public int h(int key){
//    return key % getTableSize();
//  }
//
//  public int s(int j, int key){
//    return j * ((key % (getTableSize() - 2)) + 1);
//  }
//
//}