package lesson_5;

public class Streams {

    static int size = 100000000;
    static float[] arr = new float[size];
    static float[] arrLeft = new float[size / 2];
    static float[] arrRight = new float[size / 2];
    static float[] mergedArray = new float[size];

    public static void main(String[] args) throws InterruptedException {

        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {

        assignUnit();
        long startTime = System.currentTimeMillis();
        calculateArr(arr);
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms. \n");
    }

    private static void assignUnit() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
    }

    private static void calculateArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void secondMethod() throws InterruptedException {

        assignUnit(); // заполняем поток единицами
        long startTime = System.currentTimeMillis();

        arrayBreakdown(); // делим массив
        long arrayBreakdownTime = System.currentTimeMillis() - startTime;

        Thread thread1 = new Thread(() -> {
            calculateArr(arrLeft);
        });
        Thread thread2 = new Thread(() -> {
            calculateArr(arrRight);
        });
        thread1.start(); // запускаем поток с малым массивом (левая часть)
        thread2.start(); // запускаем поток с малым массивом (правая часть)

        thread1.join(); // ждем завершения первого потока
        long calculateArrLeftTime = System.currentTimeMillis() - startTime - arrayBreakdownTime;
        thread2.join(); // ждем завершения второго потока
        long calculateArrRightTime = System.currentTimeMillis() - startTime - arrayBreakdownTime - calculateArrLeftTime;

        mergeArray(); // склеиваем массив
        long arrayMergedTime = System.currentTimeMillis() - startTime - arrayBreakdownTime - calculateArrLeftTime -
                calculateArrRightTime;

        printInfo(startTime, arrayBreakdownTime, calculateArrLeftTime, calculateArrRightTime, arrayMergedTime);
    }

    private static void arrayBreakdown() {

        System.arraycopy(arr, 0, arrLeft, 0, size / 2);
        System.arraycopy(arr, size / 2, arrRight, 0, size / 2);
    }

    private static void mergeArray() {

        System.arraycopy(arrLeft, 0, mergedArray, 0, size / 2);
        System.arraycopy(arrRight, 0, mergedArray, size / 2, size / 2);
    }

    private static void printInfo(long startTime, long arrayBreakdownTime, long calculateArrLeftTime, long calculateArrRightTime, long arrayMergedTime) {
        System.out.println("Array partitioning time: " + arrayBreakdownTime);
        System.out.println("Array calculation arrLeft time: " + calculateArrLeftTime);
        System.out.println("Array calculation arrRight time: " + calculateArrRightTime);
        System.out.println("Array gluing time: " + arrayMergedTime);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}


