package practice;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
	private final List<BankTransaction> bankTransactions;
	
	public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	
	
	public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
		double result = 0;
		for(final BankTransaction bankTransaction: bankTransactions) {
			result = bankTransactionSummarizer.summarize(result, bankTransaction);
		}
		return result;
	}
	
	
	public double calculateTotalAmount() { // 전체 내역
		double total = 0;
		for(final BankTransaction bankTransaction: bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}

	
	public double calculateTotalInMonth(final Month month) { // 월간 내역
		return summarizeTransactions((acc, bankTransaction) 
				-> bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);	
	}
	//	public double calculateTotalInMonth(final Month month) { // 월간 내역
	//		double total = 0;
	//		for(final BankTransaction bankTransaction: bankTransactions) {
	//			if(bankTransaction.getDate().getMonth() == month) {
	//				total += bankTransaction.getAmount();
	//			}
	//		}
	//		return total;
	//	}
	
	public double calculateTotalForCategory(final String category) { // 카테고리별 내역
		return summarizeTransactions((acc, bankTransaction) 
				-> bankTransaction.equals(category) ? acc + bankTransaction.getAmount() : acc);
	}
//	public double calculateTotalForCategory(final String category) { // 카테고리별 내역
//		double total = 0;
//		for(final BankTransaction bankTransaction: bankTransactions) {
//			if(bankTransaction.getDescription().equals(category)) {
//				total += bankTransaction.getAmount();
//			}
//		}
//		return total;
//	}
	
	
	public BankTransaction calculateMaxInMonth() { //달에 가장 많이 쓴 내역
		BankTransaction result = bankTransactions.get(0);
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(Math.abs(bankTransaction.getAmount()) > Math.abs(result.getAmount())) {
				result = bankTransaction;
			}
		}
		return result;
	}
	
	
	public BankTransaction calculateMinInMonth() { // 달에 가장 적게 쓴 내역
		BankTransaction result = bankTransactions.get(0);
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(Math.abs(bankTransaction.getAmount()) < Math.abs(result.getAmount())) {
				result = bankTransaction;
			}
		}
		return result;
	}
	
	
	public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
		final List<BankTransaction> result = new ArrayList<>();
		for(BankTransaction bankTransaction: bankTransactions) {
			if(bankTransactionFilter.test(bankTransaction)) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	
	public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) { // 특정 금액 이상의 거래 내역
		return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
	}
//	public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) { // 특정 금액 이상의 거래 내역
//		final List<BankTransaction> result = new ArrayList<>();
//		for(final BankTransaction bankTransaction: bankTransactions) {
//			if(bankTransaction.getAmount() >= amount) {
//				result.add(bankTransaction);
//			}
//		}
//		return result;
//	}

	
	public List<BankTransaction> findTransactionsInMonth(final Month month) { // 특정 달의 거래 내역
		return findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == month);
	}
//	public List<BankTransaction> findTransactionsInMonth(final Month month) { // 특정 달의 거래 내역
//		final List<BankTransaction>result = new ArrayList<>();
//		for(final BankTransaction bankTransaction: bankTransactions) {
//			if(bankTransaction.getDate().getMonth() == month) {
//				result.add(bankTransaction);
//			}
//		}
//		return result;
//	}
	

}

