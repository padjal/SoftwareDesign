package battleship;

import battleship.enums.TileState;
import battleship.models.*;
import battleship.utils.ConsoleUtility;

import java.util.*;

public class GameController {
    static final double SHIP_COEFFICIENT = 0.2;
    int rows;
    int columns;
    List<Ship> fleet;
    int turns = 1;
    public boolean isPlayable = true;
    Tile[][] ocean;

    /**
     * Initializes the game controller and performs important setups for the game.
     */
    public GameController(){
        System.out.println("A new battleships game has started!\n" +
                "=========GAME SETUP==========");

        createOcean();

        //Initialize ocean cells.
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                ocean[i][j] = new Tile(i, j);
            }
        }

        fleet = enterShips();

        placeShips();

        // Game ends.
        if(fleet.size() == 0){
            isPlayable = false;
        }

        display();
    }

    /**
     * Handle a player's turn.
     */
    public void takeTurn(){
        System.out.println("-----Turn " + turns + "-----");

        int row = 0;
        while (row<1 || row > rows){
            System.out.print("Row: ");
            row = ConsoleUtility.getInt();
        }

        int col = 0;
        while (col<1 || col > columns){
            System.out.print("Column: ");
            col = ConsoleUtility.getInt();
        }

        fire(row, col);

        display();

        turns++;
    }

    /**
     * Display the results of after the end of the game.
     */
    public void displayResults(){
        System.out.println("=======GAME ENDED=======");
        System.out.println("Number of turns: " + --turns);
    }

    private void drawBoard(){
        System.out.print("       ");

        for (int i=0; i<columns; i++){
            if(i < 9){
                System.out.print(i+1 + "  ");
            }else if(i >= 9 && i < 99 ){
                System.out.print(i+1 + " ");
            }else if(i >= 99 && i < 999){
                System.out.print(i+1 + "");
            }
        }

        System.out.println();

        System.out.print("      ");
        for (int i=0; i<columns; i++){
            System.out.print("---");
        }
        System.out.println();

        for (int i=0; i<rows; i++){
            System.out.print(i+1 + "\t" + "| ");
            for (int j=0; j<columns; j++){
                if (ocean[i][j].state == TileState.MISSED){
                    System.out.print("[" + "\033[0;32m" +ocean[i][j] + "\033[0m" + "]");
                    continue;
                }else if(ocean[i][j].state == TileState.HIT){
                    System.out.print("[" + "\033[0;33m" +ocean[i][j] + "\033[0m" + "]");
                    continue;
                }else if(ocean[i][j].state == TileState.SUNK){
                    System.out.print("[" + "\033[0;31m" +ocean[i][j] + "\033[0m" + "]");
                    continue;
                }
                System.out.print("[" + ocean[i][j] + "]");
            }
            System.out.println();
        }
    }

    private void display(){
        drawBoard();

        System.out.println("=========REMAINING SHIPS=========");
        System.out.print("Carriers (5 cells):\t\t");
        System.out.println(fleet.stream().filter(s -> s.getClass() == Carrier.class).count());
        System.out.print("Battleships (4 cells):\t");
        System.out.println(fleet.stream().filter(s -> s.getClass() == Battleship.class).count());
        System.out.print("Cruisers (3 cells):\t\t");
        System.out.println(fleet.stream().filter(s -> s.getClass() == Cruiser.class).count());
        System.out.print("Carriers (2 cells):\t\t");
        System.out.println(fleet.stream().filter(s -> s.getClass() == Destroyer.class).count());
        System.out.print("Submarines (1 cells):\t");
        System.out.println(fleet.stream().filter(s -> s.getClass() == Submarine.class).count());
    }

    private void createOcean(){
        System.out.println("============OCEAN============");
        do{
            System.out.print("Ocean rows: ");
            rows = ConsoleUtility.getInt();
            if(rows<5){
                System.out.println("Please enter a number greater or equal than 5.");
            }
        }while(rows < 5);

        do{
            System.out.print("Ocean columns: ");
            columns = ConsoleUtility.getInt();
            if(columns<5){
                System.out.println("Please enter a number greater or equal than 5.");
            }
        }while(columns < 5);

        ocean = new Tile[rows][columns];
    }

    private List<Ship> enterShips(){
        var ships = new ArrayList<Ship>();

        System.out.println("===========BATTLESHIPS===========");

        int carriers;
        do{
            System.out.print("Number of carriers (5 cells): ");
            carriers = ConsoleUtility.getInt();
            if(carriers<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(carriers < 0);

        for (int i = 0; i<carriers; i++){
            ships.add(new Carrier());
        }

        int battleships;
        do{
            System.out.print("Number of battleships (4 cells): ");
            battleships = ConsoleUtility.getInt();
            if(battleships<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(battleships < 0);

        for (int i = 0; i<battleships; i++){
            ships.add(new Battleship());
        }

        int cruisers;
        do{
            System.out.print("Number of cruisers (3 cells): ");
            cruisers = ConsoleUtility.getInt();
            if(cruisers<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(cruisers < 0);

        for (int i = 0; i<cruisers; i++){
            ships.add(new Cruiser());
        }

        int destroyers;
        do{
            System.out.print("Number of destroyers (2 cells): ");
            destroyers = ConsoleUtility.getInt();
            if(destroyers<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(destroyers < 0);

        for (int i = 0; i<destroyers; i++){
            ships.add(new Destroyer());
        }

        int submarines;
        do{
            System.out.print("Number of submarines (1 cell): ");
            submarines = ConsoleUtility.getInt();
            if(submarines<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(submarines < 0);

        for (int i = 0; i<submarines; i++){
            ships.add(new Submarine());
        }

        int shipTilesCount = 0;
        for (var ship :
                ships) {
            shipTilesCount += ship.size;
        }

        if(rows*columns*SHIP_COEFFICIENT < shipTilesCount){
            System.out.println("Please enter fewer ships. Program will not be able to work otherwise.");
            ships = (ArrayList<Ship>) enterShips();
        }

        return ships;
    }

    private void placeShips(){
        Random rand = new Random();
        for (var ship :fleet) {
            while (!ship.isPlaced) {
               int row = rand.nextInt(0, rows);
               int column = rand.nextInt(0, columns);
               int orientation = rand.nextInt(0, 1);
               if(ocean[row][column].shipId != null){
                   continue;
               }
               if(orientation == 0){
                   // Horizontal
                   for (int i = 1; i<=ship.size; i++){
                       if(column + 1 > columns-1){
                           break;
                       }
                       if(ocean[column + 1][row].shipId != null){
                           break;
                       }
                       if(i == ship.size){
                           // Ship fits. Placing the ship in the ocean.
                           for (int k = 0; k<ship.size; k++) {
                               ocean[row][column + k].shipId = ship.id;
                           }
                           ship.isPlaced = true;
                       }
                   }
               }else{
                    // Horizontal
                   for (int i = 1; i<=ship.size; i++){
                       if(row + 1 > rows-1){
                           break;
                       }
                       if(ocean[column][row + 1].shipId != null){
                           break;
                       }
                       if(i == ship.size){
                           // Ship fits. Placing the ship in the ocean.
                           for (int k = 0; k<ship.size; k++) {
                               ocean[row + k][column].shipId = ship.id;
                           }
                           ship.isPlaced = true;
                       }
                   }
               }
            }
        }
    }

    private void fire(int row, int column){
        if(ocean[row-1][column-1].shipId == null){
            ocean[row-1][column-1].state = TileState.MISSED;
            return;
        }

        ocean[row-1][column-1].state = TileState.HIT;

        var ship = fleet.stream().filter(s -> s.id == ocean[row-1][column-1].shipId).findFirst().orElseThrow();

        ship.timesHit++;

        if(ship.size == ship.timesHit){
            fleet.removeIf(s -> s.id == ship.id);

            for (int i =0; i< rows; i++){
                for (int j=0; j<columns; j++){
                    if (ocean[i][j].shipId == ship.id){
                        ocean[i][j].state = TileState.SUNK;
                    }
                }
            }
        }

        // Game ends.
        if(fleet.stream().count() == 0){
            displayResults();
            isPlayable = false;
        }
    }
}
