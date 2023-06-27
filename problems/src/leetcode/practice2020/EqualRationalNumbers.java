package leetcode.practice2020;

public class EqualRationalNumbers {
    class Fraction {
        long numerator;
        long denominator;
        public Fraction(long numerator, long denominator) {
            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        public void addFraction(Fraction fraction) {
            long currNr = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
            long currDr = this.denominator * fraction.denominator;
            long gcd = gcd(currNr, currDr);
            this.numerator = currNr / gcd;
            this.denominator = currDr / gcd;
        }

        private long gcd(long x, long y) {
            return x == 0 ? y : gcd(y % x, x);
        }
    }

    public Fraction getFraction(String num) {
        Fraction fraction = new Fraction(0, 1);
        String[] arr = num.split("[.()]");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].isEmpty()) continue;
            long currValue = Long.valueOf(arr[i]);
            int currLen = arr[i].length();
            // i == 0 integer part of the fraction
            if(i == 0) {
                fraction.addFraction(new Fraction(currValue, 1));
            } else if(i == 1) { //
                fraction.addFraction(new Fraction(currValue, (long)Math.pow(10, currLen)));
            } else {
                long denominator = (int)Math.pow(10, arr[i - 1].length());
                denominator *= (long)Math.pow(10, currLen) - 1;
                fraction.addFraction(new Fraction(currValue, denominator));
            }
        }
        return fraction;
    }

    public boolean isRationalEqual(String S, String T) {
        Fraction fraction1 = getFraction(S);
        Fraction fraction2 = getFraction(T);
        return fraction1.numerator == fraction2.numerator && fraction1.denominator == fraction2.denominator;
    }



    public static void main(String[] args) {
        EqualRationalNumbers rationalNumbers = new EqualRationalNumbers();
        String s = "0.(52)", t = "0.5(25)";
        System.out.println(rationalNumbers.isRationalEqual(s, t));
    }
}
