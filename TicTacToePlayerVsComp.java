
import java.util.Scanner;

// Tic-tac-toe (Player vs Computer) code for the board of any size :
public class TicTacToePlayerVsComp {

    public static void displayBoard(char[][] board){

        for( char[] arr : board){

            for( char ele : arr){

                if( ele == '\0'){
                    System.out.print(" "+"-"+" ");
                }
                else {
                    System.out.print(" "+ ele+" ");
                }
            }

            System.out.println();
        }

    }

    public static void play(char[][] board){

        Scanner sc= new Scanner(System.in);


        while(!haveWon(board) && !isFull(board)) {

            boolean val1=false;
            boolean val2=false;

            while (!val1) {
                System.out.println();
                System.out.print("X's move, enter coordinates of the cell (r,c): (index are from 0-2) : "); // user1's move is X = 1
                System.out.println();
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (isSafe(board, r, c)) {
                    board[r][c] = 'X';
                    System.out.println();
                    displayBoard(board);
                    val1 = true;
                    if(haveWon(board)){

                        System.out.println("'X' has won the game !! ");
                        break;
                    }
                } else {
                    System.out.println("!!! That cell is already filled, enter some other coordinates.");
                }
            }
            System.out.println();

            if(!haveWon(board) && !isFull(board)) {

                System.out.println("Computer's move");
                while (!val2) {

                    int r = (int) (Math.random() * board.length);
                    int c = (int) (Math.random() * board.length);

                    if (isSafe(board, r, c)) {
                        System.out.println(""+r+" "+c);
                        System.out.println();
                        board[r][c] = 'O';
                        val2 = true;
                        displayBoard(board);
                        System.out.println();
                        if (haveWon(board)) {
                            System.out.println("Computer has won the game !! ");
                            break;
                        }


                    }

                }
            }
            else{
                break;
            }
        }
        if(isFull(board) && !haveWon(board)){
            System.out.println();
            System.out.println("its a draw.");

        }

    }

    private static boolean haveWon(char[][] board) {

        // variables to check the corresponding equality
        boolean rowCheck = false;
        boolean colCheck = false;
        boolean revDiagonalCheck = false;
        boolean diagCheck = false;

        // row check
        for (int i = 0; i < board.length; i++) {

            int start = 0;
            char ch = board[i][start];

            if (ch != '\0') { // to ignore the haveWon() method for empty spaces i.e. for ('\0')

                rowCheck = true; // main step as it reveals if row condition is satisfied or not
                for (int j = 1; j < board.length; j++) {
                    if (ch != board[i][j]) {
                        rowCheck = false; // violating condition for row
                    }
                }
                if (rowCheck) { // if any row is same then stop checking
                    break;
                }
            }

        }

        // col check
        for (int i = 0; i < board.length; i++) {

            int start = 0;
            char ch = board[start][i];

            if (ch != '\0') {// to ignore the haveWon() method for empty board

                colCheck = true;// main step as it reveals if col condition is satisfied or not
                for (int j = 1; j < board.length; j++) {
                    if (ch != board[j][i]) {
                        colCheck = false;// violating condition for col
                    }
                }
                if (colCheck) { // if any one col is same then stop checking
                    break;
                }
            }

        }

        // diagonal check
        char ch = board[0][0];

        if (ch != '\0') {// to ignore the haveWon() method for empty board

            diagCheck = true;// main step as it reveals if diagonal condition is satisfied or not
            for (int j = 1; j < board.length; j++) {
                if (ch != board[j][j]) {
                    diagCheck = false; // if any diagonal element mismatches, then stop checking
                    break;
                }
            }

        }

        // reverse diagonal check
        int rowStart = 0;
        int colStart = board.length - 1;
        ch = board[rowStart][colStart];

        if (ch != '\0') {// to ignore the haveWon() method for empty board

            revDiagonalCheck = true;// main step as it reveals if reverse diagonal condition is satisfied or not
            for (int j = 1; j < board.length; j++) {
                if (ch != board[++rowStart][--colStart]) {
                    revDiagonalCheck = false;// if any diagonal element mismatches, then stop checking
                    break;
                }
            }
        }


//            System.out.println("r :" + rowCheck + "," + "c :" + colCheck + "," + "d :" + diagCheck + "," + " rd :" + revDiagonalCheck); // for debugging
        return rowCheck || colCheck || diagCheck || revDiagonalCheck;

    }

    private static boolean isFull(char[][] board) {

        for( char[] arr : board ){

            for( char ele : arr ){

                if( ele == '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(char[][] board,int row,int col) {

        if ( board[row][col] == '\0' ){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Enter the Size of the Tic Tac Toe board (NOTE: minimum size is 3) : ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (N < 3) {
            System.out.println("Size should be at least 3. Please enter again: ");
            N = sc.nextInt();
        }

        char[][] board = new char[N][N];

        System.out.println();

        displayBoard(board);

        System.out.println();

        play(board);
    }
}
