package battleship;

import battleship.utils.ConsoleUtility;

public class App {
    public static void main(String[] args) {
        GameController game = new GameController();

        while(game.isPlayable){
            game.takeTurn();
        }

        game.displayResults();
    }
}
