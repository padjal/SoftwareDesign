package softwareDesign.module4;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    static boolean serverRuns;

    public static void main(String[] args) {
        try {
            ServerSocket sSocket = new ServerSocket(Constants.PORT);
            serverRuns = true;

            while(serverRuns){
                // accepts client sockets and run them each in a new thread
                var client = new ClientHandler(sSocket.accept());

                client.start();
                System.out.println("thread " + client.getName() + " started");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // exit, failed to load socket
        } finally {
            // close everything
        }
    }
}
