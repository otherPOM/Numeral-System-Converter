package converter;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var sRadix = scan.nextInt();
        scan.nextLine();
        var num = scan.nextLine();
        var radix = scan.nextInt();

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
    }
}
