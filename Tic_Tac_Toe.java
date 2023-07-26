import java.util.Scanner;

public class Tic_Tac_Toe {
    private char[][] board;
    private char currentPlayer;
    private int size;

    public Tic_Tac_Toe(int n) {
        board = new char[n][n];
        currentPlayer = 'X';
        size = n;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    private boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinningMove(int row, int col) {
        // Check row
        boolean win = true;
        for (int j = 0; j < size; j++) {
            if (board[row][j] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // Check column
        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][col] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // Check diagonal
        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // Check reverse diagonal
        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != currentPlayer) {
                win = false;
                break;
            }
        }
        return win;
    }

    private boolean makeMove(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnd = false;
        boolean validMove;

        while (!gameEnd) {
            System.out.println("Player " + currentPlayer + ", enter your move (row), Press enter ( column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            validMove = makeMove(row, col);

            if (validMove) {
                printBoard();

                if (isWinningMove(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnd = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameEnd = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the Tic Tac Toe board: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Tic_Tac_Toe game = new Tic_Tac_Toe(size);
        game.play();
    }
}
