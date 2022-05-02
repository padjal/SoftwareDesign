package softwareDesign.module4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientGenerator {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Runnable> tasks = new ArrayList<>();

        tasks.add(new Client("Pavel"));
        tasks.add(new Client("kuchuk"));
        tasks.add(new Client("kuchuk"));
        tasks.add(new Client("Grinkrug"));
        tasks.add(new Client("Maya"));

        for (var task : tasks){
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
