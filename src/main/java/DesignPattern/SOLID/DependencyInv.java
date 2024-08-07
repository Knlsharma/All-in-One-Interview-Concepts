package DesignPattern.SOLID;

/**
 * @author : Kunal Sharma
 * @since : 20/07/24, Saturday
 **/
public class DependencyInv {
//    private LightBulb lightBulb;
//
//    public LightSwitch() {
//        this.lightBulb = new LightBulb();
//    }
//
//    public void toggle() {
//        if (lightBulb.isOn()) {
//            lightBulb.turnOff();
//        } else {
//            lightBulb.turnOn();
//        }
//    }
//}
//
//public class LightBulb {
//    private boolean isOn;
//
//    public boolean isOn() {
//        return isOn;
//    }
//
//    public void turnOn() {
//        isOn = true;
//        // Logic to turn on the light bulb
//    }
//
//    public void turnOff() {
//        isOn = false;
//        // Logic to turn off the light bulb
//    }

    /******************* After ***************/

//    public interface Switchable {
//        void turnOn();
//        void turnOff();
//    }
//
//    public class LightSwitch {
//        private Switchable device;
//
//        public LightSwitch(Switchable device) {
//            this.device = device;
//        }
//
//        public void toggle() {
//            if (device.isOn()) {
//                device.turnOff();
//            } else {
//                device.turnOn();
//            }
//        }
//    }
//
//    public class LightBulb implements Switchable {
//        private boolean isOn;
//
//        @Override
//        public boolean isOn() {
//            return isOn;
//        }
//
//        @Override
//        public void turnOn() {
//            isOn = true;
//            // Logic to turn on the light bulb
//        }
//
//        @Override
//        public void turnOff() {
//            isOn = false;
//            // Logic to turn off the light bulb
//        }
}
