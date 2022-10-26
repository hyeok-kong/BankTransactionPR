package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankTransaction {
	private static final String RESOURCES = "C:\\Users\\khb69\\Desktop\\Project\\datas\\RESOURCES.txt";
	private final LocalDate date;
	private final double amount;
	private final String description;
	
	public BankTransaction(final LocalDate date, final double amount, final String description) {
		this.date = date;
		this.amount = amount;
		this.description = description;
	}
	
	
	public LocalDate getDate() {
		return date;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	@Override
	public String toString() {
		return "BankTransaction{" + "date=" +date + ", amount=" + amount + ", description=" + description + '\'' + '}';
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		BankTransaction that = (BankTransaction) o;
		
		return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && description.equals(that.description);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(date, amount, description);
	}
	
	
	public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0;
		for(final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	
	
	public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}
		return bankTransactionsInMonth;
	}
	
	
	public static void main(String[] args) throws IOException {
		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
		
		final Path path = Paths.get(RESOURCES);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
		
		
		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
	}
}

