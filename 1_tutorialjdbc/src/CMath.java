import java.util.ArrayList;
import java.util.List;

public class CMath {
    public static boolean isPrime(int num) {
        int count = factorsOf(num).size();
        return (count == 1);
    }

    public static boolean isPerpectionNumber(int num) {
        List<Integer> numbers = factorsOf(num);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return (sum == num);
    }

    private static List<Integer> factorsOf(int num) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                numbers.add(i);
        }
        return numbers;
    }

    public static String factors(int num) {
        return factorsOf(num).toString();
    }
}
