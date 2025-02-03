package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class phoneBook {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phoneBook = new HashMap<String, String>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] token = line.split(" ");
            String phone = token[0];
            String name = token[1];
            phoneBook.put(phone, name);
        }

        String query = br.readLine();
        if (query.charAt(0) == '+') {
            query = "0" + query.substring(4); // +3890
            System.out.println(phoneBook.getOrDefault(query, "Unknown number"));
        } else System.out.println(phoneBook.getOrDefault(query, "Unknown number"));

        // Доста едноставна задача
        // „Тешкиот дел“ од задачата е да видиме на крај кога го бараме бројот
        // да видиме дали влезот почнува со +389. То ест дали почнува со +
        // ако почнува со +, значи дека нас не интересира substring од тој string
        // почнувајќи од 4ти индекс и притоа додавајќи нула на почеток за да
        // се поклопи со внесовите во хеш мапата. 

    }

}
