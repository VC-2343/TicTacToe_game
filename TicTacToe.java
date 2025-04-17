import java.util.*;
class game{
    static char[][] board;

    public game()
    {   
        board=new char[3][3];
        initboard();
    }

    void initboard(){  
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }
static void boardDisplay(){
    System.out.println("------------");
    for(int i=0;i<board.length;i++){
        System.out.print("|");
        for(int j=0;j<board[i].length;j++){
            System.out.print(board[i][j] +" | ");
        }
System.out.println();
System.out.println("------------"); 
}
}

static void placemark(int row,int col,char mark){
if(row>=0 && row<=2 && col>=0 && col<=2){
board[row][col]=mark;
}
else{
    System.out.println("Invalid");
}
}

static boolean checkCwin(){
    for(int j=0;j<=2;j++){
        if (board[0][j]!=' ' && board[0][j]==board[1][j]&& board[1][j]==board[2][j]){
            return true;
        }

    }return false;
}

static boolean chechkRwin(){
    for(int i=0;i<=2;i++){
        if(board[i][0]!=' ' && board[i][0]==board[i][1]&& board[i][1]==board[i][2]){
return true;
        }
    }
    return false;
}
static boolean checkDiagonal() {
    if (board[1][1] != ' ' && 
        ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || 
         (board[2][0] == board[1][1] && board[1][1] == board[0][2]))) {
        return true;
    }
    return false;
}


static boolean isBoardFull() {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == ' ') {
                return false;
            }
        }
    }
    return true;
}}



abstract class player{
    String name;
char mark;

abstract void makeMove();
boolean isValidMove(int row,int col){
    if(row>=0 && row<=2 && col>=0 && col<=2){
    if(game.board[row][col]==' '){
        return true;
    }}
    else{
        System.out.println("invalid");
    }        
        return false;
   
}}


class humanPlayer extends player{
humanPlayer(String name,char mark)
{
    this.name=name;
    this.mark=mark;
}
void makeMove(){
    int row,col;
    Scanner sc=new Scanner(System.in);
    
    do{
        System.out.println("enter the row and column");
        row=sc.nextInt();
        col=sc.nextInt();
    }while(!isValidMove(row,col));
    game.placemark(row,col,mark);
}
 
}

class player2 extends player{
    player2(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }
    void makeMove(){
        int row,col;
        Random r=new Random();

        do{
            System.out.println("enter the row and column");
            row=r.nextInt(3);
            col=r.nextInt(3);
        }while(!isValidMove(row,col));
        game.placemark(row,col,mark);
    }
    
   }
   public class TicTacToe{
    public static void main(String[] args) {
      game t=new game();

      humanPlayer p1=new humanPlayer("vanshika", 'x');
      player2 p2=new player2("computer", 'o');

      player cp;
      cp=p1;

      while(true){
System.out.println(cp.name+"'s"+"  turn");
cp.makeMove();
game.boardDisplay();

if(game.chechkRwin() || game.checkCwin() || game.checkDiagonal()){
System.out.println(cp.name+" has won");
break;
}
else if (game.isBoardFull()) {
    System.out.println("It's a draw!");
    break;
} else {
    cp = (cp == p1) ? p2 : p1;
    }
}}}