public class Ticket {

    private int distance;
    private String passengerName;
    private int passengerAge;
    private int tripType;
    private int seatNumber;
    public double price;

    public Ticket(int distance, String passengerName, int passengerAge, int tripType, int seatNumber) {

        setDistance(distance);
        this.passengerName = passengerName;
        setPassengerAge(passengerAge);
        setTripType(tripType);
        this.seatNumber = seatNumber;
    }

    public int getDistance() {
        return distance;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public int getTripType() {
        return tripType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setDistance(int distance) {
        if (distance <= 0) {
            System.out.println("Invalid Input!");
        } else {
            this.distance = distance;
        }
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPassengerAge(int passengerAge) {
        if (passengerAge <= 0) {
            System.out.println("Invalid input!");
        } else {
            this.passengerAge = passengerAge;
        }
    }

    public void setTripType(int tripType) {
        if (tripType == 1  || tripType == 2) {
            this.tripType = tripType;
        } else {
            System.out.println("Invalid input!");
        }
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "distance=" + distance +
                ", passengerName='" + passengerName + '\'' +
                ", passengerAge=" + passengerAge +
                ", tripType=" + tripType +
                ", seatNumber=" + seatNumber +
                '}';
    }

    public double calculatePrice() {
        double priceIncrease = 1;
        if (isWindowSide()) {
            priceIncrease = 1.2;
        }
        int numberOfWay = 1;
        if(isRoundTrip()) {
            numberOfWay = 2;
        }

        price = distance * numberOfWay * priceIncrease;

        applyDiscount();
        return price;
    }

    public boolean isWindowSide() {
        return seatNumber % 3 == 0;
    }

    private boolean isRoundTrip() {
        return tripType == 2;
    }

    public double applyDiscount() {
        if (tripType == 2) {
            price = price - (price * 0.2);
        }
        if(passengerAge < 12) {
            price = price / 2;
            return price;
        } else if (passengerAge > 65) {
            price = price - (price * 0.3);
            return price;
        } else {
            return price;
        }
    }
}
