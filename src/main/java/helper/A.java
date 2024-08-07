package helper;

/**
 * @author Kunal Sharma at 21/03/22 6:49 PM
 */

import helper.B;

import java.util.List;

public class A {

    int i = 0;

    A(int i1){ i = i1;
    }

    public static void main(String[] args) {

        A a = new A(10);
         new B().m1(a);
        System.out.println(a.i);  // 11

        new B().m2(a);
        System.out.println(a.i); // 7

        new B().m3(a);
        System.out.println(a.i); // 8
    }

//    private static int getMinIndex(List<Integer> list, int k, int[][] arr) {
//        int minValue = Integer.MIN_VALUE;
//        int
//        for(int col = 0 ; col < k ; col++)
//        {
//            Integer rowIndex = list.get(col);
//            if(arr[rowIndex][col] > minValue)
//            {
//                minValue = arr[rowIndex][col];  // min val found
//                list.remove(rowIndex);     // remove old index
//                list.add()                 // add new index
//                System.out.println(minValue);
//            }
//        }
//        return min;
//    }

//    int[][] arr = { {1,   3,11},
//                         ^
//        {2,    4, 6},
//                        ^
//        {0,    9, 10}} ;


}

