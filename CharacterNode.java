/* Name, Email: Jimmy Lozano, jnlozano@ucsd.edu
 * References: Piazza, OH
 * FileHeader: CharacterNode.java
 * This is the class that creates the CharacterNode for MyStringBuilder. 
 * It follows the policies stated in the psa regarding the field variables and single constrcutor with one getLetter method.
 * */

public class CharacterNode{

private final char letter;
public CharacterNode nextNode; 





/** The contstructor for the CharacterNode object
 * @param: a character which is the character of the given object
 * @return: none, just the object
 * */

	public CharacterNode(char x){
		this.letter = x;
			nextNode = null; // Automatically makes the nextnode null
}

/** returns the letter of the CharacterNode
 * @Param: none, but is called on the object
 * @return: the character of that CharacterNoce object
 * */

	public char getLetter(){
		return this.letter;}
}
