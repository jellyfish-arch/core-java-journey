package ticket_booking;

public class Seat {

    private int seatNumber;
    private boolean isBooked = false;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }


    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean bookSeat() {

        if (isBooked) {
            System.out.println("Already Booked.");
            return false;
        } else {
            System.out.println("Seat " + seatNumber + " Booked for you.");
            isBooked = true;
            return true;
        }
    }

    public boolean cancelBooking() {
        if (!isBooked) {
            System.out.println("Seat is not booked.");
            return false;
        }

        isBooked = false;
        System.out.println("Seat " + seatNumber + " booking cancelled.");
        return true;
    }

}
