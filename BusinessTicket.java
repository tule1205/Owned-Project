// businessTicket class representing the business class ticket, inheriting from Ticket
public class BusinessTicket extends Ticket {

    protected int choice;

    // constructor that initializes the ticket with "Business" class
    public BusinessTicket() {
        super("Business");  // call parent constructor with "Business" as passengerTicket
    }

    // override method to provide detailed information about this Business ticket
    @Override
    public String getClassDetails() {
        // return a formatted string with class name, options, total options count, and upgrades
        return "Class: " + getPassengerClass(choice) + "\nComplementary perks: carry-on bag, 1 bathroom pass" + "\nOptions: " + getOptions() +
                "\nTotal options: " + totalOption() + "\nUpgrades: " + getUpgrades();
    }
}