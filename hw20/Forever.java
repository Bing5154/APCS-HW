//Bing Li
//APCS1 pd2
//Hw20--For the Love of Strings
//2017-10-20

public class Forever{
    public static String fenceF(int posts){
	String fence = "|";
        if (posts == 1) {
	    fence = fence;
	} else {
	    for (int x = 1; x <= posts; x++) {
		fence += "--|";
	    }
	}
	return fence;
    }

    //return s with its letter reversed --> used for loop
    //keep appending char with index i decrementally
    public static String reverseF(String s) {
	String reverse = "";
	int length = s.length();
	for (int i = length - 1; i >= 0; i--) {
	    reverse += s.charAt(i); //charAt returns the char value at the specified index. 
	}
	return reverse;
    }

    //return s with its letter reversed --> used recursion
    public static String reverseR(String s) { 
	if (s.length() == 0) { 
	    return s;
	}
	return reverseR(s.substring(1)) + s.charAt(0); //recursive at first part
	//substring(1) returns the subset of the string starting from the index       //described in the parameter
	//reverse in order because the pending calls are stacked, so the first call of the recursion will be executed / printed last
    }
 
	
	    

    public static void main(String[] args) {
	System.out.println("-----------For loop Test-----------");
	System.out.println(fenceF(1)); // |
	System.out.println(fenceF(2)); // |--|
	System.out.println(fenceF(3)); // |--|--|--|

	System.out.println("----------Reverse For Loop Test-------");
	System.out.println(reverseF("hello")); //expects olleh
	System.out.println(reverseF("what")); //expects tahw

	System.out.println("----------Reverse Recursion Test-------");
        System.out.println(reverseR("hello")); //expects olleh


    }
}
	    
	
		
		    
