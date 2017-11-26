//Bing Li
//APCS1 pd2
//Hw34 -- 2D arrays
//2017-11-17

public class TwoDimArray {
   
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) {
	//first for is row
	for (int x = 0; x < a.length; x++) {
	    for (int y = 0; y < a[x].length; y++) { //interate through column
		System.out.print(a[x][y] + " ");
	    }
	    System.out.println();	
	}
      
    }

    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) {
	for (int[] row: a) {
	    for (int elem: row) {
		System.out.print(elem + " ");
	    }
	    System.out.println();
	}
    }

    //postcond: returns sum of all items in 2D int array a using nested FOR loop
    public static int sum1( int[][] a )
    {
	int sum = 0;
	for(int x = 0; x < a.length; x++) {
	    for (int y = 0; y < a[x].length; y++) {
		sum += a[x][y];
	    }
	}
	return sum;
    }

    //postcond: returns sum of all items in 2D int array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m )
    {
	int result = 0;
	for(int x = 0; x < m.length; x++) {
	     result += sumRow2(x,m);
	}
	return result;
    }

    
    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {
	int sum = 0;
	for(int y = 0; y < a[r].length; y++) {
	    sum += a[r][y];
	}
	return sum;
        
    }

    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m)
    {
	int sum = 0;
	for(int elem: m[r]) {
	    sum += elem;
	}
	return sum;
    }

    public static void main( String [] args )
    {
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	System.out.println("result for print1 using for loop: ");
	print1(m1);
        print1(m2);
	print1(m3);
	System.out.println("result for print2 using foreach loop:");
	print2(m1);
	print2(m2);
	print2(m3);
	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1)); //expects 0
	System.out.println("sum m2 : " + sum1(m2)); //expects 27
	System.out.println("sum m3 : " + sum1(m3)); //expects 21
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1)); //expects 0
	System.out.println("sum m2 : " + sum2(m2)); //expects 27
	System.out.println("sum m3 : " + sum2(m3)); //expects 21
    }
}
