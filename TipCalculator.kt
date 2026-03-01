import java.lang.Math;

public class Main {

    public static double calculateTip(double amount, double tipPercent, boolean roundUp) {
        double tip = amount * tipPercent / 100;

        if (roundUp) {
            tip = Math.ceil(tip);
        }

        return tip;
    }

    public static void main(String[] args) {

        // Fixed values (change if needed)
        double amount = 1000;
        double tipPercent = 10;
        boolean roundUp = true;

        double tip = calculateTip(amount, tipPercent, roundUp);
        double total = amount + tip;

        System.out.println("Bill Amount: " + amount);
        System.out.println("Tip Amount: " + tip);
        System.out.println("Total Amount: " + total);
    }
}
