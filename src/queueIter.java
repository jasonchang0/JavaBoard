package src;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class queueIter {
    public static void main(String[] args) {
        Queue<Integer> num = new ArrayBlockingQueue<>(9);
        num.add(0);
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);
        num.add(8);
        for(int i : num) {
            System.out.println(i);
        }
    }
}
