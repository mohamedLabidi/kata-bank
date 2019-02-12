
package fr.bank.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Statements.
 */
public class Statements {

    /** The statement list. */
    private List<Statement> statementList = new ArrayList<>();

    /**
     * Gets the statement list.
     *
     * @return the statement list
     */
    public List<Statement> getStatementList() {
        return statementList;
    }

    /**
     * Sets the statement list.
     *
     * @param statementList
     *        the new statement list
     */
    public void setStatementList(List<Statement> statementList) {
        this.statementList = statementList;
    }

    /**
     * Adds the statement.
     *
     * @param transaction
     *        the transaction
     */
    public void addStatement(Transaction transaction) {
        switch (transaction.getOperation()) {
        case Account.DEPOSIT:
            if (transaction.getAmount() > 0) {
                statementList.add(new Statement(transaction, getCurrentBalance() + transaction.getAmount()));
            }
            else {
                System.err.println("Deposit transaction rejected");
            }
            break;
        case Account.WITHDRAWAL:
            if (getCurrentBalance() + transaction.getAmount() >= 0) {
                statementList.add(new Statement(transaction, getCurrentBalance() + transaction.getAmount()));
            }
            else {
                System.err.println("withdrawal transaction rejected");
            }
            break; 
        } 
    }

    /**
     * Gets the current balance.
     *
     * @return the current balance
     */
    public double getCurrentBalance() {
        return statementList.isEmpty() ? 0 : statementList.get(statementList.size() - 1).getBalance();
    }

}
