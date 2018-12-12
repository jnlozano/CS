/*
 * Name, login, PID: Jimmy Lozano, cs8bwanf, A12638975
 * Date: Winter 2018
 * Filename: Gui2048.java
 * Help: Piazza, Textbook, Discussion, TAs
 *
 * Description:
 * This file creates the GUI for the game 2048 that was created in psa3. 
 * The file contains the customization of the interface in terms of colors and shapes. 
 * Much of the variables used here are the same used in board.java
 *
 * */
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;

import java.io.*;

public class Gui2048 extends Application
{
    private String outputBoard; // The filename for where to save the Board
    private Board board; // The 2048 Game Board

    private GridPane pane;

	private int[][] grid;
	public int size;
	public StackPane stack = new StackPane();
	public int score;


    @Override
/* Method start(Stage primaryStage)
 * Parameters: Stage
 * Return: void
 * Description: 
 * Initializes the primarystage to create the GUI that was customized by the methods in this file
 */
    public void start(Stage primaryStage)
    {
        // Process Arguments and Initialize the Game Board
        processArgs(getParameters().getRaw().toArray(new String[0]));

        // Create the pane that will hold all of the visual objects
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setStyle("-fx-background-color: rgb(187, 173, 160)");
        // Set the spacing between the Tiles
        pane.setHgap(15); 
        pane.setVgap(15);

        /** GUI code added here */
		Text score = gameScore();
		pane.add(score,2,0);
		pane.add(gameName(),0,0);
		stack.getChildren().add(pane);
		this.grid = board.getGrid();
		this.size = board.getGridSize();
		setGame();
		Scene scene = new Scene(stack);
		primaryStage.setTitle("Gui2048");
		primaryStage.setScene(scene);
		primaryStage.show();
		if(!board.isGameOver()){
			scene.setOnKeyPressed(new MyKeyHandler());
		}
		pane.requestFocus();
   
 
    }

    /** Instance methods added here */

/*
 * Method: gameName()
 * Parameters: none
 * Return: text
 * Description:
 * This gets the name of the game to display on the GUI
 */
public Text gameName(){
	Text gameName = new Text("2048");
	gameName.setFont(Font.font("Times New Roman",FontWeight.BOLD,50));
	gameName.setFill(Color.RED);
	return gameName;
}

/*
 * Method: gameEnd()
 * Parameters: none
 * Return: pane
 * Description:
 * This is the pane for the GUI that is used when the game is over
 */
public Pane gameEnd(){
	Pane end = new Pane();
	end.setStyle("-fx-background-color:rgb(180,170,150,0.8)");
	end.setPadding(new Insets(11.5,12.5,13.5,14.5));
	Text endText = new Text("Game now over!");
	endText.setFont(Font.font("Times New Roman",FontWeight.BOLD, 70));

	endText.xProperty().bind(stack.widthProperty().subtract(endText.getLayoutBounds().getWidth()).divide(2));

	endText.yProperty().bind(stack.heightProperty().divide(2));
	endText.setFill(Color.RED);
	end.getChildren().add(endText);
	return end;
}

/* 
 * Method: gameSquares(int tile)
 * Parameters: int
 * Return: Rectangle
 * Description:
 * Used to create the square tiles that hold the numbers
 */
public Rectangle gameSquares(int tile){
	Rectangle square = new Rectangle();
	square.setWidth(100);
	square.setHeight(100);
	
	square.setFill(colorNum(tile));
	return square;
	}

/*
 * Method: setGame()
 * Parameters: none
 * Return: void
 * Description:
 * Uses the values of the original board to be placed onto the gridboard used for the GUI
 */
public void setGame(){
	this.score = board.getScore();
	
	stack.getChildren().clear();
	pane.getChildren().clear();
	
	Text currentScore = gameScore();
	pane.add(currentScore,2,0);

	pane.setConstraints(currentScore,2,0,3,1, HPos.CENTER, VPos.TOP);
	pane.add(gameName(),0,0);

	for(int i = 0; i<size;i++){
		for(int j = 0; j<size; j++){
			Rectangle tile = gameSquares(grid[i][j]);
			Text num = tileNum(grid[i][j]);
			pane.add(tile,i,j+1);
			pane.add(num,i,j+1);
			pane.setHalignment(num,HPos.CENTER);
	}
	}
			stack.getChildren().add(pane);
			
			if(board.isGameOver() == true){
			stack.getChildren().add(gameEnd());
}
	}


/*
 * Method: gameScore()
 * Parameters: none
 * Return: text
 * Description:
 * Used to get the score of the current game to be placed on the GUI.
 */
public Text gameScore(){
	Text currScore = new Text();
		currScore.setText("Score: " + score);
		currScore.setFont(Font.font("Time New Roman",FontWeight.BOLD,50));
		currScore.setFill(Color.RED);
		return currScore;
}


/*
 * Method: tileNum(int tile)
 * Parameters: int
 * Return: text
 * Description:
 * customizes the color and style of the text used in the squares
 */
public Text tileNum(int tile){
	Text currTile = new Text();
		if(tile >0){
			currTile.setText(Integer.toString(tile));
			currTile.setFill(Color.RED);
		}
	if( tile >= 16){
			currTile.setText(Integer.toString(tile));
			currTile.setFill(Color.GREEN);
	}
	currTile.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		return currTile;
		}


/* 
 * Method: colorNum(int tile)
 * Parameters: int
 * Return: color
 * Description:
 * Asigns the colors of the tile based on the number of the tile
 */
public Color colorNum(int tile){
		switch(tile){
			case 0:
					return Constants2048.COLOR_EMPTY;
			case 2:
					return Constants2048.COLOR_2;
			case 4: 
					return Constants2048.COLOR_4;
			case 8: 
					return Constants2048.COLOR_8;
			case 16:
					return Constants2048.COLOR_16;
			case 32:
					return Constants2048.COLOR_32;
			case 64:
					return Constants2048.COLOR_64;
			case 128: 
					return Constants2048.COLOR_128;
			case 256:
					return Constants2048.COLOR_256;
			case 512:
					return Constants2048.COLOR_512;
			case 1024:
					return Constants2048.COLOR_1024;
			case 2048:
					return Constants2048.COLOR_2048;
			default:
					return Constants2048.COLOR_OTHER;
		}
}


/*
 * class: MyKeyHandler
 * Description:
 * This is where the eventhandler is stored to implement the methods
 */
public class MyKeyHandler implements EventHandler<KeyEvent>{

	@Override
/*
 * Method: handle(KeyEvent e)
 * Parameters: KeyEvent
 * Return: void
 * Description: determines what happens based on the moves of the user.
 */
		public void handle(KeyEvent e){
			if(e.getCode() == KeyCode.UP){
				if(board.canMove(Direction.UP)){
					board.move(Direction.UP);
					board.addRandomTile();
					setGame();
					System.out.println("Moving Up");
					}
				}
			else if(e.getCode() == KeyCode.DOWN){
				if(board.canMove(Direction.DOWN)){
					board.move(Direction.DOWN);
					board.addRandomTile();
					setGame();
					System.out.println("Moving Down");
					}
				}
			else if(e.getCode() == KeyCode.LEFT){
				if(board.canMove(Direction.LEFT)){
					board.move(Direction.LEFT);
					board.addRandomTile();
					setGame();
					System.out.println("Moving Left");
					}
				}
			else if(e.getCode() == KeyCode.RIGHT){
				if(board.canMove(Direction.RIGHT)){
					board.move(Direction.RIGHT);
					board.addRandomTile();
					setGame();
					System.out.println("Moving Right");
					}
				}
			else if(e.getCode() == KeyCode.S){
				try{
					board.saveBoard(outputBoard);
				} catch(IOException ex){
					System.out.println("saveBoard threw an Exception");
				}
					System.out.println("Saving Board to " + outputBoard);
				}
		}
}

		


    /** DO NOT EDIT BELOW */

    // The method used to process the command line arguments
    private void processArgs(String[] args)
    {
        String inputBoard = null;   // The filename for where to load the Board
        int boardSize = 0;          // The Size of the Board

        // Arguments must come in pairs
        if((args.length % 2) != 0)
        {
            printUsage();
            System.exit(-1);
        }

        // Process all the arguments 
        for(int i = 0; i < args.length; i += 2)
        {
            if(args[i].equals("-i"))
            {   // We are processing the argument that specifies
                // the input file to be used to set the board
                inputBoard = args[i + 1];
            }
            else if(args[i].equals("-o"))
            {   // We are processing the argument that specifies
                // the output file to be used to save the board
                outputBoard = args[i + 1];
            }
            else if(args[i].equals("-s"))
            {   // We are processing the argument that specifies
                // the size of the Board
                boardSize = Integer.parseInt(args[i + 1]);
            }
            else
            {   // Incorrect Argument 
                printUsage();
                System.exit(-1);
            }
        }

        // Set the default output file if none specified
        if(outputBoard == null)
            outputBoard = "2048.board";
        // Set the default Board size if none specified or less than 2
        if(boardSize < 2)
            boardSize = 4;

        // Initialize the Game Board
        try{
            if(inputBoard != null)
                board = new Board(new Random(), inputBoard);
            else
                board = new Board(new Random(), boardSize);
        }
        catch (Exception e)
        {
            System.out.println(e.getClass().getName() + 
                               " was thrown while creating a " +
                               "Board from file " + inputBoard);
            System.out.println("Either your Board(String, Random) " +
                               "Constructor is broken or the file isn't " +
                               "formated correctly");
            System.exit(-1);
        }
    }

    // Print the Usage Message 
    private static void printUsage()
    {
        System.out.println("Gui2048");
        System.out.println("Usage:  Gui2048 [-i|o file ...]");
        System.out.println();
        System.out.println("  Command line arguments come in pairs of the "+ 
                           "form: <command> <argument>");
        System.out.println();
        System.out.println("  -i [file]  -> Specifies a 2048 board that " + 
                           "should be loaded");
        System.out.println();
        System.out.println("  -o [file]  -> Specifies a file that should be " + 
                           "used to save the 2048 board");
        System.out.println("                If none specified then the " + 
                           "default \"2048.board\" file will be used");  
        System.out.println("  -s [size]  -> Specifies the size of the 2048" + 
                           "board if an input file hasn't been"); 
        System.out.println("                specified.  If both -s and -i" + 
                           "are used, then the size of the board"); 
        System.out.println("                will be determined by the input" +
                           " file. The default size is 4.");
    }
}
