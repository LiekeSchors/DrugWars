public class LoanShark {
    private final double DEBT_INTEREST = 0.1; // 10%
    private double debts;
    public double getDebts() {
        return debts;
    }

    public void setDebts(double debts) {
        this.debts = debts;
    }

    public void applyDebtInterest() {
        debts += debts * DEBT_INTEREST;
    }


}
