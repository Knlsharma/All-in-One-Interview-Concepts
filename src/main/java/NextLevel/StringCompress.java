package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 28/12/23, Thursday
 **/
public class StringCompress {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(chars[0]);
        int i = 1;

        while (i < chars.length) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(chars[i]);
                count = 1;
            }
            i++;
        }

        if (count > 1) {
            sb.append(count);
        }

        for (int j = 0; j < sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }

        return sb.length();
    }
}