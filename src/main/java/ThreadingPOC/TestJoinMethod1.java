package ThreadingPOC;

/**
 * @author Kunal Sharma at 26/04/22 3:04 PM
 */
class TestJoinMethod1 extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){System.out.println(e);}
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        TestJoinMethod1 t1=new TestJoinMethod1();
        TestJoinMethod1 t2=new TestJoinMethod1();
        TestJoinMethod1 t3=new TestJoinMethod1();
        t1.start();
        try{
            t1.join();
            t2.countStackFrames();
        }catch(Exception e){System.out.println(e);}

        t2.start();
        t3.start();
    }
}


//
//    Program of performing single task by multiple threads
//
//FileName: TestMultitasking1.java
 class TestMultitasking1 extends Thread{
    public void run(){
        System.out.println("task one");
    }
    public static void main(String args[]){
        TestMultitasking1 t1=new TestMultitasking1();
        TestMultitasking1 t2=new TestMultitasking1();
        TestMultitasking1 t3=new TestMultitasking1();

        t1.start();
        t2.start();
        t3.start();
    }
}


// Program of performing single task by multiple threads
class TestMultitasking2 implements Runnable{
    public void run(){
        System.out.println("task one");
    }

    public static void main(String args[]){
        Thread t1 =new Thread(new TestMultitasking2());// passing annonymous object of TestMultitasking2 class
        Thread t2 =new Thread(new TestMultitasking2());

        t1.start();
        t2.start();

    }
}