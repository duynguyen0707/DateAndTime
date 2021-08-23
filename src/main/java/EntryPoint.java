public class EntryPoint {
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isValidDate(int day, int month, int year) {

        int lastDayOfMonth = getLastDayOfMonth(month, year);
        if (year<1970)
            return false;
        if (day>31)
            return false;


        if (lastDayOfMonth == -1)
            return false;

        return day >= 1 && day <= lastDayOfMonth;
    }


    public static int getLastDayOfMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        else if (month == 2)
            return isLeapYear(year) ? 29 : 28;
        else
            return -1;
    }




}
