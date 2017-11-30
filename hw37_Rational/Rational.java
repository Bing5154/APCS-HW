//Bing Li
//APCS1 pd2
//Hw37: Be More Rational
//2017-11-21

public class Rational
{
  //   Instance variables for the numerator and denominator
  private int _numerator;
  private int _denominator;


  // Default constructor (no parameters)
  // creates a new Rational with the value of 0/1
  public Rational()
  {
    _numerator = 0;
    _denominator = 1;
  }


  // Constructor
  // takes 2 parameters, one for the numerator, one for the denominator
  // if an invalid denominator is attempted, should print a message and set the number to 0/1
  public Rational( int n, int d )
  {
    this();
    if ( d != 0 ) {
      _numerator = n;
      _denominator = d;
    }
    else {
      System.out.println( "Invalid number. " +
                          "Denominator set to 1." );
    }
  }


  // toString
  // returns a string representation of the rational number (formatting of your choice)
  public String toString()
  {
    return _numerator + " / " + _denominator;
  }


  // floatValue
  // returns floating point approximation of the number
  public double floatValue()
  {
    return (double)_numerator / _denominator;
  }


  // multiply
  // takes 1 Rational object as a parameter and multiplies it by this Rational object
  // does not return any value
  // should modify this object and leave the parameter alone (see below for example)
  // need not reduce the fraction
  public void multiply( Rational r )
  {
    _numerator   = this._numerator   * r._numerator;
    _denominator = this._denominator * r._denominator;
  }


  // divide
  // works the same as multiply, except the operation is division
  public void divide( Rational r )
  {
    if ( r._numerator != 0 ) {
      _numerator   = _numerator   * r._denominator;
      _denominator = _denominator * r._numerator;
    }
    else {
      System.out.println( "Div by 0 error. Values unchanged." );
    }
  }

    //pre: int a, int b
    //post: int LCM
    //exp: find LCM of two numbers by multiplying both and divding the product by gcd
    public static int LCM(int a, int b) {
	int LCM = a * b / gcdEW(a,b);
	return LCM;
    }

    //pre: int a, int b
    //post: int gcd
    //old code from hw19: used a while loop to find gcd between two numbers
    //helper function to ADD and SUBTRACT, LCM and REDUCE
    public static int gcdEW(int a, int b) {
	if (a % b == 0) {
	    return b;
        }
        return gcdEW( b, a%b);
    }

    //pre: Rational
    //post: void
    //Takes 1 Rational object (just like multiply) and adds it to the current rational number object --> reset the instance variables with the new sum
    public void add( Rational r ) {
	int LCM = LCM(this._denominator, r._denominator);
	int mult1 = LCM / this._denominator;
	int mult2 = LCM / r._denominator;
	_denominator = LCM;
	_numerator = (mult1 * this._numerator) + (mult2 * r._numerator);
    }

     //pre: Rational
    //post: void
    //Takes 1 Rational object (just like multiply) and adds it to the current rational number object --> reset the instance variables with the new difference
    public void subtract(Rational r) {
	int LCM = LCM(this._denominator, r._denominator);
	int mult1 = LCM / this._denominator;
	int mult2 = LCM / r._denominator;
	_denominator = LCM;
	_numerator = (mult1 * this._numerator) - (mult2 * r._numerator);
    }

    //pre: Rational
    //Post: int
    //Use gcdEW as helper function to find gcd of the dem and num od this Rational
     public int gcdND() {
	 int gcd = gcdEW(this._numerator, this._denominator);
	 return gcd; 
    }

    //post: Changes this Rational to one in reduced form (should use gcdND)
     public void reduce() {
        int gcd = gcdND();
        // Divide both the numerator and denominator by the gcd
        _numerator /= gcd;
        _denominator/= gcd;
    }

    //Takes a Rational parameter and compares it to the calling object
    //Returns 0 if the two numbers are equal
    //Returns 1 if the calling number is larger than the parameter
    //Returns a -1 if the calling number is smaller than the parameter
    public int compareTo(Rational r) {
	double original = this.floatValue();
	double parameter = r.floatValue();

	if(original == parameter) {
	    return 0;
	} else if(original > parameter) {
	    return 1;
	} else{
	    return -1;
	}
    }
	
	
  //main method for testing
  public static void main(String[] args)
  {
    Rational k = new Rational( 3, 7 );
    Rational s = new Rational();
    Rational t = new Rational( 8, 5 );

    Rational u = new Rational( 1, 2 );
    Rational v = new Rational( 2, 3 );
    Rational w = new Rational( 8, 12 );

    System.out.println("k: " + k );
    System.out.println("s: " +  s );
    System.out.println("t: " +  t );

    System.out.println( k + " represented as a floating pt num: "
                        + k.floatValue() );

    System.out.print( k + " * " + t + " = ");
    k.multiply(t);
    System.out.println(k); //expects: 3 / 7 * 8 / 5 = 24 / 35


    System.out.print(k + " / " + t + " = ");
    k.divide(t);
    System.out.println(k); //expects: 24 / 35 / 8 / 5 = 120 / 280

    System.out.print(k + " + " + t + " = ");
    k.add(t);
    System.out.println(k); // expects: 120/280 + 8/5 = 568/280

    System.out.print(k + " - " + u + " = ");
    k.subtract(u);
    System.out.println(k); // expects: 568 / 280 - 1 / 2 = 428/280

    System.out.print("the reduced form of current Rational k is: ");
    k.reduce();
    System.out.println(k); // expects: reduced form of k is 107/70

    
    System.out.println("result of comparison between w and k is: " + w.compareTo(k)); //-1
    System.out.println("result of comparison between v and w is: " + v.compareTo(w)); //0
    

  
    System.out.println();
    System.out.println("the LCM between 63 and 17 is: " + LCM(63,17)); //expects 1071
    System.out.println("the LCM between 30 and 25 is: " + LCM(30,25)); //expects 150
    System.out.println("the LCM between 4 and 6 is: " + LCM(4,6)); //expects 12
    System.out.println("the GCD between 4 and 6 is: " + gcdEW(4,6)); //expects 2
    System.out.println("the GCD between 2 and 4 is: " + gcdEW(3,19)); //expects 1


  }
}//end class
