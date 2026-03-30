package ticket_booking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Show Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Seat");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    system.showAvailableSeats();
                    break;

                case 2:
                    System.out.print("Enter seat number to book: ");
                    int book = sc.nextInt();
                    system.bookSeat(book);
                    break;

                case 3:
                    System.out.print("Enter seat number to cancel: ");
                    int cancel = sc.nextInt();
                    system.cancelSeat(cancel);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
