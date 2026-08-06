package oop.interfaces;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();
        car.accelerate();
        car.brake();
        car.startMusic();
        car.stopMusic();
        car.stop();

        System.out.println();

        NiceCar niceCar = new NiceCar();

        niceCar.start();
        niceCar.musicOn();
        niceCar.musicOff();
        niceCar.stop();

        System.out.println();

        Engine engine = new ElectricCar();

        engine.start();
        engine.accelerate();
        engine.stop();
    }
}