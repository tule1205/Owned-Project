import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// class ticket menu
public class TicketMenu {
    private final Scanner scanner = new Scanner(System.in);
    // list to store purchased ticket
    private final List<Ticket> tickets = new ArrayList<>();
    // handle how ticket is displayed
    private final TicketDisplay displayManager = new TicketDisplay(tickets);

    // method to display ticket menu
    public void displayMenu() {
        // infinite until users choose to exit
        while (true) {
            System.out.println("1. Add a new ticket");
            System.out.println("2. Display tickets purchased");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // add a ticket
                    addNewTicket();
                    break;
                case 2: // display ticket added
                    displayManager.displayTickets();
                    break;
                case 3: // exit display ticket menu
                    System.out.println("Goodbye!");
                    return;
                default: // error case
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // method to add a ticket
    private void addNewTicket() {
        // show all ticket's types and their information
        System.out.println("Choose a class you prefer: ");
        System.out.println();
        // steerage class
        System.out.println("1. Class: Steerage");
        System.out.println("""
                Steerage passengers fly based on available space, in the cargo hold.
                o No carry-on bags allowed – as the passenger is already flying in the cargo\
                hold, the passenger counts as a bag.\s
                o No worries about assigned seating – there are no seats to assign.Passengers\
                can opt to sit on any available cargo during the flight, for an additional fee.\s
                """);
        // coach class
        System.out.println("2. Class: Coach");
        System.out.println("""
                Provide luxurious accommodations in the main cabin of the aircraft.\s
                o No worries about assigned seating – there are no seats to assign. Coach\
                passengers stand throughout the flight.\s
                    ▪ A handrail is available to hold onto, for an additional fee.\s
                o 1 carry-on bag is allowed, for an additional fee.\s
                    ▪ Because coach class is standing room only, passengers opting to\
                bring a carry-on bag must stand on the bag throughout the flight.\s
                """);
        // business class
        System.out.println("3. Class: Business");
        System.out.println("""
                Complementary seats are provided to sit in during the flight.\s
                o Business class passengers can select from any of the super comfy middle seats.\s
                    ▪ Window or aisle seats can be selected, for an additional fee.\s
                o 1 complementary carry-on bag allowed. At Ghost, we do not believe in additional fees!\s
                    ▪ Passengers must hold their carry-on bag on their lap for the duration\
                of the flight. However, overhead bin storage is available, for an additional fee.\s
                o 1 complementary bathroom pass, to be used during flight.\s
               """);
        // first class
        System.out.println("4. Class: First");
        System.out.println("""
                Unlike other airlines where first class passengers sit in boring seats with a tiny window to look out of,\
                at Ghost, first class passengers are right where the action is!\s
                o No worries about assigned seating – there is only 1 seat available for first\
                class passengers. This seat is conveniently located at the front of the\
                aircraft, next to the captain.\s
                o Complementary flight instruments so the passenger can keep track of\
                important metrics such as airspeed and altitude. At Ghost, we do not believe\
                in additional fees!\s
                o Yoke and rudder pedals which the passenger can use, for an additional fee.\s
                o Complementary beer and wine in-flight, which the passenger shares with the captain.\s
                o 2 complementary bathroom passes, to be used during flight.
                """);

        System.out.print("Select an option: ");
        Ticket ticket;
        int classChoice = scanner.nextInt();

        switch (classChoice) {
            case 1: // add a steerage ticket
                ticket = new SteerageTicket();
                ((SteerageTicket)ticket).choice = classChoice;
                scanner.nextLine();
                addOption(ticket, "Cargo seat"); // option for steerage class
                break;
            case 2: // add a coach ticket
                ticket = new CoachTicket();
                ((CoachTicket)ticket).choice = classChoice;
                scanner.nextLine();
                addOption(ticket, "Handrail"); // option for coach class
                addOption(ticket, "Carry-on bag"); // option for coach class
                break;
            case 3: // add a business ticket
                ticket = new BusinessTicket();
                ((BusinessTicket)ticket).choice = classChoice;
                scanner.nextLine();
                addOption(ticket, "Window/Aisle"); // option for business class
                addOption(ticket, "Overhead bin storage"); // option for business class
                break;
            case 4: // add a first ticket
                ticket = new FirstTicket();
                ((FirstTicket)ticket).choice = classChoice;
                scanner.nextLine();
                addOption(ticket, "Yoke/Rudder pedal"); // option for first class
                break;
            default:
                System.out.println("Invalid class");
                return;
        }

        System.out.println();
        addUpgrade(ticket, "Thrill Seeker"); // add a thrill seeker upgrade
        boolean addedWingman = addUpgrade(ticket, "Wingman"); // add a wingman upgrade
        // if wingman is selected, prompt for wing choice
        if (addedWingman) {
            System.out.println("Wing choice: Left - Right. Enter L or R"); // wing choice: left or right
            boolean valid = false;
            // loop until getting a valid letter for wing choice (l or r)
            while (!valid) {
                String c = scanner.nextLine().trim().toUpperCase(); // if users enter lowercase letter, convert to uppercase letter
                if (c.equals("L")) {
                    System.out.println("Left");
                    ticket.addOption("Wing choice: Left");
                    valid = true;
                } else if (c.equals("R")) {
                    System.out.println("Right");
                    ticket.addOption("Wing choice: Right");
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Please enter L or R");
                }
            }
        }

        tickets.add(ticket); // add a ticket to the list
        System.out.println("Ticket added");
    }

    // method to add an option
    private void addOption(Ticket ticket, String option) {
        System.out.println("Add " + option + "? (y/n) "); // ask users to enter y to add an option or enter n to not add an option
        if (scanner.nextLine().startsWith("y")) { // if users enter y, option is added
            ticket.addOption(option);
        }
    }

    //method to add an upgrade
    private boolean addUpgrade(Ticket ticket, String upgrade) {
        System.out.println("Add " + upgrade + "? (y/n) "); // ask users to enter y to add an upgrade or enter n to not add an upgrade
        if (scanner.nextLine().startsWith("y")) { // if users enter y, option is added
            ticket.addUpgrade(upgrade);
            return true;
        }
        return false;
    }
 }
