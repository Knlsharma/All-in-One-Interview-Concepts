package NextLevel;

import java.util.HashMap;

/**
 * @author Kunal Sharma at 10/04/22 12:25 PM
 */
public class SmallestSubArrayWithMaxFrequency {
    // In single pass only
    static class Pair {
        int frequency;
        int firstIndex;
        int lastIndex;

        Pair(int frequency,int firstIndex, int lastIndex) {
            this.frequency = frequency;
            this.lastIndex = lastIndex;
            this.firstIndex = firstIndex;
        }

        public int getFrequency() {
            return frequency;
        }

        public int getLastIndex() {
            return lastIndex;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append(frequency).append(",")
                    .append(firstIndex).append(",")
                    .append(lastIndex)
                    .toString();
        }
    }

    public static void main(String[] args) {
        String s = "ebffeacbdcadbdaccdaddfe";
        HashMap<Character, Pair> map = new HashMap<>();
        char max_freq_char = 0;
        int len = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                Pair Oldpair = map.get(ch);
                int firstIndex = Oldpair.getFirstIndex();
                map.put(ch, new Pair(Oldpair.getFrequency() + 1, firstIndex, i));
            } else {
                map.put(ch, new Pair(1,i,i));
            }

            // calculate frequency and len each time
            Pair pair = map.get(ch);
            int freq = pair.getFrequency();
            int fi = pair.getFirstIndex();
            int li = pair.getLastIndex();
            if (freq > len) {
                len = freq;
                max_freq_char = ch;
            }

//            if (freq == len && (li- fi + 1) <  ) {
//                len = freq;
//                max_freq_char = ch;
//            }
        }
        System.out.println(max_freq_char);
        System.out.println(map.get(max_freq_char).toString());
    }
}
