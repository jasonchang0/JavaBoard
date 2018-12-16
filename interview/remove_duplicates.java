package interview;

import java.util.HashSet;
import java.util.Set;

public class remove_duplicates {
    public static void main(String[] args) {
        Set<Integer> no_dup = new HashSet<>();
        for (String s : args) {
            no_dup.add(new Integer(s));
        }

        System.out.println(no_dup);
    }
}
