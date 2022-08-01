package in.Banking;

import java.util.Scanner;
import in.Banking.service.*;

public class ATM
{
	public static void main(String args[])throws InvalidAmountException,InsufficientBalanceException
	{
		String bankName=null,nextoption=null;
		int option=0;
		double amount=0.0,withdrawamount=0.0;

		Scanner sc=new Scanner(System.in);
		start:
		while(true)
		{
			System.out.println("Enter Your Bank Name : ");
			bankName="in.Banking.service."+sc.next();

			try{
				Bank bank=(Bank)Class.forName(bankName).newInstance();

				
				while(true){
					System.out.println("______________choose the Operation..._______________");
					System.out.println("__1.Deposit__");
					System.out.println("__2.Withdraw__");
					System.out.println("__3.Exit__");
					option=sc.nextInt();

					try{
						switch(option){
							case 1: System.out.println("Enetr Amount to be deposit : ");
								amount=sc.nextDouble(); 
								bank.deposit(amount);
								break;

							case 2: System.out.println("Enter Amount You want to Withdraw : ");
								amount=sc.nextDouble();
								withdrawamount=bank.withdraw(amount);
								System.out.println("Collect your withdrawen amount" +withdrawamount);
								break;
							case 3: System.exit(0);

							default: System.out.println("__________Invalid option..________");
								
		
						}	
						System.out.println("\nDo You Want to comntinue ? (Y / N)  :  ");
						nextoption=sc.next();
						if("N".equalsIgnoreCase(nextoption)){break start;}


					}
					catch(InvalidAmountException e)
					{
						System.out.println(e.getMessage());
					}
					catch(InsufficientBalanceException e)
					{
						System.out.println(e.getMessage());
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}



				}
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}



		}

	
	}


}