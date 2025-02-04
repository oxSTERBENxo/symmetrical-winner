package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class collegeEnrollment {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> SSNToGPA = new HashMap<>(); // од ЕБМГ во просек
        HashMap<String, Double> GPARegistry = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim()); // број на кандидати кои сакаат да се запишат
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String SSN = tokens[0];
            String GPA = tokens[1];
            if (!SSNToGPA.containsKey(SSN)) SSNToGPA.put(SSN, Double.parseDouble(GPA));
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String SSN = tokens[0];
            String GPA = tokens[1];
            if (!GPARegistry.containsKey(SSN)) GPARegistry.put(SSN, Double.parseDouble(GPA));
        }

        String query = br.readLine();
        if (Objects.equals(SSNToGPA.get(query), GPARegistry.get(query))) System.out.println("OK");
        else System.out.println("Error");

        // Обично мапирање се прави и се проверува
        // Клучен момент во задачата е дека
        // напоменато е дека има Е-Дневник регистар
        // што ги има сите матични броеви и просеци (ова вриска писка хеш мапа) 
    }

}
