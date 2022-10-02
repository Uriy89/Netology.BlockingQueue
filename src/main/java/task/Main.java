package task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        final CallCenter callCenter = new CallCenter();

        new Thread(null, callCenter::calling, "Входящие звонки").start();
        new Thread(null, callCenter::takeCall, "Иван").start();
        new Thread(null, callCenter::takeCall, "Ольга").start();
        new Thread(null, callCenter::takeCall, "Максим").start();

    }
}
