import java.util.Scanner;
public class TicTacToe 
{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
        char currentPlayer = 'X';
        boolean gameWon = false;
        while (gameWon!=true) 
        {
            displayBoard(board);
            System.out.print("Player " + currentPlayer + ", enter row \n1\n|\n3: ");
            int row = scanner.nextInt()-1;
            System.out.print("Enter column \n1-3: ");
            int col = scanner.nextInt()-1;
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer);
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Cell already taken. Try again!!!");
            }
        }
        displayBoard(board);
        if(currentPlayer=='X')System.out.println("Player 1(X) wins!");
        if(currentPlayer=='O')System.out.println("Player 2(O) wins!");
    }
    private static void displayBoard(char[][] board) 
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j<2)System.out.print(" | ");
            }
            System.out.println();
            if (i<2)System.out.println("---------");
        }
    }
    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0]==player && board[i][1]==player && board[i][2]==player)return true;
            if (board[0][i]==player && board[1][i]==player && board[2][i]==player)return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)return true;
        return false;
    }
}
