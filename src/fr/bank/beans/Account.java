
package fr.bank.beans;
 
/**
 * The Class Account.
 */
public class Account {

    /** Label of deposit operation. */
    public static final String DEPOSIT = "DEPOSIT";
    
    /** Label of withdrawl operation.. */
    public static final String WITHDRAWAL = "WITHDRAWAL";

    /** The statements. */
    private Statements statements;
    
    /** The date of transaction. */
    private DateTransaction dateTransaction;
    
    /** The print statement. */
    private PrintStatement printStatement;

    /**
     * Instantiates a new account.
     *
     * @param statements the statements
     * @param dateTransaction the date transaction
     * @param printStatement the print statement
     */
    public Account(Statements statements, DateTransaction dateTransaction, PrintStatement printStatement) {
        this.statements = statements;
        this.dateTransaction = dateTransaction;
        this.printStatement = printStatement;
    }

    /**
     * Deposit : deposit amount in account
     *
     * @param amount the amount
     */
    public void deposit(double amount) {

        statements.addStatement(new Transaction(DEPOSIT, dateTransaction.getDate(), amount));

    }

    /**
     * Withdraw : retrieve amount from account
     *
     * @param amount the amount
     */
    public void withdraw(double amount) {

        statements.addStatement(new Transaction(WITHDRAWAL, dateTransaction.getDate(), -Math.abs(amount)));

    }

    /**
     * Prints the history.
     */
    public void printHistory() {
        printStatement.print(statements.getStatementList());
    }
}
