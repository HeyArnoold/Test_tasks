public abstract class BankingProduct {
    private String nameOfProduct;
    private String currency;
    private int balance;

    public BankingProduct(String nameOfProduct, String currency, int balance) {
        this.nameOfProduct = nameOfProduct;
        this.currency = currency;
        this.balance = balance;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public String getCurrency() {
        return currency;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public abstract void accountRefill(int quantity);
}
