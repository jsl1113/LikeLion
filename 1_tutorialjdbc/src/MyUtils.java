public class MyUtils {
    public static void game369EX() {
        int cnt = 333;
        String result = is369(cnt);
        System.out.println((cnt + result));
    }

    public static void game369() {
        for (int cnt = 0; cnt < 100; cnt++) {
            System.out.print(cnt + "");
            int a = cnt / 10;
            int b = cnt % 10;
            if (a % 3 == 0 && a != 0)
                System.out.print("*");
            if (b % 3 == 0 && b != 0)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void printcheckLeapYear() {
        int i = 1700;
        if ( checkLeapYear(i) )
            System.out.println(i + " O");
        else
            System.out.println(i + " X");
    }

    public static boolean checkLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    public static String is369(int cnt) {
        int a = cnt / 10;
        int b = cnt % 10;
        String str = (b % 3 == 0 && b != 0) ? "*" : "";
        if (a == 0)
            return str;

        return str + is369(a);
    }
}
