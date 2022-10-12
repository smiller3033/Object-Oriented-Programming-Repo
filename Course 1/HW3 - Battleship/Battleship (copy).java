


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

        //player 1 plays
        updateLocationBoard(input, 1, 2, player2LocationBoard);
        printBattleShip(player1LocationBoard);
/*
        //gameplay loop
        boolean winner = true;
        do {
            
            
        } while (winner);
    
*/
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

    //determines valid firing move
    private static char[][] updateLocationBoard(Scanner input, int player, int otherPlayer, char[][] LocationBoard) {
        char reference = 'a';
        boolean valid = false;
        int[] playerTarget = new int[2];
        while (!valid) {
            System.out.println("Player " + player + ", enter hit row/column:");
            playerTarget[0] = input.nextInt();
            playerTarget[1] = input.nextInt();
            if ((playerTarget[0] < 5) && (playerTarget[1] < 5)) {
                reference = LocationBoard[playerTarget[0]][playerTarget[1]];
            }
            else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
            if (reference == '-') {
                System.out.println("PLAYER " + player + " MISSED!");
                LocationBoard[playerTarget[0]][playerTarget[1]] = 'O';
                valid = true;
            }
            else if (reference == '@') {
                System.out.println("PLAYER " + player + " HIT PLAYER " + otherPlayer + "’s SHIP!");
                LocationBoard[playerTarget[0]][playerTarget[1]] = 'X';
                valid = true;
            }
            else if (reference == 'X' || reference == 'O') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
            }
        }

        return LocationBoard;
        
        
    }

    //updates fire history board for the player that attacked
    
}
