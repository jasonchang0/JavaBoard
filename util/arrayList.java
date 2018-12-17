package util;
import java.util.ArrayList;

public class arrayList {
    public static void main (String[] args) {
        double[] grades = new double[]{53.0/60, 48.0/60, 105.0/120};

        ArrayList<Double> gradeLst = new ArrayList<>();
        System.out.println(gradeLst.isEmpty());

        for (double i : grades) {
            gradeLst.add(i);
        }

        System.out.println(gradeLst.toArray().toString());

        for (int i = 0; i < gradeLst.size(); i += 1) {
            System.out.println(gradeLst.get(i));
        }
    }
}
