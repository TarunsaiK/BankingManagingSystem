import java.util.Scanner;

import java.text.NumberFormat;
//import java.util.Scanner;
 import java.io.*;
interface EMI{
 double calculateMonthlyPayment(int loanAmount, int termInYears, double interestRate);
}
class payment implements EMI{
 public double calculateMonthlyPayment(int loanAmount, int termInYears, double interestRate)
   {       
      interestRate /= 100.0;       
      double monthlyRate = interestRate / 12.0;       
      int termInMonths = termInYears * 12;       
      double monthlyPayment =(loanAmount*monthlyRate) /(1-Math.pow(1+monthlyRate, -termInMonths));       
      return monthlyPayment;
   }    
}
class Menu{
    int ab;
void display(){
      System.out.println("\t\t========================================");
      System.out.println("\t\t\tWelcome to SBI loan");
      System.out.println("\t\t=======================================");
      System.out.println("\t\t 1.Education Loan");
      System.out.println("\t\t2.Home Loan");
      System.out.println("\t\t3.Search");
     System.out.println("\t\t4. Exit");
      System.out.println("\n\n Enter your choice:");
      Scanner in=new Scanner(System.in);
      ab=in.nextInt();
}
}
class loan extends Menu{
        payment p=new payment();
         void Eduloan() {
        try{
         Scanner in=new Scanner(System.in);
         File file=new File("Eduloan.txt");
        // if file doesnt exists, then create it
	if (!file.exists()) {
            file.createNewFile();
	}          
      FileWriter fw = new FileWriter("Eduloan.txt",true);
      BufferedWriter bw = new BufferedWriter(fw);
      System.out.println("Enter father name:");
      String fname=in.next();
      System.out.println("Enter father bank account nuumber:");
      String facc=in.next();  
      System.out.println("Enter father income per annum:");
      double fin=in.nextDouble();
      if(fin>=100000)
        {
          System.out.println("Enter name:");
          String sname=in.next();
          System.out.println("Enter aadhar card no:");
          String saad=in.next();
          System.out.println("Enter college details:");
          String sc=in.next();
          System.out.print("Enter loan amount: ");
          int loanAmount =in.nextInt();       
          System.out.print("Enter loan term (in years): ");
          int termInYears = in.nextInt();
          double interestRate =20; 
          double monthlyPayment =p.calculateMonthlyPayment(loanAmount, termInYears, interestRate);       
          NumberFormat currencyFormat =NumberFormat.getCurrencyInstance();
          NumberFormat interestFormat =NumberFormat.getPercentInstance(); 
          System.out.println("Loan Amount: "+currencyFormat.format(loanAmount));
          System.out.println("Loan Term: "+termInYears+" years");
          System.out.println("Interest Rate: "+interestFormat.format(interestRate));
          System.out.println("Monthly Payment: "+currencyFormat.format(monthlyPayment));
          bw.write("Father name:"+fname+" ");
	  bw.write("Father acc No."+facc+" ");
          bw.write("Student name:"+sname+" "+"Student aadhaar:"+saad+" ");
	  bw.write("Term in years:"+termInYears+" ");
          bw.write("Loan amount:"+currencyFormat.format(loanAmount)+" ");
          bw.write("Interest rate:"+interestFormat.format(interestRate)+" ");
          bw.write("EMI:"+currencyFormat.format(monthlyPayment)+" ");
          bw.newLine();
        }
       else 
        {System.out.println("You are not eligible for loan");}
      bw.close();
         }
    catch (IOException e) {
	e.printStackTrace();
		}
         }
         void Homeloan(){
          try{              
         Scanner in=new Scanner(System.in);
         File file1=new File("Home Loan.txt");
        // if file doesnt exists, then create it
	if (!file1.exists()) {
            file1.createNewFile();
	}          
      FileWriter fwh = new FileWriter("Home Loan.txt",true);
      BufferedWriter bwh = new BufferedWriter(fwh);
      System.out.println("Enter Applicants name:");
      String bs=in.next();
      System.out.println("Enter bank account nuumber:");
      String br=in.next();
      System.out.println("Enter aadhar card no:");
      String bc=in.next();
      System.out.println("Enter security for loan(eg;land documents):");
      String o=in.next();  
      System.out.println("Enter your income per annum:")          ;
      double fd=in.nextDouble();
      if(fd>=100000)       
      {
      System.out.print("Enter loan amount: ");
      int loanAmount =in.nextInt();       
      System.out.print("Enter loan term (in years): ");
      int termInYears = in.nextInt();
      double interestRate =15; 
      double monthlyPayment = p.calculateMonthlyPayment(loanAmount, termInYears, interestRate);       
      NumberFormat currencyFormat =NumberFormat.getCurrencyInstance();
      NumberFormat interestFormat =NumberFormat.getPercentInstance(); 
      System.out.println("Loan Amount: "+ currencyFormat.format(loanAmount));
      System.out.println("Loan Term: "+ termInYears+" years");
      System.out.println("Interest Rate: "+interestFormat.format(interestRate));
      System.out.println("Monthly Payment: "+ currencyFormat.format(monthlyPayment));
      bwh.write("Applicant name:"+bs+" "+"Bank acc no:"+br+" "+"income:"+fd+" ");
      bwh.write("Loan amount:"+currencyFormat.format(loanAmount)+" ");
      bwh.write("Interest rate:"+interestFormat.format(interestRate)+" ");
      bwh.write("EMI:"+currencyFormat.format(monthlyPayment)+" ");
      bwh.newLine();
       }
     else
       {System.out.println("You are not eligible for loan");}   
           bwh.close();}
          catch (IOException e) {
	e.printStackTrace();
		}
         }
   void searchedu()throws Exception{
			int i=0;
			Scanner in =new Scanner(System.in);
			System.out.println("enter the name you want to search:");
			String name= in.next();
			File file=new File("Eduloan.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
			   String lineFromFile = sc.nextLine();
			   if(lineFromFile.contains(name)) { 
			       System.out.println("I found " +name+ " in Data base");
			       System.out.println(lineFromFile);
			       i=1;
			       break;
			   }
		   }
		if(i==0){
				System.out.println("File not found");
			}
		}
void searchhome()throws Exception{
			int i=0;
			Scanner in =new Scanner(System.in);
			System.out.println("enter the name you want to search:");
			String name= in.next();
			File file=new File("Home Loan.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
			   String lineFromFile = sc.nextLine();
			   if(lineFromFile.contains(name)) { 
			       System.out.println("I found " +name+ " in Data base");
			       System.out.println(lineFromFile);
			       i=1;
			       break;
			   }
			   }
		if(i==0){
				System.out.println("File not found");
			}
		}
         }
public class BankApp {
public static void main(String[] args)throws Exception {
    Scanner s = new Scanner(System.in);
    Bank myBank = new Bank();

    int user_choice = 2;

    do {
        //display menu to user
        //ask user for his choice and validate it (make sure it is between 1 and 6)
        System.out.println();
        System.out.println("1) Open a new bank account");
        System.out.println("2) Deposit to a bank account");
        System.out.println("3) Withdraw to bank account");
        System.out.println("4) Print short account information");
        System.out.println("5) Print the detailed account information including last transactions");
        System.out.println("6) To manage loans of account");
        System.out.println("7) Quit");
        System.out.println();
        System.out.print("Enter choice [1-7]: ");
        user_choice = s.nextInt();
        switch (user_choice) {
            case 1: System.out.println("Enter a customer name");
                    String cn = s.next();
                    System.out.println("Enter a opening balance");
                    double d = s.nextDouble();
                    System.out.println("Account was created and it has the following number: " + myBank.openNewAccount(cn, d));
                    break;
            case 2: System.out.println("Enter a account number");
                    int an = s.nextInt();
                    System.out.println("Enter a deposit amount");
                    double da = s.nextDouble();
                    myBank.depositTo(an, da);
                    break;
            case 3: System.out.println("Enter a account number");
                    int acn = s.nextInt();
                    System.out.println("Enter a withdraw amount");
                    double wa = s.nextDouble();
                    myBank.withdrawFrom(acn, wa);
                    break;
            case 4: System.out.println("Enter a account number");
                    int anum = s.nextInt();
                    myBank.printAccountInfo(anum);
                    break;
           case 5:  System.out.println("Enter a account number");
                    anum = s.nextInt();
                    myBank.printTransactionInfo(anum);
                    break;
           case 6:  Scanner sc = new Scanner(System.in);
                    loan l = new loan();
       		    while(true){
              	    l.display();
            	    int ch = l.ab;
      		    switch(ch){
      		       case 1: l.Eduloan();
                  		     break;
       		      case 2: l.Homeloan();
               		      break;
                      case 4: break;
            	      case 3:    System.out.println("GET THE STATUS \n 1.Education loan \n2.Home loan");
			 	int ch1=sc.nextInt();
				if(ch1==1)
					l.searchedu();
				else 
					l.searchhome();
				break;
        	     default: System.out.println("Wrong choice");
                    }
			if(ch==4)
                           break;
                    }
	  case 7:break;
          default: System.out.println("Invalid option. Please try again.");

        }
}
while (user_choice != 7);
}

static class Bank {
private BankAccount[] accounts;     // all the bank accounts at this bank
private int numOfAccounts;      // the number of bank accounts at this bank

    //Constructor: A new Bank object initially doesn’t contain any accounts.
public Bank() {
    accounts = new BankAccount[100];
    numOfAccounts = 0;
    }

// Creates a new bank account using the customer name and the opening balance given as parameters
// and returns the account number of this new account. It also adds this account into the account list
// of the Bank calling object.
public int openNewAccount(String customerName, double openingBalance) {

    BankAccount b = new BankAccount(customerName, openingBalance);
    accounts[numOfAccounts] = b;
    numOfAccounts++;
    return b.getAccountNum();
}

// Withdraws the given amount from the account whose account number is given. If the account is
// not available at the bank, it should print a message.
public void withdrawFrom(int accountNum, double amount) {
    for (int i =0; i<numOfAccounts; i++) {
        if (accountNum == accounts[i].getAccountNum()  ) {
            accounts[i].withdraw(amount);
            System.out.println("Amount withdrawn successfully");
            return;
        }
    }
    System.out.println("Account number not found.");
    }

// Deposits the given amount to the account whose account number is given. If the account is not
// available at the bank, it should print a message.
public void depositTo(int accountNum, double amount) {
    for (int i =0; i<numOfAccounts; i++) {
        if (accountNum == accounts[i].getAccountNum()  ) {
            accounts[i].deposit(amount);
            System.out.println("Amount deposited successfully");
            return;
        }
    }
    System.out.println("Account number not found.");
}

// Prints the account number, the customer name and the balance of the bank account whose
// account number is given. If the account is not available at the bank, it should print a message.
public void printAccountInfo(int accountNum) {
    for (int i =0; i<numOfAccounts; i++) {
                if (accountNum == accounts[i].getAccountNum()  ) {
                    System.out.println(accounts[i].getAccountInfo());
                    return;
                }
            }
    System.out.println("Account number not found.");
}

public void printTransactionInfo(int accountNum) {
    for (int i =0; i<numOfAccounts; i++) {
                if (accountNum == accounts[i].getAccountNum()  ) {
                    System.out.println(accounts[i].getAccountInfo());
                    System.out.println("Last transaction: " + accounts[i].getTransactionInfo(accounts[i].getNumberOfTransactions()-1));
                    return;
                }
            }
    System.out.println("Account number not found.");
}


// Prints the account number, the customer number and the balance of the bank account whose
// account number is given, together with last n transactions on that account. If the account is not
// available at the bank, it should print a message.
public void printAccountInfo(int accountNum, int n) {
    for (int i =0; i<numOfAccounts; i++) {
                        if (accountNum == accounts[i].getAccountNum()  ) {
                            System.out.println(accounts[i].getAccountInfo());
                            System.out.println(accounts[i].getTransactionInfo(n));
                            return;
                        }
                    }
    System.out.println("Account number not found.");
    }

}
    static class BankAccount{

       private int accountNum;
       private String customerName;
       private double balance;
       private double[] transactions;
       private String[] transactionsSummary;
       private int numOfTransactions;
       private  static int noOfAccounts=0;

       public String getAccountInfo(){
           return "Account number: " + accountNum + "\nCustomer Name: " + customerName + "\nBalance:" + balance +"\n";
       }

       public String getTransactionInfo(int n)
       {
            String transaction = transactionsSummary[n];
            if (transaction == null) {
                return "No transaction exists with that number.";
            }
            else {
                return transaction;
            }
        }

       public BankAccount(String abc, double xyz){
         customerName = abc;
         balance = xyz;
         noOfAccounts ++;
         accountNum = noOfAccounts;
         transactions = new double[100];
         transactionsSummary = new String[100];
         transactions[0] = balance;
         transactionsSummary[0] = "A balance of : $" + Double.toString(balance) + " was deposited.";
         numOfTransactions = 1;
       }

    public int getAccountNum(){
        return accountNum;
    }

    public int getNumberOfTransactions() {
        return numOfTransactions;
    }

    public void deposit(double amount){

        if (amount<=0) {
            System.out.println("Amount to be deposited should be positive");
        } else {
            balance = balance + amount;
            transactions[numOfTransactions] = amount;
            transactionsSummary[numOfTransactions] = "$" + Double.toString(amount) + " was deposited.";
            numOfTransactions++;
        }
    }
    public void withdraw(double amount)
    {
        if (amount<=0){
             System.out.println("Amount to be withdrawn should be positive");
         }
        else
        {
            if (balance < amount) {
                System.out.println("Insufficient balance");
            } else {
                balance = balance - amount;
                transactions[numOfTransactions] = amount;
                transactionsSummary[numOfTransactions] = "$" + Double.toString(amount) + " was withdrawn.";
                numOfTransactions++;
            }
        }
    }

    }//end of class
}
