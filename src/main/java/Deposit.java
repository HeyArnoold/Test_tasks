public class Deposit extends BankingProduct{

    private boolean isDepositClosed = false;

    public Deposit(String nameOfProduct, String currency, int balance) {
        super(nameOfProduct, currency, balance);
    }

    @Override
    public void accountRefill(int quantity) {
        if (isDepositClosed) {
            return;
        }
        setBalance(getBalance() + quantity);
    }

    public void closingTheDeposit() {
        isDepositClosed = true;
    }

    public boolean isDepositClosed() {
        return isDepositClosed;
    }
}
