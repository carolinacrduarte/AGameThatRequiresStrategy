/* Carolina Duarte
   Dr. Steinberg
   COP3503 Fall 2022
   Programming Assignment 1
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Game {
//Attributes:
 private int[][] board; //2D integer array that symbolizes the board.
 private char[] computerMoves; //1D primitive char array that will store computerize moves.

//Constructor with two parameters:
 public Game(int size, String filename) {
  this.board = new int[size][size];
  //Read moves:
  try {
   this.readMoves(filename);
  } catch (Exception e) {
   System.err.println(e.getMessage());
   System.exit(0);
  }
 }

//Scans the respective text files of moves and store them in the character array attribute:
 public void readMoves(String filename) {
  File file = new File(filename);
  if (file.exists()) {
   //Get the number of lines which represents the size of the array to hold the moves on the file.
   int size = 0;
   Path path = Path.of(filename);

   try (Stream<String> stream = Files.lines(path, Charset.defaultCharset())) {
    size = (int) stream.count();
    this.computerMoves = new char[size];
   } catch (IOException e) {
    throw new RuntimeException(e);
   }

   //Read all lines to the array.
   try {
    int i = 0;
    for (String str : Files.readAllLines(path)) {
     this.computerMoves[i++] = str.trim().charAt(0);
    }
   } catch (IOException e) {
    throw new RuntimeException(e);
   }
  }else {
   try {
    throw new FileNotFoundException(filename.concat(" - not existing!"));
   } catch (FileNotFoundException e) {
    e.printStackTrace();
   }
  }
 }

//Simulates a round of the game: 
 public int play(int player) {
  //Check if the moves are read from text file.
  if (this.computerMoves==null) {
   System.err.println("Error reading computerized moves!");
   System.exit(0);
  }
  //Counters:
  int i = 0, 
      j = 0,
      k = 0,
      gridSize = 8;
  boolean isComputerMove = false;

  //Make the moves:
  while (true) {
   //Marks the current location of the knight.
   this.board[i][j] = i + j;
   //Computer move.
   char ch = this.computerMoves[k];
   //Make moves.
   if (player == 2 && (i == 0 && j == 0)) {
    if (ch == 'd') {
     j += 1;
     i += 1;
    } else if (ch == 'r') {
     j += 1;
    } else if (ch == 'b') {
     i += 1;
    }
    k += 1;
   }else{
    //Check if the next move is to be made by player 1.
    //Player 2 is the computer (moves are specified on the file).
     if (!isComputerMove) {
      //If player 1 was specified to be the winner, ensure it is the last to move the piece.
      if (player==1) {
       //Make a move that will not allow the next move by player 2 to be the final location of the piece.
       if (((i + 1) == gridSize - 1 && (j + 1) == gridSize - 1)) {
        i += 1;
       }
      }
      else{
       //If player 2 is to be the winner, ensure it is the last to move the piece.
       //If the next move will enable player 1 to be the winner, change the normal player one stragey, diagonal movement to either down or right instead.    
       if ((i + 1) == 6 && (j + 1) == 7) {
        i += 1;
       }else {
        //Normal diagonal movement of player 1.
        if ((j + 1) < gridSize) {
         j += 1;
        }
        if ((i + 1) < gridSize) {
         i += 1;
        }
       }
      }
      //Marks that the move is done by player 1 and the next move is for player 2 (computer moves).
      isComputerMove = true;
    }else {
     //Normal computer moves from the file:
     if (ch == 'd') {
      if ((j + 1) < gridSize) {
       j += 1;
      }
      if ((i + 1) < gridSize) {
       i += 1;
      }
     } else if (ch == 'r') {
      if ((j + 1) < gridSize) {
       j += 1;
      }
     } else if (ch == 'b') {
      if ((i + 1) < gridSize) {
       i += 1;
      }
     }
    //Marks that the move is done by player 2 (computer moves) and next move is for player 1.
     isComputerMove = false;
     k += 1;
   }
  }
  //Exit the game once the piece is at the correct final location grid[7][7].
  if (i == gridSize - 1 && j == gridSize - 1) {
   break;
  }
 }

 //If the last move was done by computer:
 if (isComputerMove) {
  return 2;
 }

  return 1;
 }
}
//End of code.
