import java.util.Scanner;

public class Atm {
   

  private double balance;

  public Atm(double initial) {
    this.balance = initial;
  }

  public void displayMenu() {
    System.out.println("Welcome to the ATM!");
    System.out.println("1. Withdraw");
    System.out.println("2. Deposit");
    System.out.println("3. Check Balance");
    System.out.println("4. Exit");
    System.out.println("Enter your choice: ");
  }

  public void performTransaction(int choice) {
    Scanner s = new Scanner(System.in);
    switch (choice) {
      case 1:
        System.out.println("Enter amount to withdraw: ");
        double amount = s.nextDouble();
        if (withdraw(amount)) {
          System.out.println("Withdrawal successful. Please collect your cash.");
        } else {
          System.out.println("Insufficient funds. Please try with a lower amount.");
        }
        break;
      case 2:
        System.out.println("Enter amount to deposit: ");
        amount = s.nextDouble();
        deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + balance);
        break;
      case 3:
        System.out.println("Your current balance is: " + balance);
        break;
      case 4:
        System.out.println("Thank you for using the ATM. Goodbye!");
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }
    s.close();
  }

  private boolean withdraw(double amount) {
    if (amount > balance) {
      return false;
    }
    balance -= amount;
    return true;
  }

  private void deposit(double amount) {
    balance += amount;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter initial balance: ");
    double initialBalance = scanner.nextDouble();

    Atm atm = new Atm(initialBalance);

    while (true) {
      atm.displayMenu();
      int choice = scanner.nextInt();
      atm.performTransaction(choice);

      System.out.println("\nDo you want to perform another transaction? (y/n)");
      String anotherTransaction = scanner.nextLine().toLowerCase();
      if (!anotherTransaction.equals("y")) {
        break;
      }
    }

    scanner.close();
  }
}
 

