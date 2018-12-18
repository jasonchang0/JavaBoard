package util;
import java.util.Hashtable;

public class hashTable {
    public static void main(String[] args) {
        Hashtable<Integer, String> nums = new Hashtable<>();

        nums.put(0, "zero");
        nums.put(1, "one");
        nums.put(2, "two");
        nums.put(3, "three");
        nums.put(4, "four");
        nums.put(5, "five");

        System.out.println(nums.size());
//        System.out.println(nums.keys());

        nums.remove(5);

        for (int i : nums.keySet()) {
            System.out.println(i);
        }

        for (String s : nums.values()) {
            System.out.println(s);
        }

        System.out.println(nums.containsKey(5));
        System.out.println(nums.get(0));
    }
}
