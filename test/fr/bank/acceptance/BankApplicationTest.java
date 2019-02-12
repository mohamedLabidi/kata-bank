package fr.bank.acceptance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.bank.beans.Account;
import fr.bank.beans.Console;
import fr.bank.beans.DateTransaction;
import fr.bank.beans.PrintStatement;
import fr.bank.beans.Statements;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BankApplicationTest {

    @Mock Console console;
    @Mock DateTransaction dateTransaction;

    private Account account;

    @Before
    public void initialise() {
        Statements Statements = new Statements();
        PrintStatement printStatement = new PrintStatement(console);
        account = new Account(Statements, dateTransaction, printStatement);
    }

    @Test public void
    should_print_statement_containing_all_transactions() {
        given(dateTransaction.getDate()).willReturn("09/02/2019", "10/02/2019", "11/02/2019");
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(200);

        account.printHistory();

        verify(console).printLine("OPERATION  | DATE  | AMOUNT | BALANCE");
        verify(console).printLine("DEPOSIT | 11/02/2019 | 200,00 | 700,00");
        verify(console).printLine("WITHDRAWAL | 10/02/2019 | -500,00 | 500,00");
        verify(console).printLine("DEPOSIT | 09/02/2019 | 1000,00 | 1000,00");
    }
}
