package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 27/12/23, Wednesday
 **/
public class MaxVowelInSubstring {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                ans++;
            }
        }

        count = ans;

        for( int i = k ; i < s.length() ; i++)
        {
            char kth = s.charAt(i);
            char iMinusK = s.charAt(i-k);

            if(isVowel(kth))
            {
                count++;
            }

            if(isVowel(iMinusK))
            {
                count--;
            }

            ans = Math.max(ans, count);
        }


        return ans;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        double avg = 0;

        int sum = 0;
        for( int i = 0 ; i < k ; i++ ) {
        sum += nums[i];
        }

        avg = sum * 1.0 / k;
        ans = avg;

        for(int i = k ; i < nums.length; i++)
        {
            sum += nums[i] - nums[i-k];
            avg = sum * 1.0 / k;
            ans = Math.max(ans, avg);
        }

        return ans;
    }
}
