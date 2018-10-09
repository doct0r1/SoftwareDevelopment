package model;

public class Transaction {

    private String name;
    private String date;
    private double amount;
    private TransactionType type;

    public Transaction(String name, String date, double amount, TransactionType type) {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    // getters
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public double getAmount() {
        return amount;
    }
    public TransactionType getType() {
        return type;
    }


}
