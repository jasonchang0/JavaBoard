package util;

import java.util.PriorityQueue;

public class priorityQueue {
    

    public static void main(String[] args) {
        double[] scores = new double[]{109.0 / 135, 75.0 / 128, 110.0 / 190};
        PriorityQueue<Double> scoreQueue = new PriorityQueue<>(3);

        for (double s : scores) {
            scoreQueue.add(s);
        }

        System.out.println(scoreQueue.peek());
        System.out.println(scoreQueue.poll());

        scoreQueue.remove(scoreQueue.peek());
        System.out.println(scoreQueue.size());
    }
}
