package softwareDesign.module4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client extends Thread {
    private final String name;

    public Client(String name){
        this.name = name;
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
            Socket cSocket = new Socket("localhost", Constants.PORT);


            try (PrintWriter out = new PrintWriter(cSocket.getOutputStream())) {
                // First send the name of the client
                out.write(name + "\n");
                out.flush();

                Random rand = new Random();

                // Then, send chats
                Thread.sleep(rand.nextInt(1000, 5000));

                out.write("Hey there! This is me, " + name + '\n');
                out.flush();

                Thread.sleep(rand.nextInt(1000, 5000));

                out.write("It's nice to meet all of you\n");
                out.flush();

                out.write("end\n");
                out.flush();
            }

        } catch (IOException | InterruptedException e) {
            // could not create socket, close application
            e.printStackTrace();
        }
    }
}
