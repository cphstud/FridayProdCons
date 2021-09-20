import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Integer> compFibbNumbers;
    int sum;
    boolean keepRunning=true;
    public Consumer(BlockingQueue<Integer> queue) {
        this.compFibbNumbers = queue;
        this.sum=0;
    }
    @Override
    public void run() {
        try {
            while (keepRunning) {
                int candidate = compFibbNumbers.take();
                sum=sum+candidate;
                System.out.println("Sum: " + sum);
            }
        } catch (InterruptedException ie) {
            System.out.println("Was interrupted ..");
            System.out.println("Sum: " + sum);
        }
    }
}
