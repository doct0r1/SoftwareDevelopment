package main;

import model.Transaction;
import model.TransactionSummary;
import model.TransactionType;

public class Main {
    public static void main(String[] args) {
        Transaction t0 = new Transaction("Mustafa", "Jun", 10, TransactionType.ENTERTAINMENT);
        Transaction t1 = new Transaction("Mustafa", "Jun", 20, TransactionType.EDUCATION);
        Transaction t2 = new Transaction("Mustafa", "Jun", 40, TransactionType.EDUCATION);
        Transaction t3 = new Transaction("Mustafa", "Jun", 150, TransactionType.EDUCATION);
        Transaction t4 = new Transaction("Mustafa", "Jun", 11, TransactionType.EDUCATION);
        Transaction t5 = new Transaction("Mustafa", "Jun", 40, TransactionType.EDUCATION);
        Transaction t6 = new Transaction("Mustafa", "Jun", 5, TransactionType.EDUCATION);

        TransactionSummary ts = new TransactionSummary("Sum");
        ts.addTransaction(t0);
        ts.addTransaction(t1);
        ts.addTransaction(t2);
        ts.addTransaction(t3);
        ts.addTransaction(t4);
        ts.addTransaction(t5);
        ts.addTransaction(t6);


        double l = (10 + 20 + 40 + 150 + 11 + 40 + 5);
        int s = 7;
        System.out.println(l / s);
        System.out.println(ts.averageTransactionCost());
    }
}
