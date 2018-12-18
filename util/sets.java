package util;

import java.util.HashSet;

public class sets {
    public static void main(String[] args) {
        int[] vals = new int[]{1, 2, 1, 3, 1, 3, 4, 5, 4, 2, 1, 3, 1, 2, 4, 5};

        /* Interchangeable with TreeSet for
        more efficient amortized runtime
         */
        HashSet<Integer> hSet = new HashSet<>();

        System.out.println(hSet.isEmpty());

        for (int i : vals) {
            hSet.add(i);
        }

        hSet.remove(5);

        System.out.println("Number of Elements: " + hSet.size());

    }
}
