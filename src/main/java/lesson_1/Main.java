package lesson_1;

public class Main {

    public static void main(String[] args) throws ClassCastException {

        Treadmill treadmill = new Treadmill();

        Wall wall = new Wall();

        Cat cat = new Cat("Карбон", 500, 200);
        Cat cat1 = new Cat("Синий", 200, 300);
        Cat cat2 = new Cat("Муська", 120, 400);

        Human human = new Human("Василий", 400, 250);
        Human human1 = new Human("Михаил", 200, 500);
        Human human2 = new Human("Евгений", 150, 300);

        Robot robot = new Robot("Вердер", 700, 60);
        Robot robot1 = new Robot("CX1", 1000, 500);
        Robot robot2 = new Robot("CX2", 2000, 1000);

        Members[] members = {cat, cat1, cat2, human, human1, human2, robot, robot1, robot2};
        PassingObstacles[] lets = {treadmill, wall};

        relayLaunch(treadmill, wall, members, lets);
    }

    private static void relayLaunch(Treadmill treadmill, Wall wall, Members[] members, PassingObstacles[] lets) {
        for (int i = 0; i < members.length; i++) {
            if (members[i].action(treadmill) &&
                    members[i].action(wall)) {
                for (int j = 0; j < lets.length; j++) {
                    System.out.print(members[i].toString());
                    lets[j].run();
                    lets[j].jump();
                }
                System.out.println(members[i].info());
                System.out.println();
            }
        }
    }
}




