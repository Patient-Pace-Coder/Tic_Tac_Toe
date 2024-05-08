import java.util.Scanner;
public class TicTacToeTwoPlayers {

    public static void displayBoard( char board[][]){

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

    public static void play(char[][] board) {

        Scanner scanner = new Scanner(System.in);

        while (!haveWon(board) && !isFull(board)){

            boolean player1 = false;

            boolean player2 = false;

            while (!player1) {

                System.out.print("X's move, enter the coordinates of the cell (r,c) (0 - "+ (board.length - 1)+") :");
                System.out.println();
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isSafe(board, row, col)) {

                    board[row][col] = 'X';
                    displayBoard(board);
                    System.out.println();
                    player1 = true;

                    if (haveWon(board)) {

                        System.out.println("X has won the game !!");
                        break;
                    }

                } else {
                    System.out.println("That cell is already filled , enter some other coordinates!!.");
                    System.out.println();
                }
            }

            System.out.println();

            if(!haveWon(board) && !isFull(board)) {

                while (!player2) {

                    System.out.println("O's move, enter the coordinates of the cell (r,c) (0 - "+ (board.length - 1)+") : ");
                    System.out.println();
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();

                    if (isSafe(board, row, col)) {
                        board[row][col] = 'O';
                        displayBoard(board);
                        System.out.println();
                        player2 = true;
                        if (haveWon(board)) {

                            System.out.println("O has won the game!!");
                            break;
                        }
                    } else {
                        System.out.println("The cell is already filled, enter some other coordinates!!.");
                        System.out.println();
                    }
                }
            }
            else {
                break;
            }

        }

        if(!haveWon(board) && isFull(board)){
            System.out.println();
            System.out.println("Its a draw");
        }

    }

    private static boolean isSafe(char[][] board, int row, int col) {

        if ( board[row][col] == '\0' ){
            return true;
        }

        return false;
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
