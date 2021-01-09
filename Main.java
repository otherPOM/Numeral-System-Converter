package converter;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var num = scan.nextInt();
        var radix = scan.nextInt();
        String prefix = "";
        switch (radix) {
            case 2:
                prefix = "0b";
                break;
            case 8:
                prefix = "0";
                break;
            case 16:
                prefix = "0x";
                break;
        }
        System.out.println(prefix + Long.toString(num, radix));
    }
}
