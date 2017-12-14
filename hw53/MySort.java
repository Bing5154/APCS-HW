//Team You Might Belong in Gryffindor -- Bing and Maggie
//APCS1 pd2
//HW54 -- One File to Bring Them All
//2017-12-14R

import java.util.ArrayList;


public class MySort{

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

    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;
	int numOfSwap = 0;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
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


    
    
}
