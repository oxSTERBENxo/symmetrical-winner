package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class findTheCriminal {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<String>> dna = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            String dnaOne = br.readLine();
            String dnaTwo = br.readLine();
            if (!dna.containsKey(name)) {
                dna.put(name, new ArrayList<>());
                dna.get(name).add(dnaOne);
                dna.get(name).add(dnaTwo);
            } else {
                dna.get(name).add(dnaOne);
                dna.get(name).add(dnaTwo);
            }
        }

        String queryDnaOne = br.readLine();
        String queryDnaTwo = br.readLine();
        boolean found = false;

        for (String s : dna.keySet()) { // ги пребарувам сите клучеви
            if (dna.get(s).contains(queryDnaOne) && dna.get(s).contains(queryDnaTwo)) {
                found = true;
                System.out.println(s);
                break;
            }
        }
        if (!found) System.out.println("Unknown");

        // Од нас се бара да го најдеме криминалецот.
        // Итерирам низ сите клучеви на хеш мапата,
        // и гледам дали некое мапирање (низа)
        // ги содржи тие две ДНК нишки
        // ако ги содржи, го печатам криминалецот
        // инаку печатам Unknown

    }

}
