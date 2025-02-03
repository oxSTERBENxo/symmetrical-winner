package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class File {
    String path;
    String name;
    String content;

    File (String path, String file, String content) {
        this.path = path;
        this.name = file;
        this.content = content;
    }

    @Override
    public String toString() {
        return path + name;
    }

}

public class Files {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<File>> fileSystem = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split("\\s+");
            String path = tokens[0];
            String name = tokens[1];
            String content = tokens[2]; // со загради (...)
            File file = new File (path, name, content);
            if (!fileSystem.containsKey(content)) {
                fileSystem.put(content, new ArrayList<>());
                fileSystem.get(content).add(file);
            } else fileSystem.get(content).add(file);
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String path = tokens[1];
            String name = tokens[2];
            String content = tokens[3];
            File file = new File (path, name, content);
            int idx;
            if (command.equals("add")) {
                if (!fileSystem.containsKey(content)) { // ако не постои
                    fileSystem.put(content, new ArrayList<>()); // иницијализирај
                    fileSystem.get(content).add(new File(path, name, content)); // додади го
                } else fileSystem.get(content).add(new File(path, name, content)); // инаку додади го само
            } else if (command.equals("delete")) {
                if (fileSystem.containsKey(content)) { // ако воопшто постои вакво мапирање
                    idx = fileSystem.get(content).indexOf(file); // најди го индексот на фајлот
                    if (idx > 0) fileSystem.get(content).remove(idx); // ако индексот е нормален, избриши го
                                                                     // (проверувам дали е нормален за да не ми фрли исклучок)
                }
            } else if (command.equals("find"))
                if (fileSystem.containsKey(content) && (fileSystem.get(content).indexOf(file) > 0)) System.out.println("true");
                else System.out.println("false");
        }

        String query = br.readLine();
        query = "(" + query + ")"; // фора
        if (fileSystem.containsKey(query)) for (File file : fileSystem.get(query)) System.out.print(file.toString() + " ");

        // Во задачата е форица дека кога го пуштаат query-то, го пуштаат без загради
        // Уште една форица е да не ти излезе исклучок некаде.
        // Искрено совет при решавање на вакви задачи е пред да правам некоја
        // чудна операција (remove, find, итн...) секогаш треба да проверувам
        // дали можам воопшто тоа да го направам бидејќи може да излезе
        // исклучок инаку. Мој совет е секогаш припазување на таквите работи
        // секогаш проверување дали воопшто постои такво мапирање, пред да правам нешто со тоа мапирање
        // На кратко, не е баш најубаво да се претпоставува
        // дека нешто е така, компјутерот следи буквални инструкции
    }
}
