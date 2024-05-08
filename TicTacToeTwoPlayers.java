package Games;

import java.util.Scanner;

public class TicTacToeTwoPlayers {

    public static void displayBoard(int[][] board){

        for(int[] arr: board){
            for(int ele: arr){
                if(ele==1) {
                    System.out.print(" X " + " ");
                } else if (ele==2) {
                    System.out.print(" O "+" ");
                }
                else{
                    System.out.print(" - "+" ");
                }
            }
            System.out.println();
        }
    }

    public static void play(int[][] board){

        Scanner sc= new Scanner(System.in);


        while(!haveWon(board) && !isFull(board)) {

            boolean val1=true;
            boolean val2=true;

            while (val1) {
                System.out.println();
                System.out.print("X's move, enter coordinates of the cell (r,c): (index are from 0-2) : "); // user1's move is X = 1
                System.out.println();
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (isSafe(board, r, c)) {
                    board[r][c] = 1;
                    val1 = false;
                    if(haveWon(board)){
                        System.out.println();
                        System.out.println("'X' has won the game !! ");
                        break;
                    }
                } else {
                    System.out.println("!!! That cell is already filled, enter some other coordinates.");
                }
            }
            System.out.println();


            if(!haveWon(board) && !isFull(board)) {

                while (val2) {
                    displayBoard(board);
                    System.out.println();
                    System.out.print("O's move, enter coordinates of the cell (r,c): (index are from 0-2) : "); // user2's move is O = 2
                    System.out.println();
                    int r = sc.nextInt();
                    int c = sc.nextInt();
                    if (isSafe(board, r, c)) {
                        board[r][c] = 2;
                        val2 = false;
                        if(haveWon(board)){
                            System.out.println();
                            System.out.println("'O' has won the game !! ");
                            break;
                        }

                    } else {
                        System.out.println();
                        System.out.println("!!! That cell is already filled, enter some other coordinates.");
                    }
                }
                System.out.println();
                displayBoard(board);
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

    private static boolean haveWon(int[][] board) {

        // check for same row

        for(int i=0;i<board.length;i++) {


                if (board[i][0] == 1 &&  board[i][board.length - 2]==1 && board[i][board.length - 1]==1) {
                    return true;
                }

                if (board[i][0] == 2 &&  board[i][board.length - 2]==2 && board[i][board.length - 1]==2) {
                    return true;
                }

                // check for same col

                if (board[0][i] == 1 &&  board[1][i]==1 && board[2][i]==1) {
                    return true;
                }

                if (board[0][i] == 2 &&  board[1][i]==2 && board[2][i]==2) {
                    return true;
                }

                // check for diagonal

                if(board[i%3][i%3]== 1 && board[(i+1)%3][(i+1)%3]==1 && board[(i+2)%3][(i+2)%3]==1){
                    return true;
                }

                if(board[i%3][i%3]== 2 && board[(i+1)%3][(i+1)%3]==2 && board[(i+2)%3][(i+2)%3]==2){
                    return true;
                }

        }

        return false;
    }

    private static boolean isFull(int[][] board) {

        for(int[] arr: board){
            for(int ele: arr){
                if(ele==0){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board,int row,int col) {

        if(board[row][col]==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int board[][]=new int[3][3];
        System.out.println();
        displayBoard(board);
        System.out.println();
        play(board);
    }
}
