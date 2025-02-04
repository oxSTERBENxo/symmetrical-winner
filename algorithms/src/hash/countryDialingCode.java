package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class countryDialingCode {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> dialingCodes = new HashMap<>(); // од кодови во земји

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String code = tokens[0];
            String country = tokens[1];
            if (!dialingCodes.containsKey(code)) dialingCodes.put(code, country);
        }

        String query = br.readLine();
        char howManyDigits = query.charAt(1);
        if (howManyDigits == '1') query = query.substring(1, 2);
        else  if (howManyDigits == '2') query = query.substring(1, 3); // од опсег [1, 3),
        else  if (howManyDigits == '3') query = query.substring(1, 4);

        System.out.println(dialingCodes.get(query));

        // Доста едноставна задача.
        // Во зависност од цифрата после плусот (+26ХХХХХ, во случајов 2)
        // го кратиме query-то за да ни биде форматирано како
        // клучевите со хеш мапата, за да можеме да ја вратиме земјата
    }

}
