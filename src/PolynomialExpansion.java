package src;
import java.util.*;

public class PolynomialExpansion {
    private class Term {
        private int coefficient;
        private int power;

        public Term(String exps) {
            String[] exp = exps.split("[X\\^]");
            this.coefficient = Integer.parseInt(exp[0]);

            // index 1 is empty term
            this.power = Integer.parseInt(exp[2]);
        }

        public Term multiply(Term t2) {
            int new_coefficient = this.coefficient * t2.coefficient;
            int new_power = this.power + t2.power;

            return new Term(new_coefficient + "X^" + new_power);
        }

        @Override
        public boolean equals(Object o){
            Term t = (Term) o;
            return this.coefficient == t.coefficient && this.power == t.power;
        }

        @Override
        public int hashCode() {
            return (int) Math.round(Math.pow((double) coefficient, (double) power));
        }

        @Override
        public String toString() {
            return this.coefficient + "X^" + this.power;
        }
    }

    // (x^2+3x^1+5x^0)(x^1) = (x^3+3x^2+5x^1)
    public String PolynomialExpansion(String str) {
        ArrayList<String> groups = new ArrayList<>();

        for (String s : str.split("[)(]")) {
            s = s.replaceAll("[(]", "");

//            if (!Boolean.parseBoolean(s)) {
//                continue;
//            }

            if (s.length() == 0) {
                continue;
            }

            groups.add(s);
        }

        ArrayList<ArrayList<Term>> terms = new ArrayList<>();

        // initializing
        for (int i = 0; i < groups.size(); i += 1) {
            terms.add(new ArrayList<>());
        }

        for (int i = 0; i < groups.size(); i += 1){
            for (String exp : groups.get(i).split("[\\+]")) {
                terms.get(i).add(new Term(exp));
            }
        }

        while (terms.size() > 1) {
            ArrayList<Term> terms1 = terms.remove(0);
            ArrayList<Term> terms2 = terms.remove(0);
            ArrayList<Term> new_t = new ArrayList<>();

            for (Term t1 : terms1) {
                for (Term t2 : terms2) {
                    new_t.add(t1.multiply(t2));
                }
            }

            terms.add(new_t);
        }

        String output = "";
        ArrayList<Term> output_terms = terms.get(0);

        for (Term term : output_terms) {
            output += term.toString() + "+";
        }


        // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */

        return output.substring(0, output.length() - 1);

    }

    public static void main(String[] args) {
        // keep this function call here
        PolynomialExpansion pe = new PolynomialExpansion();
        System.out.println(pe.PolynomialExpansion("(1X^2+3X^1+5X^0)(1X^1)"));

//        Scanner s = new Scanner(System.in);
//        System.out.print(pe.PolynomialExpansion(s.nextLine()));
    }

}
