package loesungen.e3;//******************************************************************************
//  FHNW.ALGD2  -  Excercise 2.3 : Dead-End-Station                            *
// --------------------------------------------------------------------------- *
//  verionn 2                                                              vtg *
//******************************************************************************

import loesungen.e1e2.Stack;

public class main_Sackbahnhof {

	public static void main(String[] args) {
	  char waggon;
		initRails(true);
		showRails(false);
		// step #1 : clear rail 1 by putting all Bs to rail 3 and all As to rail 2
		while (!s1.isEmpty()){
		  waggon = s1.pop();
		  ++moves;
		  if (waggon == 'A'){  
		    s2.push(waggon);
		  }else{
		    s3.push(waggon);
		  }
		}
	  // step #2 : clear rail 2 by putting all Bs to rail 3 and all As to rail 1
		while (!s2.isEmpty()){
      waggon = s2.pop();
      ++moves;
      if (waggon == 'A'){
        s1.push(waggon);
      }else{
        s3.push(waggon);
      }
    }
	  // step #3 : move all of rail 3 to rail 2
    while (!s3.isEmpty()){
      s2.push(s3.pop());
      ++moves;
    }
    showRails(true);
	}
	
//***** auxiliaries ************************************************************
	private static void initRails(boolean random){
	  if (!random){
	    s2.push('A');  // init rail 2
      s2.push('A');
      s2.push('B');
      s1.push('B');  // init rail 1
      s1.push('A');
      s1.push('B');
      s1.push('A');
	  }else{
	    int n1 = (int)((Math.random() * 50) + 1);
	    int n2 = (int)((Math.random() * 50) + 1);
	    elements = n1 + n2;
	    while (n1-- > 0){
	      if (Math.random()> 0.5){
	        s1.push('A');
	      }else{                     
	        s1.push('B');
	      }
	    }
	    while (n2-- > 0){
        if (Math.random()> 0.5){
          s2.push('A');
        }else{
          s2.push('B');
        }
	    }
	  }
	}
	
	private static void showRails(boolean result){
	  s1.show("S1");
    s2.show("S2");
    s3.show("S3");
    if (result){
      System.out.println("Moves: " + moves + "/" + elements);
    }
    System.out.println("-----------------");
	}
	
//***** globals ****************************************************************
	private static Stack<Character> s1 = new Stack<Character>();
	private static Stack<Character> s2 = new Stack<Character>();
	private static Stack<Character> s3 = new Stack<Character>();
	private static int moves = 0;
	private static int elements;
}
