package filedownloader;

import filedownloader.utils.CommandsUtil;

public class Main {
    public static void main(String[] args) {
        var commands = new CommandsUtil();

        do {
            commands.readCommand();
        }while (!commands.exit);
    }
}
