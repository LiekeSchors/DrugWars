public enum Drugs {

    COCAINE(15_000, 30_000),
    HEROIN(5_000, 14_000),
    ACID(1_000, 4_500),
    GRASS(300, 900),
    SPEED(70, 250),
    LUDES(10, 60);

    private final int minPrice;
    private final int maxPrice;

     Drugs(int minPrice, int maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getRecentPrice(Drugs drug) {
         int recentPrice = 0;
         // Berechne random Preis zwischen min und max dieser Droge
         return recentPrice;
    }
}
