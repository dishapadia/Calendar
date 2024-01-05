import java.util.Scanner;

public class calendar {

    static void PrintMonth(int month) {
        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("Febuary");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("Arpril");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Invalid month.");
                break;
        }
    }

    static boolean LeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    static int DaysInMonth(int month, int fullyear) {
        int Day;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            Day = 31;
        } else if (month == 2) {
            if ((LeapYear(fullyear) == true)) {
                Day = 29;
            } else {
                Day = 28;
            }
        } else {
            Day = 30;
        }
        return Day;
    }

    static int FirstDayOfMonth(int month, int fullyear) {
        int year = fullyear % 100;
        int Century = fullyear / 100;
        int Day1 = year / 4;
        Day1 = Day1 + 1;

        if (month == 1 || month == 10) {
            Day1 = Day1 + 1;
        } else if (month == 2 || month == 3 || month == 11) {
            Day1 = Day1 + 4;
        } else if (month == 5) {
            Day1 = Day1 + 2;
        } else if (month == 6) {
            Day1 = Day1 + 5;
        } else if (month == 8) {
            Day1 = Day1 + 3;
        } else if (month == 9 || month == 12) {
            Day1 = Day1 + 6;
        } else {
        }
        if (LeapYear(fullyear) == true) {
            if (month == 1 || month == 2) {
                Day1 = Day1 - 1;
            }
        }
        if (Century == 20) {
            Day1 = Day1 + 6;
        } else if (Century == 17) {
            Day1 = Day1 + 4;
        } else if (Century == 18) {
            Day1 = Day1 + 2;
        } else if (Century == 19) {

        } else {
            Day1 = Day1 + (Day1 * 400);
        }

        Day1 = Day1 + year;

        Day1 = Day1 % 7;
        if (Day1 == 0) {
            Day1 = 7;
        }
        return Day1;
    }

    static void PrintMonth(int month, int fullyear) {
        int Day = DaysInMonth(month, fullyear);
        int StartDay = FirstDayOfMonth(month, fullyear);
        int WeekDay = StartDay;

        PrintMonth(month);
        System.out.println((fullyear));
        System.out.println(("  S  M Tu  W Th  F  S"));
        for (int i = 1; i < StartDay; i++) {
            System.out.print("   ");
        }

        for (int i = 1; i <= Day; i++) {
            if (i < 10) {
                System.out.print("  " + i);
            } else {
                System.out.print(" " + i);
            }
            if (WeekDay == 7) {
                System.out.println();
                WeekDay = 1;
            } else {
                WeekDay++;
            }
        }
        System.out.println();
    }

    static void PrintYear(int fullyear) {
        for (int month = 1; month <= 12; month++) {
            PrintMonth(month, fullyear);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fullyear;
        int month;

        System.out.println("Enter (M) for monthly calendar");
        System.out.println("Enter (Y) for yearly calendar.");

        String ans = input.nextLine();

        if (ans.equals("M") || ans.equals("m")) {
            System.out.println("Enter month (1-12):");
            month = input.nextInt();

            System.out.println("Enter year:");
            fullyear = input.nextInt();

            PrintMonth(month, fullyear);
        } else if (ans.equals("Y") || ans.equals("y")) {
            System.out.println("Enter year:");
            fullyear = input.nextInt();

            PrintYear(fullyear);
        }
        input.close();
    }
}