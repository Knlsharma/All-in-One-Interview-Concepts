package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 29/12/23, Friday
 **/
public class GCDString {
    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            int s1 = str1.length();
            ;
            int s2 = str2.length();
            int gcd = getGcd(s1, s2);
            return str1.substring(0, gcd);

        } else {
            return "";
        }

    }

    private int getGcd(int s1, int s2) {
        while (s2 % s1 != 0) {
            int rem = s2 % s1;
            s2 = s1;
            s1 = rem;
        }

        return s1;
    }
}
