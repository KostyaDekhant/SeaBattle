import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public Game() {
        player1 = new Player();
        player2 = new Player();
        scanner = new Scanner(System.in);

        player1.getGrid().generateShips();
        player2.getGrid().generateShips();
    }

    public Player getPlayer1() { return player1; }

    public Player getPlayer2() { return player2; }

    public void play() {
        Player current = player1;
        Player opponent = player2;

        while (true) {
            System.out.println("Ход игрока:");
            opponent.getGrid().printMap(); // маска: только попадания и промахи
            System.out.print("Введите координаты (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean hit = current.makeMove(x, y, opponent);

            if (hit) {
                System.out.println("Попадание!");
            } else {
                System.out.println("Мимо!");
                // меняем игроков
                Player temp = current;
                current = opponent;
                opponent = temp;
            }

            if (opponent.hasLost()) {
                System.out.println("Победа!");
                break;
            }
        }
    }
}