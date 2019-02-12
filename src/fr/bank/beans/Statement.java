package fr.bank.beans;
 
// TODO: Auto-generated Javadoc
/**
 * The Class Statement.
 */
public class Statement {
     
    /** The transaction. */
    private Transaction transaction;
     
    /** The balance. */
    private double balance;
     
    /**
     * Instantiates a new statement.
     *
     * @param transaction the transaction
     * @param balance the balance
     */
    public Statement(Transaction transaction, double balance)
    {
        this.transaction = transaction;
        this.balance = balance;
    }
 
    /**
     * Gets the transaction.
     *
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }
 
    /**
     * Sets the transaction.
     *
     * @param transaction the new transaction
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
 
    /**
     * Gets the balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
 
    /**
     * Sets the balance.
     *
     * @param balance the new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
