import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeJ {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char player = 'X';
        int row, col;
        int movel = 0;

        while (true) {
            System.out.println(" 0 1 2");
            System.out.println("0 " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
            System.out.println(" -+-+-");
            System.out.println("1 " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
            System.out.println(" -+-+-");
            System.out.println("2 " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
            System.out.println("Vez do jogador" + player + ".");

            try {
                System.out.println("Digite uma linha: ");
                row = entrada.nextInt();
                System.out.println("Digite uma coluna: ");
                col = entrada.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida");
                entrada.next();
                continue;
            }

            if (row < 0 || row > 2 || col > 2 || col < 0 || board[row][col] != ' ') {
                System.out.println("Jogada inválida");
                continue;
            }

            board[row][col] = player;
            movel++;

            if (checkWin(board, player)) {
                System.out.println("Jogador" + player + "vence\n");
                break;
            }

            if (movel == 9) {
                System.out.println("Jogado inválida");
                break;
            }

            player = (player == 'X') ? '0' : 'X';
        }

        entrada.close();
    }

    private static boolean checkWin(char[][] board, char player) {
        return (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
                (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
                (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||
                (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
                (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||
                (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||
                (board[0][0] == player && board[1][2] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}