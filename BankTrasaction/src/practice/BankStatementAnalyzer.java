package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
	private static final String RESOURCES = "C:\\Users\\khb69\\Desktop\\Project\\datas\\RESOURCES.txt";
	
	
	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCES);
		final List<String> lines = Files.readAllLines(path);
		
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		
		
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		final BankStatementHistogram bankStatementHistogram = new BankStatementHistogram(bankTransactions);
		
		collectSummary(bankStatementProcessor, bankStatementHistogram);
	}
	
	
	private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

	
	private static void collectSummary(final BankStatementProcessor bankStatementProcessor, final BankStatementHistogram bankStatementHistogram) {
		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
		System.out.println("The highest amount for all transactions is " + bankStatementProcessor.calculateMaxInMonth());
		System.out.println("The lowest amount for all transactions is " + bankStatementProcessor.calculateMinInMonth());
		
		System.out.println();
		bankStatementHistogram.histMonthlyExpenditure();
		
		System.out.println();
		bankStatementHistogram.histDesciptedExpenditure();;
		
	}
}
