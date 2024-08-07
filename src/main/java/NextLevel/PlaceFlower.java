package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 29/12/23, Friday
 **/
public class PlaceFlower {

    public boolean canPlaceFlowers(int[] fls, int n) {

        int max = 0;
        int fi = -1;
        int li = -1;

        for(int i = 0; i < fls.length; i++) {
            if(fls[i] == 0)
            {
                continue;
            }
            else if(fi == -1)
            {
                fi = i;
                li = i;
            }
            else
            {
                li = i;
            }
        }

        // all zero
        if(fi == -1)
        {
            max = (fls.length + 1) / 2;
        }
        else
        {
            // count left and right zeros
            int left = fi;
            int right = fls.length - 1 - li;

             max = left / 2;
             max += right / 2;

             int count = 0;
             for(int i = fi+1 ; i <= li - 1; i++)
             {
                 if(fls[i] == 0)
                 {
                     count++;
                 }
                 else {
                     max += (count - 1) / 2;
                     count = 0;
                 }

             }

            max += (count - 1) / 2;

        }

        return n <= max;

    }
}
