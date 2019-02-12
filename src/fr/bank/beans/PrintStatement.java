package fr.bank.beans;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors; 
import static com.google.common.collect.Lists.reverse; 
/**
 * The Class PrintStatement.
 */
public class PrintStatement {

    /** The STATEMENT_HEADER. */
    public static final String STATEMENT_HEADER = "OPERATION  | DATE  | AMOUNT | BALANCE";
    
    /** The SEPARATOR. */
    public static final String SEPARATOR = " | ";
    
    /** The console. */
    private Console console;

    /**
     * Instantiates a new prints the statement.
     *
     * @param console the console
     */
    public PrintStatement(Console console) {
        this.console = console;
    }

    /**
     * Print the list of statements in console .
     *
     * @param statementList the statement list
     */
    public void print(List<Statement> statementList) {
        printHeader();
        printStatementOperations(statementList);
    }

    /**
     * Prints the header.
     */
    private void printHeader() {
        console.printLine(STATEMENT_HEADER);
    }

    /**
     * Prints the statement operations.
     *
     * @param statementList the statement list
     */
    private void printStatementOperations(List<Statement> statementList) {
        List<String> statementLines = statementOperations(statementList);
        reverse(statementLines).forEach(console::printLine);
    }

    /**
     * Statement operations.
     *
     * @param statementList the statement list
     * @return the list
     */
    private List<String> statementOperations(List<Statement> statementList) {
       
        return statementList.stream()
                            .map(statement -> statementOperation(statement))
                            .collect(Collectors.toList());
    }

    /**
     * Statement operation.
     *
     * @param statement the statement
     * @return the string
     */
    private String statementOperation(Statement statement) {
        
        StringBuffer sb = new StringBuffer();
        sb.append(statement.getTransaction().getOperation());
        sb.append(SEPARATOR);
        sb.append(statement.getTransaction().getDate());
        sb.append(SEPARATOR);
        sb.append(formatDecimal(statement.getTransaction().getAmount()));
        sb.append(SEPARATOR);
        sb.append(formatDecimal(statement.getBalance()));
        
        return sb.toString();
    }

    /**
     * Format decimal.
     *
     * @param amount the amount
     * @return the string
     */
    private String formatDecimal(Double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(amount);
    }
}
