package lesson_1;

public class Human implements Members {

    private String name;
    private int distance;
    private int height;

    public Human(String name, int distance, int height) {
        this.name = name;
        this.distance = distance;
        this.height = height;
    }


    @Override
    public boolean action(Wall wall) {

        if (this.height >= wall.getHeightWall()) {
            this.height -= wall.getHeightWall();
            return true;
        } else {
            System.out.println("Прыгать больше не могу");
        }
        return false;
    }


    @Override
    public boolean action(Treadmill treadmill) {

        if (this.distance >= treadmill.getDistanceTreadmill()) {
            this.distance -= treadmill.getDistanceTreadmill();
            return true;
        } else {
            System.out.println("Бежать больше не могу");
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " ";

    }

    @Override
    public String info() {
        return name + " (бег: " + distance + ", прыжок: " + height + ")";
    }

}

