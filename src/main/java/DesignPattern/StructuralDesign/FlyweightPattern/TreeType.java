package DesignPattern.StructuralDesign.FlyweightPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class TreeType implements Tree {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Rendering " + name + " tree at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
        // Render tree based on intrinsic properties
    }
}