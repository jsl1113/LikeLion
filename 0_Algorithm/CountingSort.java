import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 3, 0, 5, 2, 5, 1};
        int n = arr.length;

        int[] count = new int[6];
        for (int data : arr) {
            count[data]++;
        }

        for (int i = 0; i < 5; i++) {
            count[i + 1] += count[i];
        }
        System.out.println(Arrays.toString(count));

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            count[arr[i]]--;
            int position = count[arr[i]];
            output[position] = arr[i];
        }

        System.out.println(Arrays.toString(output));
    }
}
