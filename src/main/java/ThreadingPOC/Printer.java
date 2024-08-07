package ThreadingPOC;

/**
 * @author Kunal Sharma at 26/03/22 9:08 PM
 */
public class Printer {
    public volatile boolean isOdd = false; //This variable is Volatile since multiple threads are accessing it

    //Method Synchronization using synchronized keyword
    public synchronized void evenPrinter(int num){
        if(!isOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(num);
        isOdd = false ;
        notify();
    }

    public synchronized void oddPrinter(int num){
        if(isOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(num);
        isOdd = true ;
        notify();
    }
}
