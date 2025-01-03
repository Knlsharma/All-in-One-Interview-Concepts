package HashMap;

import java.util.PriorityQueue;

/**
 * @author : Kunal Sharma
 * @since : 16/07/23, Sunday
 **/
public class StringReArrange {

    static class Pair implements Comparable<Pair> {
        int ch;
        int freq;

        Pair(int ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Pair o){
            return o.freq - this.freq;
        }
    }


    public static String rearrangeString(String str)
    {
        int[] map = new int[26];
        for(char ch: str.toCharArray()){
            map[ch-'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < 26; i++){
            if(map[i] > 0){
                pq.add(new Pair(i, map[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;
        while(pq.size() > 0){
            Pair rem = pq.remove();
            rem.freq--;
            char ch = (char)('a' + rem.ch);
            sb.append(ch);


            if(prev != null && prev.freq > 0){
                pq.add(prev);
            }
            prev = rem;
        }

        //   System.out.println(ans);
        return sb.toString();
    }
}
