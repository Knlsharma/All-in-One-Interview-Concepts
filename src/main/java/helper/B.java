package helper;

/**
 * @author Kunal Sharma at 21/03/22 6:57 PM
 */
public class B {
//
//    m1(A a) {
//        a = new A(11);
//    }

//    m2(A a) {
//        a.i = 7;
//    }


//    m3(A a) {
//        a = new A(11);
//        a.i = 8;
//    }

    public void m1(A a) {
        a = new A(11);  // new object
    }

    public void m2(A a) {
        a.i = 7;            // orignal object
    }

    public void m3(A a) {
        a = new A(11);   // new object
        a.i = 8;
    }
}
