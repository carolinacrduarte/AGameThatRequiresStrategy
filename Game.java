/* Carolina Duarte
   Dr. Steinberg
   COP3503 Fall 2022
   Programming Assignment 1
*/

import java.util.Arrays;
import java.util.Scanner;

public class Game {
   public static void main(String [] args) throws Exception
	{
      int i = 8;
      int j = 8;
      int[][] board = new int[i][j]; //Initializes an 8x8 board
  
      //This creates the 8x8 board and fills the board with asterisks
      for (int row = 0; row < board.length; row++) {
          for (int column = 0; column < board[0].length; column++) {
              board[row][column] = 0;
          }
     
          for (int column=0; column<8; column++) { //creates right amount of cells for the 8 columns
              System.out.print(board[row][column] + " "); //prints # of cells
          }
                  System.out.println(); //prints each row on new line
      }

      char[] moves_array = {'r', 'b', 'd'};
       
}
}





    
