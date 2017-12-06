//Bing Li
//APCS1 pd2
//HW47: ascending
//2017-12-05


/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a ArrayList that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
      //instantiating
      _data = new ArrayList<Comparable>();
  }

  //customize print
  public String toString()
  {
      return _data.toString(); 
  }


  // Removes the element at the specified position from this list. All elements to the right of the specified position are shifted left (1 is subtracted from their indices) and the size of this list is one less than before the method is called.
  public Comparable remove( int index )
  {
      Comparable removed = (Comparable)_data;
      _data.remove(index);
      return removed; 
  }

  //Returns the number of elements in this list.
  public int size()
  {
      return _data.size();
  }

    
  //Returns the element at the specified position in this list.
  public Comparable get( int index )
  { 
      return _data.get(index); 
  }

    //Compare newVal with existing elements. Find the index of the first occurence of an element greater than newVal. Use that index in the add method of arrayList
  public void add(Comparable newVal)
  {
      int pos = 0; //starting position 
      for(int i = 0; i < _data.size(); i++) {
	  if(newVal.compareTo(_data.get(i)) < 0) {
	     pos = i;
	     break;
	     //without the break,the for loop wll continue, and pos would be theindex of the last occurrence of an integer greater than newVal
	  } else {
	      //if loop doesn't break, then append newVal at the very end
	      pos = _data.size();
	  }
      }
      _data.add(pos, newVal);  
  }



  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
  }//end main()

}//end class OrderedArrayList
