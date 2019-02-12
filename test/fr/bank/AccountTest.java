package fr.bank;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.bank.beans.Account; 
import fr.bank.beans.DateTransaction;
import fr.bank.beans.PrintStatement;
import fr.bank.beans.Statement;
import fr.bank.beans.Statements;
import fr.bank.beans.Transaction;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    public static final String DEPOSIT = "DEPOSIT"; 
    public static final String WITHDRAWAL = "WITHDRAWAL"; 
    private static final String SYSTEM_DATE = "10/02/2019";
    private static final LinkedList<Statement> STATEMENT_LIST = new LinkedList<>();

    @Mock Statements statements;
    @Mock DateTransaction dateTransaction;
    @Mock PrintStatement printStatement;

    private Account account;

    @Before
    public void initialise() {
        given(dateTransaction.getDate()).willReturn(SYSTEM_DATE);
        account = new Account(statements, dateTransaction, printStatement);
    }

    @Test 
    public void
    store_a_deposit_transaction() {
        Transaction deposit = new Transaction(DEPOSIT, SYSTEM_DATE, 100);  

        account.deposit(100);

        verify(statements).addStatement(eq(deposit));
    }

    @Test 
    public void
    store_a_withdrawal_transaction() {
        given(dateTransaction.getDate()).willReturn(SYSTEM_DATE);
        Transaction withdrawal = new Transaction(WITHDRAWAL, SYSTEM_DATE, -100);   
        
        account.withdraw(100);

        verify(statements).addStatement(eq(withdrawal));
    }

    @Test 
    public void
    print_a_statement_containing_all_transactions() {
        given(statements.getStatementList()).willReturn(STATEMENT_LIST);

        account.printHistory();

        verify(printStatement).print(STATEMENT_LIST);
    }
}
