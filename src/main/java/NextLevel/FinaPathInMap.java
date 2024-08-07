package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 16/04/22 6:22 PM
 */
public class FinaPathInMap {

    public static void main(String[] args) {
        int c = 12;
        HashMap b = new HashMap();
        b.put("c", c);
        HashMap a = new HashMap();
        a.put("b", b);
        HashMap obj = new HashMap();
        obj.put("a", a);

        // System.out.println(obj);
        // obj = {
        //     a: {
        //         b: {
        //             c: 12
        //         }
        //     }
        // };


        System.out.println(findPath(obj, "a:b:c")); // 12
        System.out.println(findPath(obj, "a:b")); // {c: 12}
        System.out.println(findPath(obj, "a:b:d")); // null
        System.out.println(findPath(obj, "a:c")); // null
        System.out.println(findPath(obj, "a:b:c:d")); // null
        System.out.println(findPath(obj, "a:b:c:d:e")); // null

    }

    public static Object findPath(HashMap obj, String path) {

        String[] split_Strings = path.split(":");
        HashMap map = null;
        Integer isFound = null;

        for (String string : split_Strings) {
            if (obj != null && obj.containsKey(string)) {  // check whether it contains in map or not
                if (obj instanceof Map) {    // if instance of map
                    if (obj.get(string) instanceof Map) {
                        map = (HashMap) obj.get(string);
                    }
                    if (obj.get(string) instanceof Integer) {   // if instance of integer if found setting map  to null
                        isFound = (Integer) obj.get(string);
                        map = null;
                    }
                    obj = map;
                }
            } else {
                return null;
            }
        }
        return isFound != null ? isFound : obj;
    }
}
