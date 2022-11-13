package practice;

import java.time.Month;

// 함수형 인터페이스 (한 개의 추상 메소드를 포함하는 인터페이스)
@FunctionalInterface
public interface BankTransactionFilter {
	boolean test(BankTransaction bankTransaction);
}


//class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
//	
//	@Override
//	public boolean test(final BankTransaction bankTransaction) {
//		return bankTransaction.getDate().getMonth() == Month.FEBRUARY
//				&& bankTransaction.getAmount() >= 1_000;
//	}
//}