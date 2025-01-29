package linkedLists;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Army {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int aStartId = sc.nextInt();
        int aEndId = sc.nextInt();
        int bStartId = sc.nextInt();
        int bEndId = sc.nextInt();

        // Find indexes of the start and end IDs
        int aStartIdx = list.indexOf(aStartId);
        int aEndIdx = list.indexOf(aEndId);
        int bStartIdx = list.indexOf(bStartId);
        int bEndIdx = list.indexOf(bEndId);

        // Check if any ID is not found
        if (aStartIdx == -1 || aEndIdx == -1 || bStartIdx == -1 || bEndIdx == -1) {
            System.out.println("Invalid input: One or more IDs not found in the list.");
            return;
        }

        // Ensure the start index is before the end index for both intervals
        if (aStartIdx > aEndIdx) {
            int temp = aStartIdx;
            aStartIdx = aEndIdx;
            aEndIdx = temp;
        }
        if (bStartIdx > bEndIdx) {
            int temp = bStartIdx;
            bStartIdx = bEndIdx;
            bEndIdx = temp;
        }

        // Check if intervals overlap
        if ((aStartIdx <= bEndIdx && aEndIdx >= bStartIdx) ||
                (bStartIdx <= aEndIdx && bEndIdx >= aStartIdx)) {
            System.out.println("Invalid input: Intervals overlap.");
            return;
        }

        // Determine which interval comes first
        boolean aComesFirst = aStartIdx < bStartIdx;
        int firstStart, firstEnd, secondStart, secondEnd;

        if (aComesFirst) {
            firstStart = aStartIdx;
            firstEnd = aEndIdx;
            secondStart = bStartIdx;
            secondEnd = bEndIdx;
        } else {
            firstStart = bStartIdx;
            firstEnd = bEndIdx;
            secondStart = aStartIdx;
            secondEnd = aEndIdx;
        }

        // Split the list into parts
        List<Integer> beforeFirst = new LinkedList<>(list.subList(0, firstStart));
        List<Integer> firstPart = new LinkedList<>(list.subList(firstStart, firstEnd + 1));
        List<Integer> betweenParts;

        if (firstEnd + 1 <= secondStart - 1) {
            betweenParts = new LinkedList<>(list.subList(firstEnd + 1, secondStart));
        } else {
            betweenParts = new LinkedList<>();
        }

        List<Integer> secondPart = new LinkedList<>(list.subList(secondStart, secondEnd + 1));
        List<Integer> afterSecond = new LinkedList<>(list.subList(secondEnd + 1, list.size()));

        // Rebuild the list by swapping the two intervals
        list.clear();
        list.addAll(beforeFirst);
        list.addAll(secondPart);
        list.addAll(betweenParts);
        list.addAll(firstPart);
        list.addAll(afterSecond);

        // Print the result
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Проба на новиот AI модел создаден од Кинезите,
        // ви го претставувам DeepSeek :D

    }
}