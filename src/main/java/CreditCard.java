public class CreditCard extends DebitCard{

    private int interestRate;
    private int debt;

    public CreditCard(String nameOfProduct, String currency, int balance) {
        super(nameOfProduct, currency, balance);
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }
}
