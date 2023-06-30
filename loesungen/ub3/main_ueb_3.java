package ub3;

import java.util.ListIterator;

//import ComparableList.CListIterator; 


public class main_ueb_3{

  public static void main(String[] args){
    ComparableList<Integer> list1 = new ComparableList<Integer>();
    
    ListIterator<Integer> iter = list1.iterator();  // test
    
    /*
    ComparableList<Integer> list2 = new ComparableList<Integer>();
    for (int i=8; i>=0; --i){
      list1.addHead(i+1);
      list2.addHead(11 * (i+1));
    }
    System.out.println(list1);
    System.out.println(list2);
    
    System.out.println("-------------------------------------");
    
    list1.merge(list2);
    System.out.println(list1);
    System.out.println("resultant size = " + list1.size());
    
    System.out.println("-------------------------------------");
    
    ComparableList<Integer> list3 = list1.split();
    System.out.println(list3);
    System.out.println(list1);
    */
    
    for (int i=0; i<100; ++i){
      list1.addHead((int)(Math.random() * 1000));
    }
    
    /*
    int[] values = {5, 67, 12, 18, 33, 95, 3, 41, 77, 9, 56, 81};
    for (int i=0; i<values.length; ++i){
      list1.addHead(values[i]);
    }
    */
    System.out.println(list1);
    list1.mergeSort();
    System.out.println(list1);
    System.out.println("This list is " + (list1.isSorted() ? "" : "not ") + "sorted.");
    
    

  }
  
  
  

}
