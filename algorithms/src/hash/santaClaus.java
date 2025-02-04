package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


class Street {
    String name;
    String number;

    Street(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + " " + number;
    }

}

public class santaClaus {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Street> kidToStreet = new HashMap<>(); // од дете во адреса на живеење
        HashMap<String, String> oldToNewStreet = new HashMap<>(); // од старата во новата улица

        int n = Integer.parseInt(br.readLine().trim()); // број на деца кои се добри
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String kid = tokens[0]; // детето
            String name = tokens[1]; // име на улица
            String number = tokens[2]; // број на улица
            Street street = new Street(name, number);  // објект од класата улица
            kidToStreet.putIfAbsent(kid, street); // мапирање од дете во адреса на живеење
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String oldStreet = tokens[0]; // име на стара улица
            String newStreet = tokens[1]; // име на нова улица
            oldToNewStreet.putIfAbsent(oldStreet, newStreet); // мапирање на имиња од стари во нови
        }

        String query = br.readLine();
        if (kidToStreet.containsKey(query)) { // ако го има на листата за добри деца
            Street street = kidToStreet.get(query); // земи ја улицата што е асоцирана со тоа дете
            if (oldToNewStreet.containsKey(street.name)) street.name = oldToNewStreet.get(street.name);
            // ако постои мапирање за таа улица (значи сменето е името), тогаш смени го името на улицата со новото
            System.out.println(street); // испечати ја улицата
        }

        // Имам две хешмапи, една за дете во улица, друга за старо име на улица во ново
        // ги ставам најнормално во мапите
        // Ако детето воопшто го има на листата за добри деца
        // ја земам улицата, и гледам ако името на улицата го има во
        // мапата за нови улици, тогаш го менувам името на улицата во ново
        // ја печатам улицата <3

    }

}
