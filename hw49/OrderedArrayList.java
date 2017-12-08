//Bing Li
//APCS1 pd2
//HW47: Halving the Halves
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
  //This is a linear insertion b/c we are going through elements one by one
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

  //This is a binary search. After fiding the correct position (ascending order), add the newVal using such position
    public void addBin(Comparable newVal) {
	//initialization of cursors that mark start, middle, and end index (not the value corresponding to the index)
	int start = 0;
	int mid = 0;
	int end =_data.size() -1; // -1 at first call to addBin
	
	while(start <= end) {//running until the end and start cursor meet. No more value to go through, loop should break
	    int equality = _data.get(mid).compareTo(newVal);
	    if (equality == 0) { //if value of middle index matches the newVal, immediately break loop
		_data.add(mid,newVal);
		return;
	    } else if(equality < 0) {//if value of middle index is less than newVal, delimits the lower half
		start = mid + 1;
		//must add 1 cuz trunkation of integer operation
		mid = (start + end) / 2;
	    } else { //if value of middle index is greater than newVal, delimits the upperhalf
		end = mid - 1;
		//must subtract 1 cuz trunkation of integer operation
		mid = (start + end) / 2;
	    }
	}
	//If newVal is not within the current ordered list, then add it to the start
	// _data.add(start, newVal) acts as the result for start > end. When start index is greater than the end index, it technically serves as the end as well
	//Important for initializing the order list, because start(0) is set to be greater than end(-1) in the beginning (aka. first call), matches case start > end
       _data.add(start, newVal);

    }
  


  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ ) {
      Franz.add( (int)( 50 * Math.random()));
    }
    
    System.out.println( Franz );

    OrderedArrayList Lisa = new OrderedArrayList();
    
    //testing binary serach
    for(int i = 0; i < 15; i++) {
	Lisa.addBin((int)(70 * Math.random()));
    }
    
    System.out.println(Lisa);
    
  }//end main()

}//end class OrderedArrayList
