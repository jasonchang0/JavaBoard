package src;

public class DataIndexedIntegerSet {
    private boolean[] present;

    public DataIndexedIntegerSet() {
        present = new boolean[16];
    }

    /*
    Converts ith character of String to a letter number.
    e.g. 'a' -> 1 ... 'z' -> 26
     */
    public static int letterNum(String s, int i) {
        int ithChar = s.charAt(i);
        if (ithChar < 'a' || ithChar > 'z') {
            throw new IllegalArgumentException("Symbol out of bound.");
        }

        return ithChar - 'a' + 1;
    }

    public static int convertToInt(String s) {
        int intRep = 0;
        for (int i = 0; i < s.length(); i += 1) {
            intRep = intRep << 5;
            intRep += letterNum(s, i);
        }

        return intRep;
    }

    public void insert(String s) {
        int i = convertToInt(s);
        present[i] = true;
    }

    public boolean contains(String s) {
        int i = convertToInt(s);
        return present[i];
    }
}


