
import java.util.Scanner;

public class TicTacToe {

    static String Board[][]=new String[3][3];
    static Scanner sc=new Scanner(System.in);
    static int ScorePlayer_O=0;
    static int ScorePlayer_X=0;

//    public void CreateBoard(int num){
//        Board =new String[num][num];
//
//    }

    public void Player_O(){
        System.out.println("\nPlayer O Turn -------> ");
        System.out.println("Enter Row number: ");
        int row=sc.nextInt()-1;
        System.out.println("Enter col number: ");
        int col=sc.nextInt()-1;
//        System.out.println("Enter O: ");
        if(Board[row][col]==null) {
            Board[row][col] = "O";
        }
        else {
            System.out.println("\nthat slot isn't free .Please enter your choice in empty slot ");
            DisplayBoard();
            Player_O();
        }
        DisplayBoard();

    }

    public void Player_X(){
        System.out.println("\nPlayer X Turn -------> ");
        System.out.println("Enter Row number: ");
        int row= sc.nextInt()-1;
        System.out.println("Enter col number: ");
        int col=sc.nextInt()-1;
//        System.out.println("Enter X: ");
        if(Board[row][col]==null) {
            Board[row][col] = "X";
        }
        else {
            System.out.println("\nthat slot isn't free .Please enter your choice in empty slot ");
            DisplayBoard();
            Player_X();
        }
        DisplayBoard();

    }

    public void DisplayBoard(){
        for(int i = 0; i< Board.length; i++){
            for(int j = 0; j< Board.length; j++){
                System.out.print(Board[i][j]+"   |   ");
            }
            System.out.println();
        }
    }

    public void ValidateScore(){

        int row=0;
        int col=0;

        // Score of player_X

        //System.out.println("scores of playerX");

        //Row check
//        if(Board[0][0]=="X" && Board[0][1]=="X" && Board[0][2]=="X"){
//            ScorePlayer_X +=1;
//        }
//        if(Board[1][0]=="X" && Board[1][1]=="X" && Board[1][2]=="X"){
//            ScorePlayer_X +=1;
//        }
//        if(Board[2][0]=="X" && Board[2][1]=="X" && Board[2][2]=="X"){
//            ScorePlayer_X +=1;
//        }

        for(int i=0;i<Board.length;i++){
            if(Board[row][i]=="X"){
                ScorePlayer_X+=1;
            }
            row+=1;
        }
        //System.out.println("After row check: "+ScorePlayer_X);

        // col check
//        if(Board[0][0]=="X" && Board[1][0]=="X" && Board[2][0]=="X"){
//            ScorePlayer_X +=1;
//        }
//        if(Board[0][1]=="X" && Board[1][1]=="X" && Board[2][1]=="X"){
//            ScorePlayer_X +=1;
//        }
//        if(Board[0][2]=="X" && Board[1][2]=="X" && Board[2][2]=="X"){
//            ScorePlayer_X +=1;
//        }

        for(int i=0;i<Board.length;i++){
            if(Board[i][col]=="X"){
                ScorePlayer_X+=1;
            }
            col+=1;
        }

        //System.out.println("After col check: "+ScorePlayer_X);

        // Right Diagonal
//        if(Board[0][2]=="X" && Board[1][1]=="X" && Board[2][0]=="X"){
//            ScorePlayer_X +=1;
//        }

        for (int i = 0; i < Board.length; i++) {
            if (Board[i][i]=="X") {
                ScorePlayer_X+=1;
            }
        }
        //System.out.println("After right diagonal check: "+ScorePlayer_X);

        // left diagonal
//        if(Board[0][0]=="X" && Board[1][1]=="X" && Board[2][2]=="X"){
//            ScorePlayer_X +=1;
//        }

        for (int i = 0; i < Board.length; i++) {
            if (Board[i][Board.length - 1 - i]=="X") {
                ScorePlayer_X+=1;
            }
        }

        //System.out.println("After left diagonal check: "+ScorePlayer_X);
        System.out.println("Score of player X: "+ScorePlayer_X);

        // Score of player_O


        //Row check

        //System.out.println("Scores of player_O");
        if(Board[0][0]=="O" && Board[0][1]=="O" && Board[0][2]=="O"){
            ScorePlayer_O +=1;
        }
        if(Board[1][0]=="O" && Board[1][1]=="O" && Board[1][2]=="O"){
            ScorePlayer_O +=1;
        }
        if(Board[2][0]=="O" && Board[2][1]=="O" && Board[2][2]=="O"){
            ScorePlayer_O +=1;
        }

        //System.out.println("After row check check: "+ScorePlayer_O);

        // col check
        if(Board[0][0]=="O" && Board[1][0]=="O" && Board[2][0]=="O"){
            ScorePlayer_O +=1;
        }
        if(Board[0][1]=="O" && Board[1][1]=="O" && Board[2][1]=="O"){
            ScorePlayer_O +=1;
        }
        if(Board[0][2]=="O" && Board[1][2]=="O" && Board[2][2]=="O"){
            ScorePlayer_O +=1;
        }
        //System.out.println("After col check: "+ScorePlayer_O);
        // right Diagonal
        if(Board[0][2]=="O" && Board[1][1]=="O" && Board[2][0]=="O"){
            ScorePlayer_O +=1;
        }
        //System.out.println("After right diagonal check: "+ScorePlayer_O);

        // left diagonal
        if(Board[0][0]=="O" && Board[1][1]=="O" && Board[2][2]=="O"){
            ScorePlayer_O +=1;
        }
        //System.out.println("After left diagonal check: "+ScorePlayer_O);

        System.out.println("Score of player_O: "+ScorePlayer_O);


    }

    public boolean IsFull(){
        for(int i=0;i<Board.length;i++){
            for(int j=0;j<Board.length;j++){
                if(Board[i][j]==null){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        System.out.println("Enter the number of Rows/cols of the board: ");
//        int n=sc.nextInt();
        TicTacToe obj=new TicTacToe();
        Boolean isfull=true;
        //obj.CreateBoard(n);
        System.out.println("\n 3 X 3 Tic tac toe Game \n");
        obj.DisplayBoard();
        while (isfull) {
            if(!obj.IsFull()) {
                obj.Player_O();
            }
            if(!obj.IsFull()){
                obj.Player_X();
            }
            else{
                isfull=false;
            }

        }
        System.out.println("\nGame Over.\n");
        System.out.println("\nValidating Scores.............\n");
        obj.ValidateScore();
        if(ScorePlayer_O >ScorePlayer_X){
            System.out.println("\nPlayer_O Won!!! Congratulations");
        }
        else if (ScorePlayer_X==ScorePlayer_O) {
            System.out.println(" \nIt's a Draw. Well played");
        }
        else {
            System.out.println("\nPlayer_X Won!!! Congratulations");
        }
    }
}
