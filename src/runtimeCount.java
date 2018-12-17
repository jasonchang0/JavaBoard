package src;


public class runtimeCount {
    public int[] a = new int[100000];
    public static int runCount = 0;

    public int runtime(int N) {
        for (int i = 0; i < 100000; i += 1) {
            a[i] = i;
        }

        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] >= a[k]) count++;
        return count;
    }

    public static int f1 (int n) {
        int x = 0;
        for (int i = 0; i < n; i++)
            x++;
        return x;
    }

    public static int f4 (int n) {
        runCount += 1;
        if (n <= 1) return 1;
        return f4(n/2) + f4(n/2);
    }

    public static int f5 (int n) {
        runCount += 1;
        if (n <= 1) return 1;
        return f1(n) + f5(n/2) + f5(n/2);
    }

    public static void f6 (int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                runCount += 1;
            }
        }
    }

    public static void main(String[] args) {
        runtimeCount b = new runtimeCount();
//        System.out.println(b.runtime(100));
//        System.out.println(b.runtime(1000));

//        Long start = System.currentTimeMillis();
//        runtimeCount.f4(100000);
//        Long end = System.currentTimeMillis();
//        System.out.println(end - start;
//
//        start = System.currentTimeMillis();
//        runtimeCount.f4(1000000);
//        end = System.currentTimeMillis();
//        System.out.println(end - start);
//        f4(1000);
//        System.out.println("f4(1000):" + runCount);
//        runCount = 0;
//        f4(10000);
//        System.out.println("f4(10000):" + runCount);
//
//        runCount = 0;
//        f4(100000);
//        System.out.println("f4(100000):" + runCount);
//
//        f5(1000);
//        System.out.println("f5(1000):" + runCount);
//        runCount = 0;
//        f5(10000);
//        System.out.println("f5(10000):" + runCount);
//
//        runCount = 0;
//        f5(100000);
//        System.out.println("f5(100000):" + runCount);

        f6(1000);
        System.out.println("f6(1000):" + runCount);
        runCount = 0;
        f6(10000);
        System.out.println("f6(10000):" + runCount);

        runCount = 0;
        f6(100000);
        System.out.println("f6(100000):" + runCount);
    }
}
