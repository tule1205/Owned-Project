import java.util.ArrayList;
import java.util.List;

// class Ticket
public abstract class Ticket implements Comparable<Ticket> {
    // store passenger ticket
    protected String passengerTicket;
    // list to store added options
    protected List<String> options = new ArrayList<>();
    // list to store added upgrades
    protected List<String> upgrades = new ArrayList<>();
    // store number of options added
    protected int optionCount;

    // constructor to initialize passenger ticket
    public Ticket(String passengerTicket) {
        this.passengerTicket = passengerTicket;
    }

    // method to add an option and increment when adding more
    public void addOption(String option) {
        options.add(option);
        optionCount++;
    }

    // method to add an upgrade
    public void addUpgrade(String upgrade) {
        upgrades.add(upgrade);
    }

    // method to list all options
    public List<String> getOptions() {
        return options;
    }

    // method to list all upgrades
    public List<String> getUpgrades() {
        return upgrades;
    }

    // method to count total options that are chosen
    public int totalOption() {
        return optionCount;
    }

    // method to convert numeric passenger class to string type
    public String getPassengerClass(int choice) {
        return switch (choice) {
            case 1 -> "Steerage"; // first choice
            case 2 -> "Coach"; // second choice
            case 3 -> "Business"; // third choice
            case 4 -> "First"; // fourth choice
            default -> "Invalid class"; // error case
        };
    }

    // method to get passenger class in order
    private Integer getClassOrder() {
        return switch (passengerTicket) {
            case "Steerage" -> 1; // lowest
            case "Coach" -> 2;
            case "Business" -> 3;
            case "First" -> 4; // highest
            default -> Integer.MAX_VALUE;
        };
    }

    // method to compare and rearrange passenger class from the lowest to the highest
    @Override
    public int compareTo(Ticket o) {
        int classCompare = getClassOrder().compareTo(o.getClassOrder());
        if (classCompare != 0) {
            return classCompare;
        }
        return Integer.compare(options.size() + upgrades.size(), o.options.size() + o.upgrades.size());
    }

    // method to get detailed information about passenger class
    public abstract String getClassDetails();
}
