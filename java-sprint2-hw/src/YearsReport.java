import java.util.ArrayList;

public class YearsReport {
    ArrayList<String> lines;
    ArrayList<YearsData> recordRep = new ArrayList<>();   // список для хранения данных
    FileReaderRep fileReaderRep = new FileReaderRep();
    public void impRepMonthly () {  // загрузка годового отчетов из файла
        String fileName = "y.2021.csv";
        lines = fileReaderRep.readFileContents(fileName);
        System.out.println("Загружено строк:" + " " + lines.size());
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(","); // распарсили строку отчета
            int monthRep = Integer.parseInt(lineContents[0]);
            int amountRep = Integer.parseInt(lineContents[1]);
            boolean isExpenseRep = Boolean.parseBoolean(lineContents[2]);
            recordRep.add(new YearsData(monthRep, amountRep, isExpenseRep)); //Сохраняем данные в список
        }
    }
    public int sumIncome(int month) { // сумма доходов по месяцам
        int sumIncomeY = 0;
        for (int i = 0; i < recordRep.size(); ++i) {
            YearsData obj = recordRep.get(i);
            if (obj.month == month && (!obj.isExpense)) {
                sumIncomeY = obj.amount;
            }
        } return sumIncomeY;
    }
    public int sumExpense(int month){  // сумма расходов по месяцам
        int sumExpenseY = 0;
        for (int i = 0; i < recordRep.size(); ++i) {
            YearsData obj = recordRep.get(i);
            if (obj.month == month && (obj.isExpense)) {
                sumExpenseY = obj.amount;
            }
        } return sumExpenseY;
    }
    public int sumProfit(int month) { // прибыль по месяцам
        return sumIncome(month) - sumExpense(month);
    }

    public int sumAverageIncome() { //средний доход за год
        int sum = 0;
        int month = 3;
        for (int i = 0; i <= month; ++i) {
            YearsData obj = recordRep.get(i);
            if (!obj.isExpense) {
                sum += obj.amount;
            }
        } return (sum/month);
    }
    int sumAverageExpense() {  //средний расход за год
        int sum = 0;
        int month = 3;
        for (int i = 0; i <= month ; ++i) {
            YearsData obj = recordRep.get(i);
            if (obj.isExpense) {
                sum += obj.amount;
            }
        } return (sum/month);
    }
}
