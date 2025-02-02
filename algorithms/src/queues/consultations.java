package queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Student {
    String name;
    char type;

    Student (String name, char type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

}

public class consultations {

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Student> aps = new LinkedList<Student>();
        Queue<String> mms = new LinkedList<String>();
        LinkedList<String> events = new LinkedList<String>();

        int n = Integer.parseInt(br.readLine().trim()); // број на студенти коишто чекаат консултации за
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            char type = tokens[1].charAt(0);
            Student student = new Student(name, type);
            aps.offer(student);
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String student = br.readLine();
            mms.offer(student);
        }

        while (!aps.isEmpty()) {
            Student student = aps.poll();
            char question = student.type;
            events.add(student.toString()); // стави го во евенти
            if (!aps.isEmpty() && (aps.peek().type == question)) {
                if (!mms.isEmpty()) events.add(mms.poll()); // пушти еден од другата група
                aps.offer(aps.poll()); // следниот стави го на крај
            }
        }

        while (!mms.isEmpty())  // ако има преостанати
            events.add(mms.poll());

        for (String event : events)
            System.out.println(event);

        // Во задачата ни се бара да го напишеме конечниот редослед на студенти кои што
        // ќе бидат примени на консултации. Студентите доаѓаат на консултации за АПС или за ММС
        // Студентите кои доаѓаат на консултации за АПС имаат 4 типа на прашања кои можат да ги поставуваат:
        // А, B, C или D. Прво се обработуваат студентите коишто чекаат за АПС
        // бидејќи следниот ден имаат колоквиум по АПС. Доколку е примен студент којшто имал прашање од тип Х
        // и ако следниот студент има исто така прашање од тип Х, тогаш тој студент се носи на крајот од редицата
        // и се пушта еден студент од редицата за ММС.                              (Х = A, B, C, D)

        // За да ја решам задачата, правам едноставна класа Student
        // каде што имам атрибути име и тип на прашање.
        // Прво ги обработувам студентите коишто чекаат за АПС.
        // Го вадам студентот којшто е на ред, го зачувувам неговиот тип на прашање и го ставам во списокот.
        // Потоа го гледам студентот по него, peek(), и им ги споредувам типовите на прашања.
        // Ако типовите на прашања се исти, го вадам студентот којшто е на ред и го ставам на крајот од редицата,
        // и ако не е празна редицата за ММС, го пуштам студентот што е на ред од таа редица (го запишувам на списокот)

        // На крај, ако има преостанати од ММС редицата, ги обработувам и нив.

    }

}
