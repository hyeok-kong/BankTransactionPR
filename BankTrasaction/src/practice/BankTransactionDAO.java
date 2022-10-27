package practice;

import java.time.LocalDate;

public class BankTransactionDAO { // CRUD연산 구현
	// DAO : Data Access Object, 데이터베이스 같은 데이터 소스로의 접근을 추상화하고 캡슐화 함
	
	
	public BankTransaction create(final LocalDate date, final double amount, final String description) {
		throw new UnsupportedOperationException();
	}
	
	
	public BankTransaction read(final long id) {
		throw new UnsupportedOperationException();
	}
	
	
	public BankTransaction update(final long id) {
		throw new UnsupportedOperationException();
	}
	
	
	public void delete(final BankTransaction BankTransaction) {
		throw new UnsupportedOperationException();
	}
}
