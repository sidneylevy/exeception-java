import Model.exepitions.DomainException;

public class Account {
    
	private Integer number;
	private String name;
	private Double balance;
	private Double withdrawLimit;
	
	
	public Account(Integer number, String name, Double balance, Double withdrawLimit) {
		this.number = number;
		this.name = name;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getBalance() {
		return balance;
	}


	public Double getWithdrawLimit() {
		return withdrawLimit;
	}


	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException{
		if (amount > withdrawLimit) {
			throw new DomainException("O valor excede o limite de saque!");
		}
		if (amount > balance) {
			throw new DomainException("Obsserve o saldo disponivel!");
		}
		balance -= amount;
	}
}
		
		 
			
		
		
