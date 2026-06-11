import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {

    public String type;
    public String category;
    public double amount;
    public String dateTime;

    public Transaction(String type, String category, double amount) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = LocalDateTime.now().format(formatter);
    }
}
