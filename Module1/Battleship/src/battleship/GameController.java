package battleship;

import battleship.models.Ocean;
import battleship.models.Ship;
import battleship.utils.ConsoleUtility;
import jdk.jshell.spi.ExecutionControl;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void startNew(){
        System.out.println("A new battleships game has started!\n" +
                "============GAME SETUP============\n");

        var ocean = createOcean();

        enterShips();
    }

    private static Ocean createOcean(){
        System.out.println("============OCEAN============\n");

        int rows;
        do{
            System.out.print("Ocean rows: ");
            rows = ConsoleUtility.getInt();
            if(rows<=1){
                System.out.println("Please enter a number greater or equal than 1.");
            }
        }while(rows <= 1);

        int columns;
        do{
            System.out.print("Ocean columns: ");
            columns = ConsoleUtility.getInt();
            if(columns<=1){
                System.out.println("Please enter a number greater or equal than 1.");
            }
        }while(columns <= 1);

        return new Ocean(rows, columns);
    }

    private static List<Ship> enterShips(){
        System.out.println("============BATTLESHIPS============\n");

        int carriers;
        do{
            System.out.print("Number of carriers (5 cells): ");
            carriers = ConsoleUtility.getInt();
            if(carriers<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(carriers < 0);

        int battleships;
        do{
            System.out.print("Number of battleships (4 cells): ");
            battleships = ConsoleUtility.getInt();
            if(battleships<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(battleships < 0);

        int cruisers;
        do{
            System.out.print("Number of cruisers (3 cells): ");
            cruisers = ConsoleUtility.getInt();
            if(cruisers<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(cruisers < 0);

        int destroyers;
        do{
            System.out.print("Number of destroyers (2 cells): ");
            destroyers = ConsoleUtility.getInt();
            if(destroyers<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(destroyers < 0);

        int submarines;
        do{
            System.out.print("Number of submarines (1 cell): ");
            submarines = ConsoleUtility.getInt();
            if(submarines<0){
                System.out.println("Please enter a non-negative number.");
            }
        }while(submarines < 0);

        //TODO: update functionality.
        return new ArrayList<Ship>();
    }
}
