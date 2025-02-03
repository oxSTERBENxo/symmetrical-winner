package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Offer {
    String time;
    String city;
    int fee;

    Offer(String time, String city, int fee) {
        this.time = time;
        this.city = city;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return time + " " + city + " " + fee;
    }

}


public class bestOffer {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Offer> offers = new HashMap<String, Offer>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            String date = tokens[0]; // клучот
            String time = tokens[1]; // време
            String city = tokens[2]; // град
            int fee = Integer.parseInt(tokens[3]); // хонорар
            Offer offer = new Offer(time, city, fee); // објект од класата Offer
            if (!offers.containsKey(date)) offers.put(date, offer); // ако не постои ова мапирање, стави го
            else if (offers.get(date).fee < fee) offers.put(date, offer); // само ако вредноста на мапирањето
                                                                         // е помала од таа што доаѓа сега, стави ја новата
        }

        String date = br.readLine();
        if (!offers.containsKey(date)) System.out.println("No offers.");
        else System.out.println(offers.get(date));

        // Во задачата се бара да ја прикажеме најдобрата понуда за одреден датум.
        // Правам едноставна класа за да ми биде полесно кога примам од стандарден влез.
        // Главната работа во задачата е да припазам да ставам вредност
        // само кога моментална вредност за тој клуч е помала од вредноста што сакам да ја ставам
        // Ова го правам со цел да се ставаат само максималните хонорари.
        // (инаку ќе ми се изгуби прогресот)

    }

}
