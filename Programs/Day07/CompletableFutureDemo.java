package Day07;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        }).thenApply(result -> result + " World")
          .thenApply(String::toUpperCase);

        System.out.println("Main thread is free to do other things...");
        System.out.println("Result: " + future.get());
    }
}
