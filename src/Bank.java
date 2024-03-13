public class Bank {
    private final double SAVINGS_INTEREST = 0.55; // 5.5%

    private double savings;

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public void applySavingsInterest() {
        savings += savings * SAVINGS_INTEREST;
    }


}
