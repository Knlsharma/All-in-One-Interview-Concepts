package DesignPattern.CreationalDesign.BuilderPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Car {

    // Required parameters
    private String engine;
    private String transmission;

    // Optional parameters
    private boolean airbags;
    private boolean sunroof;
    private boolean navigationSystem;

    // Private constructor to prevent direct instantiation
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.transmission = builder.transmission;

        this.airbags = builder.airbags;
        this.sunroof = builder.sunroof;
        this.navigationSystem = builder.navigationSystem;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", airbags=" + airbags +
                ", sunroof=" + sunroof +
                ", navigationSystem=" + navigationSystem +
                '}';
    }


    // setting up builder
    public static class CarBuilder {

        // Required parameters
        private String engine;
        private String transmission;

        // Optional parameters
        private boolean airbags;
        private boolean sunroof;
        private boolean navigationSystem;

        public CarBuilder() {
        }

        public CarBuilder(String engine, String transmission) {
            this.engine = engine;
            this.transmission = transmission;
        }

        // Below are non mandatory

        public CarBuilder setAirbags(boolean airbags) {
            this.airbags = airbags;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setNavigationSystem(boolean navigationSystem) {
            this.navigationSystem = navigationSystem;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

        public static CarBuilder builder() {
            return new CarBuilder();
        }
    }

}
