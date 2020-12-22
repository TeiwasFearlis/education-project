import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long amount = scanner.nextInt();
        double percent = 0.1;
        int month = 6;
        do {
            double ost = percent * amount;
            amount = amount - Math.round(ost);
            //System .out.println (amount );
            month--;
        }
        while (month > 0);
        System.out.println(Math.round(amount));
    }
}