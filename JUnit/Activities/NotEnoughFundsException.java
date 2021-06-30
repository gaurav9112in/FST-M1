package junitActivities;

public class NotEnoughFundsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughFundsException(int amount, int balance) {
        super("Attempted to withdraw " + amount + " with a balance of " + balance);
    }

}
