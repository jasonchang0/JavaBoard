package interview;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i += 1) {
            boolean divisible_by_3 = (i % 3 == 0);
            boolean divisible_by_5 = (i % 5 == 0);

            if (divisible_by_3 && divisible_by_5) {
                System.out.println("FizzBuzz");
            }
            else if (divisible_by_3) {
                System.out.println("Fizz");
            }
            else if (divisible_by_5) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
