package ThreadingPOC;

import java.util.stream.IntStream;

/**
 * @author Kunal Sharma at 26/03/22 9:07 PM
 */
public class Test {

    public static void main(String[] args) throws java.lang.Exception {
//        Printer printerObj = new Printer();
//        EvenOddThread t1 = new EvenOddThread(1,10,printerObj,false); // Odd thread
//        EvenOddThread t2 = new EvenOddThread(2,10,printerObj,true);  // Even thread
//        System.out.println("Thread execution starts.....");
//        t1.start(); //Starting thread1 which calls run method
//        t2.start(); //Starting thread2 which calls run method

//        SharedResource obj = new SharedResource();
//        Thread producerTh = new Thread(() -> {
//            try {
//                Thread.sleep(10000);
//            } catch (Exception e) {
//
//            }
//            obj.addItem();
//        });
//
//        Thread consumeTh = new Thread(() -> {
//            obj.consumeItem();
//        });
//
//        producerTh.start();
//        consumeTh.start();

        QueueSharedResource obj = new QueueSharedResource(3);

        Thread producerTh = new Thread(() -> {
            IntStream.rangeClosed(0,6).forEach(num -> {
                try {
                    obj.produce(num);
                } catch (Exception e) {
                }
            });
        });

        Thread consumeTh = new Thread(() -> {
            IntStream.rangeClosed(0,6).forEach(num -> {
                try {
                    obj.consume(num);
                } catch (Exception e) {
                }
            });
        });

        producerTh.start();
        consumeTh.start();
    }
}