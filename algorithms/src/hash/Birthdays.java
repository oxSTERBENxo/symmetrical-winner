package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Birthdays {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> months = new HashMap<>(); // од месеци (цел број) во број на луѓе родени во тој месец (цел број)

        int n = Integer.parseInt(br.readLine().trim()); // колку родендени
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split("\\.");
            int day = Integer.parseInt(tokens[0]); // не ни се потребни но чисто за приказ
            int month = Integer.parseInt(tokens[1]);
            int year = Integer.parseInt(tokens[2]);
            months.put(month, months.getOrDefault(month, 0) + 1); // како key користам month,
                                                                            // како вредност користам или вредноста што постои таму
                                                                            // а ако не постои вредноста, ставам default value на 0
        }

        int month = Integer.parseInt(br.readLine().trim());
        System.out.println(months.get(month));

        // Во задачата се бара да изброиме за одреден месец колку луѓе се родени во него.
        // Користиме HashMap која што мапира од цел број во цел број (од месец во број на луѓе кои се родени во тој месец)
        // Влезот си е стандард класика.
        // Важно во задачата е да го зголемуваме бројот на луѓе родени
        // во тој месец за еден секогаш кога ќе мапираме за тој месец.
        // Бидејќи на почеток не ни се иницијализирани вредностите за клучевите
        // со функцијата getOrDefault(Object key, V defaultValue),
        // ние или ќе ја земеме вредноста што е моментална и ќе и додадеме 1 на неа и повторно ќе ја вратиме
        // или пак ако не постои вредноста (ако првпат го ставаме клучот во хеш мапата) тогаш и поставуваме
        // иницијална вредност 0, и истата ја зголемуваме за 1 и ја ставаме во мапата


    }


}
