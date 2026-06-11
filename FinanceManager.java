import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class FinanceManager {

    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addIncome(double amount) {
        transactions.add(new Transaction("Income", "Income", amount));
        System.out.println("Income Added Successfully!");
        System.out.println("----------------------------------");
    }

    public void addExpense(String category, double amount) {
        transactions.add(new Transaction("Expense", category, amount));
        System.out.println("Expense Added Successfully!");
        System.out.println("----------------------------------");
    }

    public void viewSummary() {

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {

            if (t.type.equals("Income")) {
                income += t.amount;
            } else {
                expense += t.amount;
            }
        }

        System.out.println("\n===== FINANCIAL SUMMARY =====");
        System.out.println("Total Income : Rs " + income);
        System.out.println("Total Expense: Rs " + expense);
        System.out.println("Balance      : Rs " + (income - expense));
    }
    public void viewTransactions() {

        System.out.println("\n===== ALL TRANSACTIONS =====");

        for(Transaction t : transactions) {

            System.out.println(
                t.dateTime + " | " +
                t.type + " | " +
                t.category + " | Rs " +
                t.amount
            );
        }
    }
    public void viewCategoryReport() {

        HashMap<String, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {

            if (t.type.equals("Expense")) {

                if (categoryTotals.containsKey(t.category)) {
  
                    categoryTotals.put(
                        t.category,
                        categoryTotals.get(t.category) + t.amount
                    );

                } 
                else {

                    categoryTotals.put(t.category, t.amount);
                }
            }
        }

        System.out.println("\n===== CATEGORY REPORT =====");

        for (String category : categoryTotals.keySet()) {

            System.out.println(
                category + " : Rs. " +
                categoryTotals.get(category)
            );
        }
    }
    public void saveToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"))) {

            for (Transaction t : transactions) {
                writer.write(t.type + "," + t.category + "," + t.amount);
                writer.newLine();
            }
 
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }
    public void loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                String type = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);

                transactions.add(new Transaction(type, category, amount));
            }

        } 
        catch (FileNotFoundException e) {
        } 
        catch (IOException e) {
            System.out.println("Error loading file!");
        }
    }
}
