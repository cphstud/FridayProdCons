import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    BlockingQueue<Integer> queue;
    BlockingQueue<Integer> compFibbNumberQueue;
    int feedElement;

    public Producer(BlockingQueue<Integer> queue, BlockingQueue<Integer> compFibbNumb) {
        this.queue = queue;
        this.compFibbNumberQueue=compFibbNumb;
    }

    @Override
    public void run() {
        try {
            while(true) {
                feedElement=queue.take();
                System.out.println(Thread.currentThread().getName() + " took " + feedElement);
                int compFibb=comFibbFromFeed(feedElement);
                System.out.println(Thread.currentThread().getName()+ " Sending " + compFibb);
                compFibbNumberQueue.put(compFibb);
            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();
            System.out.println("Now stopped");
        }
    }

    public int comFibbFromFeed(int feedElement) {
        if (feedElement < 2) return feedElement;
        return comFibbFromFeed(feedElement - 1) + comFibbFromFeed(feedElement - 2);
    }
}
