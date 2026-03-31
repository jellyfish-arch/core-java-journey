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

    public void showAllSeats() {
        for (Seat seat : seats) {
            if (seat.isBooked()) {
                System.out.println("Seat " + seat.getSeatNumber() + " - Booked");
            } else {
                System.out.println("Seat " + seat.getSeatNumber() + " - Available");
            }
        }
    }

    public boolean cancelSeat(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                return seat.cancelBooking();
            }
        }

        System.out.println("Seat not found.");
        return false;
    }
    
}