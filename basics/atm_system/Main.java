package atm_system;

public class Main {
    public static void main(String[] args) {

        ATM atm = new ATM();
        Account loggedInUser = atm.login();

        if (loggedInUser != null) {
            System.out.println("Welcome " + loggedInUser.getUserName());
            atm.showMenu(loggedInUser); 
        }
    }
}