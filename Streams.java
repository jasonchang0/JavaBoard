package JavaBoard;
import java.util.*;

public class Streams {
    public static void main(String[] args) {
//        int[] lst = new int[]{3, 5, 7, 9, 11};
        List<Integer> lst = List.of(3, 5, 7, 9, 11);
        lst.stream().mapToInt(index -> index).forEach(System.out::println);
    }
}
