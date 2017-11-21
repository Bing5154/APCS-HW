//Team Something -- Bing Li & Susan Lin
//APCS1 pd2
//HW19 --  gcd 3 ways
//2017-10-19


public class Stats {

    //find the mean between two int, truncates the digit after decimal point
    public static int mean(int a, int b) {
	return (a + b) / 2;
    }

    //find the mean between two doubles
    public static double mean(double a, double b) {
	return (a + b) / 2.0;
    }

    // find the max between two int
    public static int max(int a, int b) {
	if (a < b) {
	    return b;
	} else {
	    return a;
	}
    }
    
    // find the max between two doubles
    public static double max(double a, double b) {
	if (a < b) {
	    return b;
	} else {
	    return a;
	}
    }

    //find the min between two integers
    public static int min(int a, int b) {
	if (a < b) {
	    return a;
	} else {
	    return b;
	}
    }

    public static int geoMean(int a, int b) {
	/* type casting is required, otherwise would result in incompatible types:
	   possible lossy conversion from double to int (aka. loss of precision) */
	return (int) Math.sqrt(a * b);
    }

    // find geometric mean of two doubles
    public static double geoMean(double a, double b) {
	return Math.sqrt(a * b);
    }

    //uses brute-force approach, beginning at 1 and working up to lesser input
     public static int gcd(int a, int b){
	int d = 1; //divisor that increases by 1 each loop
	int c = min(a,b); //minimum of a and b
	int gcd = 0; //variable that gets replaced if BE in loop holds true
	while (d <= c){
	    if ((a % d == 0) && (b % d == 0)){
		gcd = d; //if both params are divisible by d, gcd is replaced
	    }
	    d += 1; //force is added to d to make it more brute
	}
	return gcd; //returns the biggest value of d that works, AKA greatest common divisor
    }


    /*The Euclid's algorithm takes in two integers as parameters and return the
      greatest common divisor of the given two numbers.  The algorithm will keep subtracting the smaller value from the larger value, and reassigning values to to variable large and small based on their magnitude. The algorithm will repeat until one number reaches 0, and the algorithm will return the last max / larger number as the final result */


    //employs Euclid's algorithm recursively	 
    public static int gcdER(int a, int b) {
	int large = max(a,b); // find the max of a and b, set the result to large
	int small = min(a,b); //find the min of a and b, set the result to small
	if (small == 0) {
	    return large; // base case
	} else {
	    int c = max(large - small, small); 
	    int d = min(large - small, small);
	    large = c;
	    small = d;
	    /* keep resetting large and small with the result of min and max method on (large - small) and small until base case is reached */
	    return(gcdER(c,d));
	}
    }

    //employs Euclid's algorithm iteratively with a while loop
    public static int gcdEW(int a, int b) {
	int large = max(a,b);
	int small = min(a,b);
	//keep resetting large and small with the result of min and max method on (large - small) and small, until small is 0
	while (small != 0) {
	    int c = max(large - small, small);
	    int d = min(large - small, small);
	    large = c;
	    small = d;
	}
	return large; //once small is 0, loop is broken and return large
    }
		
							    

    // test each method
    public static void main (String[] args) {
	System.out.println("The average of int a and b is " + mean(1,2));
	System.out.println("The average of double a and b is " + mean(1.0, 2.0));
	System.out.println("The max btw int a and b is " + max(-2, -4));
	System.out.println("The max btw double a and b is " + max(-2.04, 0.0));
	System.out.println("The geometric mean of int a & b is " + geoMean(2,7));
	System.out.println("The geometric mean of double a and b is " + geoMean(2.0,7.0));
	System.out.println("------------------------------------------------------");
	System.out.println("The gcd between 54 and 24 is " + gcdER(54,24)); //expects 6
	System.out.println("The gcd between 12 and 24 is " + gcdEW(12,24)); //expects 12
	System.out.println("The gcd between 30 and 25 is " + gcd(30,25)); //expects 5

    }
}
