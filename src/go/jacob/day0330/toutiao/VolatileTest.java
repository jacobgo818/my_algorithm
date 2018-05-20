package go.jacob.day0330.toutiao;

import java.util.concurrent.ThreadPoolExecutor;

public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        final Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while(Thread.activeCount()>1)
            Thread.yield();

        System.out.println(race);
    }
}
