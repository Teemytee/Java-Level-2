import java.util.*;

public class Main {

    public static void main(String[] args) {
        doTaskOne();
        doTaskTwo();
    }
    public static void doTaskOne(){
        ArrayList words = new ArrayList();
        words.add("hello");
        words.add("hello");
        words.add("bye");
        words.add("buy");
        words.add("what");
        words.add("what");
        words.add("yes");

        System.out.println("Начальный массив - " + words);
        HashSet<String> set=new HashSet<>(words);
        System.out.println("Массив с только уникальными словами - " + set);
        System.out.println("Длина массива - " + set.size());
    }

    public static void doTaskTwo(){
        Phonebook contactBook = new Phonebook();
        contactBook.add("Иванов", "+7810129856");
        contactBook.get("Иванов");
        contactBook.add("Иванов", "+79996543212");
        contactBook.get("Иванов");
        contactBook.add("Смирнов", "+79996543212");
        contactBook.get("Смирнов");
    }
}
