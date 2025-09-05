// steerageTicket class representing the lowest class of ticket, inheriting from Ticket
public class SteerageTicket extends Ticket {

    protected int choice;

    // constructor that initializes the ticket with "Steerage" class
    public SteerageTicket() {
        super("Steerage");  // call parent constructor with "Steerage" as passengerTicket
    }

    // override method to provide detailed information about this Steerage ticket
    @Override
    public String getClassDetails() {
        // return a formatted string with class name, options, total options count, and upgrades
        return "Class: " + getPassengerClass(choice) + "\nOptions: " + getOptions() +
                "\nTotal options: " + totalOption() + "\nUpgrades: " + getUpgrades();
    }
}