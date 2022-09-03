/* Carolina Duarte
   Dr. Steinberg
   COP3503 Fall 2022
   Programming Assignment 1
*/

//import java.io.File;

public class Game {

   //Constructor with two parameters:
   Game(int board_size, String obj) 
   {       
      //int[][] board = new int[board_size][board_size]; 
  
      /*This creates the 8x8 board and fills the board with zeros.
      for (int row = 0; row < board.length; row++) {
          for (int column = 0; column < board[0].length; column++) {
              board[row][column] = 0;
          }
     
          for (int column=0; column<8; column++) { //Creates right amount of cells for the 8 columns.
              System.out.print(board[row][column] + " "); //Prints # of cells.
          }
                  System.out.println(); //Prints each row on new line.
      }
      readMoves(obj);
      */
   }

   //Scans the respective text files of moves and store them in the character array attribute:
   /*public void readMoves (String obj) throws FileNotFoundException 
   {
      String theString = "";

      File file = new File(obj);
      try (Scanner scanner = new Scanner(file)) {
         theString = scanner.nextLine();
         while (scanner.hasNextLine()) {
         theString = theString + "\n" + scanner.nextLine();
         }
      }

      char[] charArray = theString.toCharArray();
      System.out.println(charArray);
   }
   */
 
   public int play (int winner)
   {
      if (winner == 1) { //Player 1 winning strategy.  
         //The text files provided is only for player 2's moves.
         //This means you will use these moves when coming up with player 1's strategy to win.
                 
         return 1;
      }
      else { //Player 2 winning strategy.
         //The text files is not used when coming up with player 2's strategy to win.
         //As for player 2's strategy, you will have to think carefully what must happen in order for player 2 to win.

         return 2;   
      }
   }

} //End of code.

