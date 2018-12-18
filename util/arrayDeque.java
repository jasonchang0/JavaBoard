package util;
import java.util.ArrayDeque;

public class arrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        System.out.println(deque.size());
        System.out.println(deque.isEmpty());

        int[] odds = new int[]{1, 3, 5, 7, 9};
        int[] evens = new int[]{0, 2, 4, 6, 8};

        for (int i : odds) {
            // equivalent to add() calls
            deque.addLast(i);
        }

        for (int i : evens) {
            deque.addFirst(i);
        }

        for (int i = 0; i < 20; i += 4) {
            System.out.println(deque.contains(i));
        }

        int head = deque.remove();
        int tail = deque.removeLast();

        System.out.println("Head: " + head + "\nTail: " + tail);

        // equivalent to remove() calls
        System.out.println(deque.pop());

        System.out.println(deque.size());
    }
}
