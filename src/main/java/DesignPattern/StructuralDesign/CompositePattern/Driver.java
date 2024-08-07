package DesignPattern.StructuralDesign.CompositePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        // Create leaf objects (files)
        File file1 = new File("document1.txt");
        File file2 = new File("image1.jpg");

        // Create a composite object (directory)
        Directory rootDirectory = new Directory("Root");
        Directory subDirectory = new Directory("SubFolder");

        // Add leaf objects to the directory
        rootDirectory.addComponent(file1);
        rootDirectory.addComponent(subDirectory);

        subDirectory.addComponent(file2);

        // Show details of the entire file system
        rootDirectory.showDetails();
    }
}
