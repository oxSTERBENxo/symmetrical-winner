package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class redCross {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> bloodGroups = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String bloodGroup = tokens[1];
            if (bloodGroup.charAt(0) == 'A') // ако карактерот прв е А
                if (bloodGroup.charAt(1) == '+' || bloodGroup.charAt(2) == '+') // ако има некаде +
                    if (!bloodGroups.containsKey("A+")) bloodGroups.put("A+", 1); // ако досега не постоел, стави го
                    else bloodGroups.put("A+", bloodGroups.get("A+") + 1); // инаку стави го ама зголеми му ја вредноста
                else if (bloodGroup.charAt(1) == '-' || bloodGroup.charAt(2) == '-')
                    if (!bloodGroups.containsKey("A-")) bloodGroups.put("A-", 1);
                    else bloodGroups.put("A-", bloodGroups.get("A-") + 1);
            if (bloodGroup.trim().equals("B+"))
                if (!bloodGroups.containsKey("B+")) bloodGroups.put("B+", 1);
                else bloodGroups.put("B+", bloodGroups.get("B+") + 1);
            if (bloodGroup.trim().equals("B-"))
                if (!bloodGroups.containsKey("B-")) bloodGroups.put("B-", 1);
                else bloodGroups.put("B-", bloodGroups.get("B-") + 1);
            if (bloodGroup.trim().equals("0+"))
                if (!bloodGroups.containsKey("0+")) bloodGroups.put("0+", 1);
                else bloodGroups.put("0+", bloodGroups.get("0+") + 1);
            if (bloodGroup.trim().equals("0-"))
                if (!bloodGroups.containsKey("0-")) bloodGroups.put("0-", 1);
                else bloodGroups.put("0-", bloodGroups.get("0-") + 1);
        }

        for (String key : bloodGroups.keySet())
            System.out.println(key + "=" + bloodGroups.get(key));

        // Премногу if-else ови има тука xD
        // Во задачата главната идеја е да игнорираме ако имаме А1+ или А2-, тоест
        // бројката да ја игнорираме и тоа го праиме со помош на споредувањето на карактерите
        // останатото е едноставно. Тест примерот што е во учебникот има
        // em dash за минус и може да не работи при директно копирање.
    }

}
