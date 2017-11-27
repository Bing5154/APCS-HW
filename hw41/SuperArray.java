//Bing Li
//APCS1 pd2
//Hw41 -- Array of Steel
//2017-11-28

public class SuperArray
{

    private static int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_size = _data.length;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String str =  "[";
	for(int i = 0; i < _data.length - 1; i++) {
	    str += _data[i] + ", ";
	}
	str += _data[_data.length - 1] + "]";
	return str;
    }

    //double capacity of SuperArray, while keeping the existing values
    private void expand()
    {
	//declare a new array twice the original size
	int[] newD = new int[_size * 2];
	//pass existing values
	for(int i = 0; i < _data.length; i++) {
	    newD[i] = _data[i];
	}
	_size = _size * 2;
	_data = newD; 
    }

    //accessor -- return value at specified index
    public int get( int index )
    {
	return _data[index];
    }

    
    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
	int oldVal = _data[index];
	_data[index] = newVal; //this change matters
	return oldVal; //not so much of this
    }

  //main method for testing
  public static void main( String[] args )
  {
   
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
 
      
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      //double the size three times
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      System.out.println("There are " + _data.length + " items in the current array");
      }
  }//end main()


}//end class
