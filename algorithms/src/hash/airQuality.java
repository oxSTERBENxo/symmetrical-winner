package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;

public class airQuality {

    public static double average (ArrayList<Double> list) {
        double average = 0;
        for (Double pm10 : list) {
            average += pm10;
        }
        average /= list.size();
        return Math.round((average * 100.0)) / 100.0 ; // заокружување на две децимали
        // To round to two decimal places, you need to multiply by 100, round, then divide by 100
    }

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Double>> airQuality = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String city = tokens[0];
            Double pm10 = Double.parseDouble(tokens[1]);
            if (!airQuality.containsKey(city)) {
                airQuality.put(city, new ArrayList<>());
                airQuality.get(city).add(pm10);
            } else airQuality.get(city).add(pm10);
        }

        String query = br.readLine();
        if (airQuality.containsKey(query)) System.out.println(average(airQuality.get(query)));

        // Во задачава клучен збор ми беше
        // „просек“ од сите вредности што ги има тој и тој град.
        // За да го направам тоа, морам јас да чуам ArrayList од сите вредности
        // па да им пресметам просечна вредност.
        // Најтешкиот дел од задачата ми беше да заокружам на две децимали xD
    }

}
