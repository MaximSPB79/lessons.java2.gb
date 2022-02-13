package lesson_1;

public class Cat implements Members {

    private String essence;
    private String name;
    private int distance;
    private int height;

    public Cat(String name, int distance, int height) {

        this.essence = "Кот";
        this.name = name;
        this.distance = distance;
        this.height = height;
    }


    public boolean action(Wall wall) {

        if (this.height >= wall.getHeightWall()) {
            this.height -= wall.getHeightWall();
            return true;
        } else {
            System.out.println("Прыгать больше не могу");
        }
        return false;
    }

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
        return essence + ", " + name + " ";

    }

    public String info(){
        return name + " (бег: " + distance + ", прыжок: " + height + ")";
    }
}
