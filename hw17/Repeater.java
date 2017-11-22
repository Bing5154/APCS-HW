/*
Team Something -- Jackie Li, Bing Li
APCS Pd2
Hw#17 -- Do I Repeat Myself
2017-10-16
*/


public class Repeater {
    public static String fenceW (int numPosts) {
	String fence = "|";
	//base case
	if (numPosts == 1) {
	    return fence;
	}
	//recursive case
	else while (numPosts > 1) {
	    fence += "--|";
	    numPosts -= 1;
	    }
	return fence;
    }

    public static String fenceR(int numPosts) {
	String fence = "|";
	//base case
	if (numPosts <= 1) {
	    return fence;
	} //recursive case
	else {
	    fence += "--";
	    return fence + fenceR(numPosts - 1);
	}
    }
    
    public static void main(String[] args){
	System.out.println(fenceW(1)); //should be |
	System.out.println(fenceW(2)); //should be |--|
	System.out.println(fenceW(3)); //should be |--|--|

	System.out.println(fenceR(1)); //Should be |
	System.out.println(fenceR(2)); //Should be |--|
	System.out.println(fenceR(3)); //Should be |--|--|
	
    }
}
