package lesson_3;

import java.util.*;

public class ArrayWords {

    static ArrayList<String> words;

    public static void main(String[] args) {

        ArrayList<String> words = getStrings();

        demoArray();

    }

    static void demoArray() {

        printArray();

        //printArray2(); // можно и так

        printArrayUnique();

        printNumberRepeatedWords();

        //printNumberRepeatedWords2(); // еще один вариант
    }

    private static ArrayList<String> getStrings() {

        words = new ArrayList<>(15);
        words.add("шина");
        words.add("машина");
        words.add("сила");
        words.add("молот");
        words.add("скала");
        words.add("древо");
        words.add("шина");
        words.add("word");
        words.add("сила");
        words.add("шина");
        words.add("человек");
        words.add("кот");
        words.add("word");
        words.add("мозг");
        words.add("сила");
        return words;
    }

    private static void printArray() {

        System.out.println("Все слова: \n");
        words.forEach(System.out::println);
        System.out.println();
    }

    private static void printArray2() {

        System.out.println("Все слова: \n");
        System.out.println(words);
        System.out.println();

    }

    private static void printArrayUnique() {

        System.out.println("Только уникальные слова: \n");
        Set<String> wordsUnique = new HashSet<>(words);
        wordsUnique.forEach(System.out::println);
        System.out.println();
    }

    private static void printNumberRepeatedWords() {

        System.out.println("Количество повторяющихся слов: \n");
        Map<String, Integer> countWords = new HashMap<>();
        for (String s : words) {
            countWords.put(s, countWords.getOrDefault(s, 0) + 1);
        }
        countWords.entrySet().forEach(System.out::println);
    }

    private static void printNumberRepeatedWords2() {
        HashMap<String, Integer> countWords = new HashMap<>();
        Integer count = null;
        for (String i : words) {
            count = countWords.get(i);
            countWords.put(i, count == null ? 1 : count + 1);
        }
        System.out.printf("Количество повторяющихся слов: \n");
        countWords.entrySet().forEach(System.out::println);
    }
}
