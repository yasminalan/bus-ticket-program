public class TicketRunner {
    public static void main(String[] args) {

        Ticket ticket = new Ticket(10, "Yasemin Alan", 10, 2, 3);

        double price = ticket.priceCalculate();
        System.out.println(price);

    }
}
