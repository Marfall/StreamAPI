package programming;

import java.util.stream.IntStream;

public class FP10Threads {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();

        Runnable runnable1 = () ->  {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
        };

        Thread thread4 = new Thread(runnable1);
        thread4.start();
//
        Runnable runnable3 = () ->
                IntStream.range(0, 10000).forEach(i -> System.out.println(Thread.currentThread().getId() + ":" + i)
                );

        Thread thread5 = new Thread(runnable3);
        thread5.start();
    }

}
