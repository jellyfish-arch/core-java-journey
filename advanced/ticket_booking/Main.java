package ticket_booking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            system.showAvailableSeats();

            System.out.print("Enter seat number to book (0 to exit): ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            system.bookSeat(choice);
        }
        sc.close();
    }
}
