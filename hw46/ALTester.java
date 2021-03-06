//Bing Li
//APCS1 Pd2
//HW46--Al<B> Sorted!
//2017-12-04

import java.util.ArrayList;

public class ALTester {

    //pre: ArrayList <Comparable> a
    //post: modify ArrayList by populating ArrayList with 23 Integers that are randomly gnerated.
    //Note: a[1] would not work b/c a is not an array. To append element, must use the default add(Object o) method in ArrayList
    public static void populate(ArrayList<Comparable> a) {
	for(int i = 0; i < 23; i++) {
	    a.add((int)(Math.random() * 23 + 1));
	}
    }

    //pre: ArrayList <Comparable> a
    //post:Using the compareTo method of <Comparable> to determine order, then apply default set method of ArrayList to sort the List in ascending order
    public static void sortV(ArrayList<Comparable> a) {
	int passes = 0; 
	int size = a.size();
	/*while loop terminates the program only if no swapping between neighboring elements occurred, which means the entire list is sorted, not just the elements in vicinity. Prepares for the worst case scenario --> test case: (5,4,3,2,1) --> only pass at the 4th aka (size - 1) time */
        while (passes < size - 1) { 
	    //for loop swithces the neighboring elements based on magnitude, looping backward
            for (int i = size-1; i > 0; i--) {
                Comparable first = a.get(i);
                Comparable second = a.get(i-1);
                if (first.compareTo(second) == -1) {
	        //default compareTo method returns -1 if 1st is less than 2nd
                    Comparable temp = first;
                    a.set(i, second);
                    a.set(i-1, temp);
                }
            }
         passes += 1;
        }
    }

    //returns sorted copy of input ArrayList
    public static ArrayList<Comparable> sort(ArrayList<Comparable> input) {
	ArrayList<Comparable> sorted = new ArrayList<Comparable>(input);
	sortV(sorted);
	return sorted;	
    }
    
 
   public static void main(String[] args) {
	ArrayList<Comparable> foo = new ArrayList<Comparable>();
	populate(foo);
	System.out.println("ArrayList foo before sorting: \n" + foo);
	ArrayList fooSorted = sort(foo);
	System.out.println("ArrayList foo after sorting: " + fooSorted);
       
   }
}
