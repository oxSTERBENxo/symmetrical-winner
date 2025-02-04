package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class checkSpelling {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>(); // Integer е dummy value

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String word = br.readLine().toLowerCase(); // при внесување на зборови, секогаш нека бидат со мали букви
            if (!dictionary.containsKey(word)) dictionary.put(word, 1);
        }

        String query = br.readLine(); // ја читаме реченицата
        String[] tokens = query.split("\\s+"); // ја цепкаме на зборови

        for (String token : tokens) { // за секој збор во зборовите
            String word = token.toLowerCase(); // форматирано, во мали букви
            char sign = word.charAt(word.length() - 1); // гледаме што има на крај
            if (sign == '?' || sign == '!' || sign == '.' || sign == ','){ // ако е интерпункциски знак
                token = token.substring(0, token.length() - 1); // скрати го самиот збор да го нема знакот
                word = word.substring(0, word.length() - 1); // скрати го форматираниот збор да го нема знакот
            }
            if (!dictionary.containsKey(word)) System.out.println(token); // ако форматираниот збор не е во речникот
                                                                          // испринтај го зборот оригинален
        }

        // Во задачата се бара да ги најдеме зборовите кои што не се напишани добро
        // На влез секогаш зборот го форматирам да е со мали букви
        // Ставам dummy value integer = 1, колку да стои нешто за вредност
        
        // Ја читам реченицата и ја цепкам на зборови
        // За секој збор во реченицата,
        // прво правам стринг форматиран каде што секој збор
        // го правам да е со мали букви

        // Потоа правам променлива карактер која што ќе ми гледа
        // кој знак го има на крајот од зборот
        // Доколку знакот на крајот од зборот е интерпункциски знак
        // го сечам и форматираниот збор ама и оригиналниот збор (неформатиран)
        // Проверувам дали го има во речникот (хеш мапата)
        // ако го нема, го печатам зборот неформатиран оригинален
    }

}
