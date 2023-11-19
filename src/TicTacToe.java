import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    CreateBoard createBoard;
    Scanner scanner = new Scanner(System.in);
    char ticTac[][] = new char[3][3];
    boolean konec = false;

    int round = 0;

    int totalcount = 0;


    public TicTacToe() {
        createBoard = new CreateBoard(this);
    }

    public void playGame() {
        createBoard.initializeTicTac();
        createBoard.printTicTac();

        while (!konec) {
            int xCount = 0;
            int oCount = 0;
            boolean xWins = false;
            boolean oWins = false;

            int row, col;

            try {
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers from 1 to 3.");
                scanner.nextLine();
                continue;
            }

            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (ticTac[row][col] == ' ') {
                    if (round % 2 == 0) {
                        ticTac[row][col] = 'X';
                        round++;
                    } else {
                        ticTac[row][col] = 'O';
                        round++;
                    }
                    totalcount++;
                } else {
                    System.out.println("This cell is occupied. Choose another one.");
                    continue;
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3.");
                continue;
            }
            createBoard.printTicTac();



            for (char radek[] : ticTac) {
                if (radek[0] == 'X' && radek[1] == 'X' && radek[2] == 'X') {
                    xWins = true;
                } else if (radek[0] == 'O' && radek[1] == 'O' && radek[2] == 'O') {
                    oWins = true;
                }
                for (char cell : radek) {
                    if (cell == 'X') {
                        xCount++;
                    } else if (cell == 'O') {
                        oCount++;
                    }
                }
            }


            for (int j = 0; j < 3; j++) {
                if ((ticTac[0][j] == 'X' && ticTac[1][j] == 'X' && ticTac[2][j] == 'X') ||
                        (ticTac[0][0] == 'X' && ticTac[1][1] == 'X' && ticTac[2][2] == 'X') ||
                        (ticTac[2][0] == 'X' && ticTac[1][1] == 'X' && ticTac[0][2] == 'X')) {
                    xWins = true;
                } else if ((ticTac[0][j] == 'O' && ticTac[1][j] == 'O' && ticTac[2][j] == 'O') ||
                        (ticTac[0][0] == 'O' && ticTac[1][1] == 'O' && ticTac[2][2] == 'O') ||
                        (ticTac[2][0] == 'O' && ticTac[1][1] == 'O' && ticTac[0][2] == 'O')) {
                    oWins = true;
                }
            }

            if (xWins) {
                System.out.println("X wins");
                konec = true;
            } else if (oWins) {
                System.out.println("O wins");
                konec = true;
            } else if (!oWins && !xWins && totalcount == 9) {
                System.out.println("Draw");
                konec = true;
            }


        }


    }
}




