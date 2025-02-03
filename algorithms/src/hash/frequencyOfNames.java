package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

public class frequencyOfNames {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> femaleNames = new HashMap<>();
        HashMap<String, Integer> maleNames = new HashMap<>();
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split("\\s+");
            String name = tokens[0].toLowerCase(); // секогаш мали букви за адекватно да се процесира
            char gender = tokens[1].charAt(0);
            if (gender == 'F') {
                if (!femaleNames.containsKey(name)) femaleNames.put(name, 1);
                else femaleNames.put(name, femaleNames.get(name) + 1);
            } else if (gender == 'M') {
                if (!maleNames.containsKey(name)) maleNames.put(name, 1);
                else maleNames.put(name, maleNames.get(name) + 1);
            }
        }
        String gender = br.readLine(); // од кој пол ќе пребаруваме
        while (true) { // се додека не се прочита END
            String token = br.readLine();
            if (token.equals("END")) break;
            token = token.toLowerCase(); // секогаш lowercase

            if (gender.charAt(0) == 'F') { // да знам да барам во женските
                char a = token.charAt(0); // првата буква
                char b = token.charAt(1); // втората буква

                for (String string : femaleNames.keySet())  // пристапување до клучевите на femaleNames
                    if (string.charAt(0) == a && string.charAt(1) == b) System.out.println(string.toUpperCase()); // ако им се исти првите букви

                if (!femaleNames.containsKey(token)) System.out.println("No such name.");
                else System.out.println(gender + " " + token.toUpperCase() + " " + femaleNames.get(token));
            }
            else if (gender.charAt(0) == 'M') { // да знам да барам во машките
                char a = token.charAt(0); // првата буква
                char b = token.charAt(1); // втората буква
                for (String string : maleNames.keySet()) { // пристапување до клучевите на femaleNames
                    if (string.charAt(0) == a && string.charAt(1) == b) System.out.println(string.toUpperCase()); // ако им се исти првите букви
                }
                if (!maleNames.containsKey(token)) System.out.println("No such name.");
                else System.out.println(gender + " " + token.toUpperCase() + " " + maleNames.get(token));
            }
        }

        // Во задачата ни се бара да симулираме компјутерска апликација која ќе пребарува имиња од завод за статистика.
        // Штосниот дел е што некогаш на влез доаѓаат имиња коишто се со големи букви, а при внесување на имињата
        // тие се пишуваат со прва голема буква и останатите мали. За да се осигурам дека за истото
        // име станува збор, секогаш и при внес и читање, името го правам да биде со мали букви.
        // Поради барањето од задачата, морам да го печатам со сите големи букви.
    }


}
