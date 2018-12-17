package interview;

public class arrays {
    public static void main(String[] args) {
        /*
        Array is a fixed length data structure
        while ArrayList is a variable length Collection
        class.
         */

        int[] x  = new int[] {0 , 1, 3, 5, 7};
        System.out.println(x.length);

        double[] y = new double[10];
        System.out.println(y.toString());

        double d = 0;
        for (int i = 0; i < y.length; i += 1) {
            y[i] = d;
            d += 2;

            System.out.println(y[i]);
        }
    }
}
