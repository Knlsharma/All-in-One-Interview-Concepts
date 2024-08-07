package NextLevel;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 31/12/23, Sunday
 **/
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Set<String> unique = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            for (int n2 = i + 1; n2 < nums.length - 2; n2++) {
                int li = n2 + 1;
                int ri = nums.length - 1;

                while (li < ri) {
                    long sum = nums[li];
                    sum += nums[ri];
                    sum += nums[n2];
                    sum += nums[i];

                    if (sum > target) {
                        ri--;

                    } else if (sum < target) {
                        li++;

                    } else {
                        StringBuilder sb = new StringBuilder();
                        String code = sb.append(nums[li])
                                .append(nums[ri])
                                .append(nums[n2])
                                .append(nums[i]).toString();
                        if (unique.contains(code) == false) {
                            result.add(Arrays.asList(nums[li], nums[ri], nums[n2], nums[i]));
                            unique.add(code);
                            ;
                        }

                        li++;
                        ri--;

                    }
                }

            }


        }

        return result;
    }
}
