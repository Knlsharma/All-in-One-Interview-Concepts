package StackBasics;

/**
 * @author : Kunal Sharma
 * @since : 07/01/24, Sunday
 **/
public class LongestPallindromicSubtring {

    public String longestPalindrome(String s) {
    // axis approach

    String res = "";

    // testing odd length
    for(int ax = 0; ax < s.length(); ax++) {
        int len = 1;
        int orbit = 1;

        while( (ax-orbit) >= 0 && (ax + orbit) < s.length() ) {
            if(s.charAt(ax-orbit) == s.charAt(ax+orbit))
            {
                orbit++;
                len += 2;
            }
            else {
                break;
            }

        }

        if(len > res.length())
        {
            int start = ax - len / 2;
            res = s.substring(start,start+len);
        }
    }

        // testing even length
        for(int ax = 0; ax < s.length(); ax++) {
            int len = 0;
            int orbit = 1;

            while( (ax-orbit + 1) >= 0 && (ax + orbit) < s.length() ) {
                if(s.charAt(ax-orbit+1) == s.charAt(ax+orbit))
                {
                    orbit++;
                    len += 2;
                }
                else {
                    break;
                }

            }

            if(len > res.length())
            {
                int start = ax - len / 2 + 1;
                res = s.substring(start,start+len);
            }
        }

        return res;
    }
}
