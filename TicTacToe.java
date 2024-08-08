import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char[][] board = {
              {'_', '_', '_'},
              {'_', '_', '_'},
              {'_', '_', '_'}
            };

            printBoard(board);

            for (int i = 0; i<9; i++) {
              if (i%2==0) {
                String turn = "Turn: X ";
                System.out.print(turn);
                char turnSign = 'X';
                int spot[] = askUser(board);
                board[spot[0]][spot[1]] = turnSign;
                printBoard(board);

                
                if (checkWin(board)== 3) {
                  System.out.println("X wins!");
                  break;
                }
                else if (i==8){
                  System.out.println("It's a tie!");
                  break;
                }

              }
              else {
                String turn = "Turn: O ";
                System.out.print(turn);
                char turnSign = 'O';
                int spot[] = askUser(board);
                board[spot[0]][spot[1]] = turnSign;
                printBoard(board);

                if (checkWin(board)== -3) {
                  System.out.println("O wins!");
                  break;
                }
              }
              System.out.println();
            }

            System.out.println("Game over!");

            scan.close();
      }

      public static void printBoard(char board[][]) {
          System.out.print("\n");
          for (int i = 0; i<board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j<board[i].length; j++) {
              System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
            System.out.print("\n");
          }
        }   

      public static int[] askUser(char boardPosition[][]){
        System.out.println("- pick a row and column number: ");
        int spotRow = scan.nextInt();
        int spotColumn = scan.nextInt();

        while(boardPosition[spotRow][spotColumn] != '_') {
          System.out.println("Please choose a spot that is not taken!");
          spotRow = scan.nextInt();
          spotColumn = scan.nextInt();
        }

        int[] spot = new int [] {spotRow, spotColumn};
        return spot;
      }

      public static int checkWin(char board[][]){
        int rows = checkRows(board); 
        
        if (Math.abs(rows) == 3) {
          return rows; 
          }
      
          int columns = checkColumns(board);
        if (Math.abs(columns) == 3) {
          return columns;  
          }
          
        
          int leftDiagonal = checkLeft(board);
        if (Math.abs(leftDiagonal) == 3) {
          return leftDiagonal; 
          }
        
          int rightDiagonal = checkRight(board);
        if (Math.abs(rightDiagonal) == 3) {
          return rightDiagonal;
          }
          return 2;
      }

      public static int checkRows(char[][] board) {
          int count = 0;

          for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[i].length; j++){
              if (board[i][j] == 'X') {
                count +=1;
              }
              else if (board[i][j] == 'O') {
                count -=1;
              }
            }
            if (count == 3 || count == -3){
              break;
            }
            else {
              count = 0;
            }
          }
          return count;
        }
      
        public static int checkColumns(char[][] board) {
          int count = 0;

          for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[i].length; j++){
              if (board[j][i] == 'X') {
                count +=1;
              }
              else if (board[j][i] == 'O') {
                count -=1;
              }
            }
            if (count == 3 || count == -3){
              break;
            }
            else {
              count = 0;
            }
          }

          return count;
        }
      
        public static int checkLeft(char[][] board) {
          int count = 0;

          for (int i = 0; i<board.length; i++) {
            if (board[i][i] == 'X') {
              count += 1;
            }
            else if (board[i][i] == 'O'){
              count -= 1;
            }
          }
          return count;
        }
      
        public static int checkRight(char[][] board) {
          int count = 0;
          int j = 2;
          for (int i = 0; i<board.length; i++) {
            
            if (board[i][j] == 'X'){
              count += 1;
            }
            else if (board[i][j] == 'O'){
              count -= 1;
            }
            j--;
          }
        
          return count;
        }

}
