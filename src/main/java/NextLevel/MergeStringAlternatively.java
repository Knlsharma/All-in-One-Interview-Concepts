package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 29/12/23, Friday
 **/
public class MergeStringAlternatively {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        boolean flag = true;

        while(i < word1.length() && j < word2.length())
        {
            if(flag)
            {
                sb.append(word1.charAt(i));
                i++;
            }
            else {
                sb.append(word2.charAt(j));
                j++;
            }

            flag = !flag;
        }

        while (i < word1.length())
        {
            sb.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length())
        {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}
