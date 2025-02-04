package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person implements Comparable<Person> {
    String name;
    String surname;
    String year;

    Person(String name, String surname, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.year = dateOfBirth;
    }

    @Override
    public String toString() {
        return name + " " + surname + " ";
    }

    @Override
    public int compareTo(Person o) {
        return this.surname.compareTo(o.surname);
    }

}


public class birthdays3 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Person>> birthdays = new HashMap<>(); // морам во низа, бидејќи треба да ги излистам сите луѓе

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String surname = tokens[1];
            String dateOfBirth = tokens[2];
            String date = dateOfBirth.substring(0, 6); // 15/05/
            String year = dateOfBirth.split("/")[2]; // годината // 1986
            Person person = new Person(name, surname, year); // ќе го пратиме човекот со годината кога е роден
            if (!birthdays.containsKey(date)) {
                birthdays.put(date, new ArrayList<>());
                birthdays.get(date).add(person);
            } else birthdays.get(date).add(person);
        }

        String query = br.readLine();
        String formatted = query.substring(0, 6); // да го направиме во ист формат како што го праќаме во хеш табела
        String queryYear = query.split("/")[2];

        Collections.sort(birthdays.get(formatted));

        for (Person person : birthdays.get(formatted)) {
            int age = Integer.parseInt(queryYear) - Integer.parseInt(person.year);
            System.out.println(person + " " + age);
        }
        // Во задачата се бара за одреден датум, да ги излистаме
        // сите луѓе коишто се родени на тој датум и колку години би правеле.
        // Ни се бара да ги испечатиме сортирани според името на вработениот.

        // Најобично читам од влез.
        // Прво стрингот го цепкам на празни места,
        // со тоа ги добивам името презимето и целата дата на раѓање,
        // но мене како клуч потребен ми е денот и месецот во ваков формат 15/05/.

        // За да го направам тоа, добиената променлива што ми е целата дата
        // дополнително ја цепкам со помош функцијата substring(int beginIndex, int endIndex)
        // и уште еднаш ја цепкам истата променлива со split.("/") за да ја добијам само годината
        // на раѓање, којашто ќе ја пратам како параметар за објектот person.

        // Потоа, кога го читам датумот од којшто сакам да видам
        // ја правам истата постапка.
        // Прво самото query го форматирам да ми биде во ист формат
        // како и клучевите во хеш мапата (ден/месец/)
        // а потоа, ја земам и годината со тоа што query го делам со split("/")

        // Во класата Person, го имплементирам интерфејсот Comparable од тип Person
        // со цел да можам да ги сортирам по презиме.
        // Го оптоварувам методот compareTo(Person o) и само ставам return this.surname.compareTo(o.surname)
        // Со ова преоптоварување, загарантирано ми е секогаш при повик на
        // Collections.sort(birthdays.get(formatted)),
        // низата од луѓе да ми биде сортирана по презиме.

    }

}
