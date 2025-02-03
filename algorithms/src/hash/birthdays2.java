package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class birthdays2 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, ArrayList<String>> monthsAndNames = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String dateOfBirth = tokens[1];
            int month = Integer.parseInt(dateOfBirth.split("\\.")[1]); // уште splitting
            if (!monthsAndNames.containsKey(month)) {
                monthsAndNames.put(month, new ArrayList<>());
                monthsAndNames.get(month).add(name);
            } else if (!monthsAndNames.get(month).contains(name)) monthsAndNames.get(month).add(name);
                                    // само ако го нема името стави го
        }

        int month = Integer.parseInt(br.readLine().trim());
        if (!monthsAndNames.containsKey(month)) System.out.println("Empty");
        else for (String name : monthsAndNames.get(month)) System.out.print(name + " ");

        // Во задачата клучен збор е „различни“ имиња. Доколку постои веќе името во низата
        // не го додавам. Го додавам само ако не постои веќе во низата
        // Кога го читам влезот, прво правам едно делење на стрингот,
        // па на dateOfBirth, правам уште едно делење.
    }

}
