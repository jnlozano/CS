/* Name, Email: Jimmy Lozano, jnlozano@ucsd.edu
 * References: Piazza, OH
 * FileHeader: MyStringBuilder.java
 * The big boy. This file holds the methods which are used as a StringBuilder.
 * The difference is that this StringBuilder uses nodes to traverse through the "string." 
 * It has methods that can delete an amount of words, add, convert to a string, return the length of the object, compare objects, and insert characters.
 * */

public class MyStringBuilder{

CharacterNode firstNode; // only ONE allowed


/** adds a character to the end of the StringBuilder object by using nodes
 * @param: the character to be added
 * @return: none, just adds the character to the end.
 * */
	public void append(char addingChar){

		if(firstNode == null){
			firstNode = new CharacterNode(addingChar);
	
		}else{
			CharacterNode currNode = firstNode;
		while(currNode.nextNode != null){
			currNode = currNode.nextNode;}
			currNode.nextNode = new CharacterNode(addingChar);
	
}
}

/** converts the object to a string object
 * @param: none, but is calle don the stringbuilder object
 * @return: a string of the object
 * */
	public String toString(){
		CharacterNode currNode = null;
		String end = "";
		currNode = firstNode;
		end = end + currNode.getLetter();
			while(currNode.nextNode!=null){
				currNode = currNode.nextNode;
				end = end + currNode.getLetter();
		
}
			return end;
}


/** returns the lenght of the object
 * @param: none, but is called on the stringbuilder object
 * @return: an int value of the length
 * */
public int length(){

	CharacterNode currNode = null;
	int counter = 1;
	currNode = firstNode;
		while(currNode.nextNode!=null){
			currNode = currNode.nextNode;
			counter++;
}
return counter;
}


/** inserts a character in a given index of the stringbuilder object
 * @param: the index to place character and the character to be placed
 * @return: void, but inserts the character in the object
 * */
public void insert(int offset, char insertChar) throws Exception{

	CharacterNode currNode = null;
		if(offset < 0 || offset> this.length()){
			throw new StringIndexOutOfBoundsException("offset not in bounds");
		}else{
			currNode = firstNode;

			for(int i = 0; i<=this.length();i++){
			
				if(offset == i){
					CharacterNode temp = new CharacterNode(currNode.getLetter());
					temp.nextNode = currNode.nextNode;
					currNode = new CharacterNode(insertChar);
					currNode.nextNode = temp;
					break;
		}
			currNode = currNode.nextNode;
	}
}
}


/** delets a given amount of characters/nodes in the stringbuilder object
 * @param: the start and end of the indices of which the characters will be deleted.
 * @return: void, but deletes the desired characters in the object
 * */
public void delete(int start, int end) throws Exception{

	CharacterNode currNode = null;
		if(start < 0 || start > end  || start > this.length()){
			throw new StringIndexOutOfBoundsException("Illegal start and end positions");
}
		else if(start == end){
			return;
		}else{
			currNode = firstNode;
			CharacterNode temp = null;
				for(int i = this.length(); i > 0;i--){
			
					if( i == end){
						temp  = new CharacterNode(currNode.getLetter());
						temp.nextNode = currNode.nextNode;
					}else if(i == start){
						currNode.nextNode = temp;
	}
					currNode = currNode.nextNode;
	}
}
}


/** returns a boolean based on if a given object is the same as called on stringbuilder object
 * @param: the object in question
 * @return: boolean value based on if they are equal or not
 * */
public boolean equals(Object other){

	CharacterNode currNode = null;
	CharacterNode curr2Node = (((MyStringBuilder)other).firstNode);
		if( other instanceof MyStringBuilder){
			currNode = firstNode;
				for(int i = 0; i<this.length();i++){
					if(currNode.equals(curr2Node)){
						return true;
}
					currNode = currNode.nextNode;
					curr2Node = curr2Node.nextNode;
}
}
	return false;
}


/** returns a boolean based on if a given string is the same as the called on stringbuilder object
 * @param: the string in question
 * @return: boolean value based on if they are equal or not
 * */
public boolean equals(String other){
	CharacterNode currNode = null;
	currNode = firstNode;
		if(other.length() == this.length()){
			for(int i = 0; i<this.length(); i++){
				if(currNode.getLetter()==(other.charAt(i))){
					return true;
			}
				currNode  = currNode.nextNode;
		}
	}
	return false;
}

}
