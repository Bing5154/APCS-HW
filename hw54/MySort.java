//Team You Might Belong in Gryffindor -- Bing and Maggie
//APCS1 pd2
//HW55 -- Never Fear, Big Oh is Here!
//2017-12-14R

import java.util.ArrayList;


public class MySort{

    /******************************************************************
     The execution time in the best case scenario for bubble sort is O(n), 
     because only n - 1 comparisons are made in a sorted array. f(x) = n - 1 
     is O(n) since we are ignoring the coefficients and constants.

     The execution time in the worst case scenario for bubble sort is O(n^2)
     because we have n - 1 passes and each pass makes n - 1 comparison 
     (every element compares itself with the next element, from first to last).
     (n - 1) * (n - 1) result in a highest degree of 2, so the bounding function
     would be O(n^2)
    *******************************************************************/
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	int numOfSwap = 0;
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
		    data.set( i, data.set(i+1,data.get(i)) );
		    numOfSwap++;
		}
		System.out.println(data); //diag: show current state of list
	    }
	}
	System.out.println("\nTotal number of swaps occurred: " + numOfSwap);
    }


    /*******************************************
     Inrespective of the order of the elements, selection sort makes n - 1 passes 
     and n - i comparisons in each pass (i is the counter of passes the array has
     gone through). Therefore, the toal number
     of comparisons is (n - 1) + (n - 2) + ... +2 + 1, which is equal to n(n-1) / 2
     since the highest degree of f(n) is 2, then the big O would be O(n^2)


     *********************************************/
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;
	int numOfSwap = 0;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    //inner loop: comparison
	    for( int i = 1; i <= pass; i++ ) {
		System.out.println( "maxPos: " + maxPos );//diag
		System.out.println( data );//diag
		//update maxPos once current index is greater than maxPos
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 ) {
		    numOfSwap++;
		    maxPos = i;
		}
	    }
          //a swap is made with the maxpos in every pass, range of arrayList shrinks with each pass
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
	}
	System.out.println("\nTotal Number of swaps occurred: " + numOfSwap);
    }//end selectionSort

    

    /*******************************************************************
     The execution time in the best case scenario for insertion sort is O(n), 
     because only n - 1 comparisons are made in a sorted array. f(x) = n - 1 
     is O(n) since we are ignoring the coefficients and constants.

     The execution time in the worst case scenario for insertion sort in O(n^2)
     because we are making n - 1 passes and each pass consists of n - i comparison,
     where i is the number of passes we have gone through. Therefore, the toal number
     of comparisons is (n - 1) + (n - 2) + ... +2 + 1, which is equal to n(n-1) / 2
     since the highest degree of f(n) is 2, then the big O would be O(n^2)
     ******************************************************************/
    public static void insertionSort( ArrayList<Comparable> data )
    {
	int numOfSwap = 0;
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    numOfSwap++;
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
	System.out.println("\nTotal number of swaps occured: " + numOfSwap);
    } //end insertion sort

    /******************Linear Add in AOL *********************************
     Best case scenario: When the desired target is at the beginning of the array
     Run Time: O(1) because we only need 1 try

     Worst case scenario: When the desired target is at the end of the array
     Run time: O(n) because we have to examine all elements one by one until
     target is found and stuff be added at targted position
     *********************************************************************/


    /***************** Binary Add in AOL ******************************
     Best case scenario: when the desired target is in the midpoint / median
     of the array
     Run Time: O(1) because we only need 1 try

     Worst case scenario: when the desired target is at either end of the array
     Run time: O(log2n) because we have to keep halving the arraylist until there
     is only one element left to examine
     *****************************************************************/
    
}
