package homework2;

/*
Ввести с консоли дату. Сравнить ее с текущей датой в
системе. Вывести отличающиеся части (год, месяц) на
экран.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class L5T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date currDate = new Date();

        System.out.print("Enter date in format yyyy-mm-dd: ");
        String dateString = sc.nextLine();
        try {
            Date userDate = dateFormat.parse(dateString);
            compareDates(currDate, userDate);

        } catch (ParseException ex) {
            System.out.println("Wrong date format!");
        }

    }

    @Deprecated
    private static void compareDates(Date currDate, Date userDate) {
        int currYearNumber = currDate.getYear();
        int userYearNumber = userDate.getYear();
        if (currYearNumber != userYearNumber) {
            System.out.print("user year: " + (userYearNumber + 1900));
            System.out.println();
        }

        int currMonthNumber = currDate.getMonth();
        int userMonthNumber = userDate.getMonth();
        if (currMonthNumber != userMonthNumber) {
            System.out.print("user month: " + userMonthNumber);
            System.out.println();
        }

        int currDateNumber = currDate.getDate();
        int userDateNumber = userDate.getDate();
        if (currDateNumber != userDateNumber) {
            System.out.print("user date: " + userDateNumber);
            System.out.println();
        }
    }
}
