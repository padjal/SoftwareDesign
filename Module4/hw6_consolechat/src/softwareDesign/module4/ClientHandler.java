package softwareDesign.module4;

import javax.xml.namespace.QName;
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread {
    private final Socket clientSocket;

    public ClientHandler(Socket socket){
        clientSocket = socket;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String name = in.readLine();

            System.out.println(name + " started");
            System.out.flush();

            // read name and check if existing
            if (UsersKeeper.userExists(name)) {
                throw new UserExistsException();
            }

            String inLine;

            while ((inLine = in.readLine()) != null) {
                    System.out.println(name + ": " + new Date(System.currentTimeMillis()) + ": " + inLine);
                    System.out.flush();
            }
        }catch (UserExistsException e){
            System.out.println(e.getMessage());
            System.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
