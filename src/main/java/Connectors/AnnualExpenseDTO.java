package Connectors;

public class AnnualExpenseDTO {
    public String name;
    public String dueDate;
    public int id;
    public double amount;
    public boolean essential;
    public String autopayBank;
    public int period;
    public String remarks;

    public String getName () {
        return this.name;
    }
}
