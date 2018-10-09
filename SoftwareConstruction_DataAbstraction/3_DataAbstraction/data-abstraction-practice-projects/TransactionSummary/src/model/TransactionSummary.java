package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TransactionSummary {

    private String name;
    private List<Transaction> transactions;

    public TransactionSummary(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public int getNumTransactions() {
        return transactions.size();
    }

    // REQUIRES: t is not already within transactions
    // MODIFIES: this
    // EFFECTS: adds the given transaction t to the list of transactions
    public void addTransaction(Transaction t) {
        if (!transactions.contains(t)) {
            transactions.add(t);
        }
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: computes the average amount of money spent on a transaction
    public double averageTransactionCost() {
        assert (transactions != null);
        double totalAmount = 0;
        int transNum = 0;
        DecimalFormat d = new DecimalFormat("#.###");
        for (Transaction t: transactions) {
            totalAmount += t.getAmount();
            transNum += 1;
        }
        try {
            return Double.parseDouble(d.format(totalAmount / transNum));
        } catch (NumberFormatException | ArithmeticException | NullPointerException ae) {
            return Double.parseDouble(null);
        }
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS:  returns the average cost of all transactions of type specificType in this
    //           TransactionSummary
    public double specificTypeAverage(TransactionType specificType) {
        double totalCost = 0;
        int numTransactions = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals(specificType)) {
                totalCost += t.getAmount();
                numTransactions++;
            }
        }
        try {
            return totalCost / numTransactions;
        } catch (ArithmeticException ae) {
            return Double.parseDouble(null);
        }
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: returns the largest transaction (in terms of cost) in this TransactionSummary
    public Transaction largestTransaction() {
        assert(transactions != null);
        double largest = 0;
        Transaction trans = null;
        for (Transaction t: transactions) {
            if (t.getAmount() > largest) {
                largest = t.getAmount();
                trans = t;
            }
        }
        return trans;
    }

    // EFFECTS: returns true if the given transaction is contained within the list of transactions
    public boolean contains(Transaction t) {
        return (transactions.contains(t));
    }


}
