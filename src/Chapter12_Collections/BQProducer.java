package Chapter12_Collections;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BQProducer extends Thread {

    private final BlockingQueue<String> queue;
    private final String name;
    private int nextNumber =  1;
    private final Random random = new Random();

    public BQProducer(BlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

//    @Override
//    public void run() {
//        while(true)
//        {
//            String str = name + "  " + nextNumber;
//            System.out.println(name + );
//        }
//    }
}
