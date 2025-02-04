package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Company {
    // ги ставам тука горе за да можам и во функцијата што е подоле да пристапам до нив
    static Map<String, List<String>> bosses = new HashMap<>(); // од менаџери во листа од вработени
    static Map<String, Integer> employeeCount = new HashMap<>(); // cache

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim()); // колку парови на вработен, менаџер
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(",");
            String employee = tokens[0];
            String boss = tokens[1];
            bosses.putIfAbsent(boss, new ArrayList<>()); // ако нема ништо стави го ова
            bosses.get(boss).add(employee); // инаку ставај
        }

        for (String boss : bosses.keySet()) { // за секој шеф
            countEmployees(boss); // изврши ја функцијата
        }

        ArrayList<String> result = new ArrayList<>(bosses.keySet()); // сите шефови стави ги во листа
        Collections.sort(result); // сортирај ја таа листа според имиња

        for (String boss : result) { // за секој шеф што е во листата
            System.out.println(boss + ": " + employeeCount.get(boss)); // испринтај го шефот, и неговиот employeeCount
        }

        // Во задачата „тешкиот“ дел е да ги избројам
        // рекурзивно колку вработени има секој шеф
        // Во коментари објаснувам подетално

    }

    private static int countEmployees(String boss) {

        if (employeeCount.containsKey(boss)) return employeeCount.get(boss);
        // мемоизација делот, ако веќе сме ставиле
        // во employeeCount хеш мапата, вредност за број на вработени, нема потреба да пресметуваш уште еднаш,
        // веднаш врати ја вредноста

        int count = 0; // секојпат кога влегува да брои за вработени, иницијално е 0
        if (bosses.containsKey(boss)) { // ако во хешмапата го има параметарот boss, а ако го нема, веднаш ќе го стави во employeeCount хешмапата, со вредност 0
            for (String employee : bosses.get(boss)) { // за секој вработен што се наоѓа во листата на вработени за тој шеф
                if (boss.equals(employee)) continue; // спречувам циклус!
                count += 1 + countEmployees(employee); // на променливата додади 1 + вредноста на бројот на вработени за тој шеф
            }
        }
        employeeCount.put(boss, count); // кога ќе завршиш со for циклусот, резултатот стави го во хешмапата
        return count; // врати ја вредноста count
    }

}
