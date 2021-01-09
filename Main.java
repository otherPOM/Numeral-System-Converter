package converter;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var sRadix = scan.nextInt();
        scan.nextLine();
        var num = scan.nextLine();
        var radix = scan.nextInt();

        if (!num.contains(".")) {
            int numInDec;
            if (sRadix == 1) {
                numInDec = num.length();
            } else {
                numInDec = Integer.parseInt(num, sRadix);
            }

            if (radix == 1) {
                System.out.println("1".repeat(numInDec));
            } else {
                System.out.println(Integer.toString(numInDec, radix));
            }
        } else {
            var numParts = num.split("\\.");
            var integerPart = Integer.toString(Integer.parseInt(numParts[0], sRadix), radix);
            var fractionalPart = convertFractionalToDecimal(numParts[1], sRadix);
            System.out.println(integerPart + convertFractionalToRadix(fractionalPart, radix));
        }
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
