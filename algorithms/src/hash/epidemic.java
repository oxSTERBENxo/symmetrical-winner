package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Patient {
    String name;
    String town;
    String type;

    Patient(String town, String name, String type) {
        this.name = name;
        this.town = town;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " " + town + " " + type;
    }

}

public class epidemic {

    public static double riskFactor (ArrayList<Patient> patients) {
        double positive = 0;
        for (Patient patient : patients)
            if (patient.type.equals("positive")) positive++; // изброј ги колку се позитивни

        double riskFactor = positive/patients.size(); // patients.size() е број на позитивни + број на негативни
        return (double) Math.round(riskFactor * 100) / 100; // заокружување на 2 децимали
    }

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Patient>> patients = new HashMap<String, ArrayList<Patient>>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String town = tokens[0];
            String name = tokens[1];
            String type = tokens[2];
            Patient patient = new Patient(town, name, type);
            if (!patients.containsKey(patient.town)) {
                patients.put(patient.town, new ArrayList<Patient>()); // иницијализирај ArrayList
                patients.get(patient.town).add(patient); // patients.get(patient.town) ќе ја врати таа листа, и на неа додади го patient
            } else patients.get(patient.town).add(patient); // инаку само додај го пациентот и тоа е тоа
        }

        String town = br.readLine(); // за оваа општина не интересира ризик факторот
        System.out.println(riskFactor(patients.get(town)));

        // Најпрво, креирам класа едноставна Patient,
        // каде што чувам атрибути за тој пациент (презиме, општина и дали е позитивен или не)
        // Иницијализирам HashMap која што од стрингови мапира ArrayList од пациенти.
        // Доколку не постои клучот (клучот е општината), тогаш
        // во мапирањето на клучот иницијализирај нова ArrayList од тип пациенти
        // и потоа на неа додај го пациентот (ова е тешкиот дел од задачата)
        // Потоа напишав функција којашто ми го пресметува ризик факторот за одредена општина
    }


}
