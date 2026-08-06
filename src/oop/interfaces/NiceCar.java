package oop.interfaces;

public class NiceCar {

    private final Car car;

    public NiceCar() {
        car = new Car();
    }

    public void start() {
        car.start();
    }

    public void stop() {
        car.stop();
    }

    public void musicOn() {
        car.startMusic();
    }

    public void musicOff() {
        car.stopMusic();
    }
}