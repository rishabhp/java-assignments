abstract class TravelBooking {
    protected String passengerName;
    protected double baseFare;

    public TravelBooking(String passengerName, double baseFare) {
        this.passengerName = passengerName;
        this.baseFare = baseFare;
    }

    public abstract double calculateFare();
}

class BusBooking extends TravelBooking {
    public BusBooking(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare + (baseFare * 0.05);
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare + ( baseFare * 0.10 - 50);
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare + (baseFare * 0.18 + 500);
    }
}

public class TravelSystem {
    public static void main(String[] args) {
        TravelBooking[] bookings = {
            new BusBooking("Karan", 750),
            new TrainBooking("Jay", 1000),
            new FlightBooking("Himanshu", 4000)
        };

        for (TravelBooking booking : bookings) {
            System.out.println(booking.passengerName + " Fare: Rs." + booking.calculateFare());
        }
    }
}
