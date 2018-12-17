package util;

public class string {
    public static void main(String[] args) {
        String str = " q w e r t y u i o p ";
        str = str.trim();
        str = str.replaceAll("\\s", "");

        System.out.println(str.length());
        System.out.println(str.charAt(0));

        System.out.println(str.toUpperCase());
        System.out.println(str.contains(str.subSequence(0, str.length())));

        String[] splitStr = str.split("[y]");
        for (String s : splitStr) {
            System.out.println(s);
        }

    }
}
