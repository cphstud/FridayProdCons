import java.util.concurrent.*;

public class Main {
    static BlockingQueue<Integer> fibbFeedNumbers = new ArrayBlockingQueue<>(8);
    static BlockingQueue<Integer> fibbToBeSummed = new ArrayBlockingQueue<>(8);

    public static void main(String[] args) {
        initSharedRes();
        Producer p1 = new Producer(fibbFeedNumbers, fibbToBeSummed);
        Producer p2 = new Producer(fibbFeedNumbers, fibbToBeSummed);
        Producer p3 = new Producer(fibbFeedNumbers, fibbToBeSummed);
        Producer p4 = new Producer(fibbFeedNumbers, fibbToBeSummed);
        Consumer c1 = new Consumer(fibbToBeSummed);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(c1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t5.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        /*
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(p1);
        es.execute(p2);
        es.execute(p3);
        es.execute(p4);
        es.execute(c1);
        try {
            es.awaitTermination(10, TimeUnit.SECONDS);
            es.shutdownNow();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

         */

	// write your code here
    }
    static void initSharedRes() {
        try {
            fibbFeedNumbers.put(4);
            fibbFeedNumbers.put(5);
            fibbFeedNumbers.put(8);
            fibbFeedNumbers.put(12);
            fibbFeedNumbers.put(21);
            fibbFeedNumbers.put(22);
            fibbFeedNumbers.put(34);
            fibbFeedNumbers.put(35);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
