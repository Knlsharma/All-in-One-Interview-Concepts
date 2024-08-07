package ThreadingPOC;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author : Kunal Sharma
 * @since : 21/06/24, Friday
 **/
public class EvenOddUsingCompletable {

    private static Object obj = new Object();

    private static IntPredicate evenCond = num -> num % 2 == 0;
    private static IntPredicate OddCond = num -> num % 2 != 0;


    public static void printNumber(IntPredicate condition) {
        IntStream.rangeClosed(1, 10)
                .filter(condition)
                .forEach(EvenOddUsingCompletable::execute);
    }


    public static void execute(int num) {
        synchronized (obj) {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + num);
                obj.notify();
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOddUsingCompletable.printNumber(OddCond));
        CompletableFuture.runAsync(() -> EvenOddUsingCompletable.printNumber(evenCond));
        Thread.sleep(1000);
    }
}
