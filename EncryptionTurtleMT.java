/* Name, Email: Jimmy Lozano, jnlozano@ucsd.edu
 * References: Piazza, OH
 * FileHeader: EncryptionTurtleMT.java
 * This file contains the methods and constructor for EncryptionTurtleMT. 
 * It is similar to EncryptionTurtle, but uses threads to accomplish the job.
 * This means it uses multiple turtles to draw out each letter. 
 * */

import turtleClasses.Turtle;
import turtleClasses.World;
import java.awt.*;
import java.util.*;


public class EncryptionTurtleMT extends DrawingTurtle implements Runnable {

    // DON'T CHANGE
    public final static int WORLD_WIDTH = 800;
    public final static int WORLD_HEIGHT = 120;

    // CHANGE BACK TO 75 WHEN DONE
    public final static int DELAY = 75;

    // These constants may be helpful:
    public final static int CHAR_WIDTH = 40;
    public final static int LINE_PADDING = 40;
    public final static int CHAR_SPACE = CHAR_WIDTH + LINE_PADDING;

    private char charr;
    private int x, y;
	
	private int rotation;
	private static final int NUM_THREADS = 3;
	private static Thread newthread;
	private static ArrayList<Thread>threads = new ArrayList<Thread>();

    /* private constructor -- this should not be called by anyone */

/** A constructor that initializes all of the primary instance variables and thread.
 * @param: the instance variables which create this turtle
 * @return: none
 */
    private EncryptionTurtleMT(World w, char charr, int x, int y, int rotation, int delay ){
	super(w, delay);
	this.setPenWidth(10);
	this.setPenColor(Color.RED);
	this.charr = charr;
	this.x = x;
	this.y = y;
	this.rotation = rotation;
	newthread = new Thread(this);
	threads.add(newthread);

        
    }

    /* multithreaded turtle code starts here; we call this method */

/** the method which encrypts the given string with multiple threads.
 * @param: the string to be encrypted and the degree at which it will be
 * @return: void
 * */
    public static void encryptMT(String originalStr, int rotation) {

		World world = new World(WORLD_WIDTH,WORLD_HEIGHT);
		int x = (WORLD_WIDTH)/6;
		int y = (WORLD_HEIGHT)/6;	
    		if(!validString(originalStr)){
				String error = "Illegal input!";
				System.err.println(error);
					return;
			}else{
				for(int i = 0; i<originalStr.length();i++){
					char charc = letterOperationMT(originalStr.charAt(i), rotation);
					EncryptionTurtleMT turt = new EncryptionTurtleMT(world,charc,x+i*CHAR_SPACE,y,rotation,DELAY);
}
					for(int i = 0; i<NUM_THREADS; i++){
						(threads.get(i)).start();
}
}
}


/** The method which encrypts the character
 * @param: the character to be encrypted and the degree
 * @return: the encrypted character
 * */

    private static char letterOperationMT(char original, int rotation){
     
		int num = (int)original;
			if(num <=(int)'Z' && num >= (int)'A'){
				num +=(rotation%26);
			if(num>(int)'Z')
				num -=26;
			else if(num <(int)'A')
				num+= 26;
			if(num <'A' || num > 'Z'){
				System.err.println("ERROR: char is " +num);
				return (char) num;
}
}
				return (char) num;
 
    }

/**Checks to make sure if the given string is valid
 * @param: the string in question
 * @return: boolean based on if the string passes the policies
 * */
    private static boolean validString(String rawInput) {
		if(rawInput.equals(null) || rawInput.equals("")||rawInput.length()<1){
			return false;}

       		 return true;

    }

/** The run method for the threads. Simply calls the encryption method and draws based on what character is returned.
 * @param: none
 * @return: void
 * */
    public void run(){
letterOperationMT(charr,rotation);
	switch(charr){
	case 'A': this.drawA(x,y);break;
	case 'B':this.drawB(x,y);break;
	case 'C': this.drawC(x,y);break;
	case 'D':this.drawD(x,y);break;
	case 'E':this.drawE(x,y);break;
	case 'F':this.drawF(x,y);break;
	case 'G':this.drawG(x,y);break;
	case 'H':this.drawH(x,y);break;
 	case 'I':this.drawI(x,y);break;   
	case 'J':this.drawJ(x,y);break;
	case 'K':this.drawK(x,y);break;
	case 'L':this.drawL(x,y);break;
	case 'M':this.drawM(x,y);break;
	case 'N':this.drawN(x,y);break;
	case 'O':this.drawO(x,y);break;
	case 'P':this.drawP(x,y);break;
	case 'Q':this.drawQ(x,y);break;
	case 'R':this.drawR(x,y);break;
	case 'S':this.drawS(x,y);break;
	case 'T':this.drawT(x,y);break;
	case 'U':this.drawU(x,y);break;
	case 'V':this.drawV(x,y);break;
	case 'W':this.drawW(x,y);break;
	case 'X':this.drawX(x,y);break;
	case 'Y':this.drawY(x,y);break;
	case 'Z':this.drawZ(x,y);break;

}
}
    public static void main(String[] args) {
        System.out.println("Hello, this is the Main method of EncryptionTurtleMT");
encryptMT("ABC",3); 
}

} // End of public class EncryptionTurtleMT extends Turtle
