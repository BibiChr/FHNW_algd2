package ub2.Lösung//******************************************************************************
//  FHNW.ALGD2  -  Excercise 2.2 : Stack                                       *
// --------------------------------------------------------------------------- *
//  verionn 2                                                              vtg *
//******************************************************************************

public class Stack<E> {
  
  public Stack(){
    list = new SinglyLinkedList<E>();
  }
  
//***** API ********************************************************************
  public void push(E e){
    list.insertFirst(e);;
  }
  
  public E top(){
    return list.getFirst();
  }
  
  public E pop(){
    E result = list.getFirst();
    list.removeFirst();
    return result;
  }
  
  public boolean isEmpty(){
    return (list.size() == 0);
  }
  
  // additional method to show stack contents
  public void show(String name){
    System.out.print(name + " : ");
    System.out.println(list);
  }
  
//***** attributes *************************************************************
  private SinglyLinkedList<E> list;

}
