package junitActivities;

public class BankAccount {
	    private Integer balance;
	    
	    // Create a constructor
	    public BankAccount(int initialBalance) {
	        balance = initialBalance;
	    }

	    // Add method to calculate
	    // balance amount after withdrawal
	    public int withdraw(Integer amount) {
	        if (balance < amount) {
	            throw new NotEnoughFundsException(amount, balance);
	        }
	        balance -= amount;
	        return balance;
	    }
	}
	
