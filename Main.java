package converter;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var x = scan.nextInt();
        System.out.println(x % 8);
    }
}
