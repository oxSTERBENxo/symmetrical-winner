package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class Book {

    public String title;
    public int takenOut;

    Book (String title, int takenOut) {
        this.title = title;
        this.takenOut = takenOut;
    }

    @Override
    public String toString() {
        return title + " " + takenOut;

    }
}

public class examSession {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String [] parts = input.split(" ");

        int n = Integer.parseInt(parts[0].trim()); // број на книги
        int m = Integer.parseInt(parts[1].trim()); // број на испити

        input = br.readLine();
        String[] books = input.split(" "); // насловите
        input = br.readLine();
        String[] exams = input.split(" "); // таргет

        Stack<Book> bookStack = new Stack<Book>();
        Stack<Book> helper = new Stack<Book>();

        Book [] bookArr = new Book[n];
        for (int i = 0; i < n; i++) {
            bookArr[i] = new Book(books[i], 0); // вака го запазувам редот на појавување
            bookStack.push(bookArr[i]); // исти референци имаат и во стек и во низа
        }

        for (String exam : exams) {
            while (!bookStack.isEmpty() && !bookStack.peek().title.equals(exam)) { // се додека не те најдам
                Book book = bookStack.pop(); // вади
                book.takenOut ++; // зголеми
                helper.push(book); // стави во помошниот стек
            }
            Book theBook = bookStack.pop(); // супер те најдов те извадов
            theBook.takenOut ++; // зголеми
            while (!helper.isEmpty()) { // да знаеме до кога да враќаме
                bookStack.push(helper.pop()); // ги враќам старите назад
            }
            bookStack.push(theBook); // те враќам тебе најгоре
        }

        for (Book book : bookArr) {
            System.out.println(book); // истите референци, па како се зголемуваат во стек така и во низа ќе се зголемуваат
                                            // takenOut
        }

//        System.out.println(bookStack);


        // Во задачата се бара да се напише за секоја книга колку пати ќе се извади
        // од стекот (вадење-ставање е еден настан)
        // Прво создавам едноставна класа Book, и во неа чувам две променливи
        // наслов на книгата и број на колку пати ја имам извадено
        // конструктор обичен и toString() метода (инаку ќе принтаме адреси xD)

        // Создавам два стека, првиот стек е главниот,
        // а вториот стек ми служи за помош (да го запазам редоследот по кој биле вадени)
        // Имам еден while кој ми врти се додека не наидам на книгата што ја барам,
        // внатре во него, ги вадам другите книги, и им ја зголемувам нивната takenOut вредност за еден
        // и ги ставам во помошниот стек.

        // Кога ќе ја најдам книгата, ја вадам и неа од стекот,
        // ја зголемувам takenOut и ја чувам (не ја ставам во помошниот)
        // Имам друг while, кој што ми се повторува се дур не се испразни помошниот стек,
        // ги враќам книгите од помошниот во главниот стек
        // Откако ќе ги вратам сите книги во главниот стек, ќе ја вратам и книгата која што првично ја барав
        // На крајот, со for each циклус ги печатам сите книги
        
    }

}
