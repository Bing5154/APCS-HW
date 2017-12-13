//Bing Li
//APCS1 pd2
//HW52: Poker Face
//2017-12-13W


/***************************************
 *  class InsertionSort -- implements InsertionSort algorithm
 *  Note To Myself: An insertion sort will keep comparing (multiple comparison) with prior elements 
    until a number is inserted into a correct position. Bubble sort will make one comparison for each element, 
    swap them and then move on to the next element
 ***************************************/

import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
      Comparable target;
      //outloop terminates when we reach the last index (aka. number of passes needed)
      for(int p = 0; p < data.size(); p++) {
	   target = data.get(p); //Comparable that is being moved around
	  
	  //Innerloop compares the current element with all elements before it
	  //Max number of comparison => current index to 0
	  for(int i = p; i >= 0; i--) {
	      //if one of the elements before is greater or equal to current index
	      if(target.compareTo(data.get(i)) <= 0) {
	       //insert target at the correct position, and remove itself from its previous current position
		  data.add(i, target); 
		  data.remove(p);
	      }
	  }
      }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input )
  {
      //declare and initialize empty ArrayList for copying
      ArrayList<Comparable> sorted = new ArrayList<Comparable>();

      //copy input ArrayList into working ArrayList
      for (Comparable element: input) {
	  sorted.add(element);
      }

      //sort working ArrayList;
      insertionSortV(sorted);

      return sorted;
  }//end insertionSort


  public static void main( String [] args )
  {
      /*===============for VOID methods=============*/
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      /* ============================================*/

      /*==========for AL-returning methods==========
      System.out.println( "*** Testing non-void version... *** " );
    	ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
       ============================================*/

  }//end main

}//end class InsertionSort
