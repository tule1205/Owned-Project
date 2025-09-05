import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// class ticket display
public class TicketDisplay {
    private final List<Ticket> tickets;
    // constructor to initialize tickets
    public TicketDisplay(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    // method to display tickets purchased
    public void displayTickets() {
        if (tickets.isEmpty()) { // no tickets added (ticket's list is empty)
            System.out.println("No tickets purchased");
            System.out.println();
            return;
        }

        System.out.println("All tickets purchased (sorted by class):");
        List<Ticket> sortedTickets = new ArrayList<>(tickets); // list to store sorted tickets
        Collections.sort(sortedTickets); // sort purchased tickets
        for (Ticket t : sortedTickets) { // loop to print out purchased tickets after sorting
            System.out.println(t.getClassDetails());
            System.out.println();
        }

        System.out.println("Tickets with Thrill Seeker upgrade:");
        boolean foundThrillSeeker = false; // thrill seeker is not added initially
        for (Ticket t : sortedTickets) { // loop to print out tickets purchased with thrill seeker upgrade
            if (t.getUpgrades().contains("Thrill Seeker")) { // if upgrade has word "thrill seeker"
                System.out.println(t.getClassDetails());
                System.out.println();
                foundThrillSeeker = true; // return true when thrill seeker is added
            }
        }
        if (!foundThrillSeeker) { // if thrill seeker is not added
            System.out.println("No tickets with Thrill Seeker upgrade.");
            System.out.println();
        }

        System.out.println("Tickets with Wingman upgrade:");
        boolean foundWingman = false; // wingman is not added initially
        for (Ticket t : sortedTickets) { // loop to print out tickets purchased with wingman upgrade
            if (t.getUpgrades().contains("Wingman")) { // if upgrade has word "wingman"
                System.out.println(t.getClassDetails());
                System.out.println();
                foundWingman = true; // return true when wingman is added
            }
        }
        if (!foundWingman) { // if wingman is not added
            System.out.println("No tickets with Wingman upgrade.");
            System.out.println();
        }

        System.out.println("Tickets - no options or upgrades:");
        boolean foundBasic = false; // basic ticket (no added option and no added upgrade)
        for (Ticket t : sortedTickets) {
            if (t.getOptions().isEmpty() && t.getUpgrades().isEmpty()) { // if options and upgrades are not added
                System.out.println(t.getClassDetails());
                System.out.println();
                foundBasic = true; // return true when basic ticket is found
            }
        }
        if (!foundBasic) { // if basic ticket is not added
            System.out.println("No tickets found."); // users don't add any ticket
            System.out.println();
        }
    }
}