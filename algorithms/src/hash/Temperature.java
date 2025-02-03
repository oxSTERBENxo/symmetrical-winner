package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class City {
    String name;
    String from;
    String to;
    double degrees;

    City (String name, String from, String to, double degrees) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return name + ": " + from + " - " + to + " " + degrees;
    }

}

public class Temperature {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, City> temperatures = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String from = tokens[1];
            String to = tokens[2];
            double degrees = Double.parseDouble(tokens[3]);
            if (!temperatures.containsKey(name)) temperatures.put(name, new City(name, from, to, degrees));
            else if (temperatures.get(name).degrees < degrees) temperatures.put(name, new City(name, from, to, degrees));
        }
        String token = br.readLine();
        System.out.println(temperatures.get(token).toString());

        // Ставам нова вредност за тој клуч (градот)
        // доколку степените што сакам да ги ставам се поголеми од моменталните степени
        // на нашата вредност (град) во мапата за тој клуч
    }

}
