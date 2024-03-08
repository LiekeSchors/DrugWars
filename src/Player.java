import java.util.ArrayList;

/**
 * @author Lieke Schors
 */
public class Player {
    private int cash = 2000;
    private int depts = 0;
    private int day = 0;

    private final ArrayList<Drugs> drugs = new ArrayList<>(100);

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getDepts() {
        return depts;
    }

    public void setDepts(int depts) {
        this.depts = depts;
    }

    public int getDay() {
        return day;
    }

    public void endOfDay() {
        if (this.day >= 0 && this.day < 30){
            this.day++;
        } else if (this.day == 30){
            System.out.println("You've reached the end of the game.");
            System.out.printf("Cash: $%d", cash);
            System.out.printf("Depts: $%d", depts);
            System.out.println("Overall: $" + (cash - depts));
        }
    }

    /**
     * Method to add a new Drug to the player's 'backpack'.
     */
    public void carry(Drugs drug, int price) {
        if (drug != null) {
            drugs.add(drug);
            cash -= price; // Wo soll price herkommen? Wie wird er berechnet? Und wo?
            System.out.printf("You bought the drug %s. Your current balance: $%d.%n", drug, cash);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "cash=$" + cash +
                ", depts=$" + depts +
                ", day=" + day +
                ", drugs=" + drugs +
                '}';
    }
}
