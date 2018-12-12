/* Name,Email: Jimmy Lozano, jnlozano@ucsd.edu
 * References: Piazza, OH
 * File Header: EncryptionTurtle.java
 * This file contains the methods and constructors for EncryptionTurtle. 
 * This is a single threaded version, which essentially means one turtle is writing all the letters. 
 * The letters are encrypted first, then drawn out by that turtle.
 * */
import turtleClasses.Turtle;
import turtleClasses.World;
import java.awt.*;
import java.util.*;


public class EncryptionTurtle extends DrawingTurtle {

  // DON'T CHANGE
  public final static int WORLD_WIDTH = 800;
  public final static int WORLD_HEIGHT = 120;

  // CHANGE BACK TO 75 WHEN DONE
  public final static int DELAY = 75;

   // These constants may be helpful:
  public final static int CHAR_WIDTH = 40;
  public final static int LINE_PADDING = 40;
  public final static int CHAR_SPACE = CHAR_WIDTH + LINE_PADDING;

  /* single threaded encryption algorithm starts here */

/** Constructor for EncryptionTurtle that creates the world everytime its called. This calls the encryption method then draws the encrypted letter.
 * @param: String to be decrypted and rotation of the decryption
 * @return: none
 * */

  public EncryptionTurtle(String originalStr, int rotation){
   
    super(new World(WORLD_WIDTH,WORLD_HEIGHT),DELAY);
		setPenWidth(10);
		setPenColor(Color.RED);
		 	if(!validString(originalStr)){
				String error = "Illegal entry: " + originalStr;
				System.err.println(error);
				return;}
			else{
				for(int i = 0;i<originalStr.length();i++){
				char character = letterOperation(originalStr.charAt(i),rotation);
	draw(character, (i+1)*CHAR_SPACE,15);

}


  }
}

/** Returns boolean based on if the string in question is valid or not.
 * @param: The string in question
 * @return: boolean if the string passes the policies.
 * */
  private boolean validString(String rawInput) {
	if(rawInput == null|| rawInput.length()<0){
		return false;}
    
		return true;
  }

/** Encrypts the letter with the rotation. Really just does what the constructor can do, so I didn't use this method but still filled it out just in case.
 * @param: the string to be decrypted and the degree at which it will be
 * @return: void
 * */
  private void encrypt(String originalStr, int rotation) throws Exception {
	
	 EncryptionTurtle turt = new EncryptionTurtle(originalStr, DELAY);
	
	 String encrypt = "";
	
		if(!validString(originalStr)){
			String error = "Illegal entry: " + originalStr;
			System.err.println(error);
				return;}
		else{
			for(int i = 0;i<originalStr.length();i++){
				char character = letterOperation(originalStr.charAt(i),rotation);
				turt.draw(character, (i+1)*CHAR_SPACE,15);
	
}
}
}
 
/** Returns the encrypted character of the original character by a degree.
 * @param: the character to be encrypted and the degree at which it will be
 * @return: the encrypted character
 * */
  private char letterOperation(char original, int rotation) {
	if(!Character.isLetter(original))
		return original;
		int mod = ((rotation % 26)+26)%26;
		if(Character.isUpperCase(original)){
			return (char) ('A'+((original - 'A' + mod) %26));
		}else{
			return (char) ('a' + ((original - 'a' + mod)%26));
}

  }

  public static void main(String[] args) {

    System.out.println("Hello, this is the Main method of EncryptionTurtle");
	 new EncryptionTurtle("POTATO",10);
  }

} // End of public class EncryptionTurtle extends Turtle
