
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App<pastDay, bl> {
    public static void main(String[] args) {
//        LocalDate today = LocalDate.now();
//        System.out.println(today);
//
//        LocalDate ld = LocalDate.of(2021, 12, 31);
//        System.out.println(ld);
//        System.out.println("------------------");
//
//        System.out.println(today.getDayOfYear());
//        System.out.println(today.getDayOfMonth());
//        System.out.println(today.getDayOfWeek());
//        System.out.println("------------------");
//
//        System.out.println(today.getMonth());
//        System.out.println(today.getMonthValue());
//        System.out.println("------------------");
//
//        System.out.println(today.getYear());
//        System.out.println("------------------");
//

//        LocalDate eld1 = LocalDate.ofYearDay(2020,34);
//        System.out.println("ePOCH: " +eld1);
//        System.out.println("------------------");
//
//        LocalTime lt = LocalTime.of(9,30,40);
//        System.out.println(lt);
//
//        LocalTime now = LocalTime.now();
//        System.out.println(now);
//
//        System.out.println(now.getHour());
//        System.out.println(now.getMinute());
//        System.out.println(now.getSecond());
//        System.out.println(now.getNano());
//        System.out.println("------------------");
//
//        System.out.println(now.plusHours(2));
//        System.out.println(now.plusMinutes(2));
//        System.out.println(now.plusSeconds(2));

//        1. Viết hàm xét năm nhuận.
//        2. Viết hàm lấy số giây 1 tháng/năm bất kỳ.
//        3. Viết hàm lấy số giây của 1 năm bất kỳ.
//        4. Viết hàm tính số giây từ ngày 1 đến ngày đang xét.

//        Nhập vào int ngày, int tháng, int năm, int giờ, int phút, int giây: phát sinh ra timestamp (giây).
//                Nhập vào timestamp (giây): phát sinh ra ngày, tháng, năm, giờ, phút, giây.
//
//        1. Không dùng class hỗ trợ ngày, tháng, năm, chỉ dùng if, for, while bình dân.
//        2. Dùng các class hỗ trợ ngày, tháng, năm.

//        LocalDate ldt = LocalDate.of(nam, thang, ngay);
//        System.out.println(ldt);
        inPutValidDate();

    }

    public static void inPutValidDate() {
        int date;
        int month;
        int year;
        int hour;
        int minute;
        int second;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.print("Input a Date: ");
            date = sc.nextInt();

            System.out.print("Input a Month: ");
            month = sc.nextInt();

            System.out.print("Input a Year: ");
            year = sc.nextInt();

            System.out.print("Input a hour: ");
            hour = sc.nextInt();

            System.out.print("Input a minute: ");
            minute = sc.nextInt();

            System.out.print("Input a second: ");
            second = sc.nextInt();

        } while (!EntryPoint.isValidDate(date, month, year));
//        String strDate = year + "-" + month +"-"+ date +" " + hour +":" + minute +":"+second;
//        System.out.println(strDate);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date d1 = null;
//        Date d2 = null;
//        LocalDate pastTime =LocalDate.ofEpochDay(0);
//        String strPastDate= pastTime + " "+ "00:00:00";
//        try {
//            d1 = format.parse(strDate);
//            d2=format.parse(strPastDate);
//            System.out.println("Current Day: " +d1);
//            System.out.println("Past Day: " +d2);
//        } catch (ParseException e){}
//
//        long diff = d1.getTime() - d2.getTime();
//
//        long diffSeconds = diff / 1000;
//
//        System.out.println("Số giây : " + diffSeconds + " seconds.");

        LocalDate ld = LocalDate.of(year, month, date);
        System.out.println(ld);
        LocalTime lt = LocalTime.of(hour, minute, second);
        System.out.println(lt);
        System.out.println("-------------------------");

        long secondTimeperyear = calulateSecondInYear(year);
        System.out.println("Số giây trong năm: " + secondTimeperyear);
        long secondTimeperMonth = calculateSecondInMonth(year, month, date);
        System.out.println("Số giây trong tháng: " + secondTimeperMonth);
        long sencondTimePerDay = calculateSecondPerDay(hour, minute, second);
        System.out.println("Số giây trong ngày: " + sencondTimePerDay);
        System.out.println("-------------------------");

        long secondTime = finalSecondTime(year, month, date, hour, minute, second);
        System.out.println(secondTime);
    }


    public static long finalSecondTime(int year, int month, int date, int hour, int minute, int second) {
        long total = 0;
        total = calulateSecondInYear(year) + calculateSecondInMonth(year, month, date) + calculateSecondPerDay(hour, minute, second);
        return total;
    }

    public static int calculateYearfrom1970(int year) {
        int sum = 0;
        sum = year - 1970;
        System.out.println("Total year from 1970: " + sum);
        return sum;
    }

    public static long calculateSecondInMonth(int year, int month, int day) {
        long secondTime = 0;
        int tongsongay = day - 1;
        int[] month_array = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month; i++) {
            if (i == 2 && EntryPoint.isLeapYear(year)) {
                month_array[2] += 1;

            }
            tongsongay = tongsongay + month_array[i];

        }
        System.out.println("Total days:" + tongsongay);
        secondTime = (long) tongsongay * 24 * 60 * 60;

        return secondTime;

    }

    public static int countLeapYear(int year) {
        int count = 0;
        for (int i = 1970; i < year; i++) {
            if (EntryPoint.isLeapYear(i)) {
                count = count + 1;
            }

        }
        return count;
    }

    public static long calulateSecondInYear(int year) {
        int numberofYear = calculateYearfrom1970(year);
        int extraDay = countLeapYear(year);
        System.out.println("Extraday: " + extraDay);
        long extraSecond = extraDay * 24 * 3600;
        long sy = 0;
        sy = (long) numberofYear * 365 * 24 * 60 * 60 + extraDay * 24 * 3600;
        return sy;

    }

    public static long calculateSecondPerDay(int hour, int minute, int second) {
        long sd = 0;

        sd = (long) hour * 60 * 60 + (long) minute * 60 + second;
        System.out.println("Tổ số giay theo giờ:" + sd);
        return sd;
    }

}
