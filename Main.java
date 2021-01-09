package converter;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final String s = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        var sourceRadixInput = scan.nextLine();
        if (!sourceRadixInput.matches("[0-9]+")) {
            error();
        }
        var sourceRadix = Integer.parseInt(sourceRadixInput);
        if (sourceRadix < 1 || sourceRadix > 36) {
            error();
        }
        var num = scan.nextLine();
        check(num, sourceRadix);
        var radixInput = scan.nextLine();
        if (!radixInput.matches("[0-9]+")) {
            error();
        }
        var radix = Integer.parseInt(radixInput);

        if (radix < 1 || radix > 36) {
            error();
        }

        if (!num.contains(".")) {
            int numInDec;
            if (sourceRadix == 1) {
                numInDec = num.length();
            } else {
                numInDec = Integer.parseInt(num, sourceRadix);
            }

            if (radix == 1) {
                System.out.println("1".repeat(numInDec));
            } else {
                System.out.println(Integer.toString(numInDec, radix));
            }
        } else {
            if (!num.matches(regex(sourceRadix) + "." + regex(sourceRadix))) {
                error();
            }
            var numParts = num.split("\\.");
            var integerPart = Integer.toString(Integer.parseInt(numParts[0], sourceRadix), radix);
            var fractionalPart = convertFractionalToDecimal(numParts[1], sourceRadix);
            System.out.println(integerPart + convertFractionalToRadix(fractionalPart, radix));
        }
    }

    private static String regex(int radix) {
        if (radix <= 10) {
            return "[0-" + (radix - 1) + "]+";
        } else {
            return "[0-9a-" + s.charAt(radix - 1) + "]+";
        }
    }

    private static void check(String num, int sourceRadix) {
        if (!num.matches("1+") && !num.matches(regex(sourceRadix)) &&
                !num.matches(regex(sourceRadix) + "." + regex(sourceRadix))) {
            error();
        }
    }

    private static void error() {
        System.out.println("error");
        System.exit(-1);
    }

    private static double convertFractionalToDecimal(String fractional, int radix) {
        var res = 0d;
        for (int i = 0; i < fractional.length(); i++) {
            res += Character.digit(fractional.charAt(i), radix) / Math.pow(radix, i + 1);
        }
        return res;
    }

    private static String convertFractionalToRadix(double fractional, int radix) {
        var sb = new StringBuilder(".");
        for (int i = 0; i < 5; i++) {
            fractional *= radix;
            var integerPart = (int) fractional;
            sb.append(Integer.toString(integerPart, radix));
            fractional -= integerPart;
        }
        return sb.toString();
    }
}
