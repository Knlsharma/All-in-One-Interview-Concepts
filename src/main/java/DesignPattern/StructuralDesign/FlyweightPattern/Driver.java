package DesignPattern.StructuralDesign.FlyweightPattern;

import java.util.Random;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    private static final String[] treeNames = {"Oak", "Pine", "Maple"};
    private static final String[] treeColors = {"Green", "Brown"};
    private static final String[] treeTextures = {"Smooth", "Rough"};

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = treeNames[random.nextInt(treeNames.length)];
            String color = treeColors[random.nextInt(treeColors.length)];
            String texture = treeTextures[random.nextInt(treeTextures.length)];

            int x = random.nextInt(100);
            int y = random.nextInt(100);

            TreeType treeType = TreeFactory.getTreeType(name, color, texture);
            treeType.render(x, y);
        }
    }
}
