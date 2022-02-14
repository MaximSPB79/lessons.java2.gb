package lesson_1;

import java.util.concurrent.ThreadLocalRandom;

public class Treadmill implements PassingObstacles {

    private int distanceTreadmill;

    public Treadmill() {
        this.distanceTreadmill = ThreadLocalRandom.current().nextInt(100) + 10;
    }


    public int getDistanceTreadmill() {
        return distanceTreadmill;
    }


    @Override
    public void run() {
        System.out.println("пробежал " + this.distanceTreadmill + " м.");
    }

    @Override
    public void jump() {

    }


}
