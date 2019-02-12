package fr.bank.beans;
 
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
  
/**
 * The Class Transaction.
 */
public class Transaction {
  
    /** The operation. */
    private  String operation;
     
    /** The date of operation. */
    private  String date;
     
    /** The amount. */
    private  double amount;
     
    /**
     * Instantiates a new transaction.
     *
     * @param operation the operation
     * @param date the date
     * @param amount the amount
     */
    public Transaction(String operation, String date, double amount)
    {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
    }
 
    /**
     * Gets the operation.
     *
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }
 
    
    /**
     * Sets the operation.
     *
     * @param operation the new operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

 
    /**
     * Gets the date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }
 
    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(String date) {
        this.date = date;
    }

 
    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

 
    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        return reflectionEquals(this, o);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }
}

