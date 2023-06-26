**Bank Account Manager System**

Create a simple Bank Account Management System that allows users to manage their bank accounts. The application 
should be capable of creating accounts, depositing money, withdrawing money, and checking the balance.

The tests are written, so you should work in TDD.

Classes:

BankAccount: This class represents a bank account. Each account should have the following variables:

- accountNumber (String): Represents the account number.
- ownerName (String): Represents the owner's name.
- balance (double): Represents the account balance.
- The class should implement the following functionalities:

- Constructor: The class should have a constructor that takes the accountNumber and ownerName as parameters. 
- The balance should be set to 0 by default.
- getAccountNumber(): Returns the account number.
- getOwnerName(): Returns the owner's name.
- getBalance(): Returns the account balance.
- deposit(amount): Adds the given amount to the account balance.
- withdraw(amount): Subtracts the given amount from the account balance if there are sufficient funds.
- Otherwise, it should display an error message.
- toString(): Returns a string representation of the account's detailed information. (Hint: Alt+insert in the class)

BankAccountManager: This class is responsible for managing bank accounts. The class should have the following variables:

- accounts (List<BankAccount>): Represents the list of accounts.
- hint: List<BankAccount> bankAccounts = new ArrayList<>();
- see the documentation what you can with an arraylist do...

The class should implement the following functionalities:

- Constructor: The class should initialize the accounts list as empty.
- findAccount(accountNumber): Returns the founded account with given account number, else return null
- createAccount(ownerName, accountNumber): Creates a new account with the provided ownerName and account number and adds it to the accounts list.
Be careful! The account number should be unique! If the bank account exists, do not create another one with the same one, but display a 
warning message to the user on the console.
- deposit(accountNumber, amount): Deposits the specified amount into the account associated with the given accountNumber.
- withdrawFromAccount(accountNumber, amount): Withdraws the specified amount from the account associated with the given accountNumber.
  Returns a String, "Amount withdraw successfully" if the withdraw was successfully or "Account not found" if the account
does not exist or "Account's balance too low!" if the account's balance is under zero or less than the given amount.
  - getAccountBalance(accountNumber): Returns the balance of the account associated with the given accountNumber, if the account
  does not exist, it should returns -1.
  **Ensure that you write the necessary test cases to verify the correctness of your implementation.**

You are required to write a Java program that implements the above Bank Account Management System.
It is not necessary to use main, it is enough if you try the application in tests. Pay attention, you can't withdraw 
more money from a bank account than is on it, you can't have a negative value on the account.
