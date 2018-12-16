package interview;

public class reverse_str {
    public static void main (String[] args) {
        int len = args[0].length();
        char[] r_string = new char[len];

        for (int i = len - 1; i >= 0; i -= 1) {
            r_string[len - i - 1] = args[0].charAt(i);
        }

        System.out.println(new String(r_string));
    }
}
