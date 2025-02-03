package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


class Drug {
    String name;
    int yesNo;
    int price;
    int stock;

    Drug(String name, int yesNo, int price, int stock) {
        this.name = name;
        this.yesNo = yesNo;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += name.toUpperCase() + " ";
        if (yesNo == 1) ret += "POS "; // ако е 1 печати ова
        else ret += "NEG "; // инаку печати ова
        ret += price + " " + stock;
        return ret;
    }

}

public class Pharmacy {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Drug> drugs = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String [] token = line.split(" ");

            String name = token[0].toLowerCase();
            int yesNo = Integer.parseInt(token[1]); // дали ги има на позитивна листа
            int price = Integer.parseInt(token[2]); // цена
            int stock = Integer.parseInt(token[3]); // количина
            Drug drug = new Drug(name, yesNo, price, stock);

            drugs.put(name, drug);
        }

        while (true) {
            String request = br.readLine();
            if (request.trim().equalsIgnoreCase("END")) break;

            request = request.toLowerCase();
            int number = Integer.parseInt(br.readLine().trim());

            if (!drugs.containsKey(request)) System.out.println("No such drug.");
            else {
                System.out.println(drugs.get(request).toString());
                if (number < drugs.get(request).stock) {
                    System.out.println("Order made.");
                    drugs.get(request).stock -= number;
                } else System.out.println("No drugs available");
            }
        }
        // Во задачата повторно правам едноставна класа со цел
        // да си помогнам кога го читам влезот.
        // Секогаш ги ставам на мали букви, за да биде case insensitive
    }


}
