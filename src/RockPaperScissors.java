import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            char moveA = getMove(scanner, 'A');
            char moveB = getMove(scanner, 'B');
            String result = determineWinner(moveA, moveB);
            displayResult(moveA, moveB, result);

            System.out.print("Play again? [Y/N]: ");
            playAgain = scanner.next().equalsIgnoreCase("Y");
        }
        scanner.close();
    }

    private static char getMove(Scanner scanner, char player) {
        char move;
        do {
            System.out.print("Player " + player + ", enter your move (R, P, S): ");
            move = scanner.next().toUpperCase().charAt(0);
        } while (move != 'R' && move != 'P' && move != 'S');
        return move;
    }

    private static String determineWinner(char moveA, char moveB) {
        if (moveA == moveB) {
            return "It's a Tie!";
        } else if ((moveA == 'R' && moveB == 'S') || (moveA == 'S' && moveB == 'P') || (moveA == 'P' && moveB == 'R')) {
            return "Player A wins!";
        } else {
            return "Player B wins!";
        }
    }

    private static void displayResult(char moveA, char moveB, String result) {
        String outcome;
        if (moveA == moveB) {
            outcome = moveA + " vs " + moveB + ": " + result;
        } else if ((moveA == 'R' && moveB == 'S') || (moveB == 'R' && moveA == 'S')) {
            outcome = "Rock breaks Scissors";
        } else if ((moveA == 'P' && moveB == 'R') || (moveB == 'P' && moveA == 'R')) {
            outcome = "Paper covers Rock";
        } else {
            outcome = "Scissors cuts Paper";
        }
        System.out.println(moveA + " vs " + moveB + ": " + outcome);
        System.out.println(result);
    }
}
