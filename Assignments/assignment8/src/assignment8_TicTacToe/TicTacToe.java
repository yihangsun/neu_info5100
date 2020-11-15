package assignment8_TicTacToe;

import java.util.*;

/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think. 
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {
	private char[][] gameBoard;
    private Scanner console;
    private char player;
    private boolean gaming;
    private String lastWinner;
    private int move;
        
    public TicTacToe() {
    	this.console = new Scanner(System.in);
    	this.player = 'X';
    	this.gaming = false;
    	this.lastWinner = "cpu";
    	intro();
    }

	private void intro() {
		this.gameBoard = new char[][] {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},};
		System.out.println("Welcome to the Tic Tac Toe Game! You are going to have a competition with the computer. CPU is 'O' and you are 'X'.");
    	System.out.println("Let's take a look of the game gameBoard!");
    	printgameBoard();
    	System.out.println("You can only choose a number from 1-9 each turn. No other numbers or symbols are allowed. Good Luck!");
    	System.out.println("Are you ready? Yes or No.");
    	String answer = console.next();
    	try {
    		if (answer.equals("Yes") || answer.equals("Y")) {
    			gaming = true;
    			move = 0;
    			if (lastWinner.equals("cpu")) {
    				player = 'O';
    			} else {
    				player = 'X';
    			}
    			askForPlace();
    		} else if (answer.equals("No") || answer.equals("N")){
    			System.out.println("It's ok. Take your time. Bye.");
    		}
    	} catch (Exception e) {
    		System.out.println("I am not clear. Bye.");
    	}
	}

    public void printgameBoard() {
        for (int i = 0 ; i < gameBoard.length; i++) {
        	for (int j = 0; j < gameBoard[0].length; j++) {
        		System.out.print(gameBoard[i][j]);
        	}
        	System.out.println("");
        }
        
    }

    public void askForPlace() {
    	while (gaming) {
    		move++;
            if (move >= 10) {
            	System.out.println("Board is full! The game ends in a tie.");
            	gameEnd();
            } else {
	            System.out.println("Enter your placement (1-9): ");
	            int pos = 0;
	            int row = 0;
	            int col = 0;
	            if (this.player == 'O') {
	            	System.out.println("It's CPU's turn.");
	            	Random rand = new Random();
	            	pos = rand.nextInt(9 - 1 + 1) + 1;
	            	row = (pos - 1) / 3 * 2;
	        		col = (pos - 1) % 3 * 2;
	            	while (gameBoard[row][col] != ' ') {
	            		pos = rand.nextInt(9 - 1 + 1) + 1;
	            		row = (pos - 1) / 3 * 2;
		        		col = (pos - 1) % 3 * 2;
	            	}
	            } else {
            		System.out.println("It's your turn.");
            		pos = console.nextInt();
            		while (true) {
	            		try {
	            			if (!(pos > 0 && pos <= 9)) {
	            				System.out.println("Unable to read; Please re-enter:");
	            				pos = console.nextInt();
	            			}
	            		} catch (InputMismatchException e) {
	            			System.out.println("Unable to read; Please re-enter:");
	            			pos = console.nextInt();
	            		}
	            		row = (pos - 1) / 3 * 2;
	            		col = (pos - 1) % 3 * 2;
	            		if (gameBoard[row][col] != ' ') {
	            			System.out.println("Already taken; Please re-enter:");
	            			pos = console.nextInt();
	            		} else {
	            			break;
	            		}
	            	}
            		row = (pos - 1) / 3 * 2;
            		col = (pos - 1) % 3 * 2;
	            }
	            placePiece(row, col);
            }
        }
    }
    
    public void emptyBoard() {
    	
    }
    
    public void placePiece(int row, int col) {
        if (player == 'X') {
        	gameBoard[row][col] = 'X';
        	printgameBoard();
        	if (checkWinner()) {
        		System.out.println("Congrats! You won!");
        		lastWinner = "Player";
        		gaming = false;
        		gameEnd();
        	} else {
        		player = 'O';
        	}
        } else {
        	gameBoard[row][col] = 'O';
        	printgameBoard();
        	if (checkWinner()) {
        		System.out.println("CPU wins ! Sorry :(");
        		lastWinner = "cpu";
        		gaming = false;
        		gameEnd();
        	} else {
        		player = 'X';
        	}
        }
    }

    public boolean checkWinner() {
    	return ((gameBoard[0][0] == player && gameBoard[0][2] == player && gameBoard[0][4] == player) || 
                (gameBoard[2][0] == player && gameBoard[2][2] == player && gameBoard[2][4] == player) || 
                (gameBoard[4][0] == player && gameBoard[4][2] == player && gameBoard[4][4] == player) || 
                (gameBoard[0][0] == player && gameBoard[2][0] == player && gameBoard[4][0] == player) || 
                (gameBoard[0][2] == player && gameBoard[2][2] == player && gameBoard[4][2] == player) || 
                (gameBoard[0][4] == player && gameBoard[2][4] == player && gameBoard[4][4] == player) || 
                (gameBoard[0][0] == player && gameBoard[2][2] == player && gameBoard[4][4] == player) || 
                (gameBoard[0][4] == player && gameBoard[2][2] == player && gameBoard[4][0] == player));
    }
    
    public void gameEnd() {
    	System.out.println("The game is ended. Do you want to start again? Yes or No.");
    	String answer = console.next();
    	try {
    		if (answer.equals("Yes") || answer.equals("Y")) {
    			gaming = true;
    			intro();
    		} else if (answer.equals("No") || answer.equals("N")) {
    			System.out.println("Bye.");
    		}
    	} catch (Exception e) {
    		System.out.println("I am not clear. Bye.");
    	}
    }
}
