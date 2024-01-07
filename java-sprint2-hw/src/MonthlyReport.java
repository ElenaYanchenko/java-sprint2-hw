import java.util.ArrayList;
public class MonthlyReport {
    ArrayList<String> lines;
    public ArrayList<MonthlyData> recordRep = new ArrayList<>(); // список для хранения данных
    FileReaderRep fileReaderRep = new FileReaderRep();
    public void impRepMonthly() { // загрузка месячных отчетов из файла
        for (int i = 1; i <= 3; i++) {
            String fileName = "m.20210" + i + ".csv";
            lines = fileReaderRep.readFileContents(fileName);
            System.out.println("Загружено строк:" + " " + lines.size());
            for (int j = 1; j < lines.size(); j++) {
                String line = lines.get(j);
                String[] lineContents = line.split(","); // распарсили строку отчета
                String itemName = lineContents[0];
                boolean isExpense = Boolean.parseBoolean(lineContents[1]);
                int quantity = Integer.parseInt(lineContents[2]);
                int unitPrice = Integer.parseInt(lineContents[3]);
                recordRep.add(new MonthlyData(i, itemName, isExpense, quantity, unitPrice));
               /* не получилось корректно заполнить хэш-мар для пар значений "ключ-список"
               monthDataHashMap.put(i, recordRep);
               */
            }
        }
    }
   public int sumExpenseAll (int month) {  // сумма расходов за месяц
       int sumExpense = 0;
       for (int i = 0; i < recordRep.size(); ++i) {
           MonthlyData obj = recordRep.get(i);
           if (obj.monthNumber == month && (obj.isExpense)){
               sumExpense += (obj.unitPrice * obj.quantity);
           }
       } return sumExpense;
   }
    public int sumIncomeAll(int month) {  // сумма доходов за месяц
        int sumIncome = 0;
        for (int i = 0; i < recordRep.size(); ++i) {
            MonthlyData obj = recordRep.get(i);
            if (obj.monthNumber == month && (!obj.isExpense)) {
                sumIncome += (obj.unitPrice * obj.quantity);
            }
        } return sumIncome;
    }
    public void sumProfitItem(int month) {  // самый прибыльный товар за месяц
        int sumProfitItem = 0;
        String nameProfitItem = null;
        int i;
        for (i = 0; i < recordRep.size(); ++i) {
            MonthlyData obj = recordRep.get(i);
            if (obj.monthNumber == month && (!obj.isExpense)) {
                if ((obj.unitPrice * obj.quantity) > sumProfitItem) {
                    sumProfitItem = (obj.unitPrice * obj.quantity);
                    nameProfitItem = obj.itemName;
                }
            }
        }
        System.out.println("Самый прибыльный товар за месяц:" + " " + nameProfitItem + " " + "на сумму:" + " " + sumProfitItem + " руб.");
    }
    public void sumExpenseItem(int month) {  // самая большая трата за месяц
        int sumExpenseItem = 0;
        String nameExpenseItem = null;
        int i;
        for (i = 0; i < recordRep.size(); ++i) {
            MonthlyData obj = recordRep.get(i);
            if (obj.monthNumber == month && (obj.isExpense)) {
                if ((obj.unitPrice * obj.quantity) > sumExpenseItem) {
                    sumExpenseItem = (obj.unitPrice * obj.quantity);
                    nameExpenseItem = obj.itemName;
                }
            }
        }
        System.out.println("Самая большая трата месяц:" + " " + nameExpenseItem + " " + "на сумму: " + sumExpenseItem + " руб.");
        System.out.println();
    }
}

