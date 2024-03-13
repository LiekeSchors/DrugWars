import java.util.ArrayList;
import java.util.Random;

public enum Drugs {

    COCAINE(15_000, 30_000, 0.0),
    HEROIN(5_000, 14_000, 0.0),
    ACID(1_000, 4_500, 0.0),
    GRASS(300, 900, 0.0),
    SPEED(70, 250, 0.0),
    LUDES(10, 60, 0.0);


    private final int minPrice;
    private final int maxPrice;
    private double recentPrice;


     Drugs(int minPrice, int maxPrice, double recentPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public double getRecentPrice() {
        return recentPrice;
    }

    public void setRecentPrice(double recentPrice) {
        this.recentPrice = recentPrice;
    }

    public static void calculateRecentPrices(ArrayList<Drugs> drugs) {
         for (Drugs drug : drugs) {
             double recentPrice = Math.random() * (drug.getMaxPrice() - drug.getMinPrice()) + drug.getMinPrice();
             drug.setRecentPrice(recentPrice);
         }
    }
    private static final Random RANDOM = new Random();
    public static Drugs randomDrugs() {
         Drugs[] drugs = values();
         return drugs[RANDOM.nextInt(drugs.length)];
    }
}
