// Name: Jimmy Lozano
// PID: A12638975
// Login: cs8bwanf
// Date: Winter 2018
// File: Board.java
// Help: Piazza, textbook, discussion, TAs, Lab Hours

// Brief Description: 
// This file contains the majority of the methods. Tons of helper methods are used here in order for the game to function appropriately. The main methods are used to save the board, determine if there are moves, make moves, and update the array used in the game. 

/**
 * Sample Board
 * <p/>
 * 0   1   2   3
 * 0   -   -   -   -
 * 1   -   -   -   -
 * 2   -   -   -   -
 * 3   -   -   -   -
 * <p/>
 * The sample board shows the index values for the columns and rows
 * Remember that you access a 2D array by first specifying the row
 * and then the column: grid[row][column]
 */

import java.util.*;
import java.io.*;

public class Board {
    public final int NUM_START_TILES = 2; 
    public final int TWO_PROBABILITY = 90;
    public final int GRID_SIZE;


    private final Random random; // a reference to the Random object, passed in 
                                 // as a parameter in Boards constructors
    private int[][] grid;  // a 2D int array, its size being boardSize*boardSize
    private int score;     // the current score, incremented as tiles merge 


  // Method: Board(random, int)
  // Parameters: random generator and int for board size.
  // Description: Contructor used to create a new board with random tiles
  // Return: no return
    public Board(Random random, int boardSize) {
        this.random = random; // 
        this.GRID_SIZE = boardSize;
 	this.grid = new int[GRID_SIZE][GRID_SIZE];
	this.score = 0;
	//loop for adding random tiles
		for(int i =0; i<NUM_START_TILES; i++){
			this.addRandomTile();
	}	
	}
    

    // Method: Board(random, string)
    // Parameters: random generator and string for a saved board
    // Description: constructs a board with information from a saved boardfile
    // Return: no return
    public Board(Random random, String inputBoard) throws IOException {
        this.random = random; 
       
	File inputfile = new File(inputBoard); // reads in the inputfile
	Scanner inputscan = new Scanner(inputfile);
	this.GRID_SIZE = Integer.parseInt(inputscan.next());
	this.score = Integer.parseInt(inputscan.next());
	this.grid = new int[GRID_SIZE][GRID_SIZE]; // uses info from the fi
		for(int i = 0; i<GRID_SIZE; i++){
			for(int j =0;j<GRID_SIZE; j++){
				this.grid[i][j] = Integer.parseInt(inputscan.next());
 
   }} }


    // Method: saveBoard(string)
    // Parameters: string used to save the board
    // Description: Saves the current board to a file
    // Return: void
    public void saveBoard(String outputBoard) throws IOException {
    File saved = new File(outputBoard);
    PrintWriter savedWriter = new PrintWriter(saved);

	savedWriter.println(GRID_SIZE);
	savedWriter.println(score); // writes down the board

		for(int i = 0; i<GRID_SIZE;i++){
			for(int j = 0; j<GRID_SIZE;j++){
		
			savedWriter.print(grid[i][j] + " ");
		}
		savedWriter.println(); // saw this on the website and used it for formatting
			}
    savedWriter.close();	
    
    }

    // Method: addRandomTile
    // Parameters: none
    // Description:Adds a random tile (of value 2 or 4) to a random empty  space on the board
    // Return: none
    public void addRandomTile() {

	int count = 0;
		for(int i = 0; i<GRID_SIZE;i++){
			for(int j = 0; j<GRID_SIZE;j++){
				if(this.grid[i][j] == 0){
					count = count+1;
				}
			}
		}
				if(count == 0){
					return;
				}
				else{
					int location = this.random.nextInt(count);
					int value = this.random.nextInt(100); // generates probability
					int walker = -1; // used to displace the tile counter
		for(int i = 0; i<GRID_SIZE;i++){
			for(int j = 0; j<GRID_SIZE;j++){
				if(this.grid[i][j] == 0){
					walker++;
				if(walker == location){
				if(value<TWO_PROBABILITY){ // determines chance of being 2 or 4
				this.grid[i][j] = 2;
				}
				else{
				this.grid[i][j] = 4;
				}
				}
				}
			}
		}
				}
				}

    

    // Method: canMove
    // Parameters: direction which is a direction based on input
    // Description determins whether the board can move in a certain direction
    // Return: returns boolean depending on movement
    public boolean canMove(Direction direction){

Direction up = Direction.UP;
Direction down = direction.DOWN;
Direction left = Direction.LEFT;
Direction right = Direction.RIGHT;

for (int i = 0; i< GRID_SIZE;i++){
	for(int j = 0; j< GRID_SIZE;j++){
		if(direction.equals(up)){
			if(i != 0 && grid[i][j] != 0){
				if(grid[i-1][j] == 0)
					return true;
				
		else if(grid[i-1][j] == grid[i][j])
					return true;
				}
			}
		else if(direction.equals(down)){
			if(i != GRID_SIZE -1 && grid[i][j] != 0){
				if(grid[i+1][j] == 0)
					return true;
			
		else if(grid[i+1][j] == grid[i][j])
					return true;
				}
			}
		else if(direction.equals(left)){
			if(j != 0 && grid[i][j] != 0){
				if(grid[i][j-1] == 0)
					return true;
		else if(grid[i][j-1] == grid[i][j])
				return true;
				}
			}
		else if(direction.equals(right)){
			if(j !=GRID_SIZE -1 && grid[i][j] != 0){
				if(grid[i][j+1] == 0)
					return true;
		else if(grid[i][j+1] == grid[i][j])
					return true;
		}
	}
}
}
return false;
}


/*
    	if(direction == Direction.LEFT){
        return directionLeft();
    	}
	if(direction == Direction.UP){
	return directionUp();
	}
	if(direction == Direction.RIGHT){
	return directionRight();
	}
	if(direction == Direction.DOWN){
	return directionDown();
	}
	return false;
	}
*/

/* Helper Methods for canMove and other methods are written below */

	// Method: directionLeft()
	// Parameters: none
	// Description: Used to determine if the left movement is valid
	// Return: boolean based on validity of movement
	private boolean directionLeft(){

	for(int i = 0; i<GRID_SIZE;i++){
		for(int j = 0; j<GRID_SIZE;j++){
			int j1 = j+1;
			if(grid[i][j] != 0 && grid[i][j] == grid[i][j1]){ // uses rules given
				return true;
			} 
			if(grid[i][j] == 0 && grid[i][j1] != 0){ // second rule given
				return true;
			}
		}
	}
				return false;
}


	// Method: directionRight()
	// Parameters: none
	// Description: Determines if right movement is valid
	// Return: boolean based on validity


	private boolean directionRight(){
	
	for(int i =0;i<GRID_SIZE;i++){
		for(int j = GRID_SIZE-1; j<0;j--){
			int j1 = j-1;
			if(grid[i][j] != 0 && grid[i][j1] == grid[i][j]){
				return true;
			}
			if(grid[i][j] ==0 && grid[i][j1] !=0){ // uses the two rules of the game since its easier than finding all the falses
				return true;
			}
		}
	}
				return false;
	}
	

	// Method: directionDown()
	// Parameters: none
	// Description: Determines if moving down is valid
	// Return: Boolean for validity
	

	private boolean directionDown(){
	
	for(int i =0; i<GRID_SIZE;i++){
		for(int j =GRID_SIZE-1;j>0;j--){
			int i1 = i-1; 
			if(grid[i][j] !=0 && grid[i1][j] == grid[i][j]){
				return true;
			}
			if(grid[i][j] == 0 && grid[i1][j] != 0){ // same exact thing as other methods except with differnt indices
				return true;
			}
		}
	}
				return false;
	}


	// Method: directionUp()
	// Parameters: none
	// Description: Determines if move up is valid
	// Return: boolean vased on validity


	private boolean directionUp(){

	for(int i =0; i<GRID_SIZE;i++){	
		for(int j=0;j<GRID_SIZE-1;j++){	
			int i1 = i+1;
			if(grid[i][j] != 0 && grid[i1][j] == grid[i][j]){
				return true;
			}
			if(grid[i][j] == 0 && grid[i1][j] != 0){
				return true;
			}
		}
	}
				return false;
	}

// Method: addTiles(int,int,int,int)
// Parameters: all ints that represent the indices of the two tiles that will be added up
// Desccription: Adds up the tiles 
// Return: boolean to continue with the other methods if the tiles are changed
				
private boolean addTiles(int i1,int j1,int i2,int j2){
	boolean change = false;
	int value = 0;
	int value2 = 0;
	if(grid[i1][j1] != 0){
	value = grid[i1][j1];
	if(grid[i2][j2] == value){
	value2 = value*2;
	grid[i2][j2] = value2;
	grid[i1][j1] = 0;
	score = score+value2;
	change = true;
	}
	}
	return change; 
	}


// Method: tilesUp()
// Parameters: none
// Description: Moves all the tiles up
// Return: boolean based on if all tiles were moved
//
public boolean tilesUp(){
	boolean change = false;
		if(rowUp() == true){
		change = true;
		}
	for(int i = 0; i<GRID_SIZE;i++){
		for(int j = 0; j<GRID_SIZE-1;j++){
		change = addTiles(i+1, j,i,j);
	}
}
		if(rowUp() == true){
		change = true;
	}
	return change;
	}

// Method: rowUp()
// Parameters: none
// Description: helper method to move all the tiles in the row up
// Return: boolean based on if all the tiles were moved up one row

private boolean rowUp(){
	boolean change = false;
	for(int j = 0; j<GRID_SIZE;j++){
	boolean changeRow = false;

		do{ // Was told to use a do/while statement by TA to make it easier
		changeRow = false;
		for(int i = 0; i<GRID_SIZE-1; i++){
		boolean changed = tileChange(i+1,j,i,j);
		if(changed == true){
		changeRow = true; // keeps tabs on whether or not the tiles are changed
		change = true; //seperate boolean to be the return statement
		}
		}
}
	while(changeRow == true);
	}
return change;
}

	// Method: tilesDown()
	// Parameters: none
	// Description: moves tiles down 
	// Return: boolea based on whether or not the tiles are moved
public boolean tilesDown(){
	boolean change = false;
	if(rowDown() == true){
	change = true;
	}
	for(int i = 0;i<GRID_SIZE;i++){
		for(int j =GRID_SIZE-1;j>0;j--){
		change = addTiles(i-1,j,i,j);
	}
	}
	if(rowDown() == true){
		change = true;
	}
	return change;
	}

	// Method: rowDown()
	// Parameters: none
	// Description: helper method that moves the row of tiles down
	// Return: boolean if the tiles are moved
private boolean rowDown(){
	boolean change = false;
		for(int j = 0; j<GRID_SIZE; j++){
		boolean changeRow = false;

	do{ // same do/while statement that was done in the first helper method
	changeRow = false;
	for(int i =GRID_SIZE-1;i>0;i--){
	boolean changed = tileChange(i-1,j,i,j);
	if(changed == true){
	changeRow=true;
	change = true;
	}
	}
	}
	while(changeRow == true);
	}
	return change;
}

	//Method: tilesLeft()
	//Parameters: none
	//Description: moves tiles left
	//Return: boolean based on the tiles moving left

public boolean tilesLeft(){
	boolean change = false;
		if(jLeft() == true){
		change = true; 
		}
		for (int i = 0; i< GRID_SIZE; i++){
		for (int j = GRID_SIZE-1;j>0;j++){
		change = addTiles(i,j+1,i,j);
	}
	}
	if(jLeft() == true){
		change = true;
	}
	return change;
	}
	// Method: jLeft()
	// Parameters: none
	// Description: helper method to move the tiles one column left
	// Return: boolean based on tiles moving left

private boolean jLeft(){
	boolean change = true;
	for(int i = 0; i<GRID_SIZE;i++){
		boolean changeCol = false;

	do{
		changeCol = false;
		for(int j = 0;j<GRID_SIZE-1; j++){
		boolean changed = tileChange(i,j+1,i,j);
		if(changed == true){
		changeCol = true;
		change = true;
		}	
		}
		}
		while(changeCol == true);	
		}
		return change;
	}


	// Method: tilesRight()
	// Parameters: none
	// Description: moves tiles right
	// Return: boolean based on tiles moving right

public boolean tilesRight(){
	boolean change = false;
		if(jRight() == true){
		change = true;
		}
		for(int i = 0; i<GRID_SIZE;i++){
			for(int j = GRID_SIZE-1;j<0;j--){
		change = addTiles(i,j-1,i,j);
		}
		}
	if(jRight() == true){
		change = true;
	}
	return change;
	}
		


	// Method: jRight()
	// Parameters: none
	// Description: helper method that moves tiles right
	// Return: boolean based on tiles mobing right	

private boolean jRight(){
	boolean change = true; 	
	for(int i =0; i<GRID_SIZE;i++){
		boolean changeCol = false;
	do{
		changeCol = false;
		for(int j = GRID_SIZE-1;j>0;j--){
		boolean changed = tileChange(i,j-1,i,j);
		if(changed == true){
		changeCol = true;
		change = true;
		}
	}
		}
	while(changeCol == true);
	}
	return change;
}


	// Method: tileChange(int,int,int,int)
	// Parameters: integers that represent indices of adjacent tiles
	// Description: Switches out the tiles if one is 0 and the other is not
	// Return: boolean if it moves the tiles


private boolean tileChange(int i1, int j1, int i2, int j2){
	boolean change = true;
	int number = 0;
		if(grid[i1][j1] != 0 && grid[i2][j2] == 0){ //ensures the two tiles are 0 and non0
		 	number = grid[i1][j1];
			grid[i2][j2] = number;
			grid[i1][j1] = 0;
		change = true;
		} 
	return change;
	}



    // Method: move(Direction)
    // Parameters: Direction that represents direction of movement for board
    // Description: move the board in a certain direction
    // Return: return true if such a move is successful
    public boolean move(Direction direction) {
        
	if(canMove(direction) == true){
		if(direction == Direction.UP){
			tilesUp();
			return true;    
}
	else if(direction == Direction.DOWN){
			tilesDown();
			return true;
}
	else if(direction == Direction.LEFT){
			tilesLeft();
			return true;
}
	else if(direction == Direction.RIGHT){
			tilesRight();
			return true;
}
}
return false;
}

public int getGridSize(){
	return GRID_SIZE;
}


    // Method: isGameOver()
    // Parameters: none
    // Description: Check to see if we have a game over
    // Return: boolean depending on if game is over or not
    public boolean isGameOver() {
Direction down = Direction.DOWN;
Direction  up = Direction.UP;
Direction left = Direction.LEFT;
Direction right = Direction.RIGHT;
	if(!canMove(up) && !canMove(down) && !canMove(left) && !canMove(right)){
	return true;
}
	return false;
}      

	// Method: canPlay()
	// Parameters: none
	// Description: checks if there are any more moves left on the board
	// Return: boolean if the board is full

private boolean canPlay(){
	
	for(int i =0; i<GRID_SIZE;i++){
		for(int j = 0;j<GRID_SIZE;j++){
		if(grid[i][j] ==0){
	return false;
	}
	}
	}
	return true;	
}

private boolean moves(){
		for(int i =0;i<GRID_SIZE;i++){
			for(int j = 0; j<GRID_SIZE-1;j++){
				if(grid[i][j] == grid[i][j+1]){
				return true;
			}
		}
		}
		for(int i = 0;i<GRID_SIZE-1;i++){
			for(int j = 0; j<GRID_SIZE;j++){
				if(grid[i][j] == grid[i+1][j]){
					return true;
				}
			}
		}
	return false;
}

    // Return the reference to the 2048 Grid
    public int[][] getGrid() {
        return grid;
    }

    // Return the score
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format("Score: %d\n", score));
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++)
                outputString.append(grid[row][column] == 0 ? "    -" :
                        String.format("%5d", grid[row][column]));

            outputString.append("\n");
        }
        return outputString.toString();
    }
}
