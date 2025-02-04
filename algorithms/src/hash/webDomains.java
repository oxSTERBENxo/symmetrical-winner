package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class webDomains {

    public static boolean findTheDot (String string) {
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) == '.') return true;
        return false;
    }

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> domains = new HashMap<String, Integer>();

        int n = Integer.parseInt(br.readLine().trim()); // број на домени
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int number = Integer.parseInt(tokens[0]); // број на посети
            String domain = tokens[1];
            String[] parts = domain.split("\\.");
            for (String part : parts) {
                if (!domains.containsKey(part)) domains.put(part, number); // ако те нема во мапата, број на посети е number
                else domains.put(part, domains.get(part) + number); // инаку постоечки број на посети + твојот број на посети
            }
        }

        ArrayList<String> webSites = new ArrayList<String>();

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if (findTheDot(line)) {
                String[] tokens = line.split("\\.");
                String domain = tokens[0]; // првиот збор само
                if (!webSites.contains(domain)) webSites.add(domain);
            }
            else if (!webSites.contains(line)) webSites.add(line);
        }

        for (String domain : webSites) {
            if (domains.containsKey(domain)) System.out.println(domains.get(domain));
            else System.out.println("Not found");
        }

        // Во задачата се бара да изброиме колку пати се посетени домените
        // Логиката е, при вчитување, сите можни клучни зборови ги запишуваме заедно со нивниот број на посетеност
        // Ако случајно се повтори некој клучен збор, тогаш само на постоечката вредност ја додаваме дополнителната
        // вредност со која бројот доаѓа (com -> 900, com, 50 -----> com -> 950)

        // Потоа, напишав една кратка функција којашто ми ја бара точката во стрингот
        // Ако има точка во стрингот, стрингот го делам на делови и го земам само првиот дел
        // и за него читам колку посетеност има
    }

}
