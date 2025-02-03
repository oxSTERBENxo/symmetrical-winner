package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> anagrams = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String token = br.readLine();
            char[] array = token.toCharArray(); // во карактерна низа
            Arrays.sort(array); // сортирата
            String sorted = new String(array); // па назад во сортиран стринг
            if (!anagrams.containsKey(sorted)) anagrams.put(sorted, 1); // ако не си ваму, стави го
            else anagrams.put(sorted, anagrams.get(sorted) + 1); // инаку зголеми ја вредноста за еден
        }

        String token = br.readLine();
        char[] array = token.toCharArray(); // истата постапка тука
        Arrays.sort(array);
        String sorted = new String(array);
        if (anagrams.containsKey(sorted)) System.out.println(anagrams.get(sorted));
        else System.out.println(-1);

        // Во задачата, главната финта е да се сортира стрингот со тоа што ќе се претвори
        // во низа од карактери и потоа ќе се врати повторно во стринг.
    }


}
