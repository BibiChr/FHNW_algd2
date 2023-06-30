package ub2.Lösung//******************************************************************************
//  ALGD-2 - Excercise 2.1                                                     *
//******************************************************************************

import java.util.NoSuchElementException;


public class SinglyLinkedList<E>{
  
  
  public SinglyLinkedList(){
    head = null;
  }
  

  public SinglyLinkedList(SinglyLinkedList<E> original){
    Element<E> tail = null;
    Element<E> r = original.head;
    while (r != null){
      if (head==null){                 // list is empty
        head = new Element<E>();
        head.data = r.data;
        head.next = null;
        tail = head;
      }else{                           // list not empty
        tail.next = new Element<E>();
        tail = tail.next;
        tail.data = r.data;
        tail.next = null;
      }
      r = r.next;
    }
    count = original.count;
  }
  
//***** API ********************************************************************
  
  
  public void insertFirst(E e){
    Element<E> r = new Element<E>();
    r.data = e;
    r.next = head;
    head = r;
    ++count;
  }
  
  
  public void insertAfter(E e, int index){
    if (index > count-1  || index < 0){
      throw new IndexOutOfBoundsException("invalid list index");
    }else{
      Element<E> newElement = new Element<E>();
      newElement.data = e;
      Element<E> r = head;
      for (int i=0; i<index; ++i){
        r = r.next;
      }
      newElement.next = r.next;
      r.next = newElement;
      ++count;
    }
    
  }
  
  
  public void removeFirst(){
    if (head!=null){
      head = head.next;
      --count;
    }else{
      throw new NoSuchElementException("list is empty");
    }
  }
  
  
  public void remove(int index){
    if (index > count-1  || index < 0){
      throw new IndexOutOfBoundsException("invalid list index");
    }else{
      if (index == 0){          // first element
        head = head.next;
      }else{                    // other elements
        Element<E> r = head;
        for (int i=0; i<index-1; ++i){
          r = r.next;
        }
        r.next = r.next.next;
      }
      --count;
    }
  }
  
  
  public void removeAll(){
    head = null;
    count = 0;
  }
  
  
  public E getFirst(){
    if (head!=null){
      return head.data;
    }else{
      throw new NoSuchElementException("list is empty");
    }
  }
  
  
  public E get(int index){
    if (index > count-1  || index < 0){
      throw new IndexOutOfBoundsException("invalid list index");
    }else{
      Element<E> r = head;
      for (int i=0; i<index; ++i){
        r = r.next;
      }
      return r.data;
    }
  }
  
  
  public int size(){
    return count;
  }
  
  
  @Override
  public String toString(){
    String result = "";
    Element<E> r = head;
    while (r!=null){
      result += (r.data.toString() + "  ");
      r = r.next;
    }
    return result;
  }

//***** attributes & nested classes*********************************************
  
  private static class Element<T>{
    T data;
    Element<T> next;
  }
  
  private Element<E> head;
  private int count = 0;
  
}
