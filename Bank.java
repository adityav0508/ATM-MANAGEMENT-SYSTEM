package in.Banking.service;
import in.Banking.*;
public interface Bank{
	public double withdraw(double amt)throws InsufficientBalanceException,InvalidAmountException;
	public void deposit(double amt)throws InvalidAmountException;

}