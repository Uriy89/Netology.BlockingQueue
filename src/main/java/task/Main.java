package task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    private static final int MAX_CALL = 60;
    private static final int CALL = 30;
    private static final int SPEAKING = 3000;
    private static final int INTERVAL = 1000;

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_CALL);

        new Thread(() -> {
            for (int i = 0; i < MAX_CALL; i++) {
                System.out.println("Идет звонок " + i);
                try {
                    queue.put("звонок " + i);
                    Thread.sleep(INTERVAL);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < CALL; i++) {
                try {
                    String call = queue.take();
                    System.out.println("Специалист Иван принял " + call);
                    Thread.sleep(SPEAKING);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < CALL; i++) {
                try {
                    String call = queue.take();
                    System.out.println("Специалист Олег принял " + call);
                    Thread.sleep(SPEAKING);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < CALL; i++) {
                try {
                    String call = queue.take();
                    System.out.println("Специалист Ирина приняла " + call);
                    Thread.sleep(SPEAKING);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();


    }
}
