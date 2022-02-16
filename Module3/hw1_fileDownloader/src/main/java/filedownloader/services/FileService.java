package filedownloader.services;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        System.out.println("Downloading...");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (String currentUrl :
                urls) {
            executorService.execute(new DownloadTask(new URL(currentUrl), path));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){
        }
    }
}
