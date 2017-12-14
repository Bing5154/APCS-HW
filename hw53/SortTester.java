//Team You Might Belong in Gryffindor -- Bing and Maggie
//APCS1 pd2
//HW54 -- One File to Bring Them All
//2017-12-14R


import java.util.ArrayList;

public class SortTester{

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

  public static void main(String[] args) {

      //Why best?
      //because if the arrayList was already sorted, there will only be comparison with neighbors but no swaps at all. 
      System.out.println("\n***Best case scenario for bubble sort... ***");
      ArrayList john = new ArrayList<Integer>();
      john.add(1);
      john.add(3);
      john.add(5);
      john.add(7);
      john.add(9);
      System.out.println( "ArrayList john before sorting:\n" + john );
      MySort.bubbleSort(john);
      System.out.println( "\nArrayList john after sorting:\n" + john );

      //why worst?
      //Because for every comparison with the neighboring element, a swap must be made. However,in both best and worst cases, the arrayList constitutes n - 1 passes.
      System.out.println("\n***Worst case scenario for bubble sort... ***");
      ArrayList mary = new ArrayList<Integer>();
      mary.add(9);
      mary.add(7);
      mary.add(5);
      mary.add(3);
      mary.add(1);
      System.out.println( "ArrayList mary before sorting:\n" + mary );
      MySort.bubbleSort(mary);
      System.out.println( "\nArrayList mary after sorting:\n" + mary );


      //Why is there no worst or best in Selection sort?
      //every pass there will always be a swap, even if the value at index i swaps with itself. 
      System.out.println("\n***Pseudo Best case scenario for Selection sort... ***");
      ArrayList ada = new ArrayList<Integer>();
      ada.add(2);
      ada.add(4);
      ada.add(6);
      ada.add(8);
      ada.add(10);
      System.out.println( "ArrayList ada before sorting:\n" + ada );
      MySort.selectionSort(ada);
      System.out.println( "\nArrayList ada after sorting:\n" + ada );

      System.out.println("\n***Pseudo Worst case scenario for selection sort... ***");
      ArrayList yoda = new ArrayList<Integer>();
      yoda.add(10);
      yoda.add(8);
      yoda.add(6);
      yoda.add(4);
      yoda.add(2);
      System.out.println( "ArrayList yoda before sorting:\n" + yoda );
      MySort.selectionSort(yoda);
      System.out.println( "\nArrayList mary after sorting:\n" + yoda );



      //Why Best?
      //Similar logic to bubble sort. In this case, each pass through the array will involve just one comparison, which will indicate that the element is in its correct position in respect to the sorted array. Therefore, no elements will need to be moved.
      System.out.println("\n*** Best case scenario for insertion sort... ***");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(1);
      glen.add(2);
      glen.add(3);
      glen.add(4);
      glen.add(5);
      System.out.println("ArrayList glen before sorting:\n" + glen);
      MySort.insertionSort(glen);
      System.out.println("\nArrayList glen after sorting:\n" + glen);

      //Why worst?
      //Array sorted in reverse order is the worst case b/c each element has to make comparisons and swaps with all the elements that are in front of it, which will lead to the maximum number of comparisons and moves.
      System.out.println("\n*** Worst case scenario for insertion sort... ***");
      ArrayList coco = new ArrayList<Integer>();
      coco.add(5);
      coco.add(4);
      coco.add(3);
      coco.add(2);
      coco.add(1);
      System.out.println("ArrayList coco before sorting:\n" + coco);
      MySort.insertionSort(coco);
      System.out.println("\nArrayList coco after sorting:\n" + coco);

      

      
      

      
  }
  

}
