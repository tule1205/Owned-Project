// firstTicket class representing the highest class ticket (First Class), inheriting from Ticket
public class FirstTicket extends Ticket {

    protected int choice;

    // constructor that initializes the ticket with "First" class
    public FirstTicket() {
        super("First");  // call parent constructor with "First" as passengerTicket
    }

    // override method to provide detailed information about this First Class ticket
    @Override
    public String getClassDetails() {
        // return a formatted string with class name, options, total options count, and upgrades
        return "Class: " + getPassengerClass(choice) + "\nComplementary perks:  flight instruments, beer and wine in-flight, 2 bathroom passes" + "\nOptions: " + getOptions() +
                "\nTotal options: " + totalOption() + "\nUpgrades: " + getUpgrades();
    }
}