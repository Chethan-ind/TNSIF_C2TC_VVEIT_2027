package TicketBookingSystem;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] bookingDetails = sc.nextLine().split(",");
        String stageEvent = bookingDetails[0].trim();
        String customer = bookingDetails[1].trim();
        int noOfSeats = Integer.parseInt(bookingDetails[2].trim());

        TicketBooking booking = new TicketBooking(stageEvent, customer, noOfSeats);
        int paymentMode = Integer.parseInt(sc.nextLine().trim());
        System.out.println("Stage event:" + booking.getStageEvent());
        System.out.println("Customer:" + booking.getCustomer());
        System.out.println("Number of seats:" + booking.getNoOfSeats());

        switch (paymentMode) {
            case 1: {
                double amount = Double.parseDouble(sc.nextLine().trim());
                booking.makePayment(amount);
                break;
            }
            case 2: {
                double amount = Double.parseDouble(sc.nextLine().trim());
                String walletNumber = sc.nextLine().trim();
                booking.makePayment(walletNumber, amount);
                break;
            }
            case 3: {
                String name = sc.nextLine().trim();
                double amount = Double.parseDouble(sc.nextLine().trim());
                String cardType = sc.nextLine().trim();
                String ccv = sc.nextLine().trim();
                booking.makePayment(cardType, ccv, name, amount);
                break;
            }
            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
