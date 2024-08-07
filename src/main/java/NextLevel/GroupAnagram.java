package NextLevel;

import java.util.*;

/**
 * @author Kunal Sharma at 03/04/22 3:54 PM
 */
public class GroupAnagram {
    public static void main(String[] args) {
//        "aabc" ,"bcaa" , "acbd" , "bacd" , "xyyz" ,"xzyy"
        List<String> listOfString = new ArrayList<>();
        listOfString.add("aabc");
        listOfString.add("bcaa");
        listOfString.add("acbd");
        listOfString.add("bacd");
        listOfString.add("xyyz");
        listOfString.add("xzyy");


        String[] InArray = listOfString.toArray(new String[0]);

        Map<String, ArrayList<String>> hashMap = new HashMap<>();

        for (String string : listOfString) {
            int[] map = new int[26];

            for (char ch : string.toCharArray()) {
                int index = ch - 'a';
                map[index]++;
            }

            String stringKey = generateStringKey(map);

            if (hashMap.containsKey(stringKey)) {
                ArrayList<String> stringList = hashMap.get(stringKey);
                stringList.add(string);
                hashMap.put(stringKey, stringList);
            } else {
                ArrayList<String> new_list = new ArrayList<>();
                new_list.add(string);
                hashMap.put(stringKey, new_list);
            }
        }
//        System.out.println(hashMap);

        hashMap.forEach((key, val) -> System.out.println(val));

    }

    private static String generateStringKey(int[] stringMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringMap.length; i++) {
            int val = stringMap[i];
            int index = i;
            if (val != 0) {
                char key = (char) (index + 'a');
                sb.append(key).append(val);
            }
        }
        return sb.toString();
    }

    // new approach
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(String s : strs) {
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(s);

        }
        return new ArrayList(anagrams.values());

    }
}
