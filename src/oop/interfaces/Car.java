package oop.interfaces;

public class Car implements Engine, Brake, Media {

    @Override
    public void start() {
        System.out.println("Engine Started");
    }

    @Override
    public void stop() {
        System.out.println("Engine Stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Car Accelerating");
    }

    @Override
    public void brake() {
        System.out.println("Brake Applied");
    }

    @Override
    public void startMusic() {
        System.out.println("Music Started");
    }

    @Override
    public void stopMusic() {
        System.out.println("Music Stopped");
    }
}