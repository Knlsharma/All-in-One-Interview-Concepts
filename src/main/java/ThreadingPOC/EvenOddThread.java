package ThreadingPOC;

/**
 * @author Kunal Sharma at 26/03/22 9:07 PM
 */
public class EvenOddThread extends Thread {
    Integer start;
    Integer N;
    Printer print;
    Boolean isEven;
    EvenOddThread(Integer start , Integer N, Printer print , Boolean isEven){
        this.N = N;
        this.start = start;
        this.print = print;
        this.isEven = isEven;
    }
    @Override
    public void run(){
        while(start <= N){
            if(isEven)
                print.evenPrinter(start);
            else
                print.oddPrinter(start);
            start += 2;
        }
    }
}
