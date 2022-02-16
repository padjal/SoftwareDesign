package filedownloader.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;

public class DownloadTask implements Runnable{
    URL url;
    String destinationPath;

    public DownloadTask(URL url, String destinationPath){
        this.url = url;
        this.destinationPath = destinationPath;
    }

    private void reportProgress(String fileName){
        System.out.println("File " + fileName + " downloaded successfully to " + destinationPath);
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
        var urlParts = url.toString().split("/");
        var fileName = urlParts[urlParts.length-1];

        try {
            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(Paths.get(destinationPath, fileName).toString());
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

            readableByteChannel.close();
            fileOutputStream.close();

            reportProgress(fileName);
        }catch (IOException ioException){
            System.out.println("An error occurred while downloading resource from " + url);
        }
    }
}
