package fr.bank; 
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.bank.beans.Console;
import fr.bank.beans.PrintStatement;
import fr.bank.beans.Statement;
import fr.bank.beans.Transaction;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementTest {

    @SuppressWarnings("rawtypes")
    private static final List NO_TRANSACIONS = Collections.EMPTY_LIST;
    public static final String DEPOSIT = "DEPOSIT"; 
    public static final String WITHDRAWAL = "WITHDRAWAL"; 
    
    @Mock Console console;

    private PrintStatement printStatement;

    @Before
    public void initialise() {
        printStatement = new PrintStatement(console);
    }

    @SuppressWarnings("unchecked")
    @Test public void
    print_header_even_when_there_are_no_transactions() {
        printStatement.print(NO_TRANSACIONS);

        verify(console).printLine(PrintStatement.STATEMENT_HEADER);
    }

    @Test public void
    print_statements_in_reverse_chronological_order() {
        List<Statement> statementList = new ArrayList<>();
        Statement statement_1  = new Statement(new Transaction(DEPOSIT,"09/02/2019", 1500), 1500); 
        statementList.add(statement_1);
        Statement statement_2  = new Statement(new Transaction(WITHDRAWAL,"10/02/2019", -150), 1350); 
        statementList.add(statement_2);
        Statement statement_3  = new Statement(new Transaction(DEPOSIT,"11/02/2019", 800), 2150);
        statementList.add(statement_3);
        

        printStatement.print(statementList);

        verify(console).printLine("OPERATION  | DATE  | AMOUNT | BALANCE");
        verify(console).printLine("DEPOSIT | 11/02/2019 | 800,00 | 2150,00");
        verify(console).printLine("WITHDRAWAL | 10/02/2019 | -150,00 | 1350,00");
        verify(console).printLine("DEPOSIT | 09/02/2019 | 1500,00 | 1500,00");
    }

}
