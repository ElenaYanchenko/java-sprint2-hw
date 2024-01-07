public class MonthlyData {  // класс для хранения данных месячных отчетов
    int monthNumber;
    String itemName;
    boolean isExpense;
    int quantity;
    int unitPrice;
    public MonthlyData(int i, String name, boolean isExp, int quant, int price) {
        monthNumber = i;
        itemName = name;
        isExpense = isExp;
        quantity = quant;
        unitPrice = price;
    }
}
