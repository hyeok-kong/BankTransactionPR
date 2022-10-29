package practice;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankStatementHistogram {
	
	
	private final List<BankTransaction> bankTransactions;
	
	
	public BankStatementHistogram(final List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	
	
	public void histMonthlyExpenditure() {
		Map<Month, Double> expenses = new HashMap<>();
		
		for(BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getAmount() > 0) continue;
			else {
				double amount = bankTransaction.getAmount();
				if(expenses.containsKey(bankTransaction.getDate().getMonth()) ) {
					amount += expenses.get(bankTransaction.getDate().getMonth());
				}
				expenses.put(bankTransaction.getDate().getMonth(), amount);
			}
		}
		
		System.out.println("<----- Monthly expenditure] ----->");
		for(Map.Entry<Month, Double> expense : expenses.entrySet()) {
			Month date = expense.getKey();
			Double amount = Math.abs(expense.getValue());
			System.out.printf("%10s : ", date);
			printHist(amount);
		}
		System.out.println("------- end -------");
	}
	
	
	public void histDesciptedExpenditure() {
		Map<String, Double> expenses = new HashMap<>();
		
		for(BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getAmount() > 0) continue;
			else {
				double amount = bankTransaction.getAmount();
				if(expenses.containsKey(bankTransaction.getDescription()) ) {
					amount += expenses.get(bankTransaction.getDescription());
				}
				expenses.put(bankTransaction.getDescription(), amount);
			}
		}
		
		System.out.println("<----- Desciption expenditure] ----->");
		for(Map.Entry<String, Double> expense : expenses.entrySet()) {
			String desc = expense.getKey();
			Double amount = Math.abs(expense.getValue());
			System.out.printf("%10s : ", desc);
			//System.out.println(amount);
			printHist(amount);
		}
		System.out.println("------- end -------");
	}
	
	
	public void printHist(double amount) {
		double amt = amount;
		while(amt > 0) {
			System.out.print("O");
			amt -= 50;
		}
		System.out.println(" (" + amount + ")");
	}
	
	
}
