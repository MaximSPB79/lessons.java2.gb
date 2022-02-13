package lesson_1;

import java.util.concurrent.ThreadLocalRandom;

public class Wall implements PassingObstacles{

    private int heightWall;

    public Wall() {
        this.heightWall = ThreadLocalRandom.current().nextInt(50) + 5;
    }


    public int getHeightWall() {
        return heightWall;
    }

    @Override
    public void jump() {
        System.out.println("прыгнул " + this.heightWall + " cм.");
    }

    @Override
    public void run() {

    }
}
