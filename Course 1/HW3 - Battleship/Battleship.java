


import java.util.*;
import java.io.*;

public class Battleship {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");
        System.out.println("");

        //initialize player 1
        System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
        char[][] player1LocationBoard = createLocationBoard(input);
        printBattleShip(player1LocationBoard);

        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }

        //initialize player 2
        System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
        char[][] player2LocationBoard = createLocationBoard(input);
        printBattleShip(player2LocationBoard);

        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }

        //initialize target history boards
        char[][] player1TargetHistory = createTargetHistory();
        char[][] player2TargetHistory = createTargetHistory();


        //initialize play
        int player = 0;
        int otherPlayer = 0;
        char reference = 'a';
        boolean valid = false;
        int[] playerTarget = new int[2];

        //gameplay loop
        boolean winner = false;
        do {
            //player 1 plays
        
            player = 1;
            otherPlayer = 2;
            reference = 'a';
            valid = false;
            //determine valid move, determine whether hit or miss
            while (!valid) {
                System.out.println("Player " + player + ", enter hit row/column:");
                playerTarget[0] = input.nextInt();
                playerTarget[1] = input.nextInt();
                if ((playerTarget[0] < 5) && (playerTarget[1] < 5)) {
                    reference = player2LocationBoard[playerTarget[0]][playerTarget[1]];
                }
                else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
                if (reference == '-') {
                    System.out.println("PLAYER " + player + " MISSED!");
                    reference = 'O';
                    valid = true;
                }
                else if (reference == '@') {
                    System.out.println("PLAYER " + player + " HIT PLAYER " + otherPlayer + "’s SHIP!");
                    reference = 'X';
                    valid = true;
                }
                else if (reference == 'X' || reference == 'O') {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                }
            }
            //update location and target history boards
            player2LocationBoard = updateLocationBoard(playerTarget, reference, player2LocationBoard);
            player1TargetHistory = updateTargetHistory(playerTarget, reference, player1TargetHistory);

            printBattleShip(player1TargetHistory);
            winner = checkWinner(player2LocationBoard, player);
            if (winner) {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                break;
            }

            //player 2 plays
        
            player = 2;
            otherPlayer = 1;
            reference = 'a';
            valid = false;
            //determine valid move, determine whether hit or miss
            while (!valid) {
                System.out.println("Player " + player + ", enter hit row/column:");
                playerTarget[0] = input.nextInt();
                playerTarget[1] = input.nextInt();
                if ((playerTarget[0] < 5) && (playerTarget[1] < 5)) {
                    reference = player1LocationBoard[playerTarget[0]][playerTarget[1]];
                }
                else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
                if (reference == '-') {
                    System.out.println("PLAYER " + player + " MISSED!");
                    reference = 'O';
                    valid = true;
                }
                else if (reference == '@') {
                    System.out.println("PLAYER " + player + " HIT PLAYER " + otherPlayer + "’s SHIP!");
                    reference = 'X';
                    valid = true;
                }
                else if (reference == 'X' || reference == 'O') {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                }
            }
            //update location and target history boards
            player1LocationBoard = updateLocationBoard(playerTarget, reference, player1LocationBoard);
            player2TargetHistory = updateTargetHistory(playerTarget, reference, player2TargetHistory);

            printBattleShip(player2TargetHistory);
            winner = checkWinner(player1LocationBoard, player);
            if (winner) {
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                break;
            }
        } while (!winner); 
        System.out.println("");
        System.out.println("Final boards:");
        System.out.println("");
        printBattleShip(player1LocationBoard);
        System.out.println("");
        printBattleShip(player2LocationBoard);
    }

    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

    //create friendly board for the player to see
    private static char[][] createLocationBoard(Scanner input) {
        //get coordinates of every ship, check if given coordinates are in bounds and not repeated
        String[][] ships = new String[5][2];
        for (int index = 0; index < 5; index++) {
            boolean validInput = true;
            while (validInput) {
                System.out.println("Enter ship " + (index + 1) + " location:");
                String tempRow = input.next();
                String tempCol = input.next();
                if (Integer.parseInt(tempRow) < 5 && Integer.parseInt(tempCol) < 5) {
                    if (!(searchOrderedArray(tempRow, tempCol, ships))) {
                        ships[index][0] = tempRow;
                        ships[index][1] = tempCol;
                        validInput = false;
                    }
                    else {
                        System.out.println("You already have a ship there. Choose different coordinates.");
                    }
                }
                else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
            }
        }       

        //creates blank board
        char[][] playerBoard = new char[5][5];
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                playerBoard[row][column] = '-';
            }
        }

        //sets ship location
        for (int index = 0; index < 5; index++) {
            
            playerBoard[Integer.parseInt(ships[index][0])][Integer.parseInt(ships[index][1])] = '@';
        }

        return playerBoard;
    }

    //check if given orded pair as String is in array
    private static boolean searchOrderedArray(String targetRow, String targetCol, String[][] array) {
        boolean result = false;
        for (String[] orderedPair : array) {
            String row = orderedPair[0];
            String col = orderedPair[1];
            
            if ((row != null) && (row.equals(targetRow))) {
                if ((col != null) && (col.equals(targetCol))) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


    //creates initial target history boards
    private static char[][] createTargetHistory() {
        char[][] playerBoard = new char[5][5];
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                playerBoard[row][column] = '-';
            }
        }
        return playerBoard;
    }

    //updates location history
    private static char[][] updateLocationBoard(int[] playerTarget, char reference, char[][] locationBoard) {
        locationBoard[playerTarget[0]][playerTarget[1]] = reference;

        return locationBoard;
         
    }

    //updates fire history board for the player that attacked
    private static char[][] updateTargetHistory(int[] playerTarget, char reference, char[][] targetHistory) {
        targetHistory[playerTarget[0]][playerTarget[1]] = reference;

        return targetHistory;
    }

    //checks to see if there is a winner
    private static boolean checkWinner(char[][] locationBoard, int player) {
        boolean winner = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (locationBoard[i][j] == '@') {
                    winner = false;
                }
            }
        }
        return winner;
    }
}
