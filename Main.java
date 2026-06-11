import java.util.Scanner;


public class Main {
    public static void printHeader() {
        System.out.println("\n==================================");
        System.out.println("     STUDENT FINANCE MANAGER");
        System.out.println("==================================");
    }
    public static void main(String args[]) {


        Scanner sc = new Scanner(System.in);
        FinanceManager fm = new FinanceManager();
        fm.loadFromFile();


        while (true) {

            System.out.println("\n===== STUDENT FINANCE MANAGER =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Summary");
            System.out.println("4. View Transactions");
            System.out.println("5. Category Report");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Income Amount: ");
                    double income = Double.parseDouble(sc.nextLine());
                    fm.addIncome(income);
                    break;

                case 2:
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Expense Amount: ");
                    double expense = Double.parseDouble(sc.nextLine());

                    fm.addExpense(category, expense);
                    break;

                case 3:
                    fm.viewSummary();
                    break;
                case 4:
                    fm.viewTransactions();
                    break;
                case 5:
                    fm.viewCategoryReport();
                    break;

                case 6:
                    fm.saveToFile();
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}