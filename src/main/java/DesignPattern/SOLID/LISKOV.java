package DesignPattern.SOLID;

/**
 * @author : Kunal Sharma
 * @since : 20/07/24, Saturday
 **/
public class LISKOV {
    public class Shape {
        protected int width;
        protected int height;

        public Shape(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }

    public class Rectangle extends Shape {
        public Rectangle(int width, int height) {
            super(width, height);
        }
    }

    public class Square extends Shape {
        public Square(int sideLength) {
            super(sideLength, sideLength);
        }

        @Override
        public void setWidth(int width) {
            super.setWidth(width);
            super.setHeight(width);
        }

        @Override
        public void setHeight(int height) {
            super.setWidth(height);
            super.setHeight(height);
        }
    }


}
