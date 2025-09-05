// coachTicket class representing the economy class ticket, inheriting from Ticket
public class CoachTicket extends Ticket {

    protected int choice;

    // constructor that initializes the ticket with "Coach" class
    public CoachTicket() {
        super("Coach");  // call parent constructor with "Coach" as passengerTicket
    }

    // override method to provide detailed information about this Coach ticket
    @Override
    public String getClassDetails() {
        // return a formatted string with class name, options, total options count, and upgrades
        return "Class: " + getPassengerClass(choice) + "\nOptions: " + getOptions() +
                "\nTotal options: " + totalOption() + "\nUpgrades: " + getUpgrades();
    }
}