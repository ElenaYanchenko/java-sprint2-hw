import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static MonthlyReport monthlyReport = new MonthlyReport();
    static YearsReport yearsReport = new YearsReport();

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                monthlyReport.impRepMonthly(); // Загрузить месячные отчеты
            } else if (i == 2) {
                yearsReport.impRepMonthly(); //Загрузить годовой отчет
            } else if (i == 3) {
                validateIncome(); //Сверить отчеты (доход)
                validateExpense(); //Сверить отчеты (расход)
            } else if (i == 4) {
                printReportMonth(); //Вывод информации о месячных отчетах
            } else if (i == 5) {
                printReportYear(); //Вывод информации о годовом отчете
            } else if (i == 6) { // Выход (4)
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    public static void printMenu() { //главное меню
        System.out.println ("Если хотите загрузить месячные отчеты, введите цифру - 1");
        System.out.println ("Если хотите загрузить годовой отчет, введите цифру - 2");
        System.out.println ("Если хотите сверить отчеты, введите цифру - 3");
        System.out.println ("Если хотите посмотреть месячные отчеты, введите цифру - 4");
        System.out.println ("Если хотите посмотреть годовой отчет, введите цифру - 5");
        System.out.println ("Для выхода из программы введите цифру - 6");
    }
    public static void validateIncome() {  // сверяем доходы по месяцам
        if (monthlyReport.recordRep.isEmpty()) {
           System.out.println("Необходимо загрузить месячные отчеты!");
            System.out.println();
            return;
        } else if (yearsReport.recordRep.isEmpty()) {
            System.out.println("Необходимо загрузить годовой отчет!");
            System.out.println();
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (yearsReport.sumIncome(i) != monthlyReport.sumIncomeAll(i)) {
                System.out.println("Доход за" + " " + i + " " + "месяц в годовом и месячном отчете не сходится!");
            } else {
                System.out.println("Сверка доходов за" + " " + i + " " + "месяц пройдена успешно!");
            }
        }
    }
    public  static void validateExpense() { // сверяем расходы по месяцам
        if (monthlyReport.recordRep.isEmpty()) {
            System.out.println("Необходимо загрузить месячные отчеты!");
            System.out.println();
            return;
        } else if (yearsReport.recordRep.isEmpty()) {
            System.out.println("Необходимо загрузить годовой отчет!");
            System.out.println();
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (yearsReport.sumExpense(i) != monthlyReport.sumExpenseAll(i)) {
                System.out.println("Расходы за" + " " + i + " " + "месяц в годовом и месячном отчете не сходится!");
            } else {
                System.out.println("Сверка расходов за" + " " + i + " " + "месяц пройдена успешно!");
            }
        }
    }
    public static void printReportMonth() {  // Печать месячного отчета
       if (monthlyReport.recordRep.isEmpty()) {
            System.out.println("Необходимо загрузить месячные отчеты!");
            System.out.println();
            return;
        } else if (yearsReport.recordRep.isEmpty()) {
            System.out.println("Необходимо загрузить годовой отчет!");
            System.out.println();
            return;
        }
        ArrayList<String> monthName = new ArrayList<>();
        monthName.add("Январь");
        monthName.add("Февраль");
        monthName.add("Март");
        monthName.add("Апрель");
        monthName.add("Май");
        monthName.add("Июнь");
        monthName.add("Июль");
        monthName.add("Август");
        monthName.add("Сентябрь");
        monthName.add("Октябрь");
        monthName.add("Ноябрь");
        monthName.add("Декабрь");
        for (int i = 1; i <= 3; i++) {
            System.out.println(monthName.get((i-1)));
            monthlyReport.sumProfitItem(i);
            monthlyReport.sumExpenseItem(i);
        }
    }
    public static void printReportYear() {  // печать годового отчета
        if (monthlyReport.recordRep.isEmpty()) {
            System.out.println("Необходимо загрузить месячные отчеты!");
            return;
        } else if (yearsReport.recordRep.isEmpty()) {
            System.out.println("Необходимо загрузить годовой отчет!");
            return;
        }
        ArrayList<String> monthName = new ArrayList<>();
        monthName.add("Январь");
        monthName.add("Февраль");
        monthName.add("Март");
        monthName.add("Апрель");
        monthName.add("Май");
        monthName.add("Июнь");
        monthName.add("Июль");
        monthName.add("Август");
        monthName.add("Сентябрь");
        monthName.add("Октябрь");
        monthName.add("Ноябрь");
        monthName.add("Декабрь");
        System.out.println("Прибыль за 2021 год составила:");
        for (int i = 1; i <= 3; i++) {
        System.out.println(monthName.get((i-1)) + ":" + yearsReport.sumProfit(i) + " руб.");
        }
        System.out.println();
        System.out.println ("Средний расход за все месяцы составил " + yearsReport.sumAverageExpense() + " руб.");
        System.out.println ("Средний доход за все месяцы составил " + yearsReport.sumAverageIncome() + " руб.");
        System.out.println();
    }
}
