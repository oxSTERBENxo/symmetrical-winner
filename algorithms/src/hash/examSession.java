package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

class Exam implements Comparable<Exam> {
    String name;
    Date time;
    String room;
    String date;

    Exam(String name, Date time, String room, String date) {
        this.name = name;
        this.time = time;
        this.room = room;
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // морам вака за да му кажам дека сакам само часовите и минутите
        return sdf.format(time) + " " + room + " " + name;
    }

    @Override
    public int compareTo(Exam o) {
        return this.time.compareTo(o.time);
    }

}


public class examSession {

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Exam>> exams = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // вака за да знае што да чита

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ", 4); // најмногу 4 - 1 пати ќе го подели
            String date = tokens[0];
            Date time = sdf.parse(tokens[1]); // треба помошничето да му испарсира
            String room = tokens[2];
            String name = tokens[3];
            Exam exam = new Exam(name, time, room, date);
            if (!exams.containsKey(date)) {
                exams.put(date, new ArrayList<>());
                exams.get(date).add(exam);
            } else exams.get(date).add(exam);
        }

        String query = br.readLine();
        Collections.sort(exams.get(query));
        for (Exam exam : exams.get(query)) {
            System.out.println(exam.toString());
        }

        // Во задачава штосот беше како да го читаме влезот.
        // Фала богу има прекрасна функција .split(String regex, int limit)
        // којашто ни овозможува да го цепкаме стрингот одреден број пати.
        // Кога го внесувам int limit, јас и кажувам на split функцијата
        // да го цепка стрингот limit - 1 пати, овозможувајќи ми
        // да го задржам како што треба името на предметот
        // (името на предметот има празни места пр. Калкулус 1)

    }

}
