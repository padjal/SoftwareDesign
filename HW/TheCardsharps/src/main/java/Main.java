public class Main {
    public static void main(String[] args) {
        var game = new GameTwentyOne();

        var players = game.generatePlayers(10);

        game.start(players);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game.stop(players);
    }
}
