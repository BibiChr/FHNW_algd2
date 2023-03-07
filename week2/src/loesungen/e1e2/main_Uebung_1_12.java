package loesungen.e1e2;
//******************************************************************************
//  ALGD-2 - Excercise 2.1                                                     *
//******************************************************************************

public class main_Uebung_1_12{

  public static void main(String[] args){
    System.out.println("***** Test the List ***********************************");
    SinglyLinkedList<Integer> s1 = new SinglyLinkedList<Integer>();
    s1.insertFirst(1);
    s1.insertFirst(2);
    s1.insertFirst(3);
    s1.insertFirst(4);
    SinglyLinkedList<Integer> s2 = new SinglyLinkedList<Integer>(s1);
    System.out.println("S1: " + s1 + "(" + s1.size() + " Elemente)");
    System.out.println("S2: " + s2 + "(" + s2.size() + " Elemente)");
    s2.removeFirst();
    System.out.println("S2: " + s2 + "(" + s2.size() + " Elemente)");
    System.out.println(s1.getFirst());
    s1.remove(2);
    System.out.println("S1: " + s1 + "(" + s1.size() + " Elemente)");
    s1.insertAfter(9, 0);
    System.out.println("S1: " + s1 + "(" + s1.size() + " Elemente)");
    System.out.println(s1.get(3));
    s1.removeAll();
    System.out.println("S1: " + s1 + "(" + s1.size() + " Elemente)");
    
    System.out.println();
    System.out.println("***** Test the loesungen.e1e2.Stack **********************************");
    Stack<Integer> stk = new Stack<Integer>();
    for (int i=0; i<10; ++i){  stk.push(i);  }
    stk.show("filled stack:" );
    System.out.print("popped: " + stk.pop());
    stk.show("   stack now");
  }

}
