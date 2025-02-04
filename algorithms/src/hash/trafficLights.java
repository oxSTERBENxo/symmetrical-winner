package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


class Driver implements Comparable<Driver> {

    String name;
    String surname;
    String regTable;
    Date time;
    int speed;

    Driver(String name, String surname, String regTable) {
        this.name = name;
        this.surname = surname;
        this.regTable = regTable;
    }

    Driver (Date time, int speed) {
        this.time = time;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int compareTo(Driver o) {
        return this.time.compareTo(o.time);
    }

}


public class trafficLights {

    public static void main (String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Driver> regTableToDriver = new HashMap<String, Driver>(); // од рег. табличка до возачот

        int n = Integer.parseInt(br.readLine().trim()); // број на регистарски таблички
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split("\\s+");
            String regTable = tokens[0];
            String name = tokens[1];
            String surname = tokens[2];
            Driver driver = new Driver(name, surname, regTable);
            if (!regTableToDriver.containsKey(driver.regTable)) regTableToDriver.put(driver.regTable, driver);
        }

        int allowedSpeed = Integer.parseInt(br.readLine().trim());

        String line = br.readLine();
        String[] tokens = line.split("\\s+");

        ArrayList<String> regTables = new ArrayList<String>();
        ArrayList<Integer> speeds = new ArrayList<>();
        ArrayList<Date> times = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // го креирам ова за да се снајде со времето

        for (int i = 0; i < tokens.length; i++) {
            if (i % 3 == 0) regTables.add(tokens[i]);
            if (i % 3 == 1) speeds.add(Integer.parseInt(tokens[i]));
            if (i % 3 == 2) times.add(sdf.parse(tokens[i])); // доволно е да ми го испрарсира и да се зачува како String
        }

        ArrayList<Driver> badDrivers = new ArrayList<Driver>();

        for (int i = 0; i < regTables.size(); i++) {
            Driver driver = regTableToDriver.get(regTables.get(i)); // земи го возачот
            driver.speed = speeds.get(i); // стави му ја брзината
            driver.time = times.get(i); // стави му го времето кога е виден
            if (driver.speed > allowedSpeed) badDrivers.add(driver); // ако брзината негова е поголема од дозволеното,
                                                                    // стави го во лоши возачи
        }

        Collections.sort(badDrivers); // имам преоптоварено compareTo(Driver o) метод,
                                     // за да може да ми ги сортира по времиња

        for (Driver driver : badDrivers) {
            System.out.println(driver);
        }

        // Задачава беше со финти.
        // Креирав класа Driver и во неа ги ставив сите атрибути што се спомнати
        // и го имплементирав Comparable interface-от од тип Driver, а подоле
        // го оптоварив compareTo(Driver o) методот, за да можам да ги споредувам/сортирам
        // според времето кога биле регистрирани

        // Прво го читам возачот го ставам во хеш мапа, лабаво
        // Бидејќи влезот за радаров е малку чуден, морав да импровизирам
        // Ја читам дозволената брзина, па го читам и влезот и го цепкам на парчиња со split(" ")

        // Правам 3 низи, од регистарски таблички, од брзини, и од времиња
        // Имам фор циклус којшто ќе е долг колку парчињата што ги исцепкав
        // и со помош на модуларна аритметика, издвојувам 3 посебни настани
        // и соодветно ги ставам променливите во низите
        // регистарската табличка на позиција i е
        // соодветна со брзината на позиција i која е
        // соодветна со времето на позиција i

        // Имам уште еден фор, којшто треба да има итерации колку што има било која од листите
        // (сите листи имаат иста големина)
        // Прво од хеш мапата, го земам објектот возач (за секоја табличка има возач)
        // Па потоа, му ги додавам атрибутите брзина и време на возачот,
        // и ако неговата брзина е поголема од дозволената, го ставам во новата низа badDrivers

        // На крај, ја сортирам оваа низа со Collections.sort(badDrivers),
        // каде ми се сортираат според времето, и ги печатам возачите

    }

}
