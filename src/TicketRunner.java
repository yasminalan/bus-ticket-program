import java.sql.SQLOutput;
import java.util.Scanner;

public class TicketRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Distance (km): ");
        int distance = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Trip type? (One-way: 1, Round trip: 2): ");
        int tripType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Seat number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();

        Ticket ticket = new Ticket(distance, name, age, tripType, seatNumber);

        double price = ticket.calculatePrice();
        System.out.println("You should pay: " + price + " EUR");

    }
}
