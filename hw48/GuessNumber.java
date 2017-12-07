//Team Something: Bing Li, Susan Lin
//APCS1 pd2
//HW 48: Keep Guessing
//2017-12-07

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_target = (int)(Math.random() * (b - a) + 1);
	_guessCtr = 1;
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
     ==================================================*/
    public void playRec() 
    {
	System.out.println("Guess a number between " + _lo + " to " + _hi + ": ");
	int guess = Keyboard.readInt();

	//Most specific case has highest priority
	if (guess == _target) {
	   System.out.println("Correct! It took " + _guessCtr + " guesses");
	   return; //break can only work inside a loop
	}
	if(guess < _target) {
	    System.out.println("Too low, try again...");
	    _lo = guess + 1; //shrink range
	    _guessCtr += 1;
	    playRec(); //recursive call
	} else  {
	    System.out.println("Too high, try again...");
	    _hi = guess - 1; //shrink range
	    _guessCtr += 1;
	    playRec(); //recursive call	    
	}
    }
   


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	System.out.println("Guess a number between " + _lo + " to " + _hi + ": ");
	int guess = Keyboard.readInt();
	//use a while loop because don't know how many times the loop will iterate
	while(!(guess == _target)) { 
	    if(guess < _target) {
	        System.out.println("Too low, try again...");
		_lo = guess + 1; //shrink range
		System.out.println("Guess a number between " + _lo + " to " + _hi + ": ");
		guess = Keyboard.readInt();
	    } else {
		System.out.println("Too high, try again...");
		_hi = guess - 1; //shrink range
		System.out.println("Guess a number between " + _lo + " to " + _hi + ": ");
		guess = Keyboard.readInt();
	    }
	    _guessCtr++;
	}
	System.out.println("Correct! It took " + _guessCtr + " guesses");
    }

    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	playRec();
	//playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
    }//end main

}//end class
