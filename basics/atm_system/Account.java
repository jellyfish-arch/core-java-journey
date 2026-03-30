package atm_system;

public class Account {
    
    private String accountNumber;
    private String userName;
    private int pin;
    private double balance;
    private boolean activeStatus = true;
    private int transactionCount = 0;
    
    public Account(String accountNumber, String userName, int pin, double balance) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }
    

    public String getUserName() {
        return userName;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPin(int pin) {
        if (pin < 1000 || pin > 9999) {
            System.out.println("PIN must be 4 digits");
            return;
        }
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void deposit(double amount) {
        if (!activeStatus) {
            System.out.println("Account is inactive");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance += amount;
        transactionCount++;
    }
    
    public boolean withdraw(double amount) {
        if (!activeStatus) {
            System.out.println("Account is inactive");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            transactionCount++;
            return true;
        } else {
            System.out.println("Insufficient balance");
            return false;
        }
    }

    public void deactivate() {
        if (activeStatus) {
            activeStatus = false;
        } else {
            System.out.println("Already deactivated.");
        }
    }
    
    public void activate() {
        if (activeStatus) {
            System.out.println("Already active.");
        } else {
            activeStatus = true;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
        "accountNumber='" + accountNumber + '\'' +
        ", userName='" + userName + '\'' +
        ", balance=" + balance +
        ", activeStatus=" + activeStatus +
        '}';
    }

}