package Array;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 25/07/24, Thursday
 **/
public class FindDiagonalOrder {


    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Using TreeMap to automatically sort keys
        TreeMap<Integer, List<Integer>> mp = new TreeMap<>();

        // Fill the map using [i+j] as key for diagonal elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                if (!mp.containsKey(key)) {
                    mp.put(key, new ArrayList<>());
                }
                mp.get(key).add(mat[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean flip = true;

        // Iterate through the TreeMap
        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            List<Integer> diagonal = entry.getValue();
            if (flip) {
                Collections.reverse(diagonal);
            }
            result.addAll(diagonal);
            flip = !flip;
        }

        // Convert List<Integer> to int[]
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}

/*
 1 2 3
 4 5 6
 7 8 9

 1 2 4 7 5 3 6 8 9
 */
