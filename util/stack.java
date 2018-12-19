package util;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        double[] scores = new double[]{11.0 / 11, 111.5 / 125, 120.0 / 125, 116.0 / 125, 101.5 / 125, 113.0 / 125, 90.0 / 125, 120.0 / 125};
        System.out.println(scores.length);

        Stack<Double> scoreQueue = new Stack<>();
        for (double s : scores) {
            scoreQueue.push(s);
        }

        System.out.println(scoreQueue.size());

        System.out.println(scoreQueue.peek());
        System.out.println(scoreQueue.size());

        System.out.println(scoreQueue.pop());
        scoreQueue.remove(120.0 / 125);

        System.out.println(scoreQueue.size());
    }
}
