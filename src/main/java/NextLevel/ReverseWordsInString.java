package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 29/12/23, Friday
 **/
public class ReverseWordsInString {

    public String reverseWords(String s) {

        String[] words = s.trim().split(" ");
        StringBuilder res = new StringBuilder();


        for(int index = words.length - 1; index >= 0 ; index--)
        {
            if(!words[index].isEmpty())
            {
                res.append(words[index]);
                res.append(" ");
            }

        }

        return res.substring(0, res.length()-1).toString();
    }
}
