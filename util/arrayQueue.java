package util;

import java.util.concurrent.ArrayBlockingQueue;

public class arrayQueue {
    // A bounded blocking queue backed by an array
    public static void main(String[] args) {
        double[] scores = new double[]{11.0 / 11, 111.5 / 125, 120.0 / 125, 116.0 / 125, 101.5 / 125, 113.0 / 125, 90.0 / 125, 120.0 / 125};
        System.out.println(scores.length);

        ArrayBlockingQueue<Double> scoreQueue = new ArrayBlockingQueue<>(8);
        for (double s : scores) {
            scoreQueue.add(s);
        }

        System.out.println(scoreQueue.size());
        System.out.println(scoreQueue.remainingCapacity());

        System.out.println(scoreQueue.peek());
        System.out.println(scoreQueue.size());

        System.out.println(scoreQueue.poll());
        scoreQueue.remove(120.0 / 125);

        System.out.println(scoreQueue.size());
    }
}
