public class Ticket {

    private int distance;
    private String passengerName;
    private int passengerAge;
    private int tripType;
    private int seatNumber;
    public int oneWay = 1;
    public int roundTrip = 2;
    public double priceIncrease = 1.2;
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
        if (seatNumber % 3 != 0) {
            if (tripType == 1) {
                price = distance * oneWay;
            } else {
                price = distance * roundTrip;
            }
        } else {
            if (tripType == 1) {
                price = distance * oneWay * priceIncrease;
            } else {
                price = distance * roundTrip * priceIncrease;
            }
        }
        applyDiscount();
        return price;
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
