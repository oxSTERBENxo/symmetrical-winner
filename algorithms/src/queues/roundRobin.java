package queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Process {
    String name;
    public int timeOfArrival;
    public int executionTime;

    Process(String name, int timeOfArrival, int executionTime) {
        this.name = name;
        this.timeOfArrival = timeOfArrival;
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return name;
    }

}

public class roundRobin {

    public static Process firstArrivedProcess(ArrayList<Process> processes) {
        Process first = processes.getFirst();

        for (int i = 1; i < processes.size(); i++) {
            if (first.timeOfArrival > processes.get(i).timeOfArrival) first = processes.get(i);
            if (first.timeOfArrival == processes.get(i).timeOfArrival) // ако им се исти, ги споредуваме нивните времиња на извршување
                if (first.executionTime < processes.get(i).executionTime) first = processes.get(i);

        }
        processes.remove(first); // по завршувањето на for циклусот, веќе е најден first, и може да се избрише од низата
        return first;
    }

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.trim()); // колку процеси


        ArrayList<Process> processes = new ArrayList<>();
        Queue<Process> queue = new LinkedList<>();
        LinkedList<String> events = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            String[] tokens = input.split(" ");
            String name = tokens[0];
            int executionTime = Integer.parseInt(tokens[1]); // кога пристигнале
            int timeOfArrival = Integer.parseInt(tokens[2]); // колку време им треба да го завршат процесот
            Process process = new Process(name, timeOfArrival, executionTime);
            processes.add(process); // потребно ми е ова за влезот да го исхенлдам
        }
        int quantum = Integer.parseInt(br.readLine().trim()); // колку време имаат секој од нив

        for (int i = 0; i < n; i++) { // enqueuing
            Process process = firstArrivedProcess(processes);
            queue.offer(process);
        }


        while (!queue.isEmpty()) {
            Process process = queue.poll(); // го вадиме од редицата, да видиме кој прв
            int maybeMaybeNot = process.executionTime - quantum;
            if (maybeMaybeNot > 0) {
                process.executionTime = maybeMaybeNot; // го менуваме неговото иницијално време на извршување
                events.add(process.toString()); // го додаваме во events
                queue.offer(process); // го враќаме на крај бидејќи не е завршено
            } else events.add(process.toString()); // супер нека си биде изваден, само запиши го кога се направил
        }

        for (String event : events)
            System.out.print(event + " ");


        // Во задачава ми се бараше да процесирам процеси.
        // Во редицата приоритет имаат оние кои имаат најмало време на пристигнување
        // (доколку времињата на пристигнување на два процеси се исти, тогаш има приоритет процесот со поголемо време на извршување)

        // Како излез ми се бара да ги испечатам процесите како се додаваат.
        // (Не треба да ја испечатам редицата туку треба да го испечатам логот на додавање, затоа користам листа посебна)
        // На почеток, прававм едноставна класа која во којашто имам атрибути (име, и двете времиња)
        // Исто така, правам и функција која што ќе ми го пресметува кој процес треба прв да влезе во редицата
        // Оваа функција ја повикувам онолку пати колку што има процеси, со цел да ги ставам на почеток во редицата
        // (важна е функцијата за да ги сместам првично во редицата)
        // Во while циклусот, го вадам првиот што е во редицата,
        // гледам колку му е времето на извршување, го одземам од квантумот
        // доколку времето на извршување е поголемо од квантумот,
        // новото време на извршување на процесот ќе биде неговото првично време на извршување минус квантумот.
        // Откако ќе го сторам тоа, процесот ќе го запишам во events и ќе го вратам на крајот од редицата
        // Инаку само ќе го запишам процесот во events
        
    }


}
