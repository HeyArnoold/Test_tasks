public class DebitCard extends BankingProduct{

    public DebitCard(String nameOfProduct, String currency, int balance) {
        super(nameOfProduct, currency, balance);
    }

    @Override
    public void accountRefill(int quantity) {
        setBalance(getBalance() + quantity);
    }

    public void cancellation(int quantity) {
        setBalance(getBalance() - quantity);
    }
}
