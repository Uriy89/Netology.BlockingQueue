package task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter extends Thread {

    private static final int INTERVAL = 1000;
    private static final int CALL = 30;
    private static final int SPEAKING = 3000;

    private static final int MAX_CALL = 60;
    private final BlockingQueue<String> queue;

    public CallCenter() {
        this.queue = new ArrayBlockingQueue<>(MAX_CALL);
    }

    public void calling() {
        for (int i = 0; i < MAX_CALL; i++) {
            System.out.println("Идет звонок " + i);
            try {
                queue.put("звонок " + i);
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                return;
            }
        }
    }



    public void takeCall() {
        for (int i = 0; i < CALL; i++) {
            try {
                String call = queue.take();
                System.out.println("Специалист " + Thread.currentThread().getName() + " принял " + call);
                Thread.sleep(SPEAKING);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}
