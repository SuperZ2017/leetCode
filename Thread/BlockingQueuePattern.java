package Thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞队列实现生产者消费者模式
 */
public class BlockingQueuePattern {

    public static void main(String[] args) {
        // 阻塞队列
        BlockingQueue shareQueue = new LinkedBlockingDeque();

        //创建生产者线程和消费者线程
        Thread prodThread = new Thread(new Producer(shareQueue));
        Thread consThread = new Thread(new Consumer(shareQueue));

        //启动生产者线程和消费者线程
        prodThread.start();
        consThread.start();
    }

    // 生产者类
    static class Producer implements Runnable {

        private final BlockingQueue shareQueue;

        Producer(BlockingQueue shareQueue) {
            this.shareQueue = shareQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                try {
                    // 产生 10 以内的随机整数放入阻塞队列
                    Random random = new Random();
                    int prodRandom = random.nextInt(10);
                    System.out.println("Produced: " + prodRandom);
                    shareQueue.put(prodRandom);
                } catch (InterruptedException e){

                }
            }
        }
    }

    // 消费者类
    static class Consumer implements Runnable {

        private final BlockingQueue shareQueue;

        Consumer(BlockingQueue shareQueue) {
            this.shareQueue = shareQueue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Consumed: " + shareQueue.take());
                } catch (InterruptedException e){

                }
            }
        }
    }
}
