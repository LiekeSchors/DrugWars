import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Lieke Schors
 */
public class Player {
    Scanner sc = new Scanner(System.in);
    private final String name;
    private double cash = 2000;
    private double debts = 0;
    private static int day = 0;
    private City currentCity;
    private Bank bankaccount = new Bank();
    private LoanShark loanshark = new LoanShark();

    ArrayList<Drugs> drugs = new ArrayList<>(100); // Soll die Liste final sein? (So wird's im Buch gemacht)


    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDebts() {
        return debts;
    }

    public void setDebts(double depts) {
        this.debts = depts;
    }

    public int getDay() {
        return day;
    }

    public static void setDay(int day) {
        Player.day = day;
    }

    public ArrayList<Drugs> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<Drugs> drugs) {
        this.drugs = drugs;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }



    public Player(String name) {
        this.name = name;
    }

    public void startOfDay() {
        Drugs.calculateRecentPrices(drugs); // Warum funktioniert das nicht?
        for (Drugs drug : drugs) {
            System.out.println(drug.getRecentPrice());
        }
    }

    public void endOfDay() {
        bankaccount.applySavingsInterest();
        loanshark.applyDebtInterest();
        if (day == 30) {
            System.out.println("You've reached the end of the game.");
            System.out.printf("Cash: $%.2f", cash);
            System.out.printf("Debts: $%.2f", debts);
            System.out.println("Overall: $" + (cash - debts));
            System.exit(0); // Passt das so?
        }
    }

    /**
     * Method to add a single drug to backpack
     */
    public void addDrugs(Drugs drug) {
        this.drugs.add(Objects.requireNonNull(drug));
    }

    /**
     * Method to buy a new Drug and add it to the player's 'backpack'.
     */
    public void buy(Player player) {
        System.out.println("What do you want to buy (Cocaine, Heroin, Acid, Grass, Speed or Ludes)?");

        // Read input from player
        ArrayList<Drugs> playerDrugs = readInputToArrayList();

        // Perform calculations and add drugs to backpack
        for (Drugs newDrug : playerDrugs) {
            if (player.drugs.size() < 100) {
                player.drugs.add(Objects.requireNonNull(newDrug));
                double price = newDrug.getRecentPrice();
                player.cash -= price;
                System.out.printf("You bought the drug %s for $%.2f. Your current balance: $%.2f. %n", newDrug, price, player.cash);
            } else {
                System.out.println("Your backpack is full. You can't buy more.%n");
                break;
            }
        }
    }

    /**
     * Method to sell drugs
     */
    public void sell() {
        ArrayList<Drugs> playerDrugs = readInputToArrayList();

        for (Drugs drug : playerDrugs) {
            if (!this.drugs.contains(drug)) {
                System.out.println("You don't have this drug anymore.");
                return;
            } else {
                this.drugs.remove(drug);
                cash += drug.getRecentPrice();
                System.out.printf("You sold the drug %s. Your current balance: $%f.%n", drug, cash);
            }
        }
    }

    public ArrayList<Drugs> readInputToArrayList() {
        ArrayList<Drugs> playerDrugs = new ArrayList<>();
        String playerInput = sc.nextLine();
        String[] playerInputSplitted = playerInput.split(", ");
        for (String s : playerInputSplitted) {
            Drugs myDrug = Drugs.valueOf(s.toUpperCase());
            playerDrugs.add(myDrug);
        }
        return playerDrugs;
    }

    /**
     * TODO: methode implementieren
     * Method to travel to another city, including adding a day and calculate travel-price
     */
    public void travelTo(Player player) {
        final double TRAVEL_COSTS_PER_KM = 3.50;
        Drugs.calculateRecentPrices(this.drugs); // Die Preise aendern sich nach einer Reise
        day++; // Die Reise dauert einen Tag
        System.out.println("To which city do you want to travel?");
        String city = sc.nextLine();

        City toCity = new City(city); // Soll eigentlich ein bereits bestehender Stadtteil sein


        double distance = 0.0;
        if (currentCity.name.equalsIgnoreCase("Bronx") && toCity.name.equalsIgnoreCase("Ghetto") || currentCity.name.equalsIgnoreCase("Ghetto") && toCity.name.equalsIgnoreCase("Bronx")) {
            distance = City.DISTANCE_BRONX_GHETTO;
        } else if (currentCity.name.equalsIgnoreCase("Bronx") && toCity.name.equalsIgnoreCase("Central Park") || currentCity.name.equalsIgnoreCase("Central Park") && toCity.name.equalsIgnoreCase("Bronx")) {
            distance = City.DISTANCE_BRONX_CENTRAL_PARK;
        } else if (currentCity.name.equalsIgnoreCase("Bronx") && toCity.name.equalsIgnoreCase("Manhattan") || currentCity.name.equalsIgnoreCase("Manhattan") && toCity.name.equalsIgnoreCase("Bronx")) {
            distance = City.DISTANCE_BRONX_MANHATTAN;
        } else if (currentCity.name.equalsIgnoreCase("Bronx") && toCity.name.equalsIgnoreCase("Coney Island") || currentCity.name.equalsIgnoreCase("Coney Island") && toCity.name.equalsIgnoreCase("Bronx")) {
            distance = City.DISTANCE_BRONX_CONEY_ISLAND;
        } else if (currentCity.name.equalsIgnoreCase("Bronx") && toCity.name.equalsIgnoreCase("Brooklyn") || currentCity.name.equalsIgnoreCase("Brooklyn") && toCity.name.equalsIgnoreCase("Bronx")) {
            distance = City.DISTANCE_BRONX_BROOKLYN;
        } else if (currentCity.name.equalsIgnoreCase("Ghetto") && toCity.name.equalsIgnoreCase("Central Park") || currentCity.name.equalsIgnoreCase("Central Park") && toCity.name.equalsIgnoreCase("Ghetto")) {
            distance = City.DISTANCE_GHETTO_CENTRAL_PARK;
        } else if (currentCity.name.equalsIgnoreCase("Ghetto") && toCity.name.equalsIgnoreCase("Manhattan") || currentCity.name.equalsIgnoreCase("Manhattan") && toCity.name.equalsIgnoreCase("Ghetto")) {
            distance = City.DISTANCE_GHETTO_MANHATTAN;
        } else if (currentCity.name.equalsIgnoreCase("Ghetto") && toCity.name.equalsIgnoreCase("Coney Island") || currentCity.name.equalsIgnoreCase("Coney Island") && toCity.name.equalsIgnoreCase("Ghetto")) {
            distance = City.DISTANCE_GHETTO_CONEY_ISLAND;
        } else if (currentCity.name.equalsIgnoreCase("Ghetto") && toCity.name.equalsIgnoreCase("Brooklyn") || currentCity.name.equalsIgnoreCase("Brooklyn") && toCity.name.equalsIgnoreCase("Ghetto")) {
            distance = City.DISTANCE_GHETTO_BROOKLYN;
        } else if (currentCity.name.equalsIgnoreCase("Central Park") && toCity.name.equalsIgnoreCase("Manhattan") || currentCity.name.equalsIgnoreCase("Manhattan") && toCity.name.equalsIgnoreCase("Central Park")) {
            distance = City.DISTANCE_CENTRAL_PARK_MANHATTAN;
        } else if (currentCity.name.equalsIgnoreCase("Central Park") && toCity.name.equalsIgnoreCase("Coney Island") || currentCity.name.equalsIgnoreCase("Coney Island") && toCity.name.equalsIgnoreCase("Central Park")) {
            distance = City.DISTANCE_CENTRAL_PARK_CONEY_ISLAND;
        } else if (currentCity.name.equalsIgnoreCase("Central Park") && toCity.name.equalsIgnoreCase("Brooklyn") || currentCity.name.equalsIgnoreCase("Brooklyn") && toCity.name.equalsIgnoreCase("Central Park")) {
            distance = City.DISTANCE_CENTRAL_PARK_BROOKLYN;
        } else if (currentCity.name.equalsIgnoreCase("Manhattan") && toCity.name.equalsIgnoreCase("Coney Island") || currentCity.name.equalsIgnoreCase("Coney Island") && toCity.name.equalsIgnoreCase("Manhattan")) {
            distance = City.DISTANCE_MANHATTAN_CONEY_ISLAND;
        } else if (currentCity.name.equalsIgnoreCase("Manhattan") && toCity.name.equalsIgnoreCase("Brooklyn") || currentCity.name.equalsIgnoreCase("Brooklyn") && toCity.name.equalsIgnoreCase("Manhattan")) {
            distance = City.DISTANCE_MANHATTAN_BROOKLYN;
        } else if (currentCity.name.equalsIgnoreCase("Coney Island") && toCity.name.equalsIgnoreCase("Brooklyn") || currentCity.name.equalsIgnoreCase("Brooklyn") && toCity.name.equalsIgnoreCase("Coney Island")) {
            distance = City.DISTANCE_CONEY_ISLAND_BROOKLYN;
        } else {
            System.out.println("This city doesn't exist.");
        }

        // Random Event happening


        double travelCosts = distance * TRAVEL_COSTS_PER_KM;
        cash -= travelCosts;
        this.currentCity = toCity;
    }

    public void addMoneyToBankAccount(Player player) {
        double savings = bankaccount.getSavings();
        System.out.printf("How much do you want to add to your bankaccount? Max. = $%.2f", cash);
        double amount = sc.nextDouble();
        player.cash -= amount;
        bankaccount.setSavings(savings + amount);
        System.out.println("Savings: $" + bankaccount.getSavings());
        System.out.println("Cash: $" + player.cash);
        System.out.println();
    }

    public void drawMoneyFromBankAccount(Player player) {
        double savings = bankaccount.getSavings();
        System.out.printf("How much do you want to draw from your bankaccount? Max. = $%.2f", savings);
        double amount = sc.nextDouble();
        bankaccount.setSavings(savings - amount);
        player.cash += amount;
        System.out.println("Savings: $" + bankaccount.getSavings());
        System.out.println("Cash: $" + player.cash);
        System.out.println();

    }

    public void loanFromLoanshark(Player player) {
        System.out.print("How much do you want to add to lend?");
        double amount = sc.nextDouble();
        player.cash += amount;
        player.debts += amount;
        System.out.println("Debts: $" + loanshark.getDebts());
        System.out.println("Cash: $" + player.cash);
        System.out.println();
    }

    public void payLoansharkBack(Player player) {
        System.out.print("How much do you want to pay back?");
        double amount = sc.nextDouble();
        player.cash -= amount;
        player.debts -= amount;
        System.out.println("Debts: $" + loanshark.getDebts());
        System.out.println("Cash: $" + player.cash);
        System.out.println();
    }

    public void saveDrugsInDepot(Player player) {

    }
}


