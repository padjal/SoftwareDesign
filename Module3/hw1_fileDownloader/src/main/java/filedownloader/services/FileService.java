package filedownloader.services;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {
    private String path = Paths.get("").toAbsolutePath().toString();

    public void changeDestination(String newDestination) throws IllegalArgumentException{
        var newPath = Paths.get(newDestination);
        if (!Files.exists(newPath)){
            throw new IllegalArgumentException("Invalid directory path. Please double check.");
        }

        path = newDestination;
    }

    public void loadFiles(List<String> urls) throws IOException {
        System.out.println("Downloading...\n");

        for (String currentUrl :
                urls) {
            var url = new URL(currentUrl);
            var urlParts = currentUrl.split("/");
            var fileName = urlParts[urlParts.length-1];

            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(Paths.get(path, fileName).toString());
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

            reportProgress(fileName);
        }
    }

    private void reportProgress(String fileName){
        System.out.println("File downloaded successfully: " + fileName);
    }
}
