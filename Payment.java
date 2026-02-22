package e_commerce;

import java.util.Scanner;

public class Payment {

    Scanner sc = new Scanner(System.in);

    public void makePayment(double amount) {
        System.out.println("\n------ PAYMENT ------");
        System.out.println("1. Net Banking");
        System.out.println("2. UPI");
        System.out.print("Choose payment option: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter Account Number: ");
            String acc = sc.next();

            System.out.print("Enter IFSC Code: ");
            String ifsc = sc.next();

            System.out.print("Enter Bank Name: ");
            String bank = sc.next();

            System.out.println("\nProcessing Net Banking Payment...");
            System.out.println("Amount: ₹" + amount);
            System.out.println(Colors.GREEN + "Payment Successful! ✅" + Colors.RESET);

        } else if (choice == 2) {
            System.out.print("Enter UPI ID: ");
            String upi = sc.next();

            System.out.println("\nProcessing UPI Payment...");
            System.out.println("Amount: ₹" + amount);
            System.out.println(Colors.GREEN + "Payment Successful! ✅" + Colors.RESET);

        } else {
            System.out.println("Invalid Payment Option!");
        }
    }
}

