package fr.bank;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.bank.beans.Statement;
import fr.bank.beans.Statements;
import fr.bank.beans.Transaction;

public class StatementsTest {
    public static final String DEPOSIT = "DEPOSIT"; 
    public static final String WITHDRAWAL = "WITHDRAWAL"; 
    private Statements statements;

    @Before
    public void initialise() {
        statements = new Statements();
    }

    @Test
    public void
    return_statements_on_the_same_order_they_were_added() {
        Transaction deposit = new Transaction(DEPOSIT,"11/02/2019", 100);
        Transaction withdrawal = new Transaction(WITHDRAWAL,"11/02/2019", -50);

        statements.addStatement(deposit);
        statements.addStatement(withdrawal);

        List<Statement> statementList = statements.getStatementList();  
        assertThat(statementList.size(),equalTo(2)); 
        assertThat(statementList.get(0).getTransaction(),equalTo(deposit));
        assertThat(statementList.get(1).getTransaction(),equalTo(withdrawal)); 
    }
    @Test
    public void
    reject_statement_when_the_amount_higher_than_balance() {
        Transaction deposit = new Transaction(DEPOSIT,"11/02/2019", 100);
        Transaction withdrawal = new Transaction(WITHDRAWAL,"11/02/2019", -150);
        

        statements.addStatement(deposit);
        statements.addStatement(withdrawal);

        List<Statement> statementList = statements.getStatementList();  
        assertThat(statementList.size(),equalTo(1));  
    }
}