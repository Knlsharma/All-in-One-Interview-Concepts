package DesignPattern.StructuralDesign.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        TreeType treeType = treeTypes.get(key);
        if (treeType == null) {
            treeType = new TreeType(name, color, texture);
            treeTypes.put(key, treeType);
        }
        return treeType;
    }
}
