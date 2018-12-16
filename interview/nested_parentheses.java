package interview;

public class nested_parentheses {
    public static void main(String[] args) {
        int equilibrium = 0;

        for (String s : args) {
            if (s.equals('(')) {
                equilibrium += 1;
            }
            else if (s.equals(')')) {
                equilibrium -= 1;
            }
        }

        System.out.println("Balanced nesting: " + Boolean.toString(equilibrium == 0));
    }
}
