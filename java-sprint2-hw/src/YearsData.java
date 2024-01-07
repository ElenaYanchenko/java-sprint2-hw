public class YearsData { // класс для хранения данных по годовым отчетам
    int month;
    int amount;
    boolean isExpense;
    YearsData (int monthRep, int amountRep, boolean isExpenseRep) {
        this.month = monthRep;
        this.amount = amountRep;
        this.isExpense = isExpenseRep;
    }
}
