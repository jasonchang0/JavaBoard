package util;
import java.util.LinkedList;

public class sequentialList {
    public static void main(String[] args) {
        LinkedList<Integer> llst = new LinkedList<>();

        System.out.println(llst.size());
        System.out.println(llst.isEmpty());

        int[] odds = new int[]{1, 3, 5, 7, 9};
        int[] evens = new int[]{0, 2, 4, 6, 8};

        for (int i : odds) {
            // equivalent to add() calls
            llst.addLast(i);
        }

        for (int i : evens) {
            llst.addFirst(i);
        }

        for (int i = 0; i < 20; i += 4) {
            System.out.println(llst.contains(i));
        }

        int head = llst.remove();
        int tail = llst.removeLast();

        System.out.println("Head: " + head + "\nTail: " + tail);

        // equivalent to remove() calls
        System.out.println(llst.pop());

        System.out.println(llst.size());
    }
}
