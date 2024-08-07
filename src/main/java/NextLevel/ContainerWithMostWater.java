package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 16/07/22, Saturday
 **/

public class ContainerWithMostWater {


    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            int min_height = Math.min(height[l], height[r]);
            int area = min_height * (r - l);

            res = Math.max(res, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}

