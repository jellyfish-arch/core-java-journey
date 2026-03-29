package ticket_booking;

import java.util.*;

public class TicketSystem {

    private List<Seat> seats;

    public TicketSystem() {
        seats = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            seats.add(new Seat(i));
        }
    }

    public void showAvailableSeats() {
        System.out.print("Available seats: ");
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }
        System.out.println();
    }

    public boolean bookSeat(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                return seat.bookSeat();
            }
        }

        System.out.println("Seat not found.");
        return false;
    }
}