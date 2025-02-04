package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Permutations {

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> permutations = new HashMap<String, Integer>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();
            Arrays.sort(chars); // по азбучен ред ќе ми ги сортира
            line = String.valueOf(chars); // ќе го врати назад во стринг
            if (!permutations.containsKey(line)) permutations.put(line, 1);
            else permutations.put(line, permutations.get(line) + 1);
        }

        String query = br.readLine();
        char[] chars = query.toCharArray();
        Arrays.sort(chars);
        query = new String(chars);
        if (permutations.containsKey(query)) System.out.println(permutations.get(query));
        else System.out.println(0);

        // Слична задача како задачата со анаграми
        // целата финта е да ги сортираме азбучно така што
        // сите зборови да се исти
        // (stop и tosp се различни но истите букви ги содржат,
        // па следува дека треба во истиот клуч да одат)

    }

}
