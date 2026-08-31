import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        int randomIndex = (int) (Math.random() * 3);
        return choices[randomIndex];
    }

    public static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "Draw";
        }
        if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors"))
                || (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock"))
                || (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))) {
            return "Player";
        }
        return "Computer";
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        double playerPercentage = ((double) playerWins / totalGames) * 100;
        double computerPercentage = ((double) computerWins / totalGames) * 100;
        String[][] stats = new String[2][2];
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(Math.round(playerPercentage * 100.0) / 100.0);
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(Math.round(computerPercentage * 100.0) / 100.0);
        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("Game\tPlayer\tComputer\tWinner");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + "\t" + gameResults[i][0] + "\t" + gameResults[i][1] + "\t\t" + gameResults[i][2]);
        }
        System.out.println();
        System.out.println("Winning Percentages:");
        for (String[] row : stats) {
            System.out.println(row[0] + ": " + row[1] + "%");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int numberOfGames = scanner.nextInt();
        String[] options = {"Rock", "Paper", "Scissors"};

        String[][] gameResults = new String[numberOfGames][3];
        int playerWins = 0;
        int computerWins = 0;

        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("Enter your choice (Rock/Paper/Scissors) for game " + (i + 1) + ": ");
            String playerChoice = scanner.next();
            String computerChoice = getComputerChoice();
            String winner = determineWinner(playerChoice, computerChoice);

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(playerWins, computerWins, numberOfGames);
        displayResults(gameResults, stats);

        scanner.close();
    }
}
