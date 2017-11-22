
import cs1.Keyboard; //case sensitive
public class Swapper {

    
    public static void swap(String[][]a, int row, int column, int row1, int column1){
	//save the old copy of first string being swapped
	String temp = a[row][column];
	//swap
	a[row][column] = a[row1][column1];
	//replace the second string being swapped with temp
	a[row1][column1] = temp;	    
    }

    //recycle old code from TwoDimArray
    //prints all elements in an 2d Array
    public static void printArr(String[][] a) {
	for(String[]row: a) {
	    for(String elem: row) {
		System.out.print(elem + " ");
	    }
	    System.out.println();
	}
    }
    



    public static void main(String[] args) {
	//declare and set the original array
	String[][] array = {{"apple", "broccoli", "carrot"},
			    {"dates", "eggplant", "falafel"},
			    {"grape","hazelnut", "ice-cream"}};
	System.out.println("Here is the original array");
	printArr(array);


	//readInt stores user input to use as args of swap
	System.out.println();
	System.out.println("Please enter integer input only, press Ctrl-c to exit");
	System.out.println("Please enter the row # of the food being swapped: ");
	int row = Keyboard.readInt(); 
	System.out.println("Please enter the column # of the food being swapped: ");
	int column = Keyboard.readInt(); 
	System.out.println("Please enter the row # of the food you want to swap with: ");
	int row1 = Keyboard.readInt(); 
	System.out.println("Please enter the column # of the food you want to swap with: ");
	int column1 = Keyboard.readInt();

	//after finish storing the input, pass them as args to swap
	swap(array, row, column, row1, column1);
	System.out.println();
	System.out.println("NEW ARRAYS");
	printArr(array);
	
	
    }
    
}
