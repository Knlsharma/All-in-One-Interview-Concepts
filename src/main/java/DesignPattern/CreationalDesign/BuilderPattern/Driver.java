package DesignPattern.CreationalDesign.BuilderPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Driver {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder("V8", "Automatic")
                .setAirbags(true)
                .setSunroof(true)
                .setNavigationSystem(true)
                .build();

        Car car2 = new Car.CarBuilder("V6", "Manual")
                .setAirbags(false)
                .setSunroof(false)
                .build();

        Car car3 = Car.CarBuilder.builder()
                .setAirbags(false)
                .setSunroof(false)
                .setNavigationSystem(true)
                .build();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}
