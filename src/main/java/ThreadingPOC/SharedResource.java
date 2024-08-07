package ThreadingPOC;

/**
 * @author : Kunal Sharma
 * @since : 10/02/24, Saturday
 **/
public class SharedResource {
    boolean isItemPresent = false;

    public synchronized void addItem()
    {
        System.out.println("Inside producer ::");
        isItemPresent = true;
        System.out.println("Producer thread is calling notify method");
        notifyAll();
    }

    public synchronized void consumeItem()
    {
        System.out.println("Inside consumer ::");
        while(!isItemPresent)
        {
            try
            {
                System.out.println("Consumer waiting...");
                wait(); // release all monitor locks
            } catch (Exception e) {

            }
        }
        isItemPresent = false;
    }
}


/** on waiting it release locks then other allowed to pick**/