package Recusrion_Practice;

/**
 * @author : Kunal Sharma
 * @since : 30/11/22, Wednesday
 **/
public class Permutation {

    // npr  where r is different ==> arrangements


    // 2^3 => 1 + 3 + 3 + 1 ==> 2^n is formula for combination

    // nPr = nCr * r!
    public static void permutations(int[] boxes, int ci, int ti) {


        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }

            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++)  // here boxes are option and itmes as level
        {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                // explore
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }


}
