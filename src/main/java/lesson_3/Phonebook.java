package lesson_3;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {

    HashMap<String, HashSet<String>> phonebook;

    Phonebook() {
        this.phonebook = new HashMap<>();
    }

    void add(String name, String number) {
        HashSet<String> phoneBook = this.phonebook.getOrDefault(name, new HashSet<>());
        phoneBook.add(number);
        this.phonebook.put(name, phoneBook);
    }

    void get(String name) {

        System.out.printf("\nКонтакт "+name+": "+ this.phonebook.getOrDefault(name, new HashSet<>()));
    }

    public static void main(String[] args) {

        Phonebook contact = new Phonebook();

        contact.add("Fred", "89784564587");
        contact.add("Fred", "897845644545");
        contact.add("Fred", "89784564521");
        contact.add("Mike", "897845615544");
        contact.add("Billy", "89784561515");
        contact.add("Mariya", "15115544665");
        contact.add("Mariya", "15115151155");

        contact.get("Fred");
        contact.get("Mike");
        contact.get("Mariya");
    }
}
