package in.Banking.service;
import in.Banking.*;
public class BankOfBaroda implements Bank
{
	private double bal;
	public void deposit(double amt)throws InvalidAmountException{
		if(amt<=0){throw new InvalidAmountException("Invalid amount passed : amount cant be negative or characters! Enter Correct Amount..");}
		bal=bal+amt;	
	
	}

	public double withdraw(double amt)throws InvalidAmountException,InsufficientBalanceException{
		if(amt<=0){throw new InvalidAmountException("Invalid amount passed : amount cant be negative or characters! Enter Correct Amount..");}
		else if(amt>bal){throw new InsufficientBalanceException("Insuuficient Balance to withdraw ....");}
		bal=bal-amt;
		return amt;
	}


}