package src;

import java.util.*;
import java.util.stream.IntStream;


class ArrayAddition {
    public static Boolean ArrayAddition(int[] arr) {

        Arrays.sort(arr);

        int target = arr[arr.length - 1];
        int sum = 0;

        if (IntStream.of(arr).anyMatch(x -> x == 1)) {
            return true;
        }

        for (int i = 0; i < arr.length - 1; i += 1) {
            sum += arr[i];
            if (sum > target) {
                arr = Arrays.copyOfRange(arr, 0, i + 1);
                arr[arr.length - 1] = target - sum - arr[i];

                return ArrayAddition(arr);

            } else if (sum == target) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        // keep this function call here

        System.out.println(ArrayAddition(new int[]{54,49,1,0,7,4}));
//        Scanner s = new Scanner(System.in);
//        System.out.print(ArrayAddition((int[]) s.nextLine()));
    }

}


