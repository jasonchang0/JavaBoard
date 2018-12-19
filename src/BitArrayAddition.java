package src;
import java.util.*;


class BitArrayAddition {
    public static boolean BitArrayAddition(int[] arr) {

        Arrays.sort(arr);
        int maxNum = arr[arr.length - 1];
        int[] nums = Arrays.copyOfRange(arr,0, arr.length - 1);

        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
//            System.out.println(1 << n);

            List<Integer> subset = new ArrayList<>();

            /*
            The "if" condition ((bitmask >> i) & 1) == 0
            checks whether the i'th bit in bitmask has been set,
            ie., whether the i'th character has already been added
            in the string. If it is not added,
            only then the character gets appended, otherwise not.
             */

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.println(i + " : " + Integer.toString(1 << j));
                    System.out.println(j);
                    subset.add(nums[j]);
                }
                else {
                    System.out.print("False: ");
                    System.out.println(i + " : " + Integer.toString(1 << j));
                    System.out.println((i & (1 << j)));
                }
                System.out.println();
            }
            if (subset.size() > 1) {
                int sum = subset.stream().mapToInt(index -> index).sum();
//                subset.stream().mapToInt(index -> index).forEach(System.out::print);
//                System.out.println();

                if (sum == maxNum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        // keep this function call here

        System.out.println(BitArrayAddition(new int[] {11,27,32,100}));
//        Scanner s = new Scanner(System.in);
//        System.out.print(BitArrayAddition((int[]) s.nextLine()));
    }

}


