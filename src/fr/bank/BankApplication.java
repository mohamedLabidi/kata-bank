package fr.bank;

import fr.bank.beans.Account;
import fr.bank.beans.Console;
import fr.bank.beans.DateTransaction;
import fr.bank.beans.PrintStatement;
import fr.bank.beans.Statements;
 
/**
 * The Class BankApplication.
 */
public class BankApplication {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Statements statements = new Statements();
        DateTransaction dateTransaction = new DateTransaction();
        PrintStatement printStatement = new PrintStatement(new Console());
        Account account = new Account(statements, dateTransaction, printStatement);
        account.deposit(1000);
        account.deposit(500); 
        account.withdraw(1000); 
        account.printHistory(); 
    }

}
