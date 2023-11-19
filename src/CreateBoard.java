
public class CreateBoard {
    TicTacToe tictac;

    public CreateBoard(TicTacToe tictac) {
        this.tictac = tictac;
    }

    public void initializeTicTac() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tictac.ticTac[i][j] = ' ';
            }
        }
    }


    public void printTicTac() {
        System.out.println("Use coordinates: first number of row, second number of column");
        System.out.println("Use space between the numbers");
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tictac.ticTac[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

}