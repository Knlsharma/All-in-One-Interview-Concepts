package DesignPattern.SOLID;

/**
 * @author : Kunal Sharma
 * @since : 20/07/24, Saturday
 **/
public class InterfaceSegregation {

    public interface Worker {
        void work();
        void eat();
        void sleep();
    }

    public class Human implements Worker {
        @Override
        public void work() {
            // Human-specific work implementation
        }

        @Override
        public void eat() {
            // Human-specific eat implementation
        }

        @Override
        public void sleep() {
            // Human-specific sleep implementation
        }
    }

    public class Robot implements Worker {
        @Override
        public void work() {
            // Robot-specific work implementation
        }

        @Override
        public void eat() {
            // No meaningful implementation for a robot
        }

        @Override
        public void sleep() {
            // No meaningful implementation for a robot
        }
    }

    /******************* after applying ***************/
//    public interface Workable {
//        void work();
//    }
//
//    public interface Eatable {
//        void eat();
//    }
//
//    public interface Sleepable {
//        void sleep();
//    }
//
//    public class Human implements Workable, Eatable, Sleepable {
//        @Override
//        public void work() {
//            // Human-specific work implementation
//        }
//
//        @Override
//        public void eat() {
//            // Human-specific eat implementation
//        }
//
//        @Override
//        public void sleep() {
//            // Human-specific sleep implementation
//        }
//    }
//
//    public class Robot implements Workable {
//        @Override
//        public void work() {
//            // Robot-specific work implementation
//        }
//    }
}
